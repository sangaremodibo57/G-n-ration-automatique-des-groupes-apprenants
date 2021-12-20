package com.example.groupeapprenant.Service;

import com.example.groupeapprenant.Model.Apprenant;

import java.util.List;

public interface ApprenantService {
    public Apprenant addapprenant(Apprenant apprenant);
    public List<Apprenant> getallapprenant();
    public  Apprenant getoneapprenant(Long id);
    public Apprenant updateapprenant(Long id, Apprenant apprenant);
    public String  deleteapprenant(Long id);
}
