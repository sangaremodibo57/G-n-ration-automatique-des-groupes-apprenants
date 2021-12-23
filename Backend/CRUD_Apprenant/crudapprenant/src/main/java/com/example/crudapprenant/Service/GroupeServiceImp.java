package com.example.crudapprenant.Service;

import com.example.crudapprenant.Model.Apprenant;
import com.example.crudapprenant.Model.Groupe;
import com.example.crudapprenant.Repository.ApprenantRepository;
import com.example.crudapprenant.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class GroupeServiceImp implements GroupeService {
    @Autowired
    GroupeRepository groupeRepository;
    @Autowired
    ApprenantRepository apprenantRepository;

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

    @Override
    public List<Groupe> Nbregrpeapprenant(Integer nombreGroupe) {
        List<Groupe> groupeList = new ArrayList<>();
        //Listes des apprenants
        List<Apprenant> allApprenants = apprenantRepository.findAll();
        //Shuffle liste
        Collections.shuffle(allApprenants);
        List<List<Apprenant>> listgroupe = IntStream.range(0, allApprenants.size())
                .boxed()
                .collect(Collectors.groupingBy(i -> i % nombreGroupe))
                .values()
                .stream()

                .map(il -> il.stream().map(allApprenants::get).collect(Collectors.toList()))
                .collect(Collectors.toList());


        for (int i = 0; i < nombreGroupe; i++) {
            Groupe groupe = new Groupe();
            groupe.setNom("Groupe" + i);
            groupe.setApprenants(listgroupe.get(i));
            groupeRepository.save(groupe);
            groupeList.add(groupe);
        }
        return groupeList;
    }


}
