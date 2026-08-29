<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.beautystylehibernate.Cliente"%>

<%
Cliente cliente = (Cliente) session.getAttribute("cliente");

if (cliente == null) {
    response.sendRedirect("login.jsp");
    return;
}

String nombre = cliente.getNombre();

%>

<!DOCTYPE html>

<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Beauty Style | Inicio</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="app-shell">

```
<header class="topbar">

    <div class="brand">

        <img src="images/logo.jpg" alt="Beauty Style">

        <div>
            <strong>Beauty Style</strong>
            <span>Tu belleza, nuestra pasión</span>
        </div>

    </div>

    <button class="notification-btn" type="button">
        ♧
    </button>

</header>


<main class="main-content">

    <section class="page">

        <div class="hero">

            <div>

                <p class="eyebrow">BIENVENIDA</p>

                <h1>
                    Hola, <%= nombre %> ♡
                </h1>

                <p>
                    ¿Qué deseas hacer hoy?
                </p>

            </div>

            <div class="hero-symbol">
                ✂
            </div>

        </div>


        <div class="quick-grid">

           <a href="agendar.jsp" class="quick-card">

    <span class="quick-icon">📅</span>

    <span>
        <b>Agendar cita</b>
        <small>Reserva tu servicio</small>
    </span>

    <span>›</span>

</a>


        <a href="MisCitasServlet" class="quick-card">

    <span class="quick-icon">◷</span>

    <span>
        <b>Mis citas</b>
        <small>Consulta o modifica tus citas</small>
    </span>

    <span>›</span>

</a>


            <button class="quick-card" type="button">
                <span class="quick-icon">✂</span>

                <span>
                    <b>Servicios</b>
                    <small>Elige el servicio que deseas obtener</small>
                </span>

                <span>›</span>
            </button>


            <button class="quick-card" type="button">
                <span class="quick-icon">⚙</span>

                <span>
                    <b>Configuración</b>
                    <small>Personaliza el funcionamiento</small>
                </span>

                <span>›</span>
            </button>

        </div>


        <div class="section-head">

            <h2>Próxima cita</h2>

            <button class="text-btn" type="button">
                Ver todas
            </button>

        </div>


        <div class="next-appointment">

            <p class="muted">
                No tienes citas registradas todavía.
            </p>

        </div>

    </section>

</main>


<nav class="bottom-nav">

    <button class="nav-item active" type="button">
        <span>⌂</span>
        <small>Inicio</small>
    </button>

    <button class="nav-item" type="button">
        <span>◷</span>
        <small>Citas</small>
    </button>

    <button class="nav-item" type="button">
        <span>♡</span>
        <small>Servicios</small>
    </button>

    <button class="nav-item" type="button">
        <span>☎</span>
        <small>Contacto</small>
    </button>

    <button class="nav-item" type="button">
        <span>◎</span>
        <small>Perfil</small>
    </button>

</nav>


</div>

</body>
</html>
