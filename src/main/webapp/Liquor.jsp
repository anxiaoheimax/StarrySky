<%--
  Created by IntelliJ IDEA.
  User: 安小黑
  Date: 2019/9/5
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>
<body>
<div class="demoTable">
    搜索酒名：
    <div class="layui-inline">
        <form id="seachForm">
            <input class="layui-input" name="liquorName" id="demoReload" autocomplete="off">
        </form>
    </div>
    <button class="layui-btn" data-type="reload" id="seachBt">搜索</button>
    <button class="layui-btn" data-type="reload" id="addBt">添加</button>
</div>

<table class="layui-hide" id="test" lay-filter="test"></table>


<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="update">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>



<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    layui.use(['table','jquery','laydate','form'], function(){
        var table = layui.table;
        var $=layui.$;
        var laydate = layui.laydate;
        var form = layui.form;
        /*=======================================================表格渲染================================================================*/
        var options ={
            elem: '#test'
            ,url:'/Liquor/findPage.action'
            ,title: '酒品列表'
            ,cols: [[
                {type: 'checkbox', fixed: 'left'}
                ,{field:'liquorId', title:'编号',  fixed: 'left'}
                ,{field:'liquor_name', title:'酒名', edit: 'text',}
                ,{field:'brand', title:'品牌',  sort: true,templet: '<div>{{d.brand.brandName}}</div>'}
                ,{field:'origin', title:'产地', edit: 'text', sort: true}
                ,{field:'price', title:'价格',  sort: true,edit: 'text'}
                ,{field:'production_date', title:'生产时间',width:200}
                ,{field:'alcoholic_strength', title:'酒精浓度',edit: 'text'}
                ,{field:'kind', title:'类型',templet: '<div>{{d.kind.kindName}}</div>'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
            ]]
            ,page: true
            ,request: {
                pageName: 'pageNow' //页码的参数名称，默认：page
                ,limitName: 'pageRows' //每页数据量的参数名，默认：limit
            }
        };
        //渲染表格
        table.render(options);
        /*监听搜索按钮点击事件*/
        /*===============================================搜索名字==========================================================*/
        $("#seachBt").click(function(){
           var liquorName=$("#seachForm input[name='liquorName']").val();
            console.log("sousuo:::"+liquorName)
            options.where = {"condition['liquor_name']":liquorName};
            table.render(options);
        })
        /*监听添加按钮的点击事件*/
        /*=============================================添加===========================================================*/
        $("#addBt").click(function () {
            layer.open({
                type: 1
                ,title:'添加酒品'
                ,offset: '100px'
                ,content: '<div style="width:300px;padding:10px">' +
                    '<form id="addForm">' +
                    '<input type="text" class="layui-input" name="liquor_name" placeholder="请输入酒品名称" lay-verify="required">' +
                    '<select name="city" class="layui-input"  name="brand"id="liquorBrand" lay-verify="required" lay-filter="brand">\n' +
                    ' <option value="">请选择品牌</option></select>' +
                    '<input type="text" class="layui-input" name="origin" placeholder="请输入产地" lay-verify="required">' +
                    '<input type="text" class="layui-input" name="price" placeholder="请输入价格" lay-verify="required">' +
                    '<input type="text" class="layui-input" id="production_date" name="production_date" placeholder="yyyy-MM-dd HH:mm:ss" lay-verify="required">'+
                    '<input type="text" class="layui-input" name="alcoholic_strength" placeholder="请输入酒精浓度" lay-verify="required">' +
                    '<select name="city" class="layui-input" name="kind" id="liquorKind" lay-verify="required">\n' +
                    '<option value="">请选择类型</option></select>' +
                    '</form>' +
                    '</div>'
                ,btn: '添加酒品'
                ,btnAlign: 'c' //按钮居中
                ,shade: 0.3//显示遮罩
                ,yes: function(){
                    /*=========================================获取添加表单中的数据======================================*/
                    var liquor_name = $("#addForm input[name='liquor_name']").val();
                    var brand=$("#liquorBrand ").val();
                    var origin = $("#addForm input[name='origin']").val();
                    var price = $("#addForm input[name='price']").val();
                    var production_date = $("#addForm input[name='production_date']").val();
                    var alcoholic_strength = $("#addForm input[name='alcoholic_strength']").val();
                    var kind=$("#liquorKind ").val();
                    /*==============================================异步请求添加数据==============================================*/
                    $.ajax({
                        type:'POST',
                        url:'/Liquor/addLiquor.action',
                        contentType:'application/json;charset=UTF-8',
                        data:JSON.stringify({"liquor_name":liquor_name,"brand":brand,"origin":origin,"price":price,"production_date":production_date,"alcoholic_strength":alcoholic_strength,"kind":kind}),//tableName=xxxxx      '{tableName:XXXX}'
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
            //====================================================日期时间选择器=========================================
            laydate.render({
                elem: '#production_date'
                ,type: 'datetime'
            });

            /*================================================动态向品牌下拉选择框中添加选项========================================*/
            $.ajax({
                url:'/Brand/findBrand.action',
                dataType:'json',
                type:'post',
                success:function(data){
                    $.each(data,function(index,item){
                        $('#liquorBrand').append(new Option(item.brandName,item.brandId));//往下拉菜单里添加元素
                    })
                    form.render();//菜单渲染 把内容加载进去
                }
            });
            /*================================================动态向类型下拉选择框中添加选项========================================*/
            $.ajax({
                url:'/Brand/findKind.action',
                dataType:'json',
                type:'post',
                success:function(data){
                    $.each(data,function(index,item){
                        $('#liquorKind').append(new Option(item.kindName,item.kindId));//往下拉菜单里添加元素
                    })
                    form.render();//菜单渲染 把内容加载进去
                }
            });

        })

        //================================================================监听行工具事件============================================
        table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
            var data = obj.data //获得当前行数据
                ,layEvent = obj.event; //获得 lay-event 对应的值
            if(layEvent === 'update'){
     /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++修改+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                layer.confirm('确定修改行么', function(index){
                    console.log(data)
                    $.ajax({
                        type:'POST',
                        url:'/Liquor/updateLquor.action',
                        contentType:'application/json;charset=UTF-8',
                        data:JSON.stringify({"liquorId":data.liquorId,"liquor_name":data.liquor_name,"brand":data.brand.brandId,"origin":data.origin,"price":data.price,"production_date":data.production_date,"alcoholic_strength":data.alcoholic_strength,"kind":data.kind.kindId}),

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

            } else if(layEvent === 'del'){
     /*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++删除+++++++++++++++++++++++++++++++++++++++++++++++++++++*/
                layer.confirm('确定删除行么', function(index){
                    obj.del(); //删除对应行（tr）的DOM结构
                    $.ajax({
                        type:'POST',
                        url:'/Liquor/deleteLiquor.action',
                        data:{"liquorId":data.liquorId},

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
                    layer.closeAll();
                });

            } else if(layEvent === 'edit'){
                layer.msg('编辑操作');
            }
        });




    });
</script>

</body>
</html>
