<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add product</title>
</head>
<body>
    <form method="post">
        Name:<input type="text" name="name" value="${dto.name}"><br>
        Inscription:<input type="text" name="inscription" value="${dto.inscription}"><br>
        Price:<input type="number" name="price" value="${dto.price}"><br>
        Image1:<input type="text" name="image1" value="${dto.image1}"><br>
        Image2:<input type="text" name="image2" value="${dto.image2}"><br>
        Image3:<input type="text" name="image3" value="${dto.image3}"><br>
        Image4:<input type="text" name="image4" value="${dto.image4}"><br>
        Image5:<input type="text" name="image5" value="${dto.image5}"><br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Upload</button>
    </form>
</body>
</html>