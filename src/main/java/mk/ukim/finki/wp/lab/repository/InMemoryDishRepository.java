package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

@Repository
public class InMemoryDishRepository implements DishRepository {

    @Override
    public List<Dish> findAll() {
        return DataHolder.dishes;
    }

    @Override
    public Dish findByDishId(String dishId) {
        return DataHolder.dishes.stream().filter(d -> d.getDishId().equals(dishId)).findFirst().orElseThrow();
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return DataHolder.dishes.stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    @Override
    public Dish save(Dish dish) {
        Dish inMemoryDish = DataHolder.dishes.stream().filter(d -> d.getDishId().equals(dish.getDishId())).findFirst().orElse(null);
        if (inMemoryDish != null) {
            inMemoryDish.setName(dish.getName());
            inMemoryDish.setCuisine(dish.getCuisine());
            inMemoryDish.setPreparationTime(dish.getPreparationTime());
            return inMemoryDish;
        } else {
            DataHolder.dishes.add(dish);
            return dish;
        }
    }

    @Override
    public void deleteById(Long id) {
        DataHolder.dishes.removeIf(d -> d.getId().equals(id));
    }
}
