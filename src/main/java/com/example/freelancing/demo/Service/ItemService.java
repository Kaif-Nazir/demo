package com.example.freelancing.demo.Service;

import com.example.freelancing.demo.Model.Item;
import com.example.freelancing.demo.Dto.ItemCreateRequest;
import com.example.freelancing.demo.GlobalException.Exception.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public Item addItem(ItemCreateRequest request) {
        Item item = new Item(
                idCounter.getAndIncrement(),
                request.getName(),
                request.getDescription()
        );
        items.add(item);
        return item;
    }

    public Item getItemById(long id) {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }
}
