package com.appGroupeAuto.apprenantGroupe.Model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString @Setter @Getter
public class Apprenant implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @Column(unique = true)
    private String nom;
    private  Long tel;
    private String email;
    @ManyToMany(mappedBy = "apprenants",fetch = FetchType.EAGER)
    private Collection<Groupe> groupes = new ArrayList<>();
}
