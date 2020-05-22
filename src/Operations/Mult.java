package Operations;

import Value.MaybeValue;
import Value.NoValue;
import Value.SomeValue;
import spreadsheet.Cell;
import spreadsheet.Expression;

public class Mult extends Operation {
    public Mult(Expression e1, Expression e2) {
        super(e1, e2);
    }
   // private Set<Cell> references;

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

    @Override
    public void cleanListener(Cell cell) {
        exp1.cleanListener(cell);
        exp2.cleanListener(cell);
    }

    /*
    @Override
    public Set<Cell> references() {
        return references;
    }
*/
    @Override
    public void addListener(Cell cell) {
        // No veig perque s'ha de tenir una referencia sobre si matreix???
        // super.references.add(cell);
        //
        // var e1 = SpreadSheet.GetReference("a1");
        exp1.addListener(cell);
        exp2.addListener(cell);
    }
    /*
    @Override
    public void notifyListeners(Set<Cell> references) {
        for(Cell cell : references){
            cell.evaluate();
        }
    }
    */
    public int operate(int i1, int i2){
        return i1 * i2;
    }
}
