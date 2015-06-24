import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class IsOpenNowTest {
	@Test
	public void testIsOpenNow() {
		assertTrue(IsOpenNow.AisOpenNow(Calendar.MONDAY, 10, 1));
		assertFalse(IsOpenNow.AisOpenNow(Calendar.SUNDAY, 10, 1));
		
		assertTrue(IsOpenNow.BisOpenNow(Calendar.FRIDAY, 3, 3));
		
		assertFalse(IsOpenNow.CisOpenNow(Calendar.MONDAY, 12, 1));
		assertTrue(IsOpenNow.CisOpenNow(Calendar.MONDAY, 12, 3));
		
		assertFalse(IsOpenNow.DisOpenNow(Calendar.SUNDAY, 9, 4));
		assertTrue(IsOpenNow.DisOpenNow(Calendar.WEDNESDAY, 9, 4));
		
		assertTrue(IsOpenNow.EisOpenNow(Calendar.TUESDAY, 12, 1));
		assertFalse(IsOpenNow.EisOpenNow(Calendar.TUESDAY, 14, 1));

	}
}