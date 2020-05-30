package Operations;

import Value.MaybeValue;
import Value.NoValue;
import Value.SomeValue;
import spreadsheet.Cell;
import spreadsheet.Expression;
import spreadsheet.Sheet;

import java.util.Set;

public class Plus extends Operation {

    public Plus(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public void addListener(Cell cell) {
        exp1.addListener(cell);
        exp2.addListener(cell);
    }

    @Override
    public void cleanListener(Cell cell) {
    }

    @Override
    public int operate(int i1, int i2){
        return i1 + i2;
    }
}
