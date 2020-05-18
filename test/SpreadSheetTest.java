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
    public void cell_no_value_with_just_one_assignment() throws NotValidCellException {
        put("a1",10);
        assertTrue(get("a1").hasValue());
        assertFalse(get("a3").hasValue());
    }

    @Test
    void given_wrong_value_exception() throws NotValidCellException{
        assertThrows(NotValidCellException.class,
                () -> put("a2","Test"));
    }


    @Test
    public void recalculation_works() throws NotValidCellException {
        put("a1",42);
        put("a2",20);
        assertEquals(new SomeValue(840), get("a3"));
    }
    @AfterEach
    public void clearSheet(){
        clear();
    }

}