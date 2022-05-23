(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-857fa300"],{"476a":function(t,e,a){"use strict";a.r(e);var i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"dashboard-container"},[a("el-row",[a("el-col",{staticStyle:{"margin-right":"20px"},attrs:{span:6}},[a("el-card",{staticStyle:{height:"800px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",{staticStyle:{"font-weight":"700"}},[t._v("目标意图研判输入")])]),a("div",[a("el-form",{staticStyle:{"margin-right":"50px"},attrs:{"label-position":"left","label-width":"160px",model:t.input}},[a("el-form-item",{attrs:{label:"编号"}},[a("el-input",{model:{value:t.input.id,callback:function(e){t.$set(t.input,"id",e)},expression:"input.id"}})],1),a("el-form-item",{attrs:{label:"名称"}},[a("el-input",{model:{value:t.input.name,callback:function(e){t.$set(t.input,"name",e)},expression:"input.name"}})],1),a("el-form-item",{attrs:{label:"国别"}},[a("el-input",{model:{value:t.input.countryCode,callback:function(e){t.$set(t.input,"countryCode",e)},expression:"input.countryCode"}})],1),a("el-form-item",{attrs:{label:"起飞机场"}},[a("el-input",{model:{value:t.input.takeOffAirPort,callback:function(e){t.$set(t.input,"takeOffAirPort",e)},expression:"input.takeOffAirPort"}})],1),a("el-form-item",{attrs:{label:"航线名称"}},[a("el-input",{model:{value:t.input.airLineName,callback:function(e){t.$set(t.input,"airLineName",e)},expression:"input.airLineName"}})],1),a("el-form-item",{attrs:{label:"降落机场"}},[a("el-input",{model:{value:t.input.landAirPort,callback:function(e){t.$set(t.input,"landAirPort",e)},expression:"input.landAirPort"}})],1),a("el-form-item",{attrs:{label:"任务活动区域编号"}},[a("el-input",{model:{value:t.input.type,callback:function(e){t.$set(t.input,"type",e)},expression:"input.type"}})],1)],1)],1)])],1),a("el-col",{attrs:{span:6}},[a("el-card",{staticStyle:{height:"800px"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",{staticStyle:{"font-weight":"700"}},[t._v("模型参数输入")])]),a("div",[a("el-form",{staticStyle:{"margin-right":"50px"},attrs:{"label-position":"left","label-width":"160px",model:t.input}},[a("el-form-item",{attrs:{label:"迭代次数"}},[a("el-input",{model:{value:t.modelPara.iteration,callback:function(e){t.$set(t.modelPara,"iteration",e)},expression:"modelPara.iteration"}})],1),a("el-form-item",{attrs:{label:"正则化系数"}},[a("el-input",{model:{value:t.modelPara.coefficient,callback:function(e){t.$set(t.modelPara,"coefficient",e)},expression:"modelPara.coefficient"}})],1),a("el-form-item",{attrs:{label:"权重比"}},[a("el-input",{model:{value:t.modelPara.weight,callback:function(e){t.$set(t.modelPara,"weight",e)},expression:"modelPara.weight"}})],1),a("el-form-item",{attrs:{label:"高度"}},[a("el-input",{model:{value:t.modelPara.height,callback:function(e){t.$set(t.modelPara,"height",e)},expression:"modelPara.height"}})],1),a("el-form-item",{attrs:{label:"速度"}},[a("el-input",{model:{value:t.modelPara.speed,callback:function(e){t.$set(t.modelPara,"speed",e)},expression:"modelPara.speed"}})],1),a("el-form-item",{attrs:{label:"电磁特征"}},[a("el-input",{model:{value:t.modelPara.eletrCh,callback:function(e){t.$set(t.modelPara,"eletrCh",e)},expression:"modelPara.eletrCh"}})],1)],1)],1)])],1),a("el-col",{attrs:{span:2}},[a("div",{staticStyle:{height:"300px"}}),a("div",{staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"primary"},on:{click:t.handleJudgment}},[t._v("开始研判")])],1)]),a("el-col",{directives:[{name:"show",rawName:"v-show",value:t.judgmentVis,expression:"judgmentVis"}],attrs:{span:8}},[a("el-card",{staticStyle:{height:"800px"}},[a("div",{staticClass:"clearfix",staticStyle:{height:"100px"},attrs:{slot:"header"},slot:"header"},[a("span",{staticStyle:{"font-weight":"700"}},[t._v("目标意图研判输出")])]),a("div",{staticStyle:{height:"600px"}},[a("div",{staticStyle:{"text-align":"center","padding-top":"50px"}},[a("el-row",{staticStyle:{"margin-top":"20px"}},[t._v(" 演训概率值："+t._s(t.result.train)+" ")]),a("el-row",{staticStyle:{"margin-top":"20px"}},[t._v(" 作战概率值："+t._s(t.result.fight)+" ")]),a("el-row",{staticStyle:{"margin-top":"20px"}},[t._v(" 转场概率值："+t._s(t.result.transition)+" ")])],1),a("div",{ref:"myChart",staticStyle:{width:"300px",height:"300px",margin:"0 auto","margin-top":"100px"}})]),a("div",{staticStyle:{height:"100px","text-align":"center"}},[a("el-button",{attrs:{type:"primary"},on:{click:t.handleSubmit}},[t._v("将结果提交到意图研判")])],1)])],1)],1)],1)},l=[],s=a("f026"),r=(a("10dd"),a("52c1")),n={name:"IntentionJudgment",computed:Object(s["a"])({},Object(r["b"])(["name"])),mounted:function(){this.$route.params.result&&(this.input.id=this.$route.params.result.id,this.input.name=this.$route.params.result.targetModel,this.input.takeOffAirPort=this.$route.params.result.startPlace,this.input.countryCode=this.$route.params.result.countryCode)},data:function(){return{judgmentVis:!1,input:{id:"1",name:"F-5L巡逻机",countryCode:"日本",takeOffAirPort:"横田空军基地",airLineName:"航线信息_1",landAirPort:"三泽基地",specialAirLineID:"003",type:"0262"},modelPara:{iteration:50,coefficient:.01,weight:3.26,height:3246,speed:244,eletrCh:"辐射场"},result:{train:.99,fight:.12,transition:.54},chart:"",option:{title:{text:""},tooltip:{},legend:{data:["概率值"]},xAxis:{data:["演训","作战","转场"]},yAxis:{},series:[{name:"概率值",type:"bar",data:[0,0,0]}]}}},methods:{handleJudgment:function(){var t=this;this.judgmentVis=!0;var e=this;e.axios.get("http://127.0.0.1:8891/LISTS").then((function(a){console.log(a),t.result.train=a.data["演训"],t.result.fight=a.data["作战"],t.result.transition=a.data["转场"],e.$message({message:"获取成功",type:"success"})})).catch((function(t){console.log(t)})),this.option.series[0].data[0]=this.result.train,this.option.series[0].data[1]=this.result.fight,this.option.series[0].data[2]=this.result.transition,this.drawChart()},drawChart:function(){this.chart=this.$echarts.init(this.$refs.myChart),this.chart.setOption(this.option)},handleSubmit:function(){var t=this;this.$router.push({name:"assessmentReport",params:{result:t.result}})}}},o=n,u=(a("7ad2"),a("cba8")),c=Object(u["a"])(o,i,l,!1,null,"9e234970",null);e["default"]=c.exports},"7ad2":function(t,e,a){"use strict";a("d2e4")},d2e4:function(t,e,a){}}]);