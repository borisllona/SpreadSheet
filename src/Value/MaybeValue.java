
import java.util.Set;

public abstract class MaybeValue implements Expression {
    private boolean hasValue;
    public boolean hasValue(){
        return hasValue;
    }

    @Override
    public MaybeValue evaluate() {
        return null;
    }

    @Override
    public Set<Cell> references() {
        return null;
    }
}
