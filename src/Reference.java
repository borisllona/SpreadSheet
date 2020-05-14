import Value.MaybeValue;


public class Reference implements Expression {
    Cell cellRef;

    public Reference(Cell ref){
        this.cellRef=ref;
    }

    @Override
    public MaybeValue evaluate() {
        return null;
    }
}
