package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Vente;
import mg.itu.painorama.repository.VenteRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VenteService {

    private final VenteRepository venteRepository;

    public void create(Vente vente) {
	venteRepository.save(vente);
    }

}
