public class Cell {
    MaybeValue val;
    Expression exp;

    public Cell(){
        val= new NoValue();
    }

    public MaybeValue evaluate(){
        return this.val;
    }
    public void set(Expression exp){
        this.exp = exp;
    }

}
