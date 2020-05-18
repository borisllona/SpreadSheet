package spreadsheet;

import Value.MaybeValue;
import Value.NoValue;

public class Cell implements ChangeListener{
    MaybeValue val;
    Expression exp;
   // Set<Cell> cellReferences;

    public Cell(){
        val = new NoValue();
        val.addListener(this);
        exp = val;
    }

    public MaybeValue evaluate(){

        return this.val;
    }

    public void set(Expression exp){
        this.exp = exp;
        //notifyReferences(exp);
    }

  /*  @Override
    public void expChanged(Expression e) {
        this.exp = e;
        notifyReferences(e);
    }

  /*  private void notifyReferences(Expression e) {
        for(Cell cell : cellReferences){
            //cell.expChanged(e);
        }
    }

    @Override
    public void addListener(Cell cell) {
        cellReferences.add(cell);
    }

    public Set<Cell> getReferences() {
        return this.cellReferences;
    }*/

    @Override
    public void expChanged(Expression e) {
        //notify current expression
        if(exp.references().size()==0){
            exp.notifyListeners(exp.references(), e);
        }
        this.exp = e;
        this.val = exp.evaluate();
    }
}
