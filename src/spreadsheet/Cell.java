package spreadsheet;

import Operations.Operation;
import Value.MaybeValue;
import Value.NoValue;

public class Cell implements ChangeListener{
    MaybeValue val;
    Expression exp;
   // Set<Cell> cellReferences;

    public Cell(){
        val = new NoValue();
        //val.addListener(this);
        exp = val;
        //exp.addListener(this);
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

    @Override
    public void expChanged(Expression e) {
        if(e.isOperation()){
            Operation op = (Operation)e;
            op.exp1.notifyListeners(op.exp1.references());
            op.exp2.notifyListeners(op.exp2.references());
        }
        this.val = e.evaluate();
        e.notifyListeners(e.references());

    }
}
