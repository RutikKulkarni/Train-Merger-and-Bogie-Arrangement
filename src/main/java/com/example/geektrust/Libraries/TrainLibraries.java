package com.example.geektrust.Libraries;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.example.geektrust.entities.Trains;

public class TrainLibraries {
    public Map <String,Trains> dataOfTrain; 
    public Map <String,Integer> fromStationData; 
    public HashSet<String> missStation; 

    public TrainLibraries(){
        // Initialize the train data map
        dataOfTrain = new HashMap<>(); 
        // Initialize the station data map
        fromStationData = new HashMap<>(); 
        // Initialize the set of missing stations
        missStation = new HashSet<>(); 
        
        // Add missing stations to the set
        missStation.add("CHN");
        missStation.add("SLM");
        missStation.add("BLR");
        missStation.add("KRN");
        missStation.add("TVC");
        missStation.add("SRR");
        missStation.add("MAQ");
        missStation.add("MAO");
        missStation.add("PNE");

        // Populate the distances of stations from a specific station
        fromStationData.put("ENGINE",Integer.MAX_VALUE); // Set the distance for "ENGINE" to be the maximum possible value
        fromStationData.put("ITJ",2150); // Set the distance of "ITJ" station
        fromStationData.put("BPL",2400); // Set the distance of "BPL" station
        fromStationData.put("AGA",2500); // Set the distance of "AGA" station
        fromStationData.put("NDL",2700); // Set the distance of "NDL" station
        fromStationData.put("PTA",3800); // Set the distance of "PTA" station
        fromStationData.put("NJP",4200); // Set the distance of "NJP" station
        fromStationData.put("GHY",4700); // Set the distance of "GHY" station
        fromStationData.put("NGP",1800); // Set the distance of "NGP" station
    }

    public void recordTrain(Trains train) {
        // Record a train object in the data map using its name as the key
        dataOfTrain.put(train.findNaming(),train); 
    }
}

