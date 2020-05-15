
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
}
