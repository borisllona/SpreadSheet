package spreadsheet;

import Value.MaybeValue;

import java.util.HashSet;
import java.util.Set;


public class Reference implements Expression {
    Cell Ref;
    Set<Cell> references = new HashSet<>();
    public Reference(Cell ref){
        this.Ref=ref;
    }

    @Override
    public MaybeValue evaluate() {
        return Ref.evaluate();
    }

    @Override
    public Set<Cell> references() {

        //return Ref.exp.references();
        return this.references;
    }

    @Override
    public void register(Cell cell) {
        references.add(cell);
    }

    @Override
    public void unregister(Cell cell) {

    }

    @Override
    public void notifyObservers(Set<Cell> references) {
        for(Cell cell : references){
            cell.evaluate();
            //cell.update(this.evaluate());
        }
    }
    @Override
    public boolean isOperation(){
        return false;
    }

}
