import java.util.HashMap;

public class Sheet {
    private static final int ASCI=97;

    private HashMap<String, Cell> table = new HashMap<>();

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

    public Cell getRef(String s){
        return table.get(s);
    }

    public MaybeValue getValue(String name) {
        Cell currentCell = table.get(name);
        return currentCell.evaluate();
       /* if(currentCell.evaluate()==null){
            return new NoValue();
        }

        return new SomeValue();*/
    }

    public void setExpression(String name, Expression expr) {
        Cell keyCell = table.get(name);
        keyCell.set(expr);
        table.put(name, keyCell);
    }

    public void clearTable(int size) {
        createStructure(size);
    }
/*
    public void setValue(String name, int value) {
        Cell keyCell = table.get(name);
        keyCell.set(new SomeValue(value));
        table.put(name, keyCell);
    }*/
}
