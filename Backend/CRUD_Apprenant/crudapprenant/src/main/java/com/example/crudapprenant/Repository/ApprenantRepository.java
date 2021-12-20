package com.example.crudapprenant.Repository;

import com.example.crudapprenant.Model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
}
