/* empty css             *//* empty css                     *//* empty css                *//* empty css                  *//* empty css              *//* empty css                  *//* empty css               *//* empty css               *//* empty css              *//* empty css                 *//* empty css                   *//* empty css                */import{r as c}from"./request-54d9b062.js";/* empty css                    */import{r as T,o as _,c as g,b as u,d as o,w as l,g as y,G as I,D as M,H as R,I as F,J,y as s,C as f,K as $,L as q,M as A,N as G,P as H,Q as K,R as L,S as Q,O as j}from"./index-fdd1b0eb.js";const W={class:"card",style:{"margin-bottom":"10px"}},X={class:"card",style:{"margin-bottom":"10px"}},Y={style:{"margin-bottom":"10px"}},Z=["src"],ee={key:0,class:"card"},oe={class:"dialog-footer"},Ve={__name:"User",setup(te){const e=T({tableData:[],total:0,pageNum:1,pageSize:5,formVisible:!1,form:{},name:""}),i=()=>{c.get("/user/selectPage",{params:{pageNum:e.pageNum,pageSize:e.pageSize,name:e.name}}).then(n=>{var t;e.tableData=((t=n.data)==null?void 0:t.list)||[],e.total=n.data.total})};i();const x=()=>{e.name=null,i()},h=()=>{e.form={},e.formVisible=!0},E=()=>{c.request({method:e.form.id?"PUT":"POST",url:e.form.id?"/user/update":"/user/add",data:e.form}).then(n=>{n.code==="200"?(f.success("操作成功"),e.formVisible=!1,i()):f.error(n.msg)})},v=n=>{e.form=JSON.parse(JSON.stringify(n)),e.formVisible=!0},w=n=>{$.confirm("删除后数据无法恢复，您确认删除吗？","确认删除",{type:"warning"}).then(t=>{c.delete("/user/delete/"+n).then(m=>{m.code==="200"?(f.success("操作成功"),i()):f.error(m.msg)})}).catch(t=>{console.log(t)})},C=n=>{e.form.avatar=n.data};function k(){window.open("http://localhost:9090/user/export")}return(n,t)=>{const m=I,r=M,d=q,N=R,U=F,p=A,S=G,b=H,z=K,V=L,D=Q,P=j,B=J;return _(),g("div",null,[u("div",W,[o(m,{"prefix-icon":"Search",style:{width:"300px","margin-right":"10px"},placeholder:"请输入名称查询",modelValue:e.name,"onUpdate:modelValue":t[0]||(t[0]=a=>e.name=a)},null,8,["modelValue"]),o(r,{type:"primary",onClick:i},{default:l(()=>[s("查询")]),_:1}),o(r,{type:"info",style:{margin:"0 10px"},onClick:x},{default:l(()=>[s("重置")]),_:1}),o(r,{type:"warning",style:{margin:"0 10px"},onClick:k},{default:l(()=>[s("一键导出")]),_:1})]),u("div",X,[u("div",Y,[o(r,{type:"success",onClick:h},{default:l(()=>[s("新增")]),_:1})]),o(N,{data:e.tableData,style:{width:"100%"}},{default:l(()=>[o(d,{prop:"id",label:"序号",width:"70"}),o(d,{prop:"username",label:"账号"}),o(d,{prop:"name",label:"昵称"}),o(d,{prop:"avatar",label:"头像"},{default:l(a=>[a.row.avatar?(_(),g("img",{key:0,src:a.row.avatar,alt:"",style:{width:"50px",height:"50px","border-radius":"50%"}},null,8,Z)):y("",!0)]),_:1}),o(d,{prop:"sex",label:"性别"}),o(d,{prop:"phone",label:"手机号"}),o(d,{prop:"account",label:"账号余额"}),o(d,{label:"操作",width:"180"},{default:l(a=>[o(r,{type:"primary",onClick:O=>v(a.row)},{default:l(()=>[s("编辑")]),_:2},1032,["onClick"]),o(r,{type:"danger",onClick:O=>w(a.row.id)},{default:l(()=>[s("删除")]),_:2},1032,["onClick"])]),_:1})]),_:1},8,["data"])]),e.total?(_(),g("div",ee,[o(U,{background:"",layout:"prev, pager, next",onCurrentChange:i,"page-size":e.pageSize,"current-page":e.pageNum,"onUpdate:currentPage":t[1]||(t[1]=a=>e.pageNum=a),total:e.total},null,8,["page-size","current-page","total"])])):y("",!0),o(B,{modelValue:e.formVisible,"onUpdate:modelValue":t[8]||(t[8]=a=>e.formVisible=a),title:"用户信息",width:"40%","destroy-on-close":""},{footer:l(()=>[u("span",oe,[o(r,{onClick:t[7]||(t[7]=a=>e.formVisible=!1)},{default:l(()=>[s("取消")]),_:1}),o(r,{type:"primary",onClick:E},{default:l(()=>[s("保存")]),_:1})])]),default:l(()=>[o(P,{model:e.form,"abel-position":"top",style:{"padding-right":"50px"}},{default:l(()=>[o(p,{label:"账号"},{default:l(()=>[o(m,{modelValue:e.form.username,"onUpdate:modelValue":t[2]||(t[2]=a=>e.form.username=a),autocomplete:"off",disabled:!!e.form.id},null,8,["modelValue","disabled"])]),_:1}),o(p,{label:"昵称"},{default:l(()=>[o(m,{modelValue:e.form.name,"onUpdate:modelValue":t[3]||(t[3]=a=>e.form.name=a),autocomplete:"off"},null,8,["modelValue"])]),_:1}),o(p,{label:"头像"},{default:l(()=>[o(S,{action:"http://localhost:9090/files/upload","on-success":C},{default:l(()=>[o(r,{type:"primary"},{default:l(()=>[s("点击上传")]),_:1})]),_:1})]),_:1}),o(p,{label:"性别"},{default:l(()=>[o(z,{modelValue:e.form.sex,"onUpdate:modelValue":t[4]||(t[4]=a=>e.form.sex=a)},{default:l(()=>[o(b,{label:"男"}),o(b,{label:"女"})]),_:1},8,["modelValue"])]),_:1}),o(p,{label:"手机号"},{default:l(()=>[o(m,{modelValue:e.form.phone,"onUpdate:modelValue":t[5]||(t[5]=a=>e.form.phone=a),autocomplete:"off"},null,8,["modelValue"])]),_:1}),o(p,{label:"角 色"},{default:l(()=>[o(D,{size:"medium",style:{width:"20%"},modelValue:e.form.role,"onUpdate:modelValue":t[6]||(t[6]=a=>e.form.role=a)},{default:l(()=>[o(V,{value:"ADMIN",label:"管理员"}),o(V,{value:"USER",label:"用户"})]),_:1},8,["modelValue"])]),_:1})]),_:1},8,["model"])]),_:1},8,["modelValue"])])}}};export{Ve as default};
