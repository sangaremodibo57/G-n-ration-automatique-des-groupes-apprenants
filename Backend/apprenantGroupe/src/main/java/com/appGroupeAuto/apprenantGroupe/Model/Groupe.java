package com.appGroupeAuto.apprenantGroupe.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Setter @Getter @ToString
public class Groupe implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(unique = true)
    private String nom;
    private Date dateCreation;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Apprenant> apprenants = new ArrayList<>();
}