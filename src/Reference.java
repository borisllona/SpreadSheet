import java.util.Set;


public class Reference implements Expression {
    Cell Ref;

    public Reference(Cell ref){
        this.Ref=ref;
    }

    @Override
    public MaybeValue evaluate() {
        return Ref.evaluate();
    }

    @Override
    public Set<Cell> references() {
        return Ref.getReferences();
    }

    @Override
    public void expChanged() {

    }

    @Override
    public void addListener(Cell cell) {

    }
}
