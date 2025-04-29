<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Eliminar Curso</title>
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
      color: #C0392B;
      font-weight: bold;
    }
    p {
      color: #FFD700;
      font-size: 18px;
      text-align: center;
    }
    .btn {
      font-weight: bold;
    }
    .btn-danger {
      background-color: #C0392B;
      color: white;
      border: none;
    }
    .btn-secondary {
      background-color: #555;
      color: white;
      border: none;
    }
    .btn-danger:hover, .btn-secondary:hover {
      filter: brightness(1.2);
    }
  </style>
</head>
<body>
<div class="container mt-5">
  <h2>Eliminar Curso</h2>
  <p>¿Estás seguro de que deseas eliminar este curso?</p>

  <form action="lista?action=eliminar" method="post">
    <input type="hidden" name="codigo" value="<%= request.getParameter("codigo") %>">
    <div class="text-center">
      <button type="submit" class="btn btn-danger btn-lg">Confirmar</button>
      <a href="lista?action=list" class="btn btn-secondary btn-lg">Cancelar</a>
    </div>
  </form>
</div>
</body>
</html>
