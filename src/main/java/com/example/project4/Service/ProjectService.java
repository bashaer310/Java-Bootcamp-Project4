package com.example.project4.Service;


import com.example.project4.Api.ApiException;
import com.example.project4.Model.CustomerModel;
import com.example.project4.Model.ProjectModel;
import com.example.project4.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectModel> getProjects(){
        return projectRepository.findAll();
    }


    public void addProject(ProjectModel project){
        project.setCreatedAt(LocalDate.now());
        projectRepository.save(project);
    }

    public void updateProject(Integer id, ProjectModel project){
        ProjectModel oldProject=projectRepository.findProjectModelById(id);
        if(oldProject==null)
            throw new ApiException("Id not found");
        oldProject=project;
        oldProject.setCreatedAt(LocalDate.now());
        oldProject.setId(id);
        projectRepository.save(oldProject);
    }

    public void deleteProject(Integer id){
        ProjectModel project=projectRepository.findProjectModelById(id);
        if(project==null)
            throw new ApiException("Id not found");
        projectRepository.delete(project);
    }


    public ProjectModel getProjectById(Integer id){
        ProjectModel project=projectRepository.findProjectModelById(id);
        if(project==null)
            throw new ApiException("Id not found");

        return project;
    }

    public List<ProjectModel> getProjectsByCategory(String category){
        List<ProjectModel> projects=projectRepository.findProjectModelByCategory(category);
        if(projects==null)
            throw new ApiException("Projects not found");

        return projects;
    }

    public List<ProjectModel> getProjectsByStatus(String status){
        List<ProjectModel> projects=projectRepository.findProjectModelByStatus(status);
        if(projects==null)
            throw new ApiException("Projects not found");

        return projects;
    }

    public List<ProjectModel> getProjectsByPriceGreaterThan(Integer price){
        List<ProjectModel> projects=projectRepository.findProjectModelByMaxPriceGreaterThanEqual(price);
        if(projects==null)
            throw new ApiException("Projects not found");

        return projects;
    }
    public List<ProjectModel> getProjectsByCreatedAtAfter(LocalDate date){
        List<ProjectModel> projects=projectRepository.findProjectModelByCreatedAtAfter(date);
        if(projects==null)
            throw new ApiException("Projects not found");

        return projects;
    }

    public void changeStatus(Integer id){
        ProjectModel project=projectRepository.findProjectModelById(id);

        if(project==null)
            throw new ApiException("Project not found");

        if (project.getStatus().equals("opened"))
            project.setStatus("finished");
        else
            project.setStatus("opened");

        projectRepository.save(project);

    }


}
