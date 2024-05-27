<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Замовлення</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Додаткові стилі можна додати тут */
    </style>
</head>
<body>

<#include "../parts/header.ftl">

<div class="container mt-5">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <#if orderInfo?has_content>
            <form method="post">
                <div class="form-group">
                    <label for="name">Ім'я:</label>
                    <input type="text" class="form-control" id="name" name="name" <#if orderInfo.name?has_content>value="${orderInfo.name}"</#if>>
                </div>
                <div class="form-group">
                    <label for="number">Номер телефону:</label>
                    <input type="text" class="form-control" id="number" name="number" <#if orderInfo.number?has_content>value="${orderInfo.number}"</#if>>
                </div>
                <div class="form-group">
                    <label for="city">Місто/населений пункт:</label>
                    <input type="text" class="form-control" id="city" name="city" <#if orderInfo.city?has_content>value="${orderInfo.city}"</#if>>
                </div>
                <div class="form-group">
                    <label for="department">Номер відділення/індекс:</label>
                    <input type="text" class="form-control" id="department" name="department" <#if orderInfo.department?has_content>value="${orderInfo.department}"</#if>>
                </div>
                <button type="submit" class="btn btn-primary">Замовити</button>
            </form>
            <#else>
                <form method="post">
                    <div class="form-group">
                        <label for="name">Ім'я:</label>
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="number">Номер телефону:</label>
                        <input type="text" class="form-control" id="number" name="number">
                    </div>
                    <div class="form-group">
                        <label for="city">Місто/населений пункт:</label>
                        <input type="text" class="form-control" id="city" name="city">
                    </div>
                    <div class="form-group">
                        <label for="department">Номер відділення/індекс:</label>
                        <input type="text" class="form-control" id="department" name="department">
                    </div>
                    <button type="submit" class="btn btn-primary">Замовити</button>
                </form>
            </#if>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
