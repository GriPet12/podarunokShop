<html lang="ua">
<head>
    <title>Add user</title>
</head>
<body>


<div class="col-md-8">
    <form method="POST" action="/user/register">
        <h2>Додати користувача</h2>
        <div class="form-group">
            <label title="UserName: ">
                <input name="username" type="text" placeholder="Ім'я користувача"/>
            </label>
            <label title="Password: ">
                <input name="password" type="password" placeholder="Пароль"/>
            </label>
            <label title="Name: ">
                <input type="text" name="name">
            </label>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">Зареєструвати</button>
        </div>
    </form>
</div>

</body>
</html>