package com.example.geektrust.commands;

import com.example.geektrust.service.TrainServices;

// Class represents a command related to train operations.
public class commandsTrain {
    // Reference to the train services object.
    TrainServices trainServices;

    // Constructor to initialize the command with train services.
    public commandsTrain(TrainServices trainServices){
        this.trainServices = trainServices;
    }

    // Method to record a train with its name and bogies.
    public void recordTrain(String trainName, String[] bogies) {
        // Delegates the task of keeping the train to the train services object.
        trainServices.keepTrain(trainName, bogies);
    }
}
