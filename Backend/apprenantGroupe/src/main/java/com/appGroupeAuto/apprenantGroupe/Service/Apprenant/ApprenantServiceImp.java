package com.appGroupeAuto.apprenantGroupe.Service.Apprenant;

import com.appGroupeAuto.apprenantGroupe.Model.Apprenant;
import com.appGroupeAuto.apprenantGroupe.repository.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprenantServiceImp implements ApprenantService {
    @Autowired
    ApprenantRepository apprenantRepository;

    @Override
    public List<Apprenant> listApprenant() {
        return null;
    }

    @Override
    public void saveApprenant(Apprenant apprenant) {
        
    }

    @Override
    public void updateApprenant(Long id, Apprenant apprenant) {

    }

    @Override
    public void deleteApprenant(Long id) {

    }
}
