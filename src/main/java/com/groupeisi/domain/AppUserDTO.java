package com.groupeisi.domain;



import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDTO {
     private int id;
    @NotNull(message = "Le prenom ne doit pas etre null")
    private String prenom;
    @NotNull(message = "Le nom ne doit pas etre null")
     private String nom;
    @NotNull(message = "L'email ne doit pas etre null")
    private String email;
    @NotNull(message = "Le password ne doit pas etre null")
    private String password;
    private int etat;


}
