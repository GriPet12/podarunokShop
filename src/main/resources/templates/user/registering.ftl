<html lang="ua">
<head>
    <title>Add user</title>
</head>
<body>
    <form method="POST" action="/user/register">
        <h2>Додати користувача</h2>
            <label title="UserName: ">
                <input name="username" type="text" placeholder="Ім'я користувача"/>
            </label>
            <label title="Password: ">
                <input name="password" type="password" placeholder="Пароль"/>
            </label>
        <button type="submit">Зареєструвати</button>
    </form>
</body>
</html>