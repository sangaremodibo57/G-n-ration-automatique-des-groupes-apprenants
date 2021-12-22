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
//  @Override
//    public List<Groupe> generateByNbreGroupe(Integer nombreGroupe) {
///*
//        // ************************************* Classe Random = Ordre Aléatoire *****************************
//        Random random = new Random();
//
//        // *************************************  Liste des apprenants recuperer ****************************
//        List<Apprenant> allApprenantList = apprenantRepositories.findAll();
//
//        // **************************************** Je recupère le nombre d'apprenants à travers la taille **************************
//        Integer nombreApprenant = apprenantRepositories.findAll().size();
//
//        // *************************************** Liste des groupes et les membres(Apprenant) qu'ils contiennent ***************
//        List<Groupe> groupeListGenerate = new ArrayList<Groupe>();
//        List<Apprenant> apprenantList = new ArrayList<>();
//        // ****************************************************Création de deux variables ********************
//        Integer nbreMembreParGroup = 0;
//        Integer membreNonRepartie ;
//
//        if (nombreApprenant % nombreGroupe !=0 ){
//
//            membreNonRepartie = (nombreApprenant % nombreGroupe);
//            nbreMembreParGroup = (nombreApprenant - membreNonRepartie) / nombreGroupe;
//            for (int i = 0; i <= nombreGroupe; i++ ){
//
//                for (int j = 0; j< nbreMembreParGroup; j++){
//                    int randomIdex = random.nextInt(allApprenantList.size());
//                    Apprenant randomApprenant = allApprenantList.get(randomIdex);
//                    apprenantList.add(randomApprenant);
//                    allApprenantList.remove(randomIdex);
//                }
//                Groupe groupe = new Groupe();
//                groupe.setName("Groupe"+i);
//                groupe.setApprenants(apprenantList);
//                groupeRepositories.save(groupe);
//                groupeListGenerate.add(groupe);
//                apprenantList.clear();
//            }
//        }
//            else {
//
//            nbreMembreParGroup = nombreApprenant / nombreGroupe;
//            for(int i = 1; i <= nombreGroupe; i++)
//            {
//                for(int j = 0; j < nbreMembreParGroup; j++)
//                {
//                    int randomIdex = random.nextInt(allApprenantList.size());
//                    Apprenant randomApprenant = allApprenantList.get(randomIdex);
//                    apprenantList.add(randomApprenant);
//                    allApprenantList.remove(randomIdex);
//                }
//                Groupe groupe = new Groupe();
//                groupe.setName("Groupe"+i);
//                groupe.setApprenants(apprenantList);
//                groupeRepositories.save(groupe);
//                groupeListGenerate.add(groupe);
//                apprenantList.clear();
//            }
//        }
//        return groupeListGenerate;
//    } */
///////////////////////////////////////////////////////////---------------------------------------------------
////Listes des apprenants
//        List<Apprenant> allApprenants = apprenantRepositories.findAll();
//
//        //Shuffle liste
//        Collections.shuffle(allApprenants);
//
//        List<List<Apprenant>> listGroupeGenetayed = IntStream.range(0, allApprenants.size())
//                .boxed()
//                .collect(Collectors.groupingBy(i -> i % nombreGroupe))
//                .values()
//                .stream()
//                .map(il -> il.stream().map(allApprenants::get).collect(Collectors.toList()))
//                .collect(Collectors.toList());
//
//        for(int i = 0; i < nombreGroupe; i++)
//        {
//            Groupe groupe = new Groupe();
//            groupe.setName("Groupe "+i);
//            groupe.setApprenants(listGroupeGenetayed.get(i));
//            groupeRepositories.save(groupe);
//        }
//
//        return listGroup();
//    }
//
//}