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
public class Groupe_Apprenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nom;
    @ManyToOne
    private Apprenant apprenant;
    @ManyToOne
    private Groupe groupe;
}
