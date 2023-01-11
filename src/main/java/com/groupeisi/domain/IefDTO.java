package com.groupeisi.domain;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IefDTO {
    private int id;
    @NotNull(message = "Le nom de doit pas etre null")
    private String nom;

}
