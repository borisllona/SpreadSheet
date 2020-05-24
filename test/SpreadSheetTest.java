import Value.SomeValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spreadsheet.NotValidCellException;

import static org.junit.jupiter.api.Assertions.*;
import static spreadsheet.SpreadSheet.*;

public class SpreadSheetTest {
    @BeforeEach
    public void setUpSheet() throws NotValidCellException {
        put("a3", mult("a1", "a2"));
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() throws NotValidCellException {
        assertFalse(get("a3").hasValue());
    }

    @Test
    public void cell_no_value_with_just_one_assignment_1() throws NotValidCellException {
        put("a1",10);
        put("a2",2);

        SomeValue sv = (SomeValue) get("a3");
        assertEquals(new SomeValue(20).getValue(), sv.getValue());
    }

    @Test
    public void cell_no_value_with_just_one_assignment() throws NotValidCellException {
        put("a1",10);
        assertTrue(get("a1").hasValue());
        assertFalse(get("a3").hasValue());
        SomeValue sv = (SomeValue)get("a1").evaluate();
        assertEquals(sv.getValue(), new SomeValue(10).getValue());
    }

    @Test
    void given_wrong_value_exception() throws NotValidCellException{
        assertThrows(NotValidCellException.class,
                () -> put("a2","Test"));
    }

    @Test
    public void recalculation_ref_works() throws NotValidCellException {
        put("a3", 23);
        put("a1","a3");
        SomeValue sv = (SomeValue)get("a1");
        assertEquals(new SomeValue(23).getValue(), sv.getValue());
        put("a3", 56);
        sv = (SomeValue)get("a1");
        assertEquals(new SomeValue(56).getValue(), sv.getValue());
    }

    @Test
    public void recalculation_ref_indirect_works() throws NotValidCellException {
        put("a4", "a2");
        put("a2","a5");
        put("a5", 56);
        SomeValue sv = (SomeValue)get("a2");
        assertEquals(new SomeValue(56).getValue(), sv.getValue());
        SomeValue sv2 = (SomeValue)get("a4");
        assertEquals(new SomeValue(56).getValue(), sv2.getValue());
    }

    @Test
    public void recalculation_works() throws NotValidCellException {
        put("a1",42);
        put("a2",20);
        SomeValue sv = (SomeValue)get("a3");
        assertEquals(new SomeValue(840).getValue(), sv.getValue());
    }

    @AfterEach
    public void clearSheet(){
        clear();
    }

}