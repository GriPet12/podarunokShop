<html lang="ua">
<head>
    <title>Login</title>
    <style>
        #inp {
            padding-top: 20px;
        }
        .vertical-align {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 85vh;
        }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<#include "../parts/header.ftl">
<div class="container vertical-align">
    <h2 id="-description">Додати користувача</h2>
    <form method="POST">
        <div class="form-group">
            <div class="input-group mb-3" id="inp">
                <input name="username" type="text" class="form-control" placeholder="Ім'я користувача" aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3" id="inp">
                <input name="password" type="password" placeholder="Пароль" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
                <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Зареєструвати</button>
            </div>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
