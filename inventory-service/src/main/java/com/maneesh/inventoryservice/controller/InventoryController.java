package com.maneesh.inventoryservice.controller;

import com.maneesh.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;
    @GetMapping(value = "/{sku-code}")
    @ResponseStatus(HttpStatus.OK)

    public Boolean isInStock(@PathVariable("sku-code") String skuCode){

        return inventoryService.isInStock(skuCode);
    }

}


