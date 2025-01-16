package mg.itu.painorama.repository;

import mg.itu.painorama.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT DISTINCT c FROM Client c " +
	    "JOIN Vente v ON c.id = v.client.id " +
	    "WHERE FUNCTION('DATE', v.dateHeure) = :dateVente")
    List<Client> findByVenteDate(@Param("dateVente") LocalDate dateVente);

}
