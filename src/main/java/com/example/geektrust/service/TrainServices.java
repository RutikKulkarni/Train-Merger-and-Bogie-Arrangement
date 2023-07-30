package com.example.geektrust.service;

import java.util.Comparator;
import java.util.LinkedList;

import com.example.geektrust.Libraries.TrainLibraries;
import com.example.geektrust.entities.Trains;

public class TrainServices {
    Trains train; // Instance variable to store information about a train
    LinkedList<String> finalBogies; // List to store the final bogies of a train
    TrainLibraries trrepo; // Instance of the train repository

    public TrainServices(TrainLibraries trainRepoObj) {
        this.trrepo = trainRepoObj;
    }

    // Method to add a train to the repository
    public void keepTrain(String trainName, String[] bogies) {
        finalBogies = new LinkedList<>();

        // Iterate through the bogies array and add the bogies to the finalBogies list,
        // except for those that are marked as missing stations
        for (int i = 1; i < bogies.length; i++) {
            if (trrepo.missStation.contains(bogies[i])) {
                continue;
            }
            finalBogies.add(bogies[i]);
        }

        // Create a new train object with the given train name and final bogies list
        train = new Trains(trainName, finalBogies);

        // Record the train in the train repository
        trrepo.recordTrain(train);
    }

    // Method to find the order of bogies for an arrived train
    public String findArrivedTrain(String trainName) {
        LinkedList<String> bogies = trrepo.dataOfTrain.get(trainName).findOrderBogie();

        // If the number of bogies is less than or equal to 1, return "JOURNEY_ENDED",
        // otherwise join the bogies with a space separator and return the result
        return bogies.size() <= 1 ? "JOURNEY_ENDED" : String.join(" ", bogies);
    }

    // Method to find the order of bogies for a departed train
    public String findDepartedTrain() {
        LinkedList<String> A = trrepo.dataOfTrain.get("TRAIN_A").findOrderBogie();
        A.addAll(trrepo.dataOfTrain.get("TRAIN_B").findOrderBogie());

        // Create a new list AB containing the bogies from TRAIN_A and TRAIN_B,
        // and remove "HYB" from the list twice
        LinkedList<String> AB = trrepo.dataOfTrain.get("TRAIN_A").findOrderBogie();
        AB.remove("HYB");
        AB.remove("HYB");

        // Sort the AB list based on the fromStationData values in descending order
        AB.sort(Comparator.comparingInt(a -> -trrepo.fromStationData.get(a)));

        // If the number of bogies is less than or equal to 2, return "JOURNEY_ENDED",
        // otherwise join the bogies with a space separator and return the result
        return AB.size() <= 2 ? "JOURNEY_ENDED" : String.join(" ", AB);
    }
}
