import Value.SomeValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import spreadsheet.NotValidCellException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static spreadsheet.SpreadSheet.*;
import static spreadsheet.SpreadSheet.clear;

public class AllOperationsTest {


    @Test
    public void plus_test1() throws NotValidCellException {
        put("a1", "b1");
        put("b1", plus(new SomeValue(2), new SomeValue(4)));
        SomeValue sv = (SomeValue) get("b1");
        assertEquals(new SomeValue(6).getValue(), sv.getValue());
        sv = (SomeValue) get("a1");
        assertEquals(new SomeValue(6).getValue(), sv.getValue());
    }

    @Test
    public void plus_test2() throws NotValidCellException {
        put("a1", 45);
        put("c1", plus("a1", 3));
        SomeValue sv = (SomeValue) get("c1");
        assertEquals(new SomeValue(48).getValue(), sv.getValue());

        put("b2", plus("a2", 5) );
        put("a2", 5);
        put("c2", "b2" );
        sv = (SomeValue) get("c2");
        assertEquals(new SomeValue(10).getValue(), sv.getValue());


    }
    @Test
    public void plus_test3() throws NotValidCellException {
        put("a1", 10);
        put("b1", "c1");
        put("c1", plus(plus(2,3), "a1"));

        SomeValue sv = (SomeValue) get("c1");
        assertEquals(new SomeValue(15).getValue(), sv.getValue());

        sv = (SomeValue) get("b1");
        assertEquals(new SomeValue(15).getValue(), sv.getValue());

    }
    @Test
    public void plus_test4() throws NotValidCellException {
        put("a1", 10);
        put("c1", plus(plus("a1", 5), 5));
        SomeValue sv = (SomeValue) get("c1");
        assertEquals(new SomeValue(20).getValue(), sv.getValue());
    }

    @Test
    public void mult_test1() throws NotValidCellException {
        put("a1", "b1");
        put("b1", mult(new SomeValue(2), new SomeValue(4)));
        SomeValue sv = (SomeValue) get("b1");
        assertEquals(new SomeValue(8).getValue(), sv.getValue());
        sv = (SomeValue) get("a1");
        assertEquals(new SomeValue(8).getValue(), sv.getValue());
    }
    @Test
    public void mult_test2() throws NotValidCellException {
        put("a1", 30);
        put("c1", mult("a1", 3));
        SomeValue sv = (SomeValue) get("c1");
        assertEquals(new SomeValue(90).getValue(), sv.getValue());

        put("b2", mult("a2", 5) );
        put("a2", 5);
        put("c2", "b2" );
        sv = (SomeValue) get("c2");
        assertEquals(new SomeValue(25).getValue(), sv.getValue());


    }

    @Test
    public void mult_test3() throws NotValidCellException {
        put("a1", 10);
        put("b1", "c1");
        put("c1", mult(mult(2,3), "a1"));

        SomeValue sv = (SomeValue) get("c1");
        assertEquals(new SomeValue(60).getValue(), sv.getValue());

        sv = (SomeValue) get("b1");
        assertEquals(new SomeValue(60).getValue(), sv.getValue());
    }

    @Test
    public void mult_test4() throws NotValidCellException {
        put("a1", 10);
        put("c1", mult(mult("a1", 5), 5));
        SomeValue sv = (SomeValue) get("c1");
        assertEquals(new SomeValue(250).getValue(), sv.getValue());
    }
    @AfterEach
    public void clearSheet(){
        clear();
    }

}
