package com.emanagement.stock.management.controller;

import com.emanagement.stock.entity.Item;
import com.emanagement.stock.management.service.CreateItemService;
import com.emanagement.stock.management.service.GetItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockManagementController {

    private GetItemService getItemService;
    private CreateItemService createItemService;

    @Autowired
    private StockManagementController(GetItemService getItemService, CreateItemService createItemService){
        this.getItemService = getItemService;
        this.createItemService = createItemService;
    }

    @GetMapping("/items")
    public List<Item> getAllOfItems(){
        return this.getItemService.getAllItems();
    }

    @GetMapping("/itemBy")
    public Item getAnItemByCode(@RequestParam String code){
        return this.getItemService.getItemByCode(code);
    }

    @PostMapping("/item")
    public Item saveItem(@RequestBody Item item){
        return createItemService.save(item);
    }


}
