interface MealPlan {

    void showMeal();
}

class VegetarianMeal implements MealPlan {

    @Override
    public void showMeal() {
        System.out.println("Vegetarian Meal : Salad, Paneer, Fruits");
    }
}

class VeganMeal implements MealPlan {

    @Override
    public void showMeal() {
        System.out.println("Vegan Meal : Tofu, Vegetables, Brown Rice");
    }
}

class KetoMeal implements MealPlan {

    @Override
    public void showMeal() {
        System.out.println("Keto Meal : Eggs, Chicken, Cheese");
    }
}

class HighProteinMeal implements MealPlan {

    @Override
    public void showMeal() {
        System.out.println("High Protein Meal : Chicken, Eggs, Milk");
    }
}

class Meal<T extends MealPlan> {

    private final T meal;

    Meal(T meal) {
        this.meal = meal;
    }

    T getMeal() {
        return meal;
    }
}

public class MealPlanGenerator {

    static <T extends MealPlan> void generateMeal(Meal<T> meal) {

        System.out.println("");
        System.out.println("Personalized Meal Plan");
        meal.getMeal().showMeal();
    }

    public static void main(String[] args) {

        Meal<VegetarianMeal> meal1 = new Meal<>(new VegetarianMeal());

        Meal<VeganMeal> meal2 = new Meal<>(new VeganMeal());

        Meal<KetoMeal> meal3 = new Meal<>(new KetoMeal());

        Meal<HighProteinMeal> meal4 = new Meal<>(new HighProteinMeal());

        generateMeal(meal1);
        generateMeal(meal2);
        generateMeal(meal3);
        generateMeal(meal4);
    }
}