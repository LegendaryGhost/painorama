package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Parfum;
import mg.itu.painorama.repository.ParfumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ParfumService {

    private final ParfumRepository parfumRepository;

    public List<Parfum> findAll() {
	return parfumRepository.findAll();
    }

}
