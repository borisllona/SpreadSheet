package spreadsheet;

import Value.MaybeValue;

import java.util.HashMap;
import java.util.Set;

public class Sheet {
    private static final int ASCI=97;

    private HashMap<String, Cell> table = new HashMap<>();
    private HashMap<String, Reference> cellReferences = new HashMap<>();

    public Sheet(int size) {
        createStructure(size);
    }

    private void createStructure(int size) {
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                Cell cell = new Cell();
                Reference ref = new Reference(cell);
                String key = searchKey(i,j);
                cell.name = key;
                table.put(key, cell);
                cellReferences.put(key, ref);
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

    public Reference getRef(String name) throws NotValidCellException {
        if(!table.containsKey(name)){
            throw new NotValidCellException();
        }
        return cellReferences.get(name);
    }

    public MaybeValue getValue(String name) throws NotValidCellException {
        if(!table.containsKey(name)){
            throw new NotValidCellException();
        }

        return table.get(name).val;
    }

    public void setExpression(String name, Expression expr) throws NotValidCellException {
        if(!table.containsKey(name)){
            throw new NotValidCellException();
        }

        Cell currentCell = getCell(name);

        currentCell.exp.unregisterListener(currentCell);

        currentCell.set(expr);
        expr.registerListener(currentCell);

        notifyListeners(currentCell);


        table.put(name, currentCell);
    }

    private void notifyListeners(Cell currentCell) throws NotValidCellException {

        Reference ref = getRef(currentCell.name);
        Set<Cell> references = ref.references();

        String name = "";
        while (! references.isEmpty())
        {
            for(Cell cell : references){
                Expression e = cell.exp;
                cell.update(e);
                name = cell.name;
            }
            ref = getRef(name);
            references = ref.references();
        }

    }

    public void clearTable(int size) {
        createStructure(size);
    }

}
