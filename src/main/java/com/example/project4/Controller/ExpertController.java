package com.example.project4.Controller;


import com.example.project4.Api.ApiResponse;
import com.example.project4.Model.CustomerModel;
import com.example.project4.Model.ExpertModel;
import com.example.project4.Service.CustomerService;
import com.example.project4.Service.ExpertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/expert")
@RequiredArgsConstructor
public class ExpertController {

    private final ExpertService expertService;

    @GetMapping("/get")
    public ResponseEntity getExperts(){
        return  ResponseEntity.status(200).body(expertService.getExperts());
    }

    @PostMapping("/add")
    public ResponseEntity addExpert(@RequestBody @Valid ExpertModel expert){
        expertService.addExpert(expert);
        return ResponseEntity.status(200).body(new ApiResponse("Expert added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateExpert(@RequestBody @Valid ExpertModel expert, @PathVariable Integer id) {
        expertService.updateExpert(id,expert);
        return ResponseEntity.status(200).body(new ApiResponse("Expert updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteExpert(@PathVariable Integer id) {
        expertService.deleteExpert(id);
        return ResponseEntity.status(200).body(new ApiResponse("Expert deleted"));
    }


    @GetMapping("/getByUsername/{username}")
    public ResponseEntity getExpertByUsername(@PathVariable String username){
        return  ResponseEntity.status(200).body(expertService.getExpertByUsername(username));

    }
    @GetMapping("/getByMajor/{major}")
    public ResponseEntity getExpertsByMajor(@PathVariable String major){
        return  ResponseEntity.status(200).body(expertService.getExpertsByMajor(major));
    }


    @GetMapping("/getByEmailAndPassword/{email}/{password}")
    public ResponseEntity getExpertByEmailAndPassword(@PathVariable String email,@PathVariable String password) {
        expertService.getExpertByEmailAndPassword(email,password);
        return ResponseEntity.status(200).body(new ApiResponse("Successful login"));
    }


}
