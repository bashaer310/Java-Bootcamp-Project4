package com.example.project4.Repository;


import com.example.project4.Model.ExpertModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends JpaRepository<ExpertModel,Integer> {
}
