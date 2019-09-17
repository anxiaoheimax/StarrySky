<%--
  Created by IntelliJ IDEA.
  User: 安小黑
  Date: 2019/9/10
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Brand</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="/layui/layui.js" charset="utf-8"></script>
    <style>
        body{
            padding:10px;
        }
    </style>
</head>
<body>
<div class="demoTable">
    搜索品牌：
    <div class="layui-inline">
        <form id="seachForm">
            <input class="layui-input" name="brandName" id="demoReload" autocomplete="off">
        </form>
    </div>
    <button class="layui-btn" data-type="reload" id="seachBt">搜索</button>
    <button class="layui-btn" data-type="reload" id="addBt">添加</button>
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
            ,url:'/Brand/findByPageBrand.action'
            ,title: '品牌数据表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'brandId', title:'编号', fixed: 'left', sort: true}
                ,{field:'brandName', title:'品牌名称', edit: 'text'}
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
            var brandName=$("#seachForm input[name='brandName']").val();
            options.where = {"condition['brandName']":brandName};
            table.render(options);
        })
//====================================================添加==================================================
        $("#addBt").click(function () {
            layer.open({
                type: 1
                ,title:'添加品牌'
                ,offset: '100px'
                ,content: '<div style="width:300px;padding:10px">' +
                    '<form id="addForm">' +
                    '<input type="text" class="layui-input" name="brandName" placeholder="请输入品牌名称" lay-verify="required">' +
                    '</form>' +
                    '</div>'
                ,btn: '添加品牌'
                ,btnAlign: 'c' //按钮居中
                ,shade: 0.3//显示遮罩
                ,yes: function(){
                    /*=========================================获取添加表单中的数据======================================*/
                    var brandName = $("#addForm input[name='brandName']").val();
                    console.log(brandName)
                    /*==============================================异步请求添加数据==============================================*/
                    $.ajax({
                        type:'POST',
                        url:'/Brand/addBrand.action',
                        contentType:'application/json;charset=UTF-8',
                        data:JSON.stringify({"brandName":brandName}),
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
                        url:'/Brand/deleteBrand.action',
                        data:{"brandId":data.brandId},
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
                    console.log("删除："+data.brandId);
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
//==================================================修改======================================================
                layer.confirm('确定修改行么', function(index){
                    console.log(data)
                    $.ajax({
                        type:'POST',
                        url:'/Brand/updateBrand.action',
                        contentType:'application/json;charset=UTF-8',
                        data:JSON.stringify({"brandId":data.brandId,"brandName":data.brandName}),

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
