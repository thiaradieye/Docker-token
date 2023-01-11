package com.groupeisi.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 150)
    private String prenom;
    @Column(nullable = false, length = 200)
    private String nom;
    @Column(nullable = false, length = 200)
    private String email;
    @Column(nullable = false, length = 200)
    private String password;
    @Column(nullable = false, length = 200)
    private int etat;
    @ManyToMany
    private List<AppRoles> appRoles;
    @OneToMany(mappedBy = "appUser")
    private  List<IA> ia;

}
