package docker.lab3.services;

import docker.lab3.entities.Item;
import docker.lab3.repositories.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItem(Integer id) {
        return itemRepository.findItemById(id);
    }

    @Transactional
    public void deleteItem(Integer id) {
        itemRepository.deleteItemById(id);
    }

    public Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
