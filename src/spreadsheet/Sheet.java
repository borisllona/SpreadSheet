package spreadsheet;

import Value.MaybeValue;

import java.util.HashMap;
import java.util.Set;

public class Sheet {
    private static final int ASCI=97;

    private HashMap<String, Cell> table = new HashMap<>();
   // private HashMap<String, Reference> cellReferences = new HashMap<>();

    public Sheet(int size) {
        createStructure(size);
    }

    private void createStructure(int size) {

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

    public Cell getRef(String name) throws NotValidCellException {
        if(!table.containsKey(name)){
            throw new NotValidCellException();
        }
        return table.get(name);
    }

    public MaybeValue getValue(String name) throws NotValidCellException {
        if(!table.containsKey(name)){
            throw new NotValidCellException();
        }
        Cell currentCell = table.get(name);
        return currentCell.evaluate();
       /* if(currentCell.evaluate()==null){
            return new NoValue();
        }

        return new SomeValue();*/
    }

    public void setExpression(String name, Expression expr) throws NotValidCellException {
        if(!table.containsKey(name)){
            throw new NotValidCellException();
        }
        Cell currentCell = getRef(name);
        Expression currentExp = currentCell.exp;
        //currentCell.evaluate();
        expr.addListener(currentCell);
        Set<Cell> references = expr.references();
        expr.notifyListeners(references);
        Cell keyCell = table.get(name);
        keyCell.set(expr);
        table.put(name, keyCell);
    }

 /*   private void notifyListeners(Set<Cell> references, Expression expr) {
        for(Cell cell : references){
            cell.expChanged(expr);
        }
    }*/

    public void clearTable(int size) {
        createStructure(size);
    }
}
