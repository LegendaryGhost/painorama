package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Production;
import mg.itu.painorama.repository.ProductionRepository;
import org.springframework.stereotype.Service;

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
}
