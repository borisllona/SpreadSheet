package Operations;

import Value.MaybeValue;
import Value.NoValue;
import Value.SomeValue;
import spreadsheet.Cell;
import spreadsheet.Expression;

import java.util.Set;

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
    public Set<Cell> references() {
        return references;
    }

    @Override
    public void register(Cell cell) {
        super.references.add(cell);
        exp1.register(cell);
        exp2.register(cell);
    }

    @Override
    public void unregister(Cell cell) {

    }

    @Override
    public void notifyObservers(Set<Cell> references) {
      //  exp1.notifyListeners(exp1.references());
      //  exp2.notifyListeners(exp2.references());
        for(Cell cell : references){
            cell.evaluate();
            //cell.update(this.evaluate());
        }
    }
    @Override
    public boolean isOperation(){ return true; }
    public int operate(int i1, int i2){
        return i1 * i2;
    }
}
