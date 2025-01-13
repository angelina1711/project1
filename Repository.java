package kz.bitlab.groupg127.MyProjectBitlab.db;


import kz.bitlab.groupg127.MyProjectBitlab.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface Repository extends JpaRepository<Item, Long> {

    Optional<Item> findByNameIgnoreCase(String name);

    List<Item> findAllByOrderByCategory();

    List<Item> findByCategory(String category);

    List<Item> findByCategoryIgnoreCase(String category);

    List<Item> findByCategoryOrderByPrice(String category);

    List<Item> findByCategoryAndPriceLessThan(String category, Double price);
}

