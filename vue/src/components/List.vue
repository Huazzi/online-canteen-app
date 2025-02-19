<template>
  <div>
    <div
      style="height: 80px; background-color: #303133; display: flex; align-items: center; border-bottom: 1px solid #ddd">
      <div style="flex: 1">
        <div style="padding-left: 20px; display: flex; align-items: center">
          <img src="../assets/imgs/logo.png" alt="" style="width: 40px">
          <div style="font-weight: bold; font-size: 24px; margin-left: 5px; color: #F9B44C">在线点餐系统</div>
        </div>
      </div>
      <div style="width: fit-content; padding-right: 10px; display: flex; align-items: center;">
        <a href="/login" ><img :src="data.user?.avatar || 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'" alt=""
          style="width: 40px; height: 40px; border-radius: 50%">
        <span style="color: white; margin-left: 5px">{{ data.user?.name || "未登录"}}</span></a>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: 200px; border-right: 1px solid #ddd; min-height: calc(100vh - 60px)">
        <el-menu active-text-color="#ffd04b" background-color="#545c64" class="el-menu-vertical-demo" default-active="2"
          text-color="#fff" @open="handleOpen" @close="handleClose" router style="border: none"
          :default-active="$route.path" :default-openeds="['/home', '2']">
          <el-menu-item index="/home">
            <el-icon>
              <HomeFilled />
            </el-icon>
            <span>系统首页</span>
          </el-menu-item>
          <el-menu-item index="/order">
            <el-icon>
              <Dish />
            </el-icon>
            <span>开始点餐</span>
          </el-menu-item>
          <el-menu-item index="/orderManager">
            <el-icon>
              <List />
            </el-icon>
            <span>订单信息</span>
          </el-menu-item>
          <el-sub-menu index="2" v-if="data.user.role === 'ADMIN'">
            <template #title>
              <el-icon>
                <Document />
              </el-icon>
              <span>信息管理</span>
            </template>
            <el-menu-item index="/tables">
              <el-icon>
                <Dish />
              </el-icon>
              <span>餐桌信息</span>
            </el-menu-item>
            <el-menu-item index="/foods">
              <el-icon>
                <Bowl />
              </el-icon>
              <span>餐品信息</span>
            </el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="3" v-if="data.user.role === 'ADMIN'">
            <template #title>
              <el-icon>
                <User />
              </el-icon>
              <span>用户管理</span>
            </template>
            <el-menu-item index="/admin">
              <el-icon>
                <UserFilled />
              </el-icon>
              <span>管理员信息</span>
            </el-menu-item>
            <el-menu-item index="/user">
              <el-icon>
                <UserFilled />
              </el-icon>
              <span>用户信息</span>
            </el-menu-item>
          </el-sub-menu>
          <el-menu-item index="/person">
            <el-icon>
              <Avatar />
            </el-icon>
            <span>个人中心</span>
          </el-menu-item>
          <el-menu-item index="login" @click="logout">
            <el-icon>
              <SwitchButton />
            </el-icon>
            <span>退出登录</span>
          </el-menu-item>
        </el-menu>
      </div>

      <div style="flex: 1; width: 0; background-color: #f8f8ff; padding: 10px">
        <router-view @updateUser="updateUser" />
      </div>
    </div>

  </div>
</template>


<script setup>
import { reactive } from "vue";
import { useRoute } from 'vue-router'
import { HomeFilled, User, UserFilled, Dish, List, SwitchButton, Bowl } from "@element-plus/icons-vue"

const $route = useRoute()

const data = reactive({
  user: JSON.parse(localStorage.getItem('canteen-user') || '{}')
})

const logout = () => {
  localStorage.removeItem('canteen-user')
}

const updateUser = () => {
  data.user = JSON.parse(localStorage.getItem('canteen-user') || '{}')
}
</script>


<style scoped>
:deep(th) {
  color: #333;
}
</style>