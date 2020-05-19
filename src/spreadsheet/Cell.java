package spreadsheet;

import Value.MaybeValue;
import Value.NoValue;

public class Cell implements ChangeListener{
    MaybeValue val;
    Expression exp;
   // Set<Cell> cellReferences;

    public Cell(){
        val = new NoValue();
        val.addListener(this);
        exp = val;
    }

    public MaybeValue evaluate(){

        return this.exp.evaluate();
    }

    public void set(Expression exp){
        this.exp = exp;
        //notifyReferences(exp);
    }

    @Override
    public void expChanged(Expression e) {
        //notify current expression
        /*if(exp.references().size()>0){
            exp.notifyListeners(exp.references(), e);
        }*/

        this.exp = e;
        this.val = exp.evaluate();
        //exp.notifyListeners(exp.references(), e);
    }
}
