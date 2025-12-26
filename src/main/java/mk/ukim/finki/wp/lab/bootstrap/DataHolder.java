package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@AllArgsConstructor
@Component
public class DataHolder {
    public final ChefRepository chefRepository;
    public final DishRepository dishRepository;

    @PostConstruct
    public void init() {
        if (chefRepository.findAll().isEmpty()) {
            chefRepository.save(new Chef("Gordon", "Ramsey", "Michelin-starred chef and TV personality known for Hell's Kitchen.", new ArrayList<>()));
            chefRepository.save(new Chef("Jamie", "Oliver", "TV chef promoting simple, healthy cooking and food education.", new ArrayList<>()));
            chefRepository.save(new Chef("Massimo", "Bottura", "Italian chef of Osteria Francescana, blending tradition with modern cuisine.", new ArrayList<>()));
            chefRepository.save(new Chef("Thomas", "Keller", "American chef behind The French Laundry, famed for precision and mentoring.", new ArrayList<>()));
            chefRepository.save(new Chef("Heston", "Blumenthal", "UK chef pioneering molecular gastronomy at The Fat Duck.", new ArrayList<>()));
        }
        if (dishRepository.findAll().isEmpty()) {
            dishRepository.save(new Dish("Spaghetti Carbonara", "Italian", 30, chefRepository.findChefsByFirstName("Gordon")));
            dishRepository.save(new Dish("Nigiri", "Japanese", 60, chefRepository.findChefsByFirstName("Jamie")));
            dishRepository.save(new Dish("Beef Wellington", "British", 180, chefRepository.findChefsByFirstName("Massimo")));
            dishRepository.save(new Dish("Pad Thai", "Thai", 40, chefRepository.findChefsByFirstName("Thomas")));
            dishRepository.save(new Dish("Coq au Vin", "French", 120, chefRepository.findChefsByFirstName("Heston")));
        }
    }
}
