package farmproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Herbs extends Plants implements IPlantOperation {

    public ArrayList<Plants> listHerbs = new ArrayList<Plants>();

    Herbs() {

    }

    public Herbs(String nameOfPlant, String mostUsedMineral, int lifeTime, String plantType, Double price,
            int kgOverDekar) {
        super(nameOfPlant, mostUsedMineral, lifeTime, plantType, price, kgOverDekar);
    }
    //This code will appoint the suitable type items from general plants list to ListHerbs. This function derivated from IPlantOperation.
    @Override
    public ArrayList<Plants> add() {
        ArrayList<Plants> newList = new ArrayList<Plants>();
        try {
            newList = readFromFile();
        } catch (IOException ex) {
            Logger.getLogger(Herbs.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Plants plantX : newList) {
            if (plantX.plantType.equals("HERB")) {
                listHerbs.add(plantX);
            }
        }
        return listHerbs;
    }
    //This function is overrited in this section via IPlantOperation interface.
    //This function gets the information given by the farmer about the former plant and its mineral info, and the lifespan of the wanted plant and puts on an arraylist of the type of bushes named posibilities.
    //After that the function puts items from arrraylist named posibilities randomly that will be presented in an array and will return that array.
    @Override
    public Plants[] selection(String mineral, int lifeTime, Plants[] herbs) {

        ArrayList<Plants> possibilities = new ArrayList<Plants>();
        ArrayList<Plants> newList = new ArrayList<Plants>();
        newList = add();
        
        for (Plants herbX : newList) {
            if (herbX.lifeTime == lifeTime && !(herbX.mostUsedMineral.equals(mineral))) {
                possibilities.add(herbX);
            }
        }
        //Random selection part
        Random rand = new Random();
        Plants selectedHerbs = new Herbs();
        for (int i = 0; i < 5; i++) {
            int randomOfIndex = rand.nextInt(possibilities.size());

            selectedHerbs = possibilities.get(randomOfIndex);
            while (selectedHerbs.mostUsedMineral.equals(mineral)) {
                randomOfIndex = rand.nextInt(possibilities.size());
                selectedHerbs = possibilities.get(randomOfIndex);
            }
            herbs[i] = selectedHerbs;
            System.out.println(selectedHerbs);
        }
        System.out.println(herbs);
        return herbs;
    }

}
