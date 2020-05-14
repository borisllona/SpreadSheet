import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class SheetTest {

    @Test
    public void TestStructureSheet(){
        Sheet s = new Sheet(5);
        HashMap<String, Cell> t = s.getTable();
        Set<String> keys = t.keySet();
        //No fa res nomes es per debugar
    }
}
