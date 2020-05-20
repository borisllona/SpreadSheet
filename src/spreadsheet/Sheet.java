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

    public Cell getCell(String name) throws NotValidCellException {
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
    }

    public void setExpression(String name, Expression expr) throws NotValidCellException {
        if(!table.containsKey(name)){
            throw new NotValidCellException();
        }
        Cell currentCell = getCell(name);
        notifyListeners(currentCell, expr);
        expr.addListener(currentCell);
        currentCell.set(expr);
        table.put(name, currentCell);
    }

    private void notifyListeners(Cell currentCell, Expression expr) {
        Expression currentExp = currentCell.exp;
        Set<Cell> references = currentExp.references();
        for(Cell cell : references){
            cell.expChanged(expr);
        }
    }

    public void clearTable(int size) {
        createStructure(size);
    }

}
