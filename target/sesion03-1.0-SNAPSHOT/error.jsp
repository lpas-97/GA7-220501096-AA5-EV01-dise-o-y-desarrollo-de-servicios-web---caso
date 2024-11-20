<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio de Sesión - HotelsCloud</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            text-align: center;
        }
        form {
            background-color: white;
            border-radius: 10px;
            padding: 20px;
            margin: 50px auto;
            max-width: 400px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.3);
        }
        form input, form button {
            width: calc(100% - 20px);
            margin: 10px 0;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        form button {
            background-color: #007BFF;
            color: white;
            cursor: pointer;
            border: none;
        }
        form button:hover {
            background-color: #0056b3;
        }
        /* Estilo para el logo */
        .logo {
            width: 100px; /* Tamaño reducido del logo */
            margin-bottom: 20px; /* Espacio debajo del logo */
        }
        /* Estilo para el enlace "Olvidaste tu contraseña" */
        .forgot-password {
            color: navy;
            text-decoration: underline;
            font-family: Arial, sans-serif;
            margin-top: 10px;
            display: block;
            font-size: 14px; /* Tamaño de fuente reducido */
            text-align: left; /* Alineado a la izquierda */
        }
        .forgot-password:hover {
            color: #0056b3; /* Cambio de color al pasar el ratón */
        }
        .error-message {
            color: red;
            font-size: 14px;
            margin-top: -10px;
            margin-bottom: 10px;
            text-align: left;
            width: calc(100% - 20px); /* Alineado con los inputs */
        }
    </style>
</head>

<body>
    <form action="login" method="POST">
        <!-- Logo encima del título -->
        <img src="images/LOGO.png" alt="Logo HotelsCloud" class="logo"> 

        <h2>Inicia Sesión</h2>
        <input type="email" name="correo" placeholder="Correo Electrónico" required> 
        <input type="password" name="contrasena" placeholder="Contraseña" required>
        
        <!-- Mensaje de error si las credenciales son incorrectas -->
        <% 
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
            <p class="error-message"><%= error %></p>
        <% 
            }
        %>
        
        <!-- Enlace "¿Olvidaste tu contraseña?" -->
        <a href="recuperarContrasena.html" class="forgot-password">¿Olvidaste tu contraseña?</a>
        
        <button type="submit">Iniciar Sesión</button>
        <button type="reset">Cancelar</button>
    </form>
</body>
</html>
