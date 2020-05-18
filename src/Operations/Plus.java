package Operations;

import Value.MaybeValue;
import Value.NoValue;
import spreadsheet.Cell;
import spreadsheet.Expression;

import java.util.Set;

public class Plus extends Operation {

    public Plus(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public MaybeValue evaluate() {
        MaybeValue v1 = exp1.evaluate();
        MaybeValue v2 = exp2.evaluate();
        if(v1.hasValue() && v2.hasValue()){
            //return operate(v1.value, v2.value);
        }
        return new NoValue();
    }

    @Override
    public Set<Cell> references() {
        return null;
    }

    @Override
    public void addListener(Cell cell) {

    }

    public int operate(int i1, int i2){
        return i1 + i2;
    }
}
