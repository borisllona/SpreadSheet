package spreadsheet;

import Value.MaybeValue;

import java.util.Set;

public interface Expression {
    MaybeValue evaluate();
    Set<Cell> references();
//    void expChanged();
    void addListener(Cell cell);

    void notifyListeners(Set<Cell> references, Expression expr);
}
