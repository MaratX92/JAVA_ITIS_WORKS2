package ru.itis.models;

import org.hibernate.annotations.LazyCollection;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_user")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String  name;

    @Column
    private String description;

    @Column
    private int price;
   /*
    @OneToMany(mappedBy = "owner")
    private List<Auto> autos;*/

    public Product() {
    }

    /**
     * Статический класс - реализация паттерна Builder
     */
    public static class Builder {
        // дублируем все поля обрамляющего класса
        private int id;
        private String name;
        private String description;
        private int price;

        // пустой конструктор
        public Builder() {

        }

        // метод принимающий на вход значение поля и возвращающий самого себя
        // но уже с заданным значением поля
        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String Description) {
            this.description = description;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    private Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;

    }


    @Override
    public String toString() {
        return  id +" "
                + name +" "
                + description +" "
                + price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj !=null && obj instanceof Product){
            Product that = (Product)obj;
            return this.id == that.id
                    && this.name.equals(that.name)
                    && this.description.equals(that.description)
                    && this.name.equals(that.name)
                    && this.price == that.price;
        } return false;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }
}

