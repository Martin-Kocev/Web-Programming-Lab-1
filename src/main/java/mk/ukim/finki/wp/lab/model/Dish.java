package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
//    private String dishId;
    private String name;
    private String cuisine;
    private int preparationTime;
    @ManyToOne
    private Chef chef;

//    static Long availableID = 1L;

//    public Dish(String dishId, String name, String cuisine, int preparationTime) {
//        this.dishId = dishId;
//        this.name = name;
//        this.cuisine = cuisine;
//        this.preparationTime = preparationTime;
//
//        id = availableID++;
//    }

    public Dish(String name, String cuisine, int preparationTime, Chef chef) {
        this.name = name;
        this.cuisine = cuisine;
        this.preparationTime = preparationTime;
        this.chef = chef;
    }
}
