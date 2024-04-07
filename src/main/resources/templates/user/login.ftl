<html lang="ua">
<head>
    <title>Login</title>
</head>
<body>
        <form method="POST" action="/login">
            <h2>Вхід</h2>
            <div class="form-group">
                <input name="username" type="text" placeholder="Ім'я користувача"/>
                <input name="password" type="password" placeholder="Пароль"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit">Увійти</button>
            </div>
        </form>
</body>
</html>