public abstract class Operation implements Expression {
    Expression exp1, exp2;

    public Operation(Expression e1, Expression e2){
        this.exp1=e1;
        this.exp2=e2;
    }

    //public int operate(int i1, int i2){ return 0; }

}
