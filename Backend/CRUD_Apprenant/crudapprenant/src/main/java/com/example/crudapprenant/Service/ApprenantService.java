package com.example.crudapprenant.Service;

import com.example.crudapprenant.Model.Apprenant;
import com.example.crudapprenant.Model.Groupe;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface ApprenantService {
    public Apprenant addapprenant(Apprenant apprenant);
    public Apprenant updateapprenant(Apprenant apprenant, Long id);
    public List<Apprenant> getallapprenant();
    public Apprenant getoneapprenant(Long id);
    public void deleteapprenant(Long id);
    

}
