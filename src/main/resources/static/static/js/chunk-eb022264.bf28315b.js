(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-eb022264"],{"8e61":function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"decisionTree"},[i("el-row",[i("el-col",{attrs:{span:8}},[i("el-card",{staticStyle:{"margin-top":"30px","margin-left":"20px","margin-right":"10px"}},[i("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[i("span",{staticStyle:{"font-weight":"700"}},[e._v("训练模型参数配置")])]),i("div",[i("el-form",{staticStyle:{"margin-right":"50px"},attrs:{"label-position":"left","label-width":"130px",model:e.configParams}},[i("el-form-item",{attrs:{label:"标准"}},[i("el-input",{model:{value:e.configParams.criterion,callback:function(t){e.$set(e.configParams,"criterion",t)},expression:"configParams.criterion"}})],1),i("el-form-item",{attrs:{label:"决策树深度"}},[i("el-input",{model:{value:e.configParams.depth,callback:function(t){e.$set(e.configParams,"depth",t)},expression:"configParams.depth"}})],1),i("el-form-item",{attrs:{label:"决策树最少叶数"}},[i("el-input",{model:{value:e.configParams.leaf,callback:function(t){e.$set(e.configParams,"leaf",t)},expression:"configParams.leaf"}})],1)],1)],1)]),i("el-card",{staticStyle:{"margin-top":"20px","margin-left":"20px","margin-right":"10px"}},[i("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[i("span",{staticStyle:{"font-weight":"700"}},[e._v("选择训练数据文件")])]),i("div",[i("el-upload",{staticClass:"upload-demo",attrs:{action:"https://jsonplaceholder.typicode.com/posts/","on-preview":e.handlePreview,"on-remove":e.handleRemove,"before-remove":e.beforeRemove,multiple:"",limit:3,"on-exceed":e.handleExceed,"file-list":e.fileList}},[i("el-button",{attrs:{size:"small",type:"primary"}},[e._v("点击上传")])],1)],1)]),i("el-card",{staticStyle:{"margin-top":"20px","margin-left":"20px","margin-right":"10px"}},[i("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[i("span",{staticStyle:{"font-weight":"700"}},[e._v("选择模型保存路径")])]),i("div",[i("el-select",{attrs:{placeholder:"请选择"},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}},e._l(e.options,(function(e){return i("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})})),1)],1)])],1),i("el-col",{attrs:{span:2}},[i("div",{staticStyle:{height:"300px"}}),i("div",{staticStyle:{"text-align":"center"}},[i("el-button",{attrs:{type:"primary"},on:{click:e.handleTrain}},[e._v("开始训练")])],1)]),e.modelVisible?i("el-col",{attrs:{span:14}},[i("el-card",{staticStyle:{"margin-top":"30px","margin-left":"10px"}},[i("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[i("span",{staticStyle:{"font-weight":"700"}},[e._v("生成决策树模型")])]),i("div",[i("img",{staticStyle:{width:"auto",height:"auto","max-width":"100%","max-height":"100%"},attrs:{src:a("e651"),alt:""}})])])],1):e._e()],1)],1)},l=[],s=(a("10dd"),{name:"ComponentName",data:function(){return{modelVisible:!1,configParams:{criterion:"entropy",depth:"25",leaf:.01},fileList:[],options:[{value:"选项1",label:"/model/save"}],value:""}},methods:{prev:function(){--this.active,this.active<0&&(this.active=0)},next:function(){this.active++>3&&(this.active=0)},handleRemove:function(e,t){console.log(e,t)},handlePreview:function(e){console.log(e)},beforeRemove:function(e,t){return this.$confirm("确定移除 ".concat(e.name,"？"))},handleTrain:function(){this.modelVisible=!0}}}),n=s,o=a("cba8"),r=Object(o["a"])(n,i,l,!1,null,"264ed364",null);t["default"]=r.exports},e651:function(e,t,a){e.exports=a.p+"static/img/treeModel1.45f7f32d.png"}}]);