package mg.itu.painorama.service;

import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Vente;
import mg.itu.painorama.repository.VenteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class VenteService {

    private final VenteRepository venteRepository;

    public void create(Vente vente) {
	venteRepository.save(vente);
    }

    public List<Vente> findAll() {
	return venteRepository.findAll();
    }

    public List<Vente> findByCriteria(Integer idCategorie, Integer idParfum) {
	return venteRepository.findAll((root, query, cb) -> {
	    List<Predicate> predicates = new ArrayList<>();

	    if (idCategorie != null) {
		predicates.add(cb.equal(root.get("produit").get("categorie").get("id"), idCategorie));
	    }
	    if (idParfum != null) {
		predicates.add(cb.equal(root.get("produit").get("parfum").get("id"), idParfum));
	    }

	    return cb.and(predicates.toArray(new Predicate[0]));
	});
    }
}
