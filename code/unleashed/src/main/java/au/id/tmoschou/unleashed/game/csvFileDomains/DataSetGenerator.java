package au.id.tmoschou.unleashed.game.csvFileDomains;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Gao on 5/07/15.
 */

/**
 * This class provides static method to get the raw data arraylist from .csv file by injecting the data to exact classes
 */
public class DataSetGenerator {

    public static ArrayList<BikeHire> getBikeHire() {
        String pathname = "AdelaideBikeHire.csv";
        ArrayList<BikeHire> bikeHires= new ArrayList<>();
        try{
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(DataSetGenerator.class.getResourceAsStream(pathname));
            BufferedReader br = new BufferedReader(reader);
            String line;
            line = br.readLine();
            while (line != null) {

                String[] columns = line.split(",");

                BikeHire bikeHire = new BikeHire(
                        columns[1],
                        Double.parseDouble(columns[2]),
                        Double.parseDouble(columns[3]),
                        Double.parseDouble(columns[4]));

                bikeHires.add(bikeHire);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bikeHires;
    }

    public static ArrayList<BikeRack> getBikeRake() {
        String pathname = "AdelaideBikeRack.csv";
        ArrayList<BikeRack> bikeRacks= new ArrayList<>();

        try{
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(DataSetGenerator.class.getResourceAsStream(pathname));
            BufferedReader br = new BufferedReader(reader);
            String line;
            line = br.readLine();
            while (line != null) {

                String[] columns = line.split(",");

                BikeRack bikeRack = new BikeRack(
                        columns[1],
                        Double.parseDouble(columns[2]),
                        Double.parseDouble(columns[3]));

                bikeRacks.add(bikeRack);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bikeRacks;
    }

    public static ArrayList<ParkingMachine> getParkingMachine() {
        String pathname = "AdelaideParkingMachines.csv";
        ArrayList<ParkingMachine> parkingMachines= new ArrayList<>();

        try{
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(DataSetGenerator.class.getResourceAsStream(pathname));
            BufferedReader br = new BufferedReader(reader);
            String line;
            line = br.readLine();
            while (line != null) {

                String[] columns = line.split(",");

                ParkingMachine parkingMachine = new ParkingMachine(
                        columns[1],
                        Double.parseDouble(columns[2]),
                        Double.parseDouble(columns[3]));

                parkingMachines.add(parkingMachine);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parkingMachines;
    }

    public static ArrayList<DrinkingFountains> getDrinkingFountains() {
        String pathname = "AdelaideDrinkingFountains.csv";
        ArrayList<DrinkingFountains> drinkingFountainses= new ArrayList<>();

        try{
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(DataSetGenerator.class.getResourceAsStream(pathname));
            BufferedReader br = new BufferedReader(reader);
            String line;
            line = br.readLine();
            while (line != null) {

                String[] columns = line.split(",");

                DrinkingFountains drinkingFountains = new DrinkingFountains(
                        columns[1],
                        Double.parseDouble(columns[2]),
                        Double.parseDouble(columns[3]));

                drinkingFountainses.add(drinkingFountains);
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return drinkingFountainses;
    }
}
