<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Каталог товарів</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<#include "../parts/header.ftl">
<div class="container py-4">
    <h1 class="mb-4">Каталог товарів</h1>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <#list products as product>
            <div class="col">
                <div class="card h-100">
                    <#if product.image1?has_content>
                        <div id="carousel-${product.id}" class="carousel slide" data-bs-ride="carousel">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <a href="/product/item/${product.id}">
                                        <img src="${product.image1}" class="d-block w-100" alt="${product.name}">
                                    </a>
                                </div>
                                <#if product.image2?has_content>
                                    <div class="carousel-item">
                                        <a href="/product/item/${product.id}">
                                            <img src="${product.image2}" class="d-block w-100" alt="${product.name}">
                                        </a>
                                    </div>
                                </#if>
                                <#if product.image3?has_content>
                                    <div class="carousel-item">
                                        <a href="/product/item/${product.id}">
                                            <img src="${product.image3}" class="d-block w-100" alt="${product.name}">
                                        </a>
                                    </div>
                                </#if>
                                <!-- Додайте інші картинки товару, якщо необхідно -->
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#carousel-${product.id}" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#carousel-${product.id}" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </#if>
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">${product.inscription}</p>
                        <p class="card-text">Ціна: ${product.price} ГРН.</p>
                        <a href="/product/item/${product.id}" class="btn btn-primary">Детальніше</a>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
