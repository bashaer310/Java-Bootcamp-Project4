package com.example.project4.Service;

import com.example.project4.Api.ApiException;
import com.example.project4.Model.CustomerModel;
import com.example.project4.Model.ExpertModel;
import com.example.project4.Model.ProjectModel;
import com.example.project4.Repository.ExpertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpertService {
    private final ExpertRepository expertRepository;

    public List<ExpertModel> getExperts(){
        return expertRepository.findAll();
    }

    public void addExpert(ExpertModel expert){
        expert.setCreatedAt(LocalDate.now());
        expertRepository.save(expert);
    }

    public void updateExpert(Integer id, ExpertModel expert){
        ExpertModel oldExpert=expertRepository.findExpertModelById(id);
        if(oldExpert==null)
            throw new ApiException("Id not found");
        oldExpert=expert;
        oldExpert.setCreatedAt(LocalDate.now());
        oldExpert.setId(id);
        expertRepository.save(oldExpert);
    }

    public void deleteExpert(Integer id){
        ExpertModel expert=expertRepository.findExpertModelById(id);
        if(expert==null)
            throw new ApiException("Id not found");
        expertRepository.delete(expert);
    }

    public List<ExpertModel> getExpertsByMajor(String major){
        List<ExpertModel> experts=expertRepository.findExpertModelByMajor(major);
        if(experts==null)
            throw new ApiException("Experts not found");

        return experts;
    }
    public void getExpertByEmailAndPassword(String email,String password){
        ExpertModel expert = expertRepository.findExpertModelByEmailAndPassword(email,password);
        if(expert==null)
            throw new ApiException("Email and Password not found");

    }

    public ExpertModel getExpertByUsername(String username){
        ExpertModel expert = expertRepository.findExpertModelByUsername(username);
        if(expert==null)
            throw new ApiException("Username not found");

        return expert;
    }

}
