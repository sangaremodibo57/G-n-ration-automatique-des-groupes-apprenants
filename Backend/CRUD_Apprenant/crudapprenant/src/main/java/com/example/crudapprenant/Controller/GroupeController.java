package com.example.crudapprenant.Controller;

import com.example.crudapprenant.Model.Groupe;
import com.example.crudapprenant.Service.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud_apprenant/api/v1")
@CrossOrigin("*")
public class GroupeController {
    @Autowired
    GroupeService groupeService;

    //Ajout d'un groupe
    @PostMapping("/savegroupe")
    public Groupe savegroupe(@RequestBody Groupe groupe) {
        return groupeService.addgroupe(groupe);
    }

    //Modification d'un groupe
    @PutMapping("/updategroupe/{id}")
    public Groupe modifgroupe(@RequestBody Groupe groupe, @PathVariable Long id) {
        return groupeService.updategroupe(groupe, id);
    }

    //Affichage des groupes
    @GetMapping("/getallgroupe")
    public List<Groupe> allgroupe() {
        return groupeService.getallgroupe();
    }

    //Affichage d'un groupe par id
    @GetMapping("/getonegroupe/{id}")
    public Groupe groupeByid(@PathVariable Long id) {
        return groupeService.getgroupeByid(id);
    }
    //Suppression d'un groupe par id
    @DeleteMapping("/deletegroupebyId/{id}")
    public void deletegroupeByid(@PathVariable Long id) {
        groupeService.deletegroupe(id);

    }
    //Groupe des Apprenants
    @GetMapping("/nbregroupe")
    public List<Groupe> Nbregrpeapprenant(@PathVariable Integer nombreGroupe) {
        return groupeService.Nbregrpeapprenant(nombreGroupe);
    }
}
