import {createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  mode: 'hash',
  routes: [
    {
      path: '/',
      name: 'Manager',
      component: () => import('@/components/List.vue'),
      redirect: '/home',
      children: [
        { path: 'home', name: 'Home', component: () => import('@/components/manager/Home.vue')},
        { path: 'admin', name: 'Admin', component: () => import('@/components/manager/Admin.vue')},
        { path: 'person', name: 'Person', component: () => import('@/components/manager/Person.vue')},
        { path: 'user', name: 'User', component: () => import('@/components/manager/User.vue')},
        { path: 'tables', name: 'Tables', component: () => import('@/components/manager/Tables.vue')},
        { path: 'order', name: 'Order', component: () => import('@/components/manager/Order.vue')},
        { path: 'foods', name: 'Foods', component: () => import('@/components/manager/Foods.vue')},
        { path: 'orderManager', name: 'OrderManager', component: () => import('@/components/manager/OrderManager.vue')},
      ]
    },
    { path: '/login', name: 'Login', component: () => import('@/components/Login.vue')},
    { path: '/register', name: 'Register', component: () => import('@/components/Register.vue')},
  ]
})

export default router
