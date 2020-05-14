import java.util.Set;

public interface Expression {
    MaybeValue evaluate();
    Set<Cell> references();
}
