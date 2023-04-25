package com.socksmarker.socksmarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Sock {
    @Id
    @GeneratedValue
    private Long id;
    private String colour;
    private Integer cottonPart;
    private Integer quantity;

    public Sock(String colour, Integer cottonPart, Integer quantity) {
        this.colour = colour;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }

    public Sock() {

    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(int cottonPart) {
        this.cottonPart = cottonPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sock sock = (Sock) o;
        return cottonPart == sock.cottonPart && quantity == sock.quantity && Objects.equals(colour, sock.colour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, cottonPart, quantity);
    }

    @Override
    public String toString() {
        return "Sock{" +
                "colour='" + colour + '\'' +
                ", cottonPart=" + cottonPart +
                ", quantity=" + quantity +
                '}';
    }
}
