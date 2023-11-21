package com.example.sampleProject.MongoDB.Contol;


import com.example.sampleProject.MongoDB.Model.Customer;
import com.example.sampleProject.MongoDB.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controller
{

    @Autowired
    private Repo rep;

    @PostMapping("/addUser")
    public Customer addUser(@RequestBody Customer customer) {
        return rep.save(customer);

    }

    // findAll method is predefine method in Mongo Repository
    // with this method we will all user that is save in our database
    @GetMapping("/getAllUser")
    public List<Customer> getAllUser(){
        return rep.findAll();
    }

}
