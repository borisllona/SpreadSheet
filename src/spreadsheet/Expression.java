package spreadsheet;

import Value.MaybeValue;

import java.util.Set;

public interface Expression {
    MaybeValue evaluate();
    void addListener(Cell cell);
    void cleanListener(Cell cell);

}
