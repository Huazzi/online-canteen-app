<template>
  <div class="login-container">
    <div class="login-box">
      <div style="font-weight: bold; font-size: 24px; text-align: center; margin-bottom: 30px; color: #1450aa">登录点餐系统</div>
      <el-form :model="data.form" ref="formRef" :rules="data.rules">
        <el-form-item prop="username">
          <el-input :prefix-icon="User" size="large" v-model="data.form.username" placeholder="请输入账号" />
        </el-form-item>
        <el-form-item prop="password">
          <el-input :prefix-icon="Lock" size="large" v-model="data.form.password" placeholder="请输入密码" show-password />
        </el-form-item>
        <el-form-item prop="role">
          <el-select size="medium" style="width: 100%" v-model="data.form.role">
            <el-option value="ADMIN" label="管理员"></el-option>
            <el-option value="USER" label="用户"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="code">
          <div style="display: flex">
            <el-input placeholder="请输入验证码" prefix-icon="el-icon-circle-check" size="medium" style="flex: 1" v-model="data.form.code"></el-input>
            <div style="flex: 1; height: 36px">
              <!-- 使用ref绑定valid-code组件 -->
              <valid-code ref="validCodeRef" @update:value="getCode" />
            </div>
          </div>
        </el-form-item>
        <el-form-item>
          <el-button size="large" type="primary" style="width: 100%" @click="login">登 录</el-button>
        </el-form-item>
      </el-form>
      <div style="text-align: right;">
        还没有账号？请先 <a href="/register">注册</a>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref } from "vue";
import { User, Lock } from "@element-plus/icons-vue";
import request from "@/utils/request";
import { ElMessage } from "element-plus";
import router from "@/router";

// 验证码校验逻辑
const validateCode = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('请输入验证码'));
  } else if (value.toLowerCase() !== code.value) {
    // 输入错误时刷新验证码
    callback(new Error('验证码错误'));
    refreshCaptcha();
  } else {
    callback();
  }
};

// 管理验证码数据
const code = ref('');
const getCode = (newCode) => {
  code.value = newCode.toLowerCase();
};

// 刷新验证码函数
const validCodeRef = ref(null);
const refreshCaptcha = () => {
  if (validCodeRef.value) {
    validCodeRef.value.refreshCode(); // 调用 valid-code 组件的 refreshCode 方法
  }
};

// 创建响应式数据
const data = reactive({
  form: {
    username: '',
    password: '',
    role: 'ADMIN',
    code: '',  // 用户输入的验证码
  },
  rules: {
    username: [
      { required: true, message: '请输入账号', trigger: 'blur' },
    ],
    password: [
      { required: true, message: '请输入密码', trigger: 'blur' },
    ],
    code: [
      { validator: validateCode, trigger: 'blur' }  // 自定义验证码校验规则
    ]
  },
});

const formRef = ref();

// 点击登录按钮时会触发此方法
const login = () => {
  formRef.value.validate((valid) => {
    if (valid) {
      // 调用后台的接口
      request.post('/login', data.form).then(res => {
        if (res.code === '200') {           // 状态码为200，成功
          ElMessage.success("登录成功");
          router.push('/');                 // 跳转到首页
          localStorage.setItem('canteen-user', JSON.stringify(res.data));  // 将用户信息保存到本地
        } else {
          ElMessage.error(res.msg);  // 状态码不为200，失败
        }
      }).catch(error => {
        console.error(error);
        ElMessage.error('登录失败，请稍后重试');
      });
    }
  });
};
</script>


<style scoped>
.login-container {
  height: 100vh;
  overflow:hidden;
  display: flex;
  justify-content: center;
  align-items: center;
  background: url("@/assets/imgs/bg.jpg");
  background-size: cover;
}
.login-box {
  width: 350px;
  padding: 50px 30px;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0,.1);
  background-color: rgba(255, 255, 255, .9);
}
</style>
