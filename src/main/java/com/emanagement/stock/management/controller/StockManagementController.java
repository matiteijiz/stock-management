package com.emanagement.stock.management.controller;

import com.emanagement.stock.entity.Item;
import com.emanagement.stock.management.service.CreateItemService;
import com.emanagement.stock.management.service.GetItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockManagementController {

    private GetItemService getItemService;
    private CreateItemService createItemService;

    private StockManagementController(GetItemService getItemService, CreateItemService createItemService){
        this.getItemService = getItemService;
        this.createItemService = createItemService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        var items = this.getItemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/item/{code}")
    public ResponseEntity<Item> getItemBy(@PathVariable String code){
        var item = this.getItemService.getItemByCode(code);
        return ResponseEntity.ok(item);
    }

    @PostMapping("/item")
    public ResponseEntity<Item> saveItem(@RequestBody Item item){
        var itemCreated = createItemService.save(item);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemCreated);
    }


}
