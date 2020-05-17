
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
    public void expChanged() {

    }

    @Override
    public void addListener(Cell cell) {

    }

}
