package spreadsheet;

import Value.MaybeValue;
import Value.NoValue;

public class Cell {// implements ChangeListener{
    MaybeValue val;
    Expression exp;
    String name;
   // Set<Cell> cellReferences;

    public Cell(){
        val = new NoValue();
        // val.addListener(this);
        exp = val;
    }

    public MaybeValue evaluate(){
        return this.exp.evaluate();
    }

    public void set(Expression exp){
        this.exp = exp;
        this.val = exp.evaluate();
        //exp.expChanged(this, exp.references());
        //notifyReferences(exp);
    }

    // @Override
    public void expChanged(Expression e) {
        this.val = e.evaluate();
         // e.notifyListeners(e.references());

    }
}
