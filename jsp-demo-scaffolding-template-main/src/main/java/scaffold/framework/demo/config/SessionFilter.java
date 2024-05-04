package scaffold.framework.demo.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false); // Récupère la session s'il existe
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            if (session != null && session.getAttribute("username") != null) {
                response.sendRedirect(request.getContextPath() + "/promotions/list");
                return;
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
                return;
            }
        }
        if (request.getRequestURI().endsWith("/login")) {

            if (session != null && session.getAttribute("username") != null) {
                response.sendRedirect(request.getContextPath() + "/promotions/list");
                return;
            }
            filterChain.doFilter(request, response);
            return;
        }
        // Vérifie si la session est présente et si l'utilisateur est connecté
        if (session == null || session.getAttribute("username") == null) {
            // Redirige vers la page de connexion si la session n'est pas présente ou si
            // l'utilisateur n'est pas connecté
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // Passe la requête au filtre suivant dans la chaîne de filtres
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
