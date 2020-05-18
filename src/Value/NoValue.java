package Value;

import spreadsheet.Cell;

import java.util.Set;

public class NoValue extends MaybeValue {
    public static final NoValue INSTANCE = new NoValue();
    private Set<Cell> references;

    public NoValue() { }

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
}
