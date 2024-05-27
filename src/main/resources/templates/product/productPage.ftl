<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Сторінка товару</title>
    <!-- Підключення Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<#include "../parts/header.ftl">
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <!-- Перевірка наявності зображень та відображення каруселі -->
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <!-- Перша картинка активна -->
                    <div class="carousel-item active">
                        <img src="${form.image1}" class="d-block w-100" alt="Перше зображення товару">
                    </div>
                    <!-- Інші картинки -->
                    <#if form.image2?has_content>
                        <div class="carousel-item">
                            <img src="${form.image2}" class="d-block w-100" alt="Друге зображення товару">
                        </div>
                    </#if>
                    <#if form.image3?has_content>
                        <div class="carousel-item">
                            <img src="${form.image3}" class="d-block w-100" alt="Третє зображення товару">
                        </div>
                    </#if>
                    <#if form.image4?has_content>
                        <div class="carousel-item">
                            <img src="${form.image4}" class="d-block w-100" alt="Четверте зображення товару">
                        </div>
                    </#if>
                    <#if form.image5?has_content>
                        <div class="carousel-item">
                            <img src="${form.image5}" class="d-block w-100" alt="П'яте зображення товару">
                        </div>
                    </#if>
                </div>
                <!-- Кнопки для перемикання слайдів -->
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Попереднє</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Наступне</span>
                </button>
            </div>
        </div>
        <div class="col-md-6">
            <h1 class="mt-5">${form.name}</h1>
            <p>${form.inscription}</p>
            <p>Ціна: ${form.price}</p>
            <form method="post" class="mt-3">
                <input type="hidden" name="idProduct" value="${form.id}">
                <div class="mb-3">
                    <label for="number" class="form-label">Кількість:</label>
                    <input type="number" class="form-control" id="number" name="number" value="1">
                </div>
                <button type="submit" class="btn btn-primary">Додати до кошика</button>
            </form>
            <#if isAdmin>
                <div class="mt-3">
                    <a href="/product/edit/${form.id}" class="btn btn-warning">Редагувати</a>
                    <a href="/product/delete/${form.id}" class="btn btn-danger">Видалити</a>
                </div>
            </#if>
        </div>
    </div>
</div>

<!-- Підключення Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
