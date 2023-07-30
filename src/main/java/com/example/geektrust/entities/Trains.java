package com.example.geektrust.entities;

import java.util.LinkedList;

public class Trains {
    private String name; // Represents the name of the train
    private LinkedList<String> trbogies; // Represents the list of bogies in the train

    public Trains(String name, LinkedList<String> trbogies) {
        this.name = name; // Initializes the name of the train
        this.trbogies = trbogies; // Initializes the list of bogies in the train
    }

    public String findNaming() {
        return name; // Returns the name of the train
    }

    public LinkedList<String> findOrderBogie() {
        return trbogies; // Returns the list of bogies in the train
    }
}

