package com.example.groupeapprenant.Controller;

import com.example.groupeapprenant.Model.Apprenant;
import com.example.groupeapprenant.Service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groupeapprenant")
@CrossOrigin("*")
public class ApprenantController {
    @Autowired
    ApprenantService apprenantService;

    //Ajout Apprenant
    @PostMapping("/savesapprenant")
    public Apprenant addapprenant(@RequestBody Apprenant apprenant) {
        return apprenantService.addapprenant(apprenant);
    }
    //Liste apprenants
    @GetMapping("/getallsapprenant")
    public List<Apprenant> allsapprenant() {
        return apprenantService.getallapprenant();
    }
    //Afficher par son id
    @GetMapping("/apprenantbyid/{id}")
    public Apprenant getapprenantbyid(@PathVariable (value= "id") Long id) {
        return apprenantService.getoneapprenant(id);
    }
    //Modifier apprenant
    @PutMapping("/updateapprenant/{id}")
    public Apprenant updateoneapprenant(@PathVariable Long id, @RequestBody Apprenant apprenant) {
        return apprenantService.updateapprenant(id, apprenant);
    }
    //Supprimer apprenant
    @DeleteMapping("/deleteapprenant/{id}")
    public void deleteoneapprenant(@PathVariable Long id) {
        apprenantService.deleteapprenant(id);

    }
}
