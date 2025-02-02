package Operations;

import spreadsheet.Cell;
import spreadsheet.Expression;

import java.util.HashSet;
import java.util.Set;

public abstract class Operation implements Expression {
    public Expression exp1, exp2;
    protected Set<Cell> references = new HashSet<>();

    public Operation(Expression e1, Expression e2){
        this.exp1=e1;
        this.exp2=e2;
    }
}
