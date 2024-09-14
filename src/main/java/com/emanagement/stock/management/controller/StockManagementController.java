package com.emanagement.stock.management.controller;

import com.emanagement.stock.entity.Item;
import com.emanagement.stock.management.service.CreateItemService;
import com.emanagement.stock.management.service.GetItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockManagementController {

    private final GetItemService getItemService;
    private final CreateItemService createItemService;

    public StockManagementController(GetItemService getItemService, CreateItemService createItemService){
        this.getItemService = getItemService;
        this.createItemService = createItemService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        var items = this.getItemService.getAllItems();
        return Optional.of(items)
                .filter(itemList -> !itemList.isEmpty())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.noContent().build());
    }

    @GetMapping("/item/{code}")
    public ResponseEntity<Item> getItemBy(@PathVariable String code){
        return ResponseEntity.of(this.getItemService.getItemByCode(code));
    }

    @PostMapping("/item")
    public ResponseEntity<Item> saveItem(@RequestBody Item item){
        var itemCreated = createItemService.save(item);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(itemCreated);
    }


}
