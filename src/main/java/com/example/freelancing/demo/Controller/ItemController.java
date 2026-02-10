package com.example.freelancing.demo.Controller;

import com.example.freelancing.demo.Model.Item;
import com.example.freelancing.demo.Dto.ItemCreateRequest;
import com.example.freelancing.demo.Service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/items")
@Tag(name = "Items", description = "Item management endpoints")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @PostMapping("/addItem")
    @Operation(summary = "Add a new item")
    public ResponseEntity<Item> addItem(@Valid @RequestBody ItemCreateRequest request) {
        Item created = itemService.addItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an item by ID")
    public Item getItemById(@PathVariable long id) {
        return itemService.getItemById(id);
    }

    @GetMapping
    @Operation(summary = "Get all items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
}
