package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Unite;
import mg.itu.painorama.repository.UniteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UniteService {

    private final UniteRepository uniteRepository;

    public List<Unite> findAll() {
	return uniteRepository.findAll();
    }

}
