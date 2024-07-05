package org.example.recipesapp;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private  final StringProperty name = new SimpleStringProperty();
    private final ListProperty<String> ingredients = new SimpleListProperty<>();
    private final StringProperty instructions = new SimpleStringProperty();
    private final IntegerProperty prepTime = new SimpleIntegerProperty();
    private final IntegerProperty cookTime = new SimpleIntegerProperty();
    private final IntegerProperty servings =  new SimpleIntegerProperty();
    private final StringProperty category = new SimpleStringProperty();

    public Recipe (String name, List<String> ingredients, String instructions, int prepTime, int cookTime, int servings, String category) {
        setName(name);
        setIngredients(ingredients);
        setInstructions(instructions);
        setPrepTime(prepTime);
        setCookTime(cookTime);
        setServings(servings);
        setCategory(category);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients.get();
    }

    public void setIngredients(List<String> ingredients) {
        // this.ingredients.set(new ArrayList<>(ingredients));
    }

    public ListProperty<String> ingredientsProperty() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions.get();
    }

    public void setInstructions(String instructions) {
        this.instructions.set(instructions);
    }

    public StringProperty instructionsProperty() {
        return instructions;
    }

    public int getPrepTime() {
        return prepTime.get();
    }

    public void setPrepTime(int prepTime) {
        this.prepTime.set(prepTime);
    }

    public IntegerProperty prepTimeProperty() {
        return prepTime;
    }

    public int getCookTime() {
        return cookTime.get();
    }

    public void setCookTime(int cookTime) {
        this.cookTime.set(cookTime);
    }

    public IntegerProperty cookTimeProperty() {
        return cookTime;
    }

    public int getServings() {
        return servings.get();
    }

    public void setServings(int servings) {
        this.servings.set(servings);
    }

    public IntegerProperty servingsProperty() {
        return servings;
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public StringProperty categoryProperty() {
        return category;
    }

    @Override
    public String toString() {
        return getName();
    }
}
