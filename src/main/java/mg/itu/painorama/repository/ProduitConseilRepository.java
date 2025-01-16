package mg.itu.painorama.repository;

import mg.itu.painorama.entity.ProduitConseil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitConseilRepository extends JpaRepository<ProduitConseil, Integer> {

    @Query("SELECT pc FROM ProduitConseil pc WHERE MONTH(pc.date) = :mois AND YEAR(pc.date) = :annee")
    List<ProduitConseil> findByMonthAndYear(@Param("mois") Integer mois, @Param("annee") Integer annee);

    @Query("SELECT pc FROM ProduitConseil pc WHERE YEAR(pc.date) = :annee")
    List<ProduitConseil> findByYear(@Param("annee") Integer annee);

}
