package com.mou.bakingapp.data.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class RecipeModel implements Parcelable{

    private String name;
    private List<IngredientModel> ingredients;
    private List<StepModel> steps;
    private int servings;
    private String image;

    public RecipeModel(String name, List<IngredientModel> ingredients, List<StepModel> steps, int servings, String image) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.servings = servings;
        this.image = image;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public RecipeModel createFromParcel(Parcel in) {
            return new RecipeModel(in);
        }

        public RecipeModel[] newArray(int size) {
            return new RecipeModel[size];
        }
    };

    private RecipeModel(Parcel in) {
        this.name = in.readString();
        ingredients = new ArrayList<>();
        in.readList(this.ingredients, IngredientModel.class.getClassLoader());
        this.steps = new ArrayList<>();
        in.readList(this.steps ,StepModel.class.getClassLoader());
        this.servings = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientModel> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientModel> ingredients) {
        this.ingredients = ingredients;
    }

    public List<StepModel> getSteps() {
        return steps;
    }

    public void setSteps(List<StepModel> steps) {
        this.steps = steps;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeList(this.ingredients);
        dest.writeList(this.steps);
        dest.writeInt(this.servings);
    }
}
