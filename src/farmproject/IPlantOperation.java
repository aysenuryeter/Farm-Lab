package farmproject;

import java.util.ArrayList;

public interface IPlantOperation {

    ArrayList<Plants> add();

    Plants[] selection(String mineral, int year, Plants[] array);

}
