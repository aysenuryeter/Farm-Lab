
package farmproject;

import static farmproject.Plants.readFromFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bushes extends Plants implements IPlantOperation {

     //this class saves the items in the plants arraylist thats eligible for plantsType
    public static ArrayList<Plants> listBushes = new ArrayList<Plants>();

    Bushes() {

    }
    
    public Bushes(String nameOfPlant, String mostUsedMineral, int lifeTime, String plantType, Double price,
            int kgOverDekar) {
        super(nameOfPlant, mostUsedMineral, lifeTime, plantType, price, kgOverDekar);
        
    }
    //This code will appoint the suitable type items from general plants list to ListBushes. This function derivated from IPlantOperation.
    @Override
    public ArrayList<Plants> add() {
        ArrayList<Plants> newList = new ArrayList<Plants>();
        try {
            newList = readFromFile();
        } catch (IOException ex) {
            Logger.getLogger(Herbs.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Plants plantX : newList) {
            if (plantX.plantType.equals("BUSH")) {
                listBushes.add(plantX);
            }
        }
        System.out.println(listBushes);
        return listBushes;
    }
    //This function is overrited in this section via IPlantOperation interface.
    //This function gets the information given by the farmer about the former plant and its mineral info, and the lifespan of the wanted plant and puts on an arraylist of the type of bushes named posibilities.
    //After that the function puts items from arrraylist named posibilities randomly that will be presented in an array and will return that array.
    @Override
    public Plants[] selection(String mineral, int lifeTime, Plants[] bushes) {

        ArrayList<Plants> possibilities = new ArrayList<Plants>();
        ArrayList<Plants> newList = new ArrayList<Plants>();
        newList = add();

        for (Plants bushesX : newList) {
            if (bushesX.lifeTime == lifeTime && !(bushesX.mostUsedMineral.equals(mineral))) {
                possibilities.add(bushesX);
            }
        }
        System.out.println(possibilities.size());
        //random selection part
        Random rand = new Random();
        Plants selectedBuhes = new Bushes();

        for (int i = 0; i < 5; i++) {
            int randomOfIndex = rand.nextInt(possibilities.size());
            selectedBuhes = possibilities.get(randomOfIndex);
            while (selectedBuhes.mostUsedMineral.equals(mineral)) {
                randomOfIndex = rand.nextInt(possibilities.size());
                selectedBuhes = possibilities.get(randomOfIndex);
            }
            bushes[i] = selectedBuhes;
            System.out.println(selectedBuhes);
        }
        System.out.println(bushes);

        return bushes;
    }

}
