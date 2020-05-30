package spreadsheet;

import Value.MaybeValue;
import Value.NoValue;

public class Cell {
    MaybeValue val;
    Expression exp;
    String name;

    public Cell(){
        val = NoValue.INSTANCE;
        exp = val;
    }

    public MaybeValue evaluate(){
        return this.exp.evaluate();
    }

    public void set(Expression exp){
        this.exp = exp;
        this.val = exp.evaluate();
    }

    // @Override
    public void expChanged(Expression e) {
        this.val = e.evaluate();

    }
}
