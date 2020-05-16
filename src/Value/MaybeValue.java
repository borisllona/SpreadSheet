package Value;


import spreadsheet.Expression;

public abstract class MaybeValue  implements Expression {
    private boolean hasValue;
    public boolean hasValue(){
        return hasValue;
    }
}
