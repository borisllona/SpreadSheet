package spreadsheet;

import Value.MaybeValue;

import java.util.Set;

public interface Expression {
    MaybeValue evaluate();
    Set<Cell> references();
    void registerListener(Cell cell);
    void unregisterListener(Cell cell);
}
