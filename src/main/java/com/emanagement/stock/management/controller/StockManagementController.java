package com.emanagement.stock.management.controller;

import com.emanagement.stock.dto.ItemRequestDto;
import com.emanagement.stock.entity.Item;
import com.emanagement.stock.management.service.CreateItemService;
import com.emanagement.stock.management.service.GetItemService;
import com.emanagement.stock.provider.ResponseProvider;
import jakarta.validation.Valid;
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
    private final ResponseProvider responseProvider;

    public StockManagementController(GetItemService getItemService, CreateItemService createItemService, ResponseProvider responseProvider){
        this.getItemService = getItemService;
        this.createItemService = createItemService;
        this.responseProvider = responseProvider;
    }

    //TODO:Ver si puedo encapsular la forma en que resuelvo la respuesta de los ResponseEntity

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        var items = this.getItemService.getAllItems();
        return Optional.of(items)
                .filter(itemList -> !itemList.isEmpty())
                .map(responseProvider::ok)
                .orElseGet(responseProvider::noContent);
    }

    @GetMapping("/item/{code}")
    public ResponseEntity<Item> getItemBy(@PathVariable String code){
        var item = this.getItemService.getItemByCode(code);
        return item
                .map(responseProvider::ok)
                .orElseGet(responseProvider::notFound);
    }

    @PostMapping("/item")
    public ResponseEntity<Item> saveItem(@Valid @RequestBody ItemRequestDto item){
        var itemCreated = createItemService.save(item);
        return responseProvider.created(itemCreated);
    }


}
