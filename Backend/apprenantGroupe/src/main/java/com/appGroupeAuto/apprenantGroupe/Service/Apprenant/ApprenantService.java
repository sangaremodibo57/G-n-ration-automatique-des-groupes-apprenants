package com.appGroupeAuto.apprenantGroupe.Service.Apprenant;

import com.appGroupeAuto.apprenantGroupe.Model.Apprenant;

import java.util.List;

public interface ApprenantService {
    public List<Apprenant> listApprenant();
    public void saveApprenant(Apprenant apprenant);
    public void updateApprenant(Long id,Apprenant apprenant);
    public void deleteApprenant(Long id);
}
