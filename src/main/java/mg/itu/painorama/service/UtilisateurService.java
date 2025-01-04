package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.dto.LoginRequest;
import mg.itu.painorama.entity.Utilisateur;
import mg.itu.painorama.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public Utilisateur findByEmailAndPassword(LoginRequest loginRequest) {
	Utilisateur utilisateur = utilisateurRepository.findByEmail(loginRequest.getEmail());

	if (utilisateur != null && utilisateurRepository.isPasswordCorrect(loginRequest.getEmail(), loginRequest.getMotDePasse())) {
	    return utilisateur;
	}

	return null;
    }

}
