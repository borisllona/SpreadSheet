package Value;

import spreadsheet.Cell;

import java.util.Set;

public class SomeValue extends MaybeValue {
    int value;

    public SomeValue(int value){
        this.value=value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public MaybeValue evaluate() {
        return new SomeValue(this.value);
    }

    @Override
    public Set<Cell> references() {
        return null;
    }

    @Override
    public void expChanged() { }

    @Override
    public void addListener(Cell cell) { }

}
