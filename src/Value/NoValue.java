package Value;

import spreadsheet.Cell;
import spreadsheet.Expression;

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
    public void addListener(Cell cell) {
        references.add(cell);
    }

    @Override
    public void notifyListeners(Set<Cell> references, Expression expr) {
        for(Cell cell : references){
            cell.expChanged(expr);
        }
    }
}
