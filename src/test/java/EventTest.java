import org.testng.annotations.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    public void stringConversionTest() {
        assertEquals("[E][\u2936] Test Event (at: Wed 04/12/2019 06:00 PM)", new Event("Test Event", "Wed 04/12/2019 06:00 PM").toString());
    }
}
