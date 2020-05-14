import java.util.ArrayList;
import java.util.HashMap;

public class Sheet {
    private static final int ASCI=97;

    private HashMap<String, Cell> table = new HashMap<>();

    public Sheet(int size) {
        createStructure2(size);
    }

    private void createStructure2(int size) {

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                Cell cell = new Cell();
                String key = searchKey(i,j);
                table.put(key, cell);
            }
        }
    }

    private String searchKey(int i, int j) {
        int asciiValue = i + ASCI;
        return Character.toString((char) asciiValue).concat(Integer.toString(j + 1));
    }

}
