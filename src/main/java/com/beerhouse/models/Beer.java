package com.beerhouse.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String ingredients;
    @Column
    private String alcoholContent;
    @Column
    private float price;
    @Column
    private String category;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(String alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Beer(String name, String ingredients, String alcoholContent, float price, String category) {
        this.name = name;
        this.ingredients = ingredients;
        this.alcoholContent = alcoholContent;
        this.price = price;
        this.category = category;
    }

    public Beer(){

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Beer beer = (Beer) o;

        return id != null ? id.equals(beer.id) : beer.id == null;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", alcoholContent='" + alcoholContent + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
