<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, java.util.ArrayList, tecsup.edu.pe.democrudjdbc.model.Curso" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Lista de Cursos</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <style>
    body {
      background-color: #121212;
      color: #FFD700;
      font-family: 'Arial', sans-serif;
    }
    .container {
      background: #1c1c1c;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 0 15px rgba(255, 215, 0, 0.8);
    }
    h2 {
      text-align: center;
      color: #FFD700;
      font-weight: bold;
    }
    .table-dark {
      background-color: #000;
      color: #FFD700;
    }
    .table-dark th {
      background-color: #222;
    }
    .btn {
      font-weight: bold;
    }
    .btn-warning {
      background-color: #FFD700;
      color: #121212;
      border: none;
    }
    .btn-danger {
      background-color: #C0392B;
      color: white;
      border: none;
    }
    .btn-success {
      background-color: #27AE60;
      color: white;
      border: none;
    }
    .btn-warning:hover, .btn-danger:hover, .btn-success:hover {
      filter: brightness(1.2);
    }
  </style>
</head>
<body>

<div class="container mt-5">
  <h2>Lista de Cursos</h2>

  <%
    List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");

    if (cursos == null) {
      cursos = new ArrayList<>();
      out.println("<p class='text-danger text-center'>⚠️ No se han recibido cursos desde el servidor.</p>");
    } else if (cursos.isEmpty()) {
      out.println("<p class='text-warning text-center'>⚠️ La lista de cursos está vacía.</p>");
    } else {
      out.println("<p class='text-success text-center'>✅ Se encontraron " + cursos.size() + " cursos.</p>");
    }
  %>

  <table class="table table-bordered table-dark">
    <thead>
    <tr>
      <th>Código</th>
      <th>Nombre</th>
      <th>Créditos</th>
      <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <%
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
    <% } %>
    </tbody>
  </table>

  <div class="text-center mt-4">
    <a href="lista?action=nuevo" class="btn btn-success btn-lg">Crear Nuevo Curso</a>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
