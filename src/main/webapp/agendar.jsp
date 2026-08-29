<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.mycompany.beautystylehibernate.Cliente"%>
<%@page import="com.mycompany.beautystylehibernate.Servicio"%>
<%@page import="com.mycompany.beautystylehibernate.dao.ServicioDAO"%>
<%@page import="java.util.List"%>

<%
Cliente cliente = (Cliente) session.getAttribute("cliente");


if (cliente == null) {
    response.sendRedirect("login.jsp");
    return;
}

ServicioDAO servicioDAO = new ServicioDAO();
List<Servicio> servicios = servicioDAO.listar();


%>

<!DOCTYPE html>

<html lang="es">

<head>


<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Agendar cita | Beauty Style</title>

<link rel="stylesheet" href="css/style.css">


</head>

<body>

<div class="app-shell">

<header class="topbar">


<div class="brand">

    <img src="images/logo.jpg" alt="Beauty Style">

    <div>

        <strong>Beauty Style</strong>
        <span>Agendar cita</span>

    </div>

</div>


</header>

<main class="main-content">

<div class="page-heading">


<h1>Agendar cita</h1>

<p>
    Reserva tu próximo servicio de belleza
</p>


</div>

<section class="form-card">

<form action="AgendarCitasServlet" method="post">

<div class="two-cols">

<div>

<label>Nombre completo</label>

<input type="text"
value="<%= cliente.getNombre() + " " + cliente.getApellido() %>"
readonly>

</div>

<div>

<label>Teléfono</label>

<input type="text"
    value="<%= cliente.getTelefono() %>"
    readonly>

</div>

</div>

<label>Servicio</label>

<select name="servicio" required>

<option value="">
Seleccione un servicio
</option>

<%

for(Servicio servicio : servicios){

%>

<option value="<%= servicio.getId_servicio() %>">

<%= servicio.getNombre_servicio() %> - $<%= servicio.getPrecio() %>

</option>

<%

}

%>

</select>

<div class="two-cols">

<div>

<label>Fecha</label>

<input type="date"
    name="fecha"
    required>

</div>

<div>

<label>Hora</label>

<input type="time"
    name="hora"
    required>

</div>

</div>

<label>Nota adicional</label>

<textarea name="nota"
          rows="4"
          placeholder="Escribe alguna observación"></textarea>

<button type="submit"
     class="btn btn-primary btn-block">

Confirmar cita

</button>

</form>

</section>

</main>

<nav class="bottom-nav">

<button class="nav-item active">
<span>⌂</span>
<small>Inicio</small>
</button>

<button class="nav-item">
<span>◷</span>
<small>Citas</small>
</button>

<button class="nav-item">
<span>♡</span>
<small>Servicios</small>
</button>

<button class="nav-item">
<span>☎</span>
<small>Contacto</small>
</button>

<button class="nav-item">
<span>◎</span>
<small>Perfil</small>
</button>

</nav>

</div>

</body>

</html>
