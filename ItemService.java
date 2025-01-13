package kz.bitlab.groupg127.MyProjectBitlab.services;

import kz.bitlab.groupg127.MyProjectBitlab.models.Item;
import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item addItem(Item item);
    Item updateItem(Item item);
    void deleteItem(Long id);
    Optional<Item> getItemByName(String name);
}
