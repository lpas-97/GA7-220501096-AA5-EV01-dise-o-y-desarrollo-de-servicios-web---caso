package Administrador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/procesarRegistro")
public class Registrate extends HttpServlet {

    // Aquí se podrían usar una base de datos para almacenar los usuarios
    // Por ahora, usaremos un simple array para simular la existencia de un usuario
    private static final String CORREO_EXISTENTE = "lolitapalta11@gmail.com"; // Simulando un correo existente

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String nombreUsuario = request.getParameter("nombreUsuario");
        String contrasena = request.getParameter("contrasena");

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || correo.isEmpty() || nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            request.setAttribute("error", "Todos los campos son obligatorios.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // Verificar si el correo ya está registrado (esto sería una validación contra la base de datos)
        if (CORREO_EXISTENTE.equals(correo)) {
            request.setAttribute("error", "El correo electrónico ya está registrado.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }

        // Aquí puedes agregar la lógica para guardar los datos del nuevo usuario en la base de datos
        // Por ejemplo, un objeto usuario o un método que guarde la información en la base de datos

        // Si el registro es exitoso, redirigir a la página de inicio de sesión o bienvenida
        request.setAttribute("mensaje", "Registro exitoso. Por favor, inicie sesión.");
        request.getRequestDispatcher("registrate.jsp").forward(request, response);
    }
}
