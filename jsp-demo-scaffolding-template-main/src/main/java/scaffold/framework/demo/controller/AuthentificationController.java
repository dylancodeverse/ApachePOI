package scaffold.framework.demo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller

public class AuthentificationController {
    @Autowired
    private DataSource dataSource;

    @GetMapping("/login")
    public String showLoginPage() {
        return "pages/authentification/login"; // Affiche la page de connexion (login.html)
    }

    @PostMapping("/login")
    public String processLoginForm(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection connection = dataSource.getConnection()) {

            String query = "SELECT * FROM utilisateur WHERE nom_utilisateur = ? AND mot_de_passe = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                statement.setString(2, password);

                System.out.println(statement);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        session.setAttribute("role", resultSet.getInt("role"));
                        return "redirect:/promotions/list";
                    } else {
                        return "pages/authentification/login";
                    }
                }
            }
        } catch (SQLException e) {
            // Gestion des exceptions
            e.printStackTrace();
            return "pages/authentification/login";
        }
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "pages/authentification/register"; // Affiche la page d'inscription (register.html)
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            // Supprime l'attribut d'utilisateur de la session
            session.removeAttribute("username");
            session.removeAttribute("role");
            session.invalidate();
        }
        return "pages/authentification/login";
    }
}
