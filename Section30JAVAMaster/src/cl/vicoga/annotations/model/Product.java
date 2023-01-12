package cl.vicoga.annotations.model;

import cl.vicoga.annotations.JsonAttribute;

import java.time.LocalDate;

public class Product {

    @JsonAttribute(capitalize = true)
    private String name;
    @JsonAttribute
    private Long price;
    private LocalDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
