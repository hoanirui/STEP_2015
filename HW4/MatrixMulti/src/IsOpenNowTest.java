import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class IsOpenNowTest {
	@Test
	public void testIsOpenNow() {
		assertFalse(IsOpenNow.isOpenNow(Calendar.MONDAY, 8));
		assertTrue(IsOpenNow.isOpenNow(Calendar.MONDAY, 9));

	}
}