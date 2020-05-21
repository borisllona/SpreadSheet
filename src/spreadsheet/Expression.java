package spreadsheet;

import Value.MaybeValue;

import java.util.Set;

public interface Expression {
    MaybeValue evaluate();
    Set<Cell> references();

    void register(Cell cell);
    void unregister(Cell cell);
    void notifyObservers(Set<Cell> references);

    boolean isOperation();
    //void expChanged(Expression e);
}
