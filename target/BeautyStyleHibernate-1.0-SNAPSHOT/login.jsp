<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar sesión - Beauty Style</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

    <main class="auth-view">

        <section class="auth-card">

            <img src="images/logo.jpg"
                 alt="Logo Beauty Style"
                 class="auth-logo">

            <h1>Iniciar sesión</h1>

            <p class="muted">
                Ingresa a tu cuenta para gestionar tus citas.
            </p>

            <form action="LoginServlet" method="post">

                <label for="usuario">Usuario</label>

                <input type="text"
                       id="usuario"
                       name="usuario"
                       placeholder="Ingresa tu usuario"
                       required>

                <label for="password">Contraseña</label>

                <input type="password"
                       id="password"
                       name="password"
                       placeholder="Ingresa tu contraseña"
                       required>

                <button type="submit"
                        class="btn btn-primary btn-block">
                    Iniciar sesión
                </button>

            </form>

            <p>
                ¿No tienes una cuenta?
                <a href="#" class="link-btn">Registrarse</a>
            </p>

        </section>

    </main>

</body>
</html>