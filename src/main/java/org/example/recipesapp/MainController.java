package org.example.recipesapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.*;
import java.util.stream.Collectors;

public class MainController {
    @FXML private ListView<Recipe> recipeListView;
    @FXML private PieChart categoryChart;
    @FXML private TextField searchField;
    @FXML private RecipeDetailController recipeDetailController;

    private ObservableList<Recipe> recipes = FXCollections.observableArrayList();
    private Map<String, List<Recipe>> recipeByCategory = new HashMap<>();

    @FXML
    public void initialize() {
        recipeListView.setItems(recipes);
        recipeListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                recipeDetailController.setRecipe(newValue);
            }
        });

        recipes.addListener((javafx.collections.ListChangeListener.Change<? extends Recipe> c) -> {
            updateRecipesByCategory();
            updateCategoryChart();
        });

        // add some sample recipes
        addSampleRecipes();
    }

    private void addSampleRecipes() {
        recipes.add(new Recipe("Spaghetti Bolognese", Arrays.asList("Spaghetti", "Ground Meat", "Tomato Sauce", "onion", "Garlic"), "1. Cook spaghetti\n2. Brown beef\n3. Add sauce and simmer", 10, 20, 4, "Italian"));

        recipes.add(new Recipe("Caesar Salad", Arrays.asList("Romaine Lettuce", "Croutons", "Parmesan Cheese", "Caesar Dressing"), "1. Chop lettuce\n2. Mix Ingredients\n3. Toss with dressings", 15, 0, 2, "Salad"));

        recipes.add(new Recipe("Chocolate Chip Cookies", Arrays.asList("Flour", "Butter", "Sugar", "Chocolate chips", "Eggs"), "1. Mix Ingredients\n2. Form Cookies\n3. Bake at 350F for 10 minutes", 20, 10, 24, "Dessert"));
    }

    @FXML
    public void newRecipe() {
        Recipe recipe = new Recipe("New Recipe", new ArrayList<>(), "", 0, 0, 0, "uncategorized");
        recipes.add(recipe);
        recipeListView.getSelectionModel().select(recipe);
    }

    @FXML
    private void searchRecipes() {
        String keyword = searchField.getText().toLowerCase();
        List<Recipe> searchResults = recipes.stream()
                .filter(recipe -> recipe.getName().toLowerCase().contains(keyword) || recipe.getIngredients().stream().anyMatch(i -> i.toLowerCase().contains(keyword)) || recipe.getCategory().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
        recipeListView.setItems(FXCollections.observableArrayList(searchResults));
    }

    private void updateRecipesByCategory() {
        recipeByCategory.clear();
        for (Recipe recipe : recipes) {
            recipeByCategory.computeIfAbsent(recipe.getCategory(), k -> new ArrayList<>()).add(recipe);
        }
    }

    public void updateCategoryChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for (Map.Entry<String, List<Recipe>> entry : recipeByCategory.entrySet()) {
            pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue().size()));
        }
        categoryChart.setData(pieChartData);
    }

    @FXML
    private void exit() {
        System.exit(0);
    }
}
