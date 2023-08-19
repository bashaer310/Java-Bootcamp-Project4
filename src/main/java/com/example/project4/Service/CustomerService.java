package com.example.project4.Service;


import com.example.project4.Api.ApiException;
import com.example.project4.Model.CustomerModel;
import com.example.project4.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomerModel> getCustomers(){
        return customerRepository.findAll();
    }

    public void addCustomer(CustomerModel customer){
        customer.setCreatedAt(java.time.LocalDateTime.now());
        customerRepository.save(customer);
    }

    public void updateCustomer(Integer id, CustomerModel customer){
        CustomerModel oldCustomer=customerRepository.findCustomerModelById(id);
        if(oldCustomer==null)
            throw new ApiException("Id not found");
        oldCustomer=customer;
        oldCustomer.setCreatedAt(java.time.LocalDateTime.now());
        oldCustomer.setId(id);
        customerRepository.save(oldCustomer);
    }

    public void deleteCustomer(Integer id){
        CustomerModel customer=customerRepository.findCustomerModelById(id);
        if(customer==null)
            throw new ApiException("Id not found");
        customerRepository.delete(customer);
    }

    public CustomerModel getCustomerByUsername(String username){
        CustomerModel customer = customerRepository.findCustomerModelByUsername(username);
        if(customer==null)
            throw new ApiException("Username not found");

        return customer;
    }
    public String getCustomerByEmailAndPassword(String email,String password){
        CustomerModel customer = customerRepository.findCustomerModelByEmailAndPassword(email,password);
        if(customer==null)
            throw new ApiException("Email and Password not found");

        return "Successful login";
    }

}
