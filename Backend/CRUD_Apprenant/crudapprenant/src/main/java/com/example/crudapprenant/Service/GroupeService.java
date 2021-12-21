package com.example.crudapprenant.Service;

import com.example.crudapprenant.Model.Groupe;

import java.util.List;

public interface GroupeService {
    public Groupe addgroupe(Groupe groupe);
    public Groupe updategroupe(Groupe groupe, Long id);
    public List<Groupe> getallgroupe();
    public Groupe getgroupeByid(Long id);
    public  void deletegroupe(Long id);
}
