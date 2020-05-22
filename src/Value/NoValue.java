package Value;

import spreadsheet.Cell;
import spreadsheet.Sheet;

import java.util.Set;

public class NoValue extends MaybeValue {
    public static final NoValue INSTANCE = new NoValue();

    public NoValue() {
        super.setValue(false);
    }

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
        return references;
    }


    @Override
    public void registerListener(Cell cell) {
        references.add(cell);
    }

    @Override
    public void unregisterListener(Cell cell) {
        references.remove(cell);
    }
}
