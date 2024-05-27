<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Документ</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<#include "../parts/header.ftl">

<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <h3>Інформація про користувача</h3>
        </div>
        <div class="card-body">
            <#if info.name?has_content>
                <p><strong>Ім'я:</strong> ${info.name}</p>
            <#else>
                <p><strong>Ім'я:</strong> Не надано</p>
            </#if>
            <p><strong>Ім'я користувача:</strong> ${info.username}</p>
            <p><strong>Роль користувача:</strong> ${info.userRole}</p>
            <#if info.number?has_content>
                <p><strong>Номер:</strong> ${info.number}</p>
            <#else>
                <p><strong>Номер:</strong> Не надано</p>
            </#if>
            <#if info.city?has_content>
                <p><strong>Місто:</strong> ${info.city}</p>
            <#else>
                <p><strong>Місто:</strong> Не надано</p>
            </#if>
            <#if info.department?has_content>
                <p><strong>Відділ:</strong> ${info.department}</p>
            <#else>
                <p><strong>Відділ:</strong> Не надано</p>
            </#if>
        </div>
    </div>
    <#if info.orders?has_content>
        <div class="card mt-4">
            <div class="card-header">
                <h4>Замовлення</h4>
            </div>
            <div class="card-body">
                <div id="orders">
                    <#list orders as order>
                        <div class="border-bottom pb-3 mb-3">
                            <h5>Замовлення № ${order.idOrder}</h5>
                            <#list order.products as product>
                                <p><strong>Назва продукту:</strong> ${product.product.nameProduct}</p>
                            </#list>
                        </div>
                    </#list>
                </div>
            </div>
        </div>
    <#else>
        <div class="card mt-4">
            <div class="card-header">
                <h4>Замовлення</h4>
            </div>
            <div class="card-body">
                <p>Замовлення не знайдено.</p>
            </div>
        </div>
    </#if>

    <div class="mt-3" style="padding-bottom: 20px">
        <a href="/logout" class="btn btn-warning">Вийти</a>
    </div>

    <#if isAdmin>
        <div class="mt-3" style="padding-bottom: 20px">
            <a href="/product/add" class="btn btn-primary">Додати товар</a>
        </div>
    </#if>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>