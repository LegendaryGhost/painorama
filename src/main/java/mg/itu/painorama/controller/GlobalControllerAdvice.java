package mg.itu.painorama.controller;

import jakarta.servlet.http.HttpSession;
import mg.itu.painorama.entity.Utilisateur;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("utilisateur")
    public Utilisateur utilisateur(HttpSession session) {
	return (Utilisateur) session.getAttribute("utilisateur");
    }
}
