
public class NoValue extends MaybeValue {
    NoValue nV = null;

    //RETORNARA UNA INSTANCIA NO VALUE SINGLETON
    @Override
    public boolean hasValue() {
        /* No se si es necessari */
        return false;
    }

    @Override
    public MaybeValue evaluate() {
        if( nV == null){
            nV = new NoValue();
        }
        return nV;
    }

    @Override
    public void expChanged() {

    }

    @Override
    public void addListener(Cell cell) {

    }
}
