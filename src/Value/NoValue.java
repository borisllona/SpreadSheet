package Value;

public class NoValue extends MaybeValue{

   public static final NoValue INSTANCE = new NoValue();
   private NoValue(){}

    //RETORNARA UNA INSTANCIA NO VALUE SINGLETON
    @Override
    public boolean hasValue() {
        /* No se si es necessari */
        return false;
    }

}
