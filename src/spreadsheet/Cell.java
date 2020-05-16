package spreadsheet;

import Value.MaybeValue;

public class Cell {
    MaybeValue val;
    Expression exp;

    public MaybeValue evaluate(){
        return this.val;
    }
    public void set(Expression exp){
        this.exp = exp;
    }
}
