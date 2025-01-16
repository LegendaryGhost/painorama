package mg.itu.painorama.repository;

import mg.itu.painorama.entity.Produit;
import mg.itu.painorama.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecetteRepository extends JpaRepository<Recette, Integer> {
    List<Recette> findByProduit(Produit produit);
}
