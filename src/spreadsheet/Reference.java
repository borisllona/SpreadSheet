package spreadsheet;

import Value.MaybeValue;
import spreadsheet.Cell;
import spreadsheet.Expression;

import java.util.Set;


public class Reference implements Expression {
    Cell cellRef;

    public Reference(Cell ref){
        this.cellRef=ref;
    }

    @Override
    public MaybeValue evaluate() {
        return null;
    }

    @Override
    public Set<Cell> references() {
        return null;
    }


}
