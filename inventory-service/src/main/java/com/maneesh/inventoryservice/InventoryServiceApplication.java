package com.maneesh.inventoryservice;

import com.maneesh.inventoryservice.model.Inventory;
import com.maneesh.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setQuantity(2);
            inventory.setSkuCode("iphone_16");

            Inventory inventory1 = new Inventory();
            inventory1.setQuantity(0);
            inventory1.setSkuCode("iphone_XS");

            Inventory inventory3 = new Inventory(); // Change this line
            inventory3.setQuantity(3);
            inventory3.setSkuCode("iphone_9");

            inventoryRepository.save(inventory);
            inventoryRepository.save(inventory1);
            inventoryRepository.save(inventory3);
        };
    }

}
