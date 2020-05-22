package Operations;

import Value.MaybeValue;
import Value.NoValue;
import Value.SomeValue;
import spreadsheet.Cell;
import spreadsheet.Expression;
import spreadsheet.Sheet;

import java.util.Set;

public class Plus extends Operation {

    private Set<Cell> references;

    public Plus(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public MaybeValue evaluate() {
        MaybeValue v1 = exp1.evaluate();
        MaybeValue v2 = exp2.evaluate();
        if(v1.hasValue() && v2.hasValue()){
            SomeValue sv1= (SomeValue) v1;
            SomeValue sv2= (SomeValue) v2;
            return new SomeValue(operate(sv1.getValue(), sv2.getValue()));
        }
        return new NoValue();
    }

    /*
    @Override
    public Set<Cell> references() {
        return references;
    }
*/
    @Override
    public void registerListener(Cell cell) {
        exp1.registerListener(cell);
        exp2.registerListener(cell);
    }

    @Override
    public void unregisterListener(Cell cell) {
        exp1.unregisterListener(cell);
        exp2.unregisterListener(cell);
    }

    public int operate(int i1, int i2){
        return i1 + i2;
    }
}
