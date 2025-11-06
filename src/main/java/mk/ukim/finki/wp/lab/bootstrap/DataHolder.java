package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Chef> chefs = null;
    public static List<Dish> dishes = null;

    @PostConstruct
    public void init() {
        chefs = new ArrayList<>();
        dishes = new ArrayList<>();

        chefs.add(new Chef(1L, "Gordon", "Ramsey", "Michelin-starred chef and TV personality known for Hell's Kitchen.", new ArrayList<>()));
        chefs.add(new Chef(2L, "Jamie", "Oliver", "TV chef promoting simple, healthy cooking and food education.", new ArrayList<>()));
        chefs.add(new Chef(3L, "Massimo", "Bottura", "Italian chef of Osteria Francescana, blending tradition with modern cuisine.", new ArrayList<>()));
        chefs.add(new Chef(4L, "Thomas", "Keller", "American chef behind The French Laundry, famed for precision and mentoring.", new ArrayList<>()));
        chefs.add(new Chef(5L, "Heston", "Blumenthal", "UK chef pioneering molecular gastronomy at The Fat Duck.", new ArrayList<>()));

        dishes.add(new Dish("1", "Spaghetti Carbonara", "Italian", 30));
        dishes.add(new Dish("2", "Nigiri", "Japanese", 60));
        dishes.add(new Dish("3", "Beef Wellington", "British", 180));
        dishes.add(new Dish("4", "Pad Thai", "Thai", 40));
        dishes.add(new Dish("5", "Coq au Vin", "French", 120));
    }
}
