package Value;

import spreadsheet.Cell;

import java.util.Set;

public class NoValue extends MaybeValue {
    public static final NoValue INSTANCE = new NoValue();

    public NoValue() {
        super.setValue(false);
    }

    //RETORNARA UNA INSTANCIA NO VALUE SINGLETON
    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public MaybeValue evaluate() {
        return NoValue.INSTANCE;
    }


    @Override
    public Set<Cell> references() {
        return this.references;
    }

    @Override
    public void register(Cell cell) {
        references.add(cell);
    }

    @Override
    public void unregister(Cell cell) {

    }

    @Override
    public void notifyObservers(Set<Cell> references) {
        for(Cell cell : references) {
            cell.evaluate();
            //cell.update(this.evaluate());
        }
    }
    @Override
    public boolean isOperation(){ return false; }
}
