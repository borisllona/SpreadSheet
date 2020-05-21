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

    }

    @Override
    public void update(Expression expr) {

        this.val = this.exp.evaluate();
        expr.notifyObservers(expr.references());

    }
}
