package com.groupeisi.entities;




import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false, length = 100)
    private String nom;
    @ManyToOne
    private AppUser appUser;
    @OneToMany(mappedBy = "IEF")
    private List<Ief> ief;
}
