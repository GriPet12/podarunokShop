<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Корзина</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Додаткові стилі можна додати тут */
    </style>
</head>
<body>
<#include "../parts/header.ftl">

<div class="container">
    <div class="row mt-5">
        <div class="col">
            <h3 class="text-center mb-4">Корзина</h3>
            <#if card?has_content>
                <#list card as item>
                    <div class="row mb-3">
                        <div class="col-3">
                            <img src="${item.product.image1}" alt="${item.product}" class="img-fluid" width="50%">
                        </div>
                        <div class="col-6">
                            <p>${item.product.nameProduct}</p>
                        </div>
                        <div class="col-3">
                            <p>Кількість: ${item.quantity}</p>
                        </div>
                    </div>
                    <hr>
                </#list>
                <div class="text-center">
                    <a href="/product/buy" class="btn btn-primary">Замовити</a>
                </div>
            <#else>
                <h4 class="text-center">Корзина порожня</h4>
            </#if>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
