<%--
  Created by IntelliJ IDEA.
  User: 安小黑
  Date: 2019/9/9
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Compartment</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="demoTable">
    搜索卡座或包厢：
    <div class="layui-inline">
        <form id="seachForm">
            <input class="layui-input" name="compName" id="demoReload" autocomplete="off">
        </form>
    </div>
    <button class="layui-btn" data-type="reload" id="seachBt">搜索</button>
    <button class="layui-btn" data-type="reload" id="addBt">添加</button>
</div>

<table class="layui-hide" id="test" lay-filter="test"></table>
<!-- 酒桌或包厢类型判断   模板 -->

<script type="text/html" id="comptype">
    {{#  if(d.compState == 1){ }}
    卡座
    {{#  } else { }}
    包厢
    {{#  } }}
</script>
<!-- 酒桌或包厢预定状态判断   模板 -->

<script type="text/html" id="statueTempl">
    {{#  if(d.compState == 1){ }}
    空闲中
    {{#  } else { }}
    已预定
    {{#  } }}
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="reserve">
        {{#  if(d.compState == 1){ }}
        预定
        {{#  } else { }}
        退订
        {{#  } }}
    </a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script>
    layui.use(['table','jquery','laydate','form'], function(){
        var table = layui.table;
        var $=layui.$;
        var laydate = layui.laydate;
        var form = layui.form;

        var options ={
            elem: '#test'
            ,url:'/Compartment/findByPageComp.action'
            ,title: '酒桌,包厢数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'compId', title:'编号', fixed: 'left', sort: true}
                ,{field:'compName', title:'名称', edit: 'text'}
                ,{field:'compState', title:'状态',templet:'#statueTempl'}
                ,{field:'reserve_date', title:'预定时间'}
                ,{field:'comptype', title:'类型', edit: 'text',templet:'#comptype'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:200}
            ]]
            ,page: true
            ,request: {
                pageName: 'pageNow' //页码的参数名称，默认：page
                ,limitName: 'pageRows' //每页数据量的参数名，默认：limit
            }
        };
        //渲染表格
        table.render(options);
 //===================================================搜索===========================================================
        $("#seachBt").click(function(){
            var compName=$("#seachForm input[name='compName']").val();
            options.where = {"condition['compName']":compName};
            table.render(options);
        })
//====================================================添加==================================================
        $("#addBt").click(function () {
            layer.open({
                type: 1
                ,title:'添加卡座或包厢'
                ,offset: '100px'
                ,content: '<div style="width:300px;padding:10px">' +
                    '<form id="addForm">' +
                    '<input type="text" class="layui-input" name="compName" placeholder="请输入卡座或包厢名称" lay-verify="required">' +
                    '<input type="text" class="layui-input" name="comptype" placeholder="请输入类型" lay-verify="required">' +
                    '</form>' +
                    '</div>'
                ,btn: '添加酒品'
                ,btnAlign: 'c' //按钮居中
                ,shade: 0.3//显示遮罩
                ,yes: function(){
                    /*=========================================获取添加表单中的数据======================================*/
                    var compName = $("#addForm input[name='compName']").val();
                    var comptype = $("#addForm input[name='comptype']").val();
                    /*==============================================异步请求添加数据==============================================*/
                    $.ajax({
                        type:'POST',
                        url:'Compartment/addCompartment.action',
                        contentType:'application/json;charset=UTF-8',
                        data:JSON.stringify({"compName":compName,"compState":"1","comptype":comptype}),
                        success:function (resdata) {
                            if(resdata=="ok"){
                                layer.msg("添加成功");
                                table.render(options);
                            }else{
                                layer.msg("添加失败，请重试或者联系管理员");
                            }
                        }
                    });
                    layer.closeAll();
                }
            });
        });


//===============================================================监听行工具事件========================================================
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
 //===================--------------------===========删除===============================================================
                    $.ajax({
                        type:'POST',
                        url:'Compartment/deleteCompartment.action',
                        data:{"compTd":data.compId},
                        success:function (resdata) {
                            console.log(resdata)
                            if(resdata=="ok"){
                                layer.msg("删除成功");
                                table.render(options);
                            }else{
                                layer.msg("删除失败，请重试或者联系管理员");
                            }
                        }
                    })
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
//==================================================修改======================================================
                layer.confirm('确定修改行么', function(index){
                    console.log(data)
                    $.ajax({
                        type:'POST',
                        url:'/Compartment/updateCompartment.action',
                        contentType:'application/json;charset=UTF-8',
                        data:JSON.stringify({"compId":data.compId,"compName":data.compName,"comptype":data.comptype,}),

                        success:function (resdata) {
                            console.log(resdata)
                            if(resdata=="ok"){
                                layer.msg("修改成功");
                                table.render(options);
                            }else{
                                layer.msg("修改失败，请重试或者联系管理员");
                            }
                        }
                    })
                    layer.closeAll();
                });
            }else if(obj.event === 'reserve'){
 //================================================================预定/退订=====================================================
               if(data.compState==1){
                   layer.open({
                       type: 1
                       ,title:'预定'
                       ,offset: '100px'
                       ,content: '<div style="width:300px;padding:10px">' +
                           '<form id="addForm">' +
                           '<input type="text" class="layui-input" id="production_date" name="reserve_date" placeholder="yyyy-MM-dd HH:mm:ss" lay-verify="required">'+
                           '</form>' +
                           '</div>'
                       ,btn: '添加酒品'
                       ,btnAlign: 'c' //按钮居中
                       ,shade: 0.3//显示遮罩
                       ,yes: function(){
                           /*=========================================获取表单中的数据======================================*/
                           var reserve_date = $("#addForm input[name='reserve_date']").val();
                           /*==============================================异步请求数据==============================================*/
                           $.ajax({
                               type:'POST',
                               url:'Compartment/reserveOrUnsubscribe.action',
                               contentType:'application/json;charset=UTF-8',
                               data:JSON.stringify({"compId":data.compId,"compState":"2","reserve_date":reserve_date}),
                               success:function (resdata) {
                                   if(resdata=="ok"){
                                       layer.msg("预定成功");
                                       table.render(options);
                                   }else{
                                       layer.msg("预定失败，请重试或者联系管理员");
                                   }
                               }
                           });
                           layer.closeAll();
                       }
                   });
               }else{
    //===============================================退订===========================================================
                   $.ajax({
                       type:'POST',
                       url:'Compartment/reserveOrUnsubscribe.action',
                       contentType:'application/json;charset=UTF-8',
                       data:JSON.stringify({"compId":data.compId,"compState":"1","reserve_date":null}),
                       success:function (resdata) {
                           if(resdata=="ok"){
                               layer.msg("退订成功");
                               table.render(options);
                           }else{
                               layer.msg("退订失败，请重试或者联系管理员");
                           }
                       }
                   });
               }
 //====================================================日期时间选择器=========================================
                laydate.render({
                    elem: '#production_date'
                    ,type: 'datetime'
                    ,min:1
                    ,max:7
                });
            }

        });
    });
</script>

</body>
</html>
