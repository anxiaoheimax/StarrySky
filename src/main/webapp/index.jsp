<%--
  Created by IntelliJ IDEA.
  User: 安小黑
  Date: 2019/9/4
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>




<button id="update">点击修改</button>
<button id="add">点击添加</button>
<button id="delete">点击删除</button>
<button id="select">点击使用id查询</button>
<a href="/Liquor/selectLiquor.action?id=2">点击使用id查询</a>
<button id="selectpage">点击分页查询</button>


<script src="js/jquery.min.js"></script>
<script>

    $(document).ready(function () {

        $("#update").click(function () {
            $.ajax({
                type:'POST',
                url:'/Liquor/updateLquor.action',
                contentType:'application/json;charset=UTF-8',
                /*String liquor_name, String origin, Date production_date*/
                /*int liquorId, int price*/
                data:'{"liquorId":5,"price":23}',
                success:function (data) {
                    console.log(data);
                }
            })
        })
        $("#add").click(function () {
            $.ajax({
                type:'POST',
                url:'/Liquor/addLiquor.action',
                contentType:'application/json;charset=UTF-8',
                /*String liquor_name, Brand brand, String origin, int price, Date production_date, float alcoholic_strength, Kind kind*/
                data:'{"liquor_name":"火石榴","brand":7,"origin":"美国","price":153,"production_date":"1800-10-20 12:30:10","alcoholic_strength":6.5,"kind":2}',
                success:function (data) {
                    console.log(data);
                }
            })
        })
        $("#delete").click(function () {
            $.ajax({
                type:'POST',
                url:'/Liquor/deleteLiquor.action',
                contentType:'application/json;charset=UTF-8',
                /*String liquor_name, Brand brand, String origin, int price, Date production_date, float alcoholic_strength, Kind kind*/
                data:'{"liquorId":10}',
                success:function (data) {
                    console.log(data);
                }
            })
        })
        $("#select").click(function () {
            $.ajax({
                type:'POST',
                url:'/Liquor/selectLiquor.action',
                contentType:'application/json;charset=UTF-8',
                /*String liquor_name, Brand brand, String origin, int price, Date production_date, float alcoholic_strength, Kind kind*/
                data:'{"liquorId":2}',
                success:function (data){
                    console.log(data);
                }
            })
        })




    })

</script>


</body>
</html>
