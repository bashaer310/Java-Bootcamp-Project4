package com.example.project4.Repository;


import com.example.project4.Model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel,Integer> {

    CustomerModel findCustomerModelById(Integer id);
    CustomerModel findCustomerModelByUsername(String username);
    CustomerModel findCustomerModelByEmailAndPassword(String email,String password);
}
