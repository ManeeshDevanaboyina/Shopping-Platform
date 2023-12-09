package com.maneesh.inventoryservice.controller;

import com.maneesh.inventoryservice.dto.InventoryResponse;
import com.maneesh.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;


    /* If the Customer orders 100 products the 100 product have 100 different SkuCodes.
    * Making API calls for each and every SkuCode will be time consuming
    * Instead we can pass list of SkuCodes at a time*/

    //http:localhost:8082/api/inventory/iphone-13,iphone-14 - Instead of Passing like this for better readability

    //http:localhost:8082/api/inventory?skuCode=iphone-13 & skuCode=iphone-14(Request Parameter format)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){

        return inventoryService.isInStock(skuCode);
    }

}


