package com.example.project4.Controller;


import com.example.project4.Api.ApiResponse;
import com.example.project4.Model.CustomerModel;
import com.example.project4.Model.ProjectModel;
import com.example.project4.Service.CustomerService;
import com.example.project4.Service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/project")
@RequiredArgsConstructor
public class ProjectController {


    private final ProjectService projectService;

    @GetMapping("/get")
    public ResponseEntity getProjects(){
        return  ResponseEntity.status(200).body(projectService.getProjects());
    }

    @PostMapping("/add")
    public ResponseEntity addProject(@RequestBody @Valid ProjectModel project){
        projectService.addProject(project);
        return ResponseEntity.status(200).body(new ApiResponse("Project added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProject(@RequestBody @Valid ProjectModel project, @PathVariable Integer id) {
        projectService.updateProject(id,project);
        return ResponseEntity.status(200).body(new ApiResponse("Project updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
        return ResponseEntity.status(200).body(new ApiResponse("Project deleted"));
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity getProjectById(@PathVariable Integer id){
        return  ResponseEntity.status(200).body(projectService.getProjectById(id));
    }
     @GetMapping("/getByCategory/{category}")
    public ResponseEntity getProjectsByCategory(@PathVariable String category){
        return  ResponseEntity.status(200).body(projectService.getProjectsByCategory(category));
    }

    @GetMapping("/getByStatus/{status}")
    public ResponseEntity getProjectsByStatus(@PathVariable String status){
        return  ResponseEntity.status(200).body(projectService.getProjectsByStatus(status));
    }
    @GetMapping("/getByPrice/{price}")
    public ResponseEntity getProjectsByPrice(@PathVariable Integer price){
        return  ResponseEntity.status(200).body(projectService.getProjectsByPriceGreaterThan(price));
    }
    @GetMapping("/getByDate/{date}")
    public ResponseEntity getProjectsByDate(@PathVariable LocalDate date){
        return  ResponseEntity.status(200).body(projectService.getProjectsByCreatedAtAfter(date));
    }
    @PutMapping("/changeStatus/{id}")
    public ResponseEntity changeStatus(@PathVariable Integer id){
        projectService.changeStatus(id);
        return  ResponseEntity.status(200).body(new ApiResponse("Status changed"));

    }




}
