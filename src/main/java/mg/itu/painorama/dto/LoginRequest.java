package mg.itu.painorama.dto;

import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String motDePasse;

}
