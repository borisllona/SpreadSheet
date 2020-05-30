package Operations;

import spreadsheet.Cell;
import spreadsheet.Expression;

public class Mult extends Operation {
    public Mult(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public void cleanListener(Cell cell) {
        exp1.cleanListener(cell);
        exp2.cleanListener(cell);
    }

    @Override
    public void addListener(Cell cell) {
        exp1.addListener(cell);
        exp2.addListener(cell);
    }

    @Override
    public int operate(int i1, int i2){
        return i1 * i2;
    }
}
