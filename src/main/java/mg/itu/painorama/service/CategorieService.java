package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Categorie;
import mg.itu.painorama.repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;

    public List<Categorie> findAll() {
	return categorieRepository.findAll();
    }

}
