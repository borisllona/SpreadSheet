import  Operations.*;
import Value.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpreadSheetTest {
    @BeforeEach
    public void setUpSheet(){
        put("a3", SpreadSheet.mult("a1", "a2"));
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() {
        assertFalse(get("a3").hasValue());
    }

    @Test
    public void cell_no_value_with_just_one_assignment(){
        put("a1",10);
        assertTrue(get("a1").hasValue()));
        assertFalse(get("a3").hasValue());
    }

    @Test
    void given_wrong_value_exception() throws WrongValueException{
        assertThrows(WrongValueException.class,
                () -> put("a2","Test"));
    }


    @Test
    public void recalculation_works(){
        put("a1",42);
        put("a2",20);
        assertEquals(new SomeValue(840), get("a3"));
    }
    @AfterEach
    public void clearSheet(){
        clear();
    }

}