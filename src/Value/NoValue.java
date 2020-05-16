package Value;

import spreadsheet.Cell;

import java.util.*;

public class NoValue extends MaybeValue{

   public static final NoValue INSTANCE = new NoValue();

   private NoValue(){}

    //RETORNARA UNA INSTANCIA NO VALUE SINGLETON
    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public MaybeValue evaluate() {
        return NoValue.INSTANCE;
    }

    @Override
    public Set<Cell> references() {
        // todo: retorno llista buida. Pendent de test per veure si funciona
        return new HashSet<>();
    }
}
