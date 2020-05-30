package Value;


import spreadsheet.Cell;
import spreadsheet.Expression;

import java.util.HashSet;
import java.util.Set;

public abstract class MaybeValue implements Expression {
    private boolean hasValue;
    // protected Set<Cell> references = new HashSet<>();

    public boolean hasValue(){
        return hasValue;
    }
    public void setValue(boolean hasValue){
       this.hasValue = hasValue;
    }

}
