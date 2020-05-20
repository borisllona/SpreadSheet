package spreadsheet;

import Operations.Mult;
import Operations.Plus;
import Value.MaybeValue;
import Value.SomeValue;

public class SpreadSheet {
    private static int SIZE=5;
    private static final Sheet SHEET = new Sheet(SIZE);


    public static MaybeValue get(String name) throws NotValidCellException {
        return SHEET.getValue(name);
    }

    public static void put(String name, Expression expr) throws NotValidCellException {


        //reference name, notifyAll references(expr)
        //EVALUATE de la cela name
        //Tenim el maybeValue(NV o SV) de l'evaluate
        //maybeValue.preferences()
        //notify preferences amb la nova expresió
        //expr.addListener(SHEET.getRef(name));   //afegim a la nova expresio el listener name
        SHEET.setExpression(name, expr);        //definim l'expresió nova a la cela

    }

    public static void put(String name, int value) throws NotValidCellException {
        SHEET.setExpression(name, new SomeValue(value));
        //Expression  = value -> SomeValue a la cel·la name. name notifica als seus listeners
    }

    public static void put(String name, String refName) throws NotValidCellException {
        Reference r = new Reference(SHEET.getCell(refName)); //TODO: referencia ja creada i no nova??
        SHEET.setExpression(name, r);
        //Expression = referencia -> Cel·la: name escolta a la referència, afegir a la taula de refname
        //la cela name.
    }

    public static void clear(){
        SHEET.clearTable(SIZE);
    }

    //Plus combinations//
    public static Expression plus(Expression expr1, Expression expr2){
        return new Plus(expr1, expr2);
    }

    public static Expression plus(Expression expr1, int value2){
        MaybeValue v2 = new SomeValue(value2);  //Maybe value o Expression

        return new Plus(expr1, v2);
    }

    public static Expression plus(Expression expr1, String ref2) throws NotValidCellException {
        Cell cell = SHEET.getCell(ref2);             //Cast de expression??

        return new Plus(expr1, cell.evaluate());
    }

    public static Expression plus(int value1, Expression expr2){
        MaybeValue v1 = new SomeValue(value1);

        return new Plus(v1, expr2);
    }

    public static Expression plus(int value1, int value2){
        MaybeValue v1 = new SomeValue(value1);
        MaybeValue v2 = new SomeValue(value2);

        return new Plus(v1, v2);
    }

    public static Expression plus(int value1, String ref2) throws NotValidCellException {
        MaybeValue v1 = new SomeValue(value1);
        Cell cell = SHEET.getCell(ref2);             //Cast de expression??

        return new Plus(v1, cell.evaluate());
    }

    public static Expression plus(String ref1, Expression expr2) throws NotValidCellException {
        Cell cell = SHEET.getCell(ref1);             //Cast de expression??

        return new Plus(cell.evaluate(), expr2);
    }

    public static Expression plus(String ref1, int value2) throws NotValidCellException {
        Cell cell = SHEET.getCell(ref1);             //Cast de expression??
        MaybeValue v1 = new SomeValue(value2);

        return new Plus(cell.evaluate(), v1);
    }

    public static Expression plus(String ref1, String ref2) throws NotValidCellException {
        Cell cell = SHEET.getCell(ref1);             //Cast de expression??
        Cell cell2 = SHEET.getCell(ref2);             //Cast de expression??

        return new Plus(cell.evaluate(), cell2.evaluate());
    }

    //Mult combinations//
    public static Expression mult(Expression expr1, Expression expr2){
        return new Mult(expr1, expr2);
    }

    public static Expression mult(Expression expr1, int value2){
        MaybeValue v2 = new SomeValue(value2);  //Maybe value o Expression

        return new Mult(expr1, v2);
    }

    public static Expression mult(Expression expr1, String ref2) throws NotValidCellException {

        Cell cell = SHEET.getCell(ref2);             //Cast de expression??

        return new Mult(expr1, cell.evaluate());
    }

    public static Expression mult(int value1, Expression expr2){

        MaybeValue v1 = new SomeValue(value1);

        return new Mult(v1, expr2);
    }

    public static Expression mult(int value1, int value2){

        MaybeValue v1 = new SomeValue(value1);
        MaybeValue v2 = new SomeValue(value2);

        return new Mult(v1, v2);
    }

    public static Expression mult(int value1, String ref2) throws NotValidCellException {

        MaybeValue v1 = new SomeValue(value1);
        Cell cell = SHEET.getCell(ref2);             //Cast de expression??

        return new Mult(v1, cell.evaluate());
    }

    public static Expression mult(String ref1, Expression expr2) throws NotValidCellException {

        Cell cell = SHEET.getCell(ref1);             //Cast de expression??

        return new Plus(cell.evaluate(), expr2);
    }

    public static Expression mult(String ref1, int value2) throws NotValidCellException {

        Cell cell = SHEET.getCell(ref1);             //Cast de expression??
        MaybeValue v1 = new SomeValue(value2);

        return new Mult(cell.evaluate(), v1);
    }

    public static Expression mult(String ref1, String ref2) throws NotValidCellException {

        Cell cell = SHEET.getCell(ref1);             //Cast de expression??
        Cell cell2 = SHEET.getCell(ref2);             //Cast de expression??

        return new Mult(new Reference(cell), new Reference(cell2));
    }
}
