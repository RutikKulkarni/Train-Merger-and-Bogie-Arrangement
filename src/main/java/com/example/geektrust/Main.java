package com.example.geektrust;

import com.example.geektrust.Libraries.TrainLibraries;
import com.example.geektrust.commands.commandsTrain;
import com.example.geektrust.service.TrainServices;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Opening a file input stream for the specified file name passed as an argument
            FileInputStream fis = new FileInputStream(args[0]); 
            // Creating a scanner object to read the file
            Scanner sc = new Scanner(fis); 
            // Creating an instance of the trrepo class (repository for trains)
            TrainLibraries trainRepo = new TrainLibraries(); 
            // Creating an instance of the servtr class (services for trains) and passing the trainRepo as a dependency
            TrainServices trainServices = new TrainServices(trainRepo); 
            // Creating an instance of the comand class (commands for train operations) and passing the trainServices as a dependency
            commandsTrain cmd = new commandsTrain(trainServices); 

            // Reading each line from the file and processing the train information
            while (sc.hasNextLine()) {
                // Splitting the line by space to extract train information
                String[] trainInput = sc.nextLine().split(" "); 
                // Calling the recordTrain method of the cmd object to record the train information
                cmd.recordTrain(trainInput[0], trainInput); 
            }
            sc.close(); // Closing the scanner

            // Printing the arrival and departure information for specific trains
            System.out.println("ARRIVAL TRAIN_A " + trainServices.findArrivedTrain("TRAIN_A"));
            System.out.println("ARRIVAL TRAIN_B " + trainServices.findArrivedTrain("TRAIN_B"));
            System.out.println("DEPARTURE TRAIN_AB " + trainServices.findDepartedTrain());

        } catch (IOException e) {
            // Handling any IOException that occurs while reading the file
            System.out.println("Invalid Input"); 
        }
    }
}
