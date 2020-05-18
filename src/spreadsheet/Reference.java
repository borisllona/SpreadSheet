package spreadsheet;

import Value.MaybeValue;

import java.util.Set;


public class Reference implements Expression {
    Cell Ref;
    Set<Cell> references;
    public Reference(Cell ref){
        this.Ref=ref;
    }

    @Override
    public MaybeValue evaluate() {
        return Ref.evaluate();
    }

    @Override
    public Set<Cell> references() {
        return this.references;
    }

    @Override
    public void addListener(Cell cell) {
        references.add(cell);
    }

    @Override
    public void notifyListeners(Set<Cell> references, Expression expr) {
        for(Cell cell : references){
            cell.expChanged(expr);
        }
    }
}
