package com.emanagement.stock.management.service;

import com.emanagement.stock.dto.ItemRequestDto;
import com.emanagement.stock.entity.Item;
import com.emanagement.stock.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateItemService {

    private ItemRepository itemRepository;

    private CreateItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item save(ItemRequestDto dto){
        Item item = Item.builder()
                .code(UUID.randomUUID().toString())
                .name(dto.getName())
                .stock(dto.getStock())
                .build();
        return this.itemRepository.save(item);
    }

}
