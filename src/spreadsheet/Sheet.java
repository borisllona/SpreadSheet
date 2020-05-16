package spreadsheet;


import java.util.HashMap;

public class Sheet {
    private HashMap<String, Cell> taula = new HashMap<>();
    private static final int ASCI=97;
        public Sheet(int size) {
            for (int i = 0; i < size; i++){
                for (int x = 0; x < size; x++){
                    String index =  Character.toString((char)(ASCI + i));
                    index +=  Integer.toString(x + 1);
                    //todo: revisar com afegir una cel·la amb NoValue
                    taula.put(index, new Cell());
                }
            }
        }
}
