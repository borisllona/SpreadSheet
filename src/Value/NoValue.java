package Value;

public class NoValue extends MaybeValue {

    //RETORNARA UNA INSTANCIA NO VALUE SINGLETON
    @Override
    public boolean hasValue() {
        /* No se si es necessari */
        return false;
    }
}
