package Value;

import spreadsheet.Cell;

import java.util.Set;

public class SomeValue extends MaybeValue {
    int value;

    public SomeValue(int value){
        super.setValue(true);
        this.value=value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public boolean hasValue() {
        return super.hasValue();
    }

    @Override
    public MaybeValue evaluate() {
        return new SomeValue(this.value);
    }

    @Override
    public Set<Cell> references() {
        return references;
    }

    @Override
    public void addListener(Cell cell) {
        references.add(cell);
    }

    @Override
    public void notifyListeners(Set<Cell> references) {
        for(Cell cell : references){
            cell.evaluate();
        }
    }

    @Override
    public boolean isOperation() {
        return false;
    }

}
