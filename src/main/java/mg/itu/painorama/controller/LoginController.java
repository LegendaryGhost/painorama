package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.dto.LoginRequest;
import mg.itu.painorama.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class LoginController {

    private final UtilisateurService utilisateurService;

    // Affiche le formulaire de connexion
    @GetMapping("/")
    public String showLoginForm(Model model) {
	model.addAttribute("loginRequest", new LoginRequest());
	return "login";
    }

    // Traite la soumission du formulaire
    @PostMapping("/login")
    public String processLogin(@ModelAttribute("loginRequest") LoginRequest loginRequest, Model model) {
	boolean isAuthenticated = utilisateurService.authenticate(loginRequest);
	if (isAuthenticated) {
	    // Redirige vers une page sécurisée après le login réussi
	    return "redirect:/ingredients/fiche";
	} else {
	    // Ajoute un message d'erreur au modèle si le login échoue
	    model.addAttribute("error", "Email ou mot de passe incorrect.");
	    return "login";
	}
    }
}
