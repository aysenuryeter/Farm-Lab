/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmproject;

import static farmproject.Plants.readFromFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trees extends Plants implements IPlantOperation {

    public static ArrayList<Plants> listTrees = new ArrayList<Plants>();

    Trees() {

    }

    public Trees(String nameOfPlant, String mostUsedMineral, int lifeTime, String plantType, Double price,
            int kgOverDekar) {
        super(nameOfPlant, mostUsedMineral, lifeTime, plantType, price, kgOverDekar);
        // TODO Auto-generated constructor stub
    }
//This code will appoint the suitable type items from general plants list to ListTrees. This function derivated from IPlantOperation.
    @Override
    public ArrayList<Plants> add() {
        ArrayList<Plants> newList = new ArrayList<Plants>();
        try {
            newList = readFromFile();
        } catch (IOException ex) {
            Logger.getLogger(Herbs.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Plants plantX : newList) {
            if (plantX.plantType.equals("TREE")) {
                listTrees.add(plantX);
            }
        }
        System.out.println(listTrees);
        return listTrees;
    }
    /*This function is overrited in this section via IPlantOperation interface.
    This function gets the information given by the farmer about the former plant and its mineral info, and the lifespan of the wanted plant and puts on an arraylist of the type of bushes named posibilities.
    After that the function puts items from arrraylist named posibilities randomly that will be presented in an array and will return that array. */
    @Override
    public Plants[] selection(String mineral, int lifeTime, Plants[] trees) {

        ArrayList<Plants> possibilities = new ArrayList<Plants>();
        ArrayList<Plants> newList = new ArrayList<Plants>();
        newList = add();
        for (Plants treeX : newList) {
            if (treeX.lifeTime == lifeTime && !(treeX.mostUsedMineral.equals(mineral))) {
                possibilities.add(treeX);
            }
        }
        //Random selection part
        Random rand = new Random();
        Plants selectedTrees = new Trees();
        for (int i = 0; i < 5; i++) {
            int randomOfIndex = rand.nextInt(possibilities.size());

            selectedTrees = possibilities.get(randomOfIndex);
            while (selectedTrees.mostUsedMineral.equals(mineral)) {
                randomOfIndex = rand.nextInt(possibilities.size());
                selectedTrees = possibilities.get(randomOfIndex);
            }
            //assigning the selected trees to array
            trees[i] = selectedTrees;
            System.out.println(selectedTrees);
        }
        System.out.println(trees);

        return trees;
    }

}
