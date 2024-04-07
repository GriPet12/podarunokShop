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
    <#list products as product>
        <a href="/product/item/${product.id}">product</a><br>
        name:${product.name}<br>
        inscription:${product.inscription}<br>
        price:${product.price}<br>
        image1:${product.image1}<br>
        image2:${product.image2}<br>
        image3:${product.image3}<br>
        image4:${product.image4}<br>
        image5:${product.image5}<br>
        -----------------------------------------------------------------------<br>
    </#list>
</body>
</html>