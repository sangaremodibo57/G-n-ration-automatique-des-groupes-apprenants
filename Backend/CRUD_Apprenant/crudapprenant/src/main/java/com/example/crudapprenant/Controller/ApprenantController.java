package com.example.crudapprenant.Controller;

import com.example.crudapprenant.Model.Apprenant;
import com.example.crudapprenant.Service.ApprenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud_apprenant/api/v1")
@CrossOrigin("*")
public class ApprenantController {
    @Autowired
    ApprenantService appreService;

//Ajout d'un apprenant
    @PostMapping("/savesapprenant")
    public Apprenant saveapprenant(@RequestBody Apprenant apprenant) {
        return appreService.addapprenant(apprenant);
    }
//Modification de l'apprenant
    @PutMapping("/modifapprenant/{id}")
    public Apprenant modifapprenant(@RequestBody Apprenant apprenant, @PathVariable Long id) {
        return appreService.updateapprenant(apprenant, id);
    }
    //Affichage de tous apprenants
    @GetMapping("/allapprenants")
    public List<Apprenant> getsallapprenant() {
        return appreService.getallapprenant();
    }
//Affichage d'un seul  apprenant
    @GetMapping("/oneapprenant/{id}")
    public Apprenant getoneapprenantbyId(@PathVariable Long id) {
        return appreService.getoneapprenant(id);
}
//Suppression d'un seul apprenant
    @DeleteMapping("/deleteapprenant/{id}")
    public void deleteapprenantbyId(@PathVariable Long id) {
        appreService.deleteapprenant(id);

}


}
