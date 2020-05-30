package Operations;

import Value.MaybeValue;
import Value.NoValue;
import Value.SomeValue;
import spreadsheet.Cell;
import spreadsheet.Expression;

import java.util.HashSet;
import java.util.Set;

public abstract class Operation implements Expression {
    public Expression exp1, exp2;
    protected Set<Cell> references = new HashSet<>();

    public Operation(Expression e1, Expression e2){
        this.exp1=e1;
        this.exp2=e2;
    }

    public MaybeValue evaluate() {
        MaybeValue v1 = exp1.evaluate();
        MaybeValue v2 = exp2.evaluate();
        if(v1.hasValue() && v2.hasValue()){
            SomeValue sv1= (SomeValue) v1;
            SomeValue sv2= (SomeValue) v2;
            return new SomeValue(operate(sv1.getValue(), sv2.getValue()));
        }
        return NoValue.INSTANCE;
    }

    protected abstract int operate(int value, int value1);

}
