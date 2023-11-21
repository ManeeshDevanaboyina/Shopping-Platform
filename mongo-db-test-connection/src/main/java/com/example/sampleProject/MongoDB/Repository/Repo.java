package com.example.sampleProject.MongoDB.Repository;

import com.example.sampleProject.MongoDB.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableMongoRepositories
public interface Repo extends MongoRepository<Customer, String> {


}
