package com.example.groupeapprenant.Service;

import com.example.groupeapprenant.Model.Apprenant;
import com.example.groupeapprenant.Repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprenantServiceImp implements ApprenantService{
    @Autowired
    ApprenantRepository apprenantRepository;

    @Override
    public Apprenant addapprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    @Override
    public List<Apprenant> getallapprenant() {
        return apprenantRepository.findAll();
    }

    @Override
    public Apprenant getoneapprenant(Long id) {
        return apprenantRepository.getById(id);
    }

    @Override
    public Apprenant updateapprenant(Long id, Apprenant apprenant) {
        Apprenant apprenant1 = apprenantRepository.findById(id).get();
        apprenant1.setNom_complet(apprenant.getNom_complet());
        apprenant1.setEmail(apprenant.getEmail());
        apprenant1.setTelephone(apprenant.getTelephone());
        return apprenantRepository.save(apprenant);
    }

    @Override
    public String deleteapprenant(Long id) {
        apprenantRepository.deleteById(id);
        return "Suppression effectuée avec succès";

    }
}
