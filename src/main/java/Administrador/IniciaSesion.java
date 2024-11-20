package Administrador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/procesarInicioSesion")
public class IniciaSesion extends HttpServlet {

    private static final String CORREO_VALIDO = "lolitapalta11@gmail.com";
    private static final String CONTRASENA_VALIDA = "1234";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        // Verificar si las credenciales son correctas
        if (CORREO_VALIDO.equals(correo) && CONTRASENA_VALIDA.equals(contrasena)) {
            // Si las credenciales son correctas, redirigir a la página de bienvenida
            request.getRequestDispatcher("bienvenido.jsp").forward(request, response);
        } else {
            // Si las credenciales son incorrectas, redirigir a la página de error
            request.setAttribute("error", "Correo o contraseña incorrectos.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
