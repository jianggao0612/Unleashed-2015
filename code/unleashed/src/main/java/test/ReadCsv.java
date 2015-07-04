package test;

import au.id.tmoschou.unleashed.game.csvFileDomains.BikeHire;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gao on 5/07/15.
 */
public class ReadCsv {
    public static void main(String args[]){
        try {

            String pathname = "AdelaideBikeHire.csv";
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line;
            ArrayList<BikeHire> bikeHires= new ArrayList<>();

            while (br.readLine() != null) {
                line = br.readLine();
                String[] columns = line.split(",");

                BikeHire bikeHire = new BikeHire(
                        columns[1],
                        Double.parseDouble(columns[2]),
                        Double.parseDouble(columns[3]),
                        Double.parseDouble(columns[4]));

                bikeHires.add(bikeHire);
            }

            for(int i = 0; i < bikeHires.size(); i++){
                System.out.println(bikeHires.get(i).getName() + ": " + bikeHires.get(i).getLatitude() + ", " + bikeHires.get(i).getLongitude() + ", " + bikeHires.get(i).getPrice());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
