package kz.bitlab.groupg127.MyProjectBitlab.services.impl;

import kz.bitlab.groupg127.MyProjectBitlab.db.Repository;
import kz.bitlab.groupg127.MyProjectBitlab.models.Item;
import kz.bitlab.groupg127.MyProjectBitlab.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final Repository repository;

    @Override
    public List<Item> getAllItems() {
        return repository.findAll();
    }

    @Override
    public Item getItemById(Long id) {
        Item item = new Item(100L, "def", "def", 0, "", "");
        return repository.findById(id).orElse(item);
    }

    @Override
    public Item addItem(Item item) {
        return null;
    }

    @Override
    public Item updateItem(Item item) {
        return null;
    }

    @Override
    public void deleteItem(Long id) {
    }

    @Override
    public Optional<Item> getItemByName(String name) {
        return repository.findByNameIgnoreCase(name);
    }
}
