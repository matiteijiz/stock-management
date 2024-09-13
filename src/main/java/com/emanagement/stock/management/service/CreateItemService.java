package com.emanagement.stock.management.service;

import com.emanagement.stock.entity.Item;
import com.emanagement.stock.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CreateItemService {

    private ItemRepository itemRepository;
    private Logger logger = LoggerFactory.getLogger(CreateItemService.class);

    private CreateItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public Item save(Item item){
        logger.info(item.toString());
        return this.itemRepository.save(item);
    }
}
