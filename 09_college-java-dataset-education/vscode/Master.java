import java.util.ArrayList;

/**
 * This class is Top class / super class that store data set education,
 * and this class have 2 method that addData() and getDataSet()
 */
public class Master {
  protected ArrayList<ArrayList<Object>> dataSet = new ArrayList<>();
  /*
  - 0 : No
  - 1 : Kode kemdagi
  - 2 : Kode BPJS
  - 3 : Povinsi
  - 4 : Status pendidikan negeri
  - 5 : Status pendidikan swasta
  - 6 : Total
  */

  /**
   * This function is to add data to dataSet arrayList with parameter value,
   * this function will be called in main class.
   * @param newData
   */
  public void addData(ArrayList<Object> newData) {
    dataSet.add(newData);
  }

  /**
   * This function is very simple that to return / get data set with return
   * value is double ArrayList object data type. 
   * @return
   */
  public ArrayList<ArrayList<Object>> getDataSet() {
    return dataSet;
  }
}
