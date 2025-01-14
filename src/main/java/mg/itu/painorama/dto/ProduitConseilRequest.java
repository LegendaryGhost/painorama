package mg.itu.painorama.dto;

import lombok.Data;

@Data
public class ProduitConseilRequest {

    private Integer idProduit;
    private Integer annee;
    private Integer mois;
    private String description;

}
