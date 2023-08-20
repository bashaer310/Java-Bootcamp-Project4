package com.example.project4.Repository;


import com.example.project4.Model.ExpertModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpertRepository extends JpaRepository<ExpertModel,Integer> {
    ExpertModel findExpertModelById(Integer id);
    List<ExpertModel> findExpertModelByMajor(String major);
    ExpertModel findExpertModelByEmailAndPassword(String email,String password);

    ExpertModel findExpertModelByUsername(String username);
}
