import org.junit.Test;

import static org.junit.Assert.*;

public class GridDataTest {

    @Test
    public void testAdd() throws Exception {
        GridData data = new GridData( 10 );
        assertEquals("", 10, data.getData().length );
        LocalTime currentTime = new LocalTime();

    }
}