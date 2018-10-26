package com.mou.bakingapp.data.models;

import android.os.Parcel;
import android.os.Parcelable;

public class IngredientModel implements Parcelable{
    private String measure;
    private String ingredient;
    private double quantity;

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public IngredientModel createFromParcel(Parcel in) {
            return new IngredientModel(in);
        }

        public IngredientModel[] newArray(int size) {
            return new IngredientModel[size];
        }
    };

    private IngredientModel(Parcel in) {
        this.measure = in.readString();
        this.ingredient = in.readString();
        this.quantity = in.readDouble();
    }

    public IngredientModel(String measure, String ingredient, double quantity) {
        this.measure = measure;
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.measure);
        dest.writeString(this.ingredient);
        dest.writeDouble(this.quantity);
    }
}
