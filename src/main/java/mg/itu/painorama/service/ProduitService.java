package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Produit;
import mg.itu.painorama.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public List<Produit> findAll() {
	return produitRepository.findAll();
    }

}
