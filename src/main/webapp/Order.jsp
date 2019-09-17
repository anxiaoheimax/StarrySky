<%--
  Created by IntelliJ IDEA.
  User: 安小黑
  Date: 2019/9/10
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js" charset="utf-8"></script>
    <style>
        .input{
            display:inline-block;
        }

         body{
             padding:10px;
         }

    </style>
</head>
<body>
<div class="demoTable">
    搜索订单：
    <div class="layui-inline">
        <form id="seachForm">
            <div class="input"><input class="layui-input" name="Uid" id="Uid" placeholder="用户ID" ></div>
            <div class="input"><input class="layui-input" name="compId" id="compId" placeholder="选择酒桌"></div>
            <div class="input"><input class="layui-input" name="money" id="money" placeholder="请输入金额"></div>
        </form>
    </div>
    <button class="layui-btn" data-type="reload" id="seachBt">搜索</button>
</div>

<table class="layui-hide" id="test" lay-filter="test"></table>
<!-- 酒桌或包厢类型判断   模板 -->


<script type="text/html" id="barDemo">
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
            ,url:'/Order/findOrderByPage.action'
            ,title: '品牌数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'orderId', title:'编号', fixed: 'left', sort: true}
                ,{field:'Uid', title:'用户ID'}
                ,{field:'compId', title:'酒桌编号'}
                ,{field:'money', title:'金额'}
                ,{field:'payment', title:'是否结算', edit: 'text'}
                ,{field:'order_date', title:'订单时间'}
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
            var Uid=$("#seachForm input[name='Uid']").val();
            var compId=$("#seachForm input[name='compId']").val();
            var money=$("#seachForm input[name='money']").val();

            console.log(Uid+""+compId+""+money)
            options.where = {"condition['Uid']":Uid,"condition['compId']":compId,"condition['money']":money};
            table.render(options);
        })

//===============================================================监听行工具事件========================================================
        table.on('tool(test)', function(obj){
            var data = obj.data;
            console.log(obj)
            if(obj.event === 'del'){

                layer.confirm('真的删除行么', function(index){
                    //===================--------------------===========删除===============================================================
                    $.ajax({
                        type:'POST',
                        url:'/Order/deleteOrder.action',
                        data:{"orderId":data.orderId},
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
                    console.log("删除："+data.orderId);
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
//==================================================修改======================================================
                layer.confirm('确定修改行么', function(index){
                    console.log(data)
                    $.ajax({
                        type:'POST',
                        url:'/Order/updateOrder.action',
                        contentType:'application/json;charset=UTF-8',
                        data:JSON.stringify({"orderId":data.orderId,"payment":data.payment}),

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
            }

        });
    });
</script>

</body>
</html>
