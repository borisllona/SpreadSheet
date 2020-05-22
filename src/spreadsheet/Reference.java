package spreadsheet;

import Value.MaybeValue;

import java.util.HashSet;
import java.util.Set;


public class Reference implements Expression {
    Cell Ref;
    //Todo: refactor eliminar hash perq una cela una referencia.
    Set<Cell> references = new HashSet<>();

    public Reference(Cell ref){
        this.Ref=ref;
    }

    @Override
    public MaybeValue evaluate() {
        return Ref.evaluate();
    }

    /*
    @Override
    public Set<Cell> references() {
        return this.references;
    }
*/
    @Override
    public void addListener(Cell cell) {
        references.add(cell);
    }

    @Override
    public void cleanListener(Cell cell) {
        references.remove(cell);
    }

/*
    @Override
    public void notifyListeners(Set<Cell> references) {
        for(Cell cell : references){
            cell.expChanged(this);
        }
    }
*/

}
