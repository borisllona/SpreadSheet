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
        //ToDo: aplicar patró fatory method (lazy)
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                Cell cell = new Cell();
                Reference ref = new Reference(cell);
                String key = searchKey(i,j);
                // only for debug
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
        // Cell currentCell = table.get(name);
        // return currentCell.evaluate();
        return table.get(name).val;
    }

    public void setExpression(String name, Expression expr) throws NotValidCellException {
        if(!table.containsKey(name)){
            throw new NotValidCellException();
        }

        Cell currentCell = getCell(name);

        // Elimina referencies de l'expressió anterior
        currentCell.exp.unregisterListener(currentCell);

        currentCell.set(expr);
        expr.registerListener(currentCell);

        notifyListeners(currentCell, expr);


        table.put(name, currentCell);
    }

    private void notifyListeners(Cell currentCell, Expression expr) {
        //ToDo: refactor eliminar for each, si fem una cela una referencia
        // Expression currentExp = currentCell.exp;
        var references = SpreadSheet.GetReference(currentCell.name).references; // currentExp.references();
        /*
        for(Cell cell : references){
            var e = cell.exp;
            cell.expChanged(e);
        }
         */
        String name = "";
        while (! references.isEmpty())
        {
            for(Cell cell : references){
                var e = cell.exp;
                cell.update(e);
                name = cell.name;
            }
            references = SpreadSheet.GetReference(name).references;
        }

    }

    public void clearTable(int size) {
        createStructure(size);
    }

}
