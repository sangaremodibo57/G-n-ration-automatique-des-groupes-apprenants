package com.example.crudapprenant.Service;

import com.example.crudapprenant.Model.Groupe;
import com.example.crudapprenant.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeServiceImp implements GroupeService {
    @Autowired
    GroupeRepository groupeRepository;

    @Override
    public Groupe addgroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public Groupe updategroupe(Groupe groupe, Long id) {
        Groupe groupe1 = groupeRepository.findById(id).get();
        groupe1.setNom(groupe.getNom());
        groupe1.setDate(groupe.getDate());
        return groupeRepository.save(groupe1);
    }

    @Override
    public List<Groupe> getallgroupe() {
        return groupeRepository.findAll();
    }

    @Override
    public Groupe getgroupeByid(Long id) {
        return groupeRepository.findById(id).get();
    }

    @Override
    public void deletegroupe(Long id) {
        groupeRepository.deleteById(id);

    }
}
