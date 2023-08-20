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


    @GetMapping("/getProjectById/{id}")
    public ResponseEntity getProjectById(@PathVariable Integer id){
        return  ResponseEntity.status(200).body(projectService.getProjectById(id));
    }
     @GetMapping("/getProjectByCategory/{category}")
    public ResponseEntity getProjectByCategory(@PathVariable String category){
        return  ResponseEntity.status(200).body(projectService.getProjectsByCategory(category));
    }

    @GetMapping("/getProjectByStatus/{status}")
    public ResponseEntity getProjectByStatus(@PathVariable String status){
        return  ResponseEntity.status(200).body(projectService.getProjectsByStatus(status));
    }
    @GetMapping("/getProjectByPrice/{price}")
    public ResponseEntity getProjectByPrice(@PathVariable Integer price){
        return  ResponseEntity.status(200).body(projectService.getProjectsByPriceGreaterThan(price));
    }
    @GetMapping("/getProjectByDate/{date}")
    public ResponseEntity getProjectByDate(@PathVariable LocalDateTime date){
        return  ResponseEntity.status(200).body(projectService.getProjectsByCreatedAtAfter(date));
    }
    @PutMapping("/changeStatus/{id}")
    public ResponseEntity changeStatus(@PathVariable Integer id){
        projectService.changeStatus(id);
        return  ResponseEntity.status(200).body(new ApiResponse("Status changed"));

    }




}
