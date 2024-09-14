package com.emanagement.stock.management.service;

import com.emanagement.stock.entity.Item;
import com.emanagement.stock.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetItemService {

    private ItemRepository itemRepository;

    @Autowired
    private GetItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems(){
        return this.itemRepository.findAll();
    }

    public Optional<Item> getItemByCode(String code) {
        return this.itemRepository.findById(code);
    }
}
