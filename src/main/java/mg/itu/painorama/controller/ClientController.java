package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Client;
import mg.itu.painorama.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@AllArgsConstructor
@RequestMapping("/clients")
@Controller
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/acheteurs")
    public String listeClientsAcheteurs(@RequestParam(value = "dateVente", required = false) LocalDate dateVente, Model model) {
	dateVente = dateVente == null ? LocalDate.now() : dateVente;

	model.addAttribute("clients", clientService.findByDateVente(dateVente));
	model.addAttribute("dateVente", dateVente);

	return "clients/liste";
    }

    @GetMapping("/ajouter")
    public String ajouterClient(Model model) {
	model.addAttribute("client", new Client());
	return "clients/formulaire";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarClient(@ModelAttribute("client") Client client) {
	clientService.create(client);
	return "redirect:/clients/acheteurs";
    }

}
