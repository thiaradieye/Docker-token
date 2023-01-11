package com.groupeisi.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ief {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 150)
    private String nom;
    @ManyToOne
    private IA ia;
}
