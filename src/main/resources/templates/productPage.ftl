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
name:${form.name}<br>
inscription:${form.inscription}<br>
price:${form.price}<br>
image1:${form.image1}<br>
image2:${form.image2}<br>
image3:${form.image3}<br>
image4:${form.image4}<br>
image5:${form.image5}<br>
<br>
<form method="post">
    <input type="hidden" name="idProduct" value="${form.id}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <label>
        Number:
        <input type="number" name="number"><br>
    </label>
    <button type="submit">add to card</button>
</form>
</body>
</html>