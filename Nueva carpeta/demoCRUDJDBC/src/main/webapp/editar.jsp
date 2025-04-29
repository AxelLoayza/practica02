<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="tecsup.edu.pe.democrudjdbc.model.Curso" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Editar Curso</title>
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
    label {
      color: #FFD700;
      font-weight: bold;
    }
    .form-control {
      background-color: #000;
      color: #FFD700;
      border: 1px solid #FFD700;
    }
    .btn {
      font-weight: bold;
    }
    .btn-primary {
      background-color: #FFD700;
      color: #121212;
      border: none;
    }
    .btn-secondary {
      background-color: #555;
      color: white;
      border: none;
    }
    .btn-primary:hover, .btn-secondary:hover {
      filter: brightness(1.2);
    }
  </style>
</head>
<body>
<div class="container mt-5">
  <h2>Detalles del Curso</h2>

  <%
    Curso curso = (Curso) request.getAttribute("curso");
    boolean isNew = curso == null;
  %>

  <form action="lista?action=<%= isNew ? "insert" : "update" %>" method="post">
    <div class="mb-3">
      <label class="form-label">Código:</label>
      <input type="text" name="codigo" class="form-control" value="<%= isNew ? "" : curso.getCodigo() %>" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Nombre:</label>
      <input type="text" name="nombre" class="form-control" value="<%= isNew ? "" : curso.getNombre() %>" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Créditos:</label>
      <input type="number" name="creditos" class="form-control" value="<%= isNew ? "" : curso.getCreditos() %>" required>
    </div>
    <div class="text-center">
      <button type="submit" class="btn btn-primary"><%= isNew ? "Guardar" : "Actualizar" %></button>
      <a href="lista?action=list" class="btn btn-secondary">Cancelar</a>
    </div>
  </form>
</div>
</body>
</html>
