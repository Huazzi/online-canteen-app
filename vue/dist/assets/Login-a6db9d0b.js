/* empty css             *//* empty css                  */import{r as I}from"./request-54d9b062.js";import{_ as w,o as h,c as g,F as $,z as k,$ as N,t as R,a0 as v,r as B,b as u,d as t,w as l,O as U,e as C,y as M,p as D,h as F,C as y,B as A,G as q,M as O,R as j,S as G,D as J,s as T,a1 as H}from"./index-fdd1b0eb.js";/* empty css              *//* empty css                  *//* empty css               *//* empty css               */const K={name:"validCode",data(){return{length:4,codeList:[]}},mounted(){this.createdCode()},methods:{refreshCode(){this.createdCode()},createdCode(){let r=this.length,s=[],c="ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz0123456789",_=c.length;for(let a=0;a<r;a++){let n=[Math.round(Math.random()*220),Math.round(Math.random()*240),Math.round(Math.random()*200)];s.push({code:c.charAt(Math.floor(Math.random()*_)),color:`rgb(${n})`,padding:`${Math.floor(Math.random()*10)}px`,transform:`rotate(${Math.floor(Math.random()*90)-Math.floor(Math.random()*90)}deg)`})}this.codeList=s,this.$emit("update:value",s.map(a=>a.code).join(""))},getStyle(r){return`color: ${r.color}; font-size: 18px; padding: ${r.padding}; transform: ${r.transform}`}}};function P(r,s,c,_,a,n){return h(),g("div",{class:"ValidCode disabled-select",style:{width:"100%",height:"100%"},onClick:s[0]||(s[0]=(...o)=>n.refreshCode&&n.refreshCode(...o))},[(h(!0),g($,null,k(a.codeList,(o,f)=>(h(),g("span",{key:f,style:N(n.getStyle(o))},R(o.code),5))),128))])}const Q=w(K,[["render",P]]);const V=r=>(D("data-v-8a813017"),r=r(),F(),r),W={class:"login-container"},X={class:"login-box"},Y=V(()=>u("div",{style:{"font-weight":"bold","font-size":"24px","text-align":"center","margin-bottom":"30px",color:"#1450aa"}},"登录点餐系统",-1)),Z={style:{display:"flex"}},ee={style:{flex:"1",height:"36px"}},oe=V(()=>u("div",{style:{"text-align":"right"}},[M(" 还没有账号？请先 "),u("a",{href:"/register"},"注册")],-1)),te={__name:"Login",setup(r){const s=(m,e,d)=>{e===""?d(new Error("请输入验证码")):e.toLowerCase()!==c.value?(d(new Error("验证码错误")),n()):d()},c=v(""),_=m=>{c.value=m.toLowerCase()},a=v(null),n=()=>{a.value&&a.value.refreshCode()},o=B({form:{username:"",password:"",role:"ADMIN",code:""},rules:{username:[{required:!0,message:"请输入账号",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}],code:[{validator:s,trigger:"blur"}]}}),f=v(),S=()=>{f.value.validate(m=>{m&&I.post("/login",o.form).then(e=>{e.code==="200"?(y.success("登录成功"),A.push("/"),localStorage.setItem("canteen-user",JSON.stringify(e.data))):y.error(e.msg)}).catch(e=>{console.error(e),y.error("登录失败，请稍后重试")})})};return(m,e)=>{const d=q,p=O,x=j,b=G,E=Q,L=J,z=U;return h(),g("div",W,[u("div",X,[Y,t(z,{model:o.form,ref_key:"formRef",ref:f,rules:o.rules},{default:l(()=>[t(p,{prop:"username"},{default:l(()=>[t(d,{"prefix-icon":C(T),size:"large",modelValue:o.form.username,"onUpdate:modelValue":e[0]||(e[0]=i=>o.form.username=i),placeholder:"请输入账号"},null,8,["prefix-icon","modelValue"])]),_:1}),t(p,{prop:"password"},{default:l(()=>[t(d,{"prefix-icon":C(H),size:"large",modelValue:o.form.password,"onUpdate:modelValue":e[1]||(e[1]=i=>o.form.password=i),placeholder:"请输入密码","show-password":""},null,8,["prefix-icon","modelValue"])]),_:1}),t(p,{prop:"role"},{default:l(()=>[t(b,{size:"medium",style:{width:"100%"},modelValue:o.form.role,"onUpdate:modelValue":e[2]||(e[2]=i=>o.form.role=i)},{default:l(()=>[t(x,{value:"ADMIN",label:"管理员"}),t(x,{value:"USER",label:"用户"})]),_:1},8,["modelValue"])]),_:1}),t(p,{prop:"code"},{default:l(()=>[u("div",Z,[t(d,{placeholder:"请输入验证码","prefix-icon":"el-icon-circle-check",size:"medium",style:{flex:"1"},modelValue:o.form.code,"onUpdate:modelValue":e[3]||(e[3]=i=>o.form.code=i)},null,8,["modelValue"]),u("div",ee,[t(E,{ref_key:"validCodeRef",ref:a,"onUpdate:value":_},null,512)])])]),_:1}),t(p,null,{default:l(()=>[t(L,{size:"large",type:"primary",style:{width:"100%"},onClick:S},{default:l(()=>[M("登 录")]),_:1})]),_:1})]),_:1},8,["model","rules"]),oe])])}}},ue=w(te,[["__scopeId","data-v-8a813017"]]);export{ue as default};
