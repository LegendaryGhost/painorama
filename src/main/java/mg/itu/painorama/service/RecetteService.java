package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Recette;
import mg.itu.painorama.repository.RecetteRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RecetteService {

    private final RecetteRepository recetteRepository;

    public void create(Recette recette) {
	recetteRepository.save(recette);
    }

}
