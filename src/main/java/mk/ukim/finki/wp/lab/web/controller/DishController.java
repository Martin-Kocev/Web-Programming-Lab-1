package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dishes")
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping()
    public String getDishesPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("dishes", dishService.listDishes());

        return "listDishes";
    }
    @PostMapping()
    public String getDishesPageAndAddToChef(@RequestParam(required = false) String error, Model model, @RequestParam String chefId) {
        model.addAttribute("dishes", dishService.listDishes());
        model.addAttribute("chefId", chefId);

        return "listDishes";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add")
    public String saveDish(@RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime) {
        dishService.create(name, cuisine, preparationTime);

        return "redirect:/dishes";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public String deleteDish(@PathVariable Long id) {
        dishService.delete(id);

        return "redirect:/dishes";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/edit/{id}")
    public String editDish(@PathVariable Long id, @RequestParam String name, @RequestParam String cuisine, @RequestParam int preparationTime) {
        dishService.update(id, name, cuisine, preparationTime);

        return "redirect:/dishes";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/dish-form/{id}")
    public String getEditDishForm(@PathVariable Long id, Model model) {
        if (dishService.findById(id) == null) {
            return "redirect:/dishes?error=DishNotFound";
        }
        model.addAttribute("dish", dishService.findById(id));

        return "dish-form";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dish-form")
    public String getAddDishPage(@RequestParam(required = false) String chefId, Model model) {

        return "dish-form";
    }
}
