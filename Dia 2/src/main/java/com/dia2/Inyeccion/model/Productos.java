package com.dia2.Inyeccion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Productos {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;
    private double Precio;

    private String Name;

    public Productos() {
    }

    public Productos(int id, double precio, String name) {
        Id = id;
        Precio = precio;
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "Id=" + Id +
                ", Precio=" + Precio +
                ", Name='" + Name + '\'' +
                '}';
    }
}
