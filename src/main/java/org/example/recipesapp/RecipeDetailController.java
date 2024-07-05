package org.example.recipesapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeDetailController {
    @FXML private TextField nameField;
    @FXML private TextArea ingredientsArea;
    @FXML private TextArea instructionsArea;
    @FXML private TextField prepTimeField;
    @FXML private TextField cookTimeField;
    @FXML private TextField servingsField;
    @FXML private TextField categoryField;

    private Recipe currentRecipe;

    public void setRecipe (Recipe recipe) {
        this.currentRecipe = recipe;
        nameField.setText(recipe.getName());
        ingredientsArea.setText(String.join("\n", recipe.getIngredients()));
        instructionsArea.setText(recipe.getInstructions());
        prepTimeField.setText(String.valueOf(recipe.getPrepTime()));
        cookTimeField.setText(String.valueOf(recipe.getCookTime()));
        servingsField.setText(String.valueOf(recipe.getServings()));
        categoryField.setText(recipe.getCategory());
    }

    @FXML
    public void saveRecipe() {
        if (currentRecipe != null) {
            currentRecipe.setName(nameField.getText());
            List<String> ingredients = Arrays.stream(ingredientsArea.getText().split("\n"))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.toList());
            currentRecipe.setIngredients(ingredients);
            currentRecipe.setInstructions(instructionsArea.getText());
            currentRecipe.setPrepTime(Integer.parseInt(prepTimeField.getText()));
            currentRecipe.setCookTime(Integer.parseInt(cookTimeField.getText()));
            currentRecipe.setServings(Integer.parseInt(servingsField.getText()));
            currentRecipe.setCategory(categoryField.getText());

        }
    }
}
