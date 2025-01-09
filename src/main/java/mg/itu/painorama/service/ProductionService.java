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

}
