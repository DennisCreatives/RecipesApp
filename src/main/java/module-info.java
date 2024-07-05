module org.example.recipesapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.recipesapp to javafx.fxml;
    exports org.example.recipesapp;
}