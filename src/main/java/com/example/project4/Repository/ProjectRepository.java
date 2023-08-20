package com.example.project4.Repository;

import com.example.project4.Model.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel,Integer> {
    ProjectModel findProjectModelById(Integer id);
    List<ProjectModel> findProjectModelByCategory(String category);
    List<ProjectModel> findProjectModelByStatus(String status);
    List<ProjectModel> findProjectModelByMaxPriceGreaterThanEqual(Integer price);
    List<ProjectModel> findProjectModelByCreatedAtAfter(LocalDate date);

}
