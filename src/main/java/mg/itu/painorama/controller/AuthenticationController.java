package mg.itu.painorama.controller;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import mg.itu.painorama.dto.LoginRequest;
import mg.itu.painorama.entity.Utilisateur;
import mg.itu.painorama.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class AuthenticationController {

    private final UtilisateurService utilisateurService;

    @GetMapping("/")
    public String showLoginForm(Model model) {
	model.addAttribute("loginRequest", new LoginRequest());
	return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginRequest") LoginRequest loginRequest, HttpSession session, Model model) {
	Utilisateur utilisateur = utilisateurService.findByEmailAndPassword(loginRequest);

	if (utilisateur != null) {
	    // Stocker l'utilisateur dans la session HTTP
	    session.setAttribute("utilisateur", utilisateur);
	    return "redirect:/ingredients/fiche";
	} else {
	    model.addAttribute("error", "Email ou mot de passe incorrect.");
	    return "login";
	}
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
	session.invalidate(); // Invalide complètement la session
	return "redirect:/";
    }

}
