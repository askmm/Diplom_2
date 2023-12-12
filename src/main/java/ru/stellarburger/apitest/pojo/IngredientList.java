package ru.stellarburger.apitest.pojo;

import java.util.List;

public class IngredientList {
    private List<String> ingredients;

    public IngredientList() {
    }

    public IngredientList(List<String> ingredientList) {
        this.ingredients = ingredientList;
    }

    public List<String> getIngredientList() {
        return ingredients;
    }

    public void setIngredientList(List<String> ingredientList) {
        this.ingredients = ingredientList;
    }
}
