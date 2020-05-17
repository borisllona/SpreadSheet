import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spreadsheet.SpreadSheet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static SpreadSheet.*;

public class ComplexSpreadSheetTest {
    @BeforeEach
    public void setUp() throws NotValidCellException {
        put("c1", mult("a1", "b1"));
        put("c2", mult("a2", "b2"));
        put("c3", plus("c1", "c2"));

        put("a1", 10); put("b1", 20);
        put("a2", 30); put("b2", 40);
    }

    @Test
    public void chained_expressions() throws NotValidCellException {
        assertEquals(new SomeValue(1400), get("c3"));
    }
    @Test
    public void chained_propagations() throws NotValidCellException {
        put("a1", "b1");
        assertEquals(new SomeValue(1600), get("c3"));
    }
    @AfterEach
    public void tearDown(){
        SpreadSheet.clear();
    }

}