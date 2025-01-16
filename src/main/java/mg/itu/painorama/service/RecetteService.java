package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Produit;
import mg.itu.painorama.entity.Recette;
import mg.itu.painorama.repository.RecetteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RecetteService {

    private final RecetteRepository recetteRepository;

    public void create(Recette recette) {
	recetteRepository.save(recette);
    }

    public List<Recette> findByIdProduit(Integer id) {
        Produit produit = new Produit();
        produit.setId(id);
        return recetteRepository.findByProduit(produit);
    }
}
