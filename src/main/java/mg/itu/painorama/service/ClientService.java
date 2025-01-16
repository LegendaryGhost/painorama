package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Client;
import mg.itu.painorama.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> findAll() {
	return clientRepository.findAll();
    }

    public List<Client> findByDateVente(LocalDate dateVente) {
	return clientRepository.findByVenteDate(dateVente);
    }

}
