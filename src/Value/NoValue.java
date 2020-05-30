package Value;

import spreadsheet.Cell;
import spreadsheet.Sheet;

import java.util.Set;

public class NoValue extends MaybeValue {
    public static final NoValue INSTANCE = new NoValue();

    private NoValue() {
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
    public void addListener(Cell cell) {
    }
    @Override
    public void cleanListener(Cell cell) {
    }

}
