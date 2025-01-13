package kz.bitlab.groupg127.MyProjectBitlab.controllers;

import kz.bitlab.groupg127.MyProjectBitlab.models.Item;
import kz.bitlab.groupg127.MyProjectBitlab.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import kz.bitlab.groupg127.MyProjectBitlab.db.Repository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ItemService itemService;

    @Autowired
    Repository repository;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        List<Item> items = repository.findAllByOrderByCategory();
        System.out.println("Количество товаров: " + items.size());
        model.addAttribute("items", items);
        return "index";
    }


    @PostMapping("/infoBurger")
    @ResponseBody
    public Item getProductDetails(@RequestParam("id") String id) {
        Long newId = Long.valueOf(id);
        Item item = itemService.getItemById(newId);
        return item;
    }

    @PostMapping("/searchBurger")
    @ResponseBody
    public Item searchBurgerByName(@RequestParam("query") String query) {
        return itemService.getItemByName(query)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Бургер не найден"));
    }

    @GetMapping("/menu")
    public String showMenuPage() {
        return "redirect:/";  // Перенаправляем на главную страницу
    }
}
