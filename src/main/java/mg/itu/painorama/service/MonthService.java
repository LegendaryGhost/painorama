package mg.itu.painorama.service;

import mg.itu.painorama.dto.MoisDTO;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MonthService {

    public List<MoisDTO> getMonthsInFrench() {
	// Utilise le style complet pour les noms de mois (ex: "janvier")
	Locale frenchLocale = Locale.FRENCH;

	return Stream.of(Month.values())
		.map(month -> new MoisDTO(month.getValue(), month.getDisplayName(TextStyle.FULL, frenchLocale)))
		.collect(Collectors.toList());
    }
}
