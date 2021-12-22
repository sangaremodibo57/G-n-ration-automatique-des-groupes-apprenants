package com.example.crudapprenant.Repository;

import com.example.crudapprenant.Model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    @Query("SELECT count(*) FROM Apprenant")
    int findBynombreapprenant();
}
