package com.vikramdev;

import java.beans.ConstructorProperties;

public class Alien {
    private int age;
    // private Laptop lap = new Laptop();
    private Laptop lap;
    private int salary;

    Alien() {
        System.out.println("alien ob created");
    }

    @ConstructorProperties({ "age", "lap" })
    public Alien(int age, Laptop lap) {
        System.out.println("Para Constructor Called");
        this.age = age;
        this.lap = lap;
    }

    public void setAge(int age) {
        System.out.println("setter called");
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void hello() {
        System.out.println("in alien class");
    }
}
