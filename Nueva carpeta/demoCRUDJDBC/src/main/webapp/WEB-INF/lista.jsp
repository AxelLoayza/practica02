<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, java.util.ArrayList, tecsup.edu.pe.democrudjdbc.model.Curso" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Cursos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<%
    List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");

    if (cursos == null) {
        cursos = new ArrayList<>(); // Evita errores de NullPointerException
        out.println("<p class='text-danger'>⚠️ No se han recibido cursos desde el servidor.</p>");
    } else if (cursos.isEmpty()) {
        out.println("<p class='text-warning'>⚠️ No hay cursos disponibles.</p>");
    } else {
        out.println("<p class='text-success'>✅ Se encontraron " + cursos.size() + " cursos.</p>");
    }
%>
<div class="container mt-5">
    <h2 class="text-center">Lista de Cursos</h2>


    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>Código</th>
            <th>Nombre</th>
            <th>Créditos</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Iterar sobre la lista de cursos
            for (Curso curso : cursos) {
        %>
        <tr>
            <td><%= curso.getCodigo() %></td>
            <td><%= curso.getNombre() %></td>
            <td><%= curso.getCreditos() %></td>
            <td>
                <a href="lista?action=buscar&codigo=<%= curso.getCodigo() %>" class="btn btn-warning btn-sm">Editar</a>
                <a href="lista?action=eliminar&codigo=<%= curso.getCodigo() %>" class="btn btn-danger btn-sm">Eliminar</a>
            </td>
        </tr>
        <%
            } // Cierre correcto del bucle `for`
        %>
        </tbody>
    </table>

    <% } // Cierre correcto de la validación `if (!cursos.isEmpty())` %>

    <a href="base?action=nuevo" class="btn btn-success">Crear Nuevo Curso</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
