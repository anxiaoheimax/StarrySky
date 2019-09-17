<%--
  Created by IntelliJ IDEA.
  User: 安小黑
  Date: 2019/9/14
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>后台</title>
    <link rel="stylesheet" href="/layui/css/layui.css"  media="all">
    <style>
        .layui-tree-txt{
            color: rgba(255,255,255,.7);
        }
        .layui-footer{
            height: 20px;
        }

        iframe{
            width: 100%;
            height: 100%;
            border: none;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">星空酒吧后台</div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    ${sessionScope.user.getUname()}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <div id="test1" class="demo-tree demo-tree-box"></div>

        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <iframe src="sale.html" name="main"></iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        @星空酒吧
    </div>
</div>
<script src="/layui/layui.js" charset="utf-8"></script>
<script>
    //JavaScript代码区域
    layui.use(['tree', 'util','jquery','element'], function() {
        var tree = layui.tree
            , layer = layui.layer
            , util = layui.util
            , $ = layui.jquery
            ,element = layui.element;


        $.get('/Jrd/findJrdByRid.action',{"uId":${sessionScope.user.getUid()}},function (resData) {
            console.log(resData);
            tree.render({
                elem: '#test1' //默认是点击节点可进行收缩
                ,isJump:false  //点击不跳转
                ,data: resData
                ,click: function(obj){
                    var href = obj.data.href;
                    if(href){
                        window.parent.main.location.href = href;
                    }

                    // console.log(obj.state); //得到当前节点的展开状态：open、close、normal
                    // console.log(obj.elem); //得到当前节点元素
                    //
                    // console.log(obj.data.children); //当前节点下是否有子节点
                }
            });
        });

    });
</script>
</body>
</html>
