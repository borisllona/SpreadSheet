package Value;

import spreadsheet.Cell;

import java.util.Set;

public class NoValue extends MaybeValue {
    public static final NoValue INSTANCE = new NoValue();

    //RETORNARA UNA INSTANCIA NO VALUE SINGLETON
    @Override
    public boolean hasValue() {
        /* No se si es necessari */
        return false;
    }

    @Override
    public MaybeValue evaluate() {
        return NoValue.INSTANCE;
    }

    @Override
    public void expChanged() {

    }

    @Override
    public Set<Cell> references() {
        return null;
    }

    @Override
    public void addListener(Cell cell) {

    }
}
