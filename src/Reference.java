import Value.MaybeValue;

import java.util.Set;


public class Reference implements Expression {
    Cell Ref;

    public Reference(Cell ref){
        this.Ref=ref;
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
