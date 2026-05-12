import java.util.ArrayList;

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

  public void addData(ArrayList<Object> newData) {
    dataSet.add(newData);
  }

  public ArrayList<ArrayList<Object>> getDataSet() {
    return dataSet;
  }
}
