import Operations.*;
import Value.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static spreadsheet.SpreadSheet.*;
import java.util.HashMap;
import java.util.Set;


import static org.junit.Assert.assertEquals;
public class SpreadSheetTest {
    @BeforeEach
    public void setUpSheet(){

        put("a3", mult("a1", "a2"));
    }

    @Test
    public void recalculation_works(){
        put("a1", 42);
        put("a2", 20);
        assertEquals(new SomeValue(840), get("a3"));
    }
}
