package com.example.geektrust.Libraries;
// This code defines an enum named "stdi".
public enum DistanceBetweenStation {
    ITJ(2150),   // Represents the city ITARSI with a distance of 2150 units.
    BPL(2400),   // Represents the city BHOPAL with a distance of 2400 units.
    AGA(2500),   // Represents the city AGRA with a distance of 2500 units.
    NDL(2700),   // Represents the city NEW DELHI with a distance of 2700 units.
    PTA(3800),   // Represents the city PATNA with a distance of 3800 units.
    NJP(4200),   // Represents the city NEW JALPAIGURI with a distance of 4200 units.
    GHY(4700),   // Represents the city GUWAHATI with a distance of 4700 units.
    NGP(1800);   // Represents the city NAGPUR with a distance of 1800 units.

    final int distance;
    // It takes a distance value as a parameter and assigns it to the "distance" variable.
    DistanceBetweenStation(int distance) {
        this.distance = distance;
    }
}

