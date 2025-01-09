package mg.itu.painorama.service;

import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Production;
import mg.itu.painorama.entity.Recette;
import mg.itu.painorama.repository.ProductionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductionService {

    private final ProductionRepository productionRepository;

    public List<Production> findAll() {
	return productionRepository.findAll();
    }

    public Production findById(Integer id) {
	return productionRepository.findById(id).orElseThrow(() -> new RuntimeException("Production introuvable"));
    }

    public void create(Production production) {
	productionRepository.save(production);
    }

    public void update(Production production) {
	productionRepository.save(production);
    }

    public void delete(Integer id) {
	productionRepository.deleteById(id);
    }

    public List<Production> findByCriteria(Integer idProduit, Integer idStatut, LocalDate date, Integer idCategorie,
	    Integer idIngredient) {
	return productionRepository.findAll((root, query, cb) -> {
	    List<Predicate> predicates = new ArrayList<>();

	    if (idProduit != null) {
		predicates.add(cb.equal(root.get("produit").get("id"), idProduit));
	    }
	    if (idStatut != null) {
		predicates.add(cb.equal(root.get("statutProduction").get("id"), idStatut));
	    }
	    if (date != null) {
		predicates.add(cb.equal(cb.function("date", LocalDate.class, root.get("dateHeure")), date));
	    }
	    if (idCategorie != null) {
		predicates.add(cb.equal(root.get("produit").get("categorie").get("id"), idCategorie));
	    }
	    if (idIngredient != null) {
		// Créer un sous-requête pour filtrer les produits contenant l'ingrédient
		assert query != null;
		Subquery<Integer> subquery = query.subquery(Integer.class);
		Root<Recette> recetteRoot = subquery.from(Recette.class);
		subquery.select(recetteRoot.get("produit").get("id"))
			.where(cb.equal(recetteRoot.get("ingredient").get("id"), idIngredient));

		// Ajouter le prédicat pour que le produit soit dans les résultats de la sous-requête
		predicates.add(root.get("produit").get("id").in(subquery));
	    }

	    return cb.and(predicates.toArray(new Predicate[0]));
	});
    }

}
