package Operations;

import java.util.Set;

public class Plus extends Operation {

    public Plus(Expression e1, Expression e2) {
        super(e1, e2);
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
