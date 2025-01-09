package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.StatutProduction;
import mg.itu.painorama.repository.StatutProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StatutProductionService {

    private final StatutProductionRepository statutProductionRepository;

    public List<StatutProduction> findAll(){
	return statutProductionRepository.findAll();
    }

}
