package spreadsheet;

import Value.MaybeValue;
import Value.NoValue;

public class Cell implements Observer {
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
        this.val = this.exp.evaluate();
        return this.val;
    }

    public void set(Expression exp){
        this.exp = exp;
        this.val = exp.evaluate();
        //exp.expChanged(this, exp.references());
        //notifyReferences(exp);
       // exp.notifyObservers(exp.references());
    }

    @Override
    public void update(Expression exp) {
        /*if(e.isOperation()){
            Operation op = (Operation)e;
            op.exp1.notifyListeners(op.exp1.references());
            op.exp2.notifyListeners(op.exp2.references());
        }
        this.val = e.evaluate();
        e.notifyListeners(e.references());*/
        this.val = exp.evaluate();
        exp.notifyObservers(exp.references());


    }
}
