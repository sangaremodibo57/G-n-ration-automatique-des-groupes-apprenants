package com.example.crudapprenant.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nom_complet;
    private String email;
    private Long telephone;
    @OneToMany(mappedBy = "apprenant")
    private Collection<Apprenant> apprenant;

}