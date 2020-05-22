package spreadsheet;

import Value.MaybeValue;
import Value.NoValue;

public class Cell implements observer{
    MaybeValue val;
    Expression exp;
    String name;

    public Cell(){
        val = new NoValue();
        exp = val;
    }

    public MaybeValue evaluate(){
        return this.exp.evaluate();
    }

    public void set(Expression exp){
        this.exp = exp;
        this.val = exp.evaluate();
    }

     @Override
    public void update(Expression e) {
        this.val = e.evaluate();
    }
}
