<!doctype html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Змінити товар</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Змінити товар</h1>
    <form method="post">
        <div class="form-group">
            <label for="name">Назва</label>
            <input type="text" class="form-control" id="name" name="name" value="${dto.name}" placeholder="Введіть назву товару">
        </div>
        <div class="form-group">
            <label for="inscription">Опис</label>
            <textarea class="form-control" id="inscription" name="inscription" rows="5" placeholder="Введіть опис товару">${dto.inscription}</textarea>
        </div>
        <div class="form-group">
            <label for="price">Ціна</label>
            <input type="number" class="form-control" id="price" name="price" value="${dto.price}" placeholder="Введіть ціну товару">
        </div>
        <div class="form-group">
            <label for="image1">Зображення 1</label>
            <input type="text" class="form-control" id="image1" name="image1" value="${dto.image1}" placeholder="Введіть URL зображення 1">
        </div>
        <div class="form-group">
            <label for="image2">Зображення 2</label>
            <input type="text" class="form-control" id="image2" name="image2" value="${dto.image2}" placeholder="Введіть URL зображення 2">
        </div>
        <div class="form-group">
            <label for="image3">Зображення 3</label>
            <input type="text" class="form-control" id="image3" name="image3" value="${dto.image3}" placeholder="Введіть URL зображення 3">
        </div>
        <div class="form-group">
            <label for="image4">Зображення 4</label>
            <input type="text" class="form-control" id="image4" name="image4" value="${dto.image4}" placeholder="Введіть URL зображення 4">
        </div>
        <div class="form-group">
            <label for="image5">Зображення 5</label>
            <input type="text" class="form-control" id="image5" name="image5" value="${dto.image5}" placeholder="Введіть URL зображення 5">
        </div>
        <button type="submit" class="btn btn-primary mb-3">Зберегти зміни</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
