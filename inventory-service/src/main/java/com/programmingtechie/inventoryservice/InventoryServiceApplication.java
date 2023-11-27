package com.programmingtechie.inventoryservice;

import com.programmingtechie.inventoryservice.model.Inventory;
import com.programmingtechie.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
        return args -> {
            Inventory inventory=new Inventory();
            inventory.setQuantity(100);
            inventory.setSkuCode("iphone_12");
            Inventory inventory1=new Inventory();
            inventory1.setQuantity(1);
            inventory1.setSkuCode("iphone_11");

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);


        };
    }

}
