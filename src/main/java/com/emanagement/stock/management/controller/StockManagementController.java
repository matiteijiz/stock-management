package com.emanagement.stock.management.controller;

import com.emanagement.stock.entity.Item;
import com.emanagement.stock.management.service.CreateItemService;
import com.emanagement.stock.management.service.GetItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock")
public class StockManagementController {

    private GetItemService getItemService;
    private CreateItemService createItemService;

    private StockManagementController(GetItemService getItemService, CreateItemService createItemService){
        this.getItemService = getItemService;
        this.createItemService = createItemService;
    }

    @GetMapping("/items")
    public List<Item> getAllItems(){
        return this.getItemService.getAllItems();
    }

    @GetMapping("/item/{code}")
    public Item getItemBy(@PathVariable String code){
        return this.getItemService.getItemByCode(code);
    }

    @PostMapping("/item")
    public Item saveItem(@RequestBody Item item){
        return createItemService.save(item);
    }


}
