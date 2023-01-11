package com.groupeisi.domain;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRolesDTO {

    private int id;
    @NotNull(message = "Le nom ne doit pas etre null")
    private String nom;

}
