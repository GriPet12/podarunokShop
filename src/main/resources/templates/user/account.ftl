<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
name:${info.name}<br>
username:${info.username}<br>
user role:${info.userRole}<br>

<#if info.number?has_content>
number:${info.number}<br>
</#if>

<#if info.address?has_content>
address:${info.address}<br>
</#if>

<#if info.orders?has_content>
<div id="orders">
    <#list info.orders as order>
        ----------------------------
        Замовлення № ${order.idOrder}
        <#list order.products as product>
            Імя продукта: ${product.nameProduct}
        </#list>
        ----------------------------
    </#list>
</div>
</#if>
<br>
</body>
</html>