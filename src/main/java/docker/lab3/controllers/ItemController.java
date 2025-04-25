package docker.lab3.controllers;

import docker.lab3.entities.Item;
import docker.lab3.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(final ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<?> getItem(@PathVariable final Integer itemId) {
        try {
            return ResponseEntity.ok(itemService.getItem(itemId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllItems() {
        try {
            return ResponseEntity.ok(itemService.getAllItems());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> addItem(@RequestBody final Item item) {
        try {
            return ResponseEntity.ok(itemService.createItem(item));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable final Integer itemId) {
        try {
            itemService.deleteItem(itemId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
