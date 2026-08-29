<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.beautystylehibernate.Cita"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Mis citas - Beauty Style</title>

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="app-shell">

    <header class="topbar">

        <div class="brand">

            <img src="images/logo.jpg" alt="Beauty Style">

            <div>
                <strong>Beauty Style</strong>
                <span>Tu espacio de belleza</span>
            </div>

        </div>

    </header>


    <main class="main-content">

        <div class="page-heading">

            <h1>Mis citas</h1>

            <p>Consulta y administra tus reservas</p>

        </div>


        <div class="appointments-list">

            <%
                List<Cita> citas = (List<Cita>) request.getAttribute("citas");

                if (citas != null && !citas.isEmpty()) {

                    for (Cita cita : citas) {
            %>

            <div class="appointment-card">

                <div class="quick-icon">
                    📅
                </div>


                <div>

                    <h3>
                        <%= cita.getServicio().getNombre_servicio() %>
                    </h3>

                    <p>
                        <strong>Estilista:</strong>
                        <%= cita.getEstilista().getNombre() %>
                    </p>

                    <p>
                        <strong>Fecha:</strong>
                        <%= cita.getFecha() %>
                    </p>

                    <p>
                        <strong>Hora:</strong>
                        <%= cita.getHora() %>
                    </p>

                    <p>
                        <strong>Estado:</strong>
                        <%= cita.getEstado() %>
                    </p>

                </div>


                <div class="appointment-actions">

                    <button class="btn btn-primary btn-small"
                            type="button">
                        Modificar
                    </button>

                    <button class="btn btn-danger btn-small"
                            type="button">
                        Cancelar
                    </button>

                </div>

            </div>

            <%
                    }

                } else {
            %>

            <div class="form-card">

                <h2>No tienes citas agendadas</h2>

                <p>
                    Cuando agendes una cita aparecerá aquí.
                </p>

                <a href="agendar.jsp"
                   class="btn btn-primary">
                    Agendar cita
                </a>

            </div>

            <%
                }
            %>

        </div>

    </main>


    <nav class="bottom-nav">

        <a href="inicio.jsp" class="nav-item">

            <span>⌂</span>
            <small>Inicio</small>

        </a>


        <a href="MisCitasServlet" class="nav-item active">

            <span>◷</span>
            <small>Citas</small>

        </a>


        <a href="#" class="nav-item">

            <span>✦</span>
            <small>Servicios</small>

        </a>


        <a href="#" class="nav-item">

            <span>♡</span>
            <small>Contacto</small>

        </a>


        <a href="#" class="nav-item">

            <span>◉</span>
            <small>Perfil</small>

        </a>

    </nav>

</div>

</body>
</html>