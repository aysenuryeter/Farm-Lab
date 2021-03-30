package farmproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Plants {

    //features of plants
    static ArrayList<Plants> listPlants = new ArrayList<Plants>();
    String nameOfPlant;
    String mostUsedMineral;
    int lifeTime;
    String plantType;
    Double price;
    int kgOverDekar;

    Plants() {
    }

    public Plants(String nameOfPlant, String mostUsedMineral, int lifeTime, String plantType, Double price,
            int kgOverDekar) {
        this.nameOfPlant = nameOfPlant;
        this.mostUsedMineral = mostUsedMineral;
        this.lifeTime = lifeTime;
        this.plantType = plantType;
        this.price = price;
        this.kgOverDekar = kgOverDekar;
    }

    public String getNameOfPlant() {
        return nameOfPlant;
    }

    public void setNameOfPlant(String nameOfPlant) {
        this.nameOfPlant = nameOfPlant;
    }

    public void setMostUsedMineral(String mostUsedMineral) {
        this.mostUsedMineral = mostUsedMineral;
    }

    public void setLifeTime(int lifeTime) {
        this.lifeTime = lifeTime;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setKgOverDekar(int kgOverDekar) {
        this.kgOverDekar = kgOverDekar;
    }

    public String getMostUsedMineral() {
        return mostUsedMineral;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public String getPlantType() {
        return plantType;
    }

    public Double getPrice() {
        return price;
    }

    public int getKgOverDekar() {
        return kgOverDekar;
    }

    //This function is an Plants type arraylist that will read from txt file and assign to Plants type arraylist.
    //And then it will return the list
    public static ArrayList<Plants> readFromFile() throws IOException {

        try {

            ArrayList<Plants> listPlant = new ArrayList<Plants>();

            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("farmproject/Plant.txt");
            BufferedReader inFile = new BufferedReader(new InputStreamReader(is));

            String inputLine, x;
            while ((inputLine = inFile.readLine()) != null) {
                Plants stu = new Plants();
                //alınan değerler indexlere atama işlemi
                String[] plantsVars = inputLine.split(":");
                stu.setNameOfPlant(plantsVars[0]);
                stu.setMostUsedMineral(plantsVars[1]);
                x = plantsVars[2];
                stu.setLifeTime(Integer.parseInt(x));
                stu.setPlantType(plantsVars[3]);
                x = plantsVars[4];
                stu.setPrice(Double.parseDouble(x));
                x = plantsVars[5];
                stu.setKgOverDekar(Integer.parseInt(x));
                listPlant.add(stu);
            }
            return listPlant;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listPlants;
    }
    //Function prints the plants arraylist using toString method. With the help of the for loop, all the elements of arraylist have been reached.

    public void displayPlant() throws FileNotFoundException, IOException {
        ArrayList<Plants> newList = new ArrayList<Plants>();
        newList = readFromFile();
        for (Plants plantX : newList) {
            System.out.println(plantX.toString());
        }
    }

    //With the help of this method, mineral information of the plant whose name is sent as a parameter will returning to send to other functions.
    public String searchPlant(String PlantName) throws FileNotFoundException, IOException {
        ArrayList<Plants> newList = new ArrayList<Plants>();
        newList = readFromFile();
        for (Plants plantX : newList) {
            if (plantX.nameOfPlant.equals(PlantName)) {
                return plantX.mostUsedMineral;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getNameOfPlant() + " " + getMostUsedMineral() + " " + getLifeTime() + " " + getPlantType() + " " + getPrice() + " " + getKgOverDekar();
    }

}
