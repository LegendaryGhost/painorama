package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.dto.ProduitConseilRequest;
import mg.itu.painorama.entity.Produit;
import mg.itu.painorama.entity.ProduitConseil;
import mg.itu.painorama.repository.ProduitConseilRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class ProduitConseilService {

    private final ProduitConseilRepository produitConseilRepository;

    public void create(ProduitConseilRequest request) {
	ProduitConseil produitConseil = new ProduitConseil();

	Produit produit = new Produit();
	produit.setId(request.getIdProduit());
	produitConseil.setProduit(produit);

	produitConseil.setDescription(request.getDescription());

	LocalDate date = LocalDate.of(request.getAnnee(), request.getMois(), 1);
	produitConseil.setDate(date);

	produitConseilRepository.save(produitConseil);
    }

    public List<ProduitConseil> findByMonthAndYear(Integer mois, Integer annee) {
	return produitConseilRepository.findByMonthAndYear(mois, annee);
    }

    public List<ProduitConseil> findByYear(Integer annee) {
	return produitConseilRepository.findByYear(annee);
    }

}
