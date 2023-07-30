package com.example.geektrust;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void input1Test() throws FileNotFoundException {
        // Redirecting the output stream to capture the printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        // Reading the input file
        File file = new File("sample_input/input1.txt");
        String expected = "ARRIVAL TRAIN_A ENGINE NDL NDL GHY NJP NGP\n"+
                          "ARRIVAL TRAIN_B ENGINE NJP GHY AGA BPL PTA\n" +
                          "DEPARTURE TRAIN_AB ENGINE ENGINE GHY GHY NJP NJP PTA NDL NDL AGA BPL NGP";
        FileInputStream inputStream = new FileInputStream(file);
        System.setIn(inputStream);
        // Running the main method with the input file
        Main.main(new String[]{file.getPath()});
        // Restoring the original output stream and input stream
        System.setOut(originalOut);
        System.setIn(System.in);
        // Capturing the actual output
        String actual = outputStream.toString().trim();
        // Asserting the expected output and actual output
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void input2Test() throws FileNotFoundException {
        // Redirecting the output stream to capture the printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);
        // Reading the input file
        File file = new File("sample_input/input2.txt");
        String expected = "ARRIVAL TRAIN_A ENGINE HYB NGP ITJ\n"+
                          "ARRIVAL TRAIN_B ENGINE NJP PTA\n" +
                          "DEPARTURE TRAIN_AB ENGINE ENGINE NJP PTA ITJ NGP";
        FileInputStream inputStream = new FileInputStream(file);
        System.setIn(inputStream);
        // Running the main method with the input file
        Main.main(new String[]{file.getPath()});
        // Restoring the original output stream and input stream
        System.setOut(originalOut);
        System.setIn(System.in);
        // Capturing the actual output
        String actual = outputStream.toString().trim();
        // Asserting the expected output and actual output
        Assertions.assertEquals(expected, actual);
    }
}