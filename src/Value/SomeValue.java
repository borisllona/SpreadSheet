package Value;

import spreadsheet.Cell;

import java.util.Set;

public class SomeValue extends MaybeValue {
    int value;
    private Set<Cell> references;

    public SomeValue(int value){
        super.setValue(true);
        this.value=value;
    }

    public int getValue(){
        return this.value;
    }

  /*  @Override
    public boolean hasValue() {
        return true;
    }
*/
    @Override
    public MaybeValue evaluate() {
        return new SomeValue(this.value);
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
