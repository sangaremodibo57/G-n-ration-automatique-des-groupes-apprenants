package com.example.crudapprenant.Service;

import com.example.crudapprenant.Model.Apprenant;
import com.example.crudapprenant.Repository.ApprenantRepository;
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
    public Apprenant updateapprenant(Apprenant apprenant, Long id) {
        Apprenant appre = apprenantRepository.findById(id).get();
        appre.setNom_complet(apprenant.getNom_complet());
        appre.setEmail(apprenant.getEmail());
        appre.setTelephone(apprenant.getTelephone());
        return apprenantRepository.save(appre);
    }

    @Override
    public List<Apprenant> getallapprenant() {
        return apprenantRepository.findAll();
    }

    @Override
    public Apprenant getoneapprenant(Long id) {
        return apprenantRepository.findById(id).get();
    }

    @Override
    public void deleteapprenant(Long id) {
        apprenantRepository.deleteById(id);

    }
}
