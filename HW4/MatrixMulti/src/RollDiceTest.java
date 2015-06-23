import static org.junit.Assert.*;

import org.junit.Test;


public class RollDiceTest {

	// idea1: call the function rollDice many times(1000, 10000)
	// make sure the probability of each is around 1/6 within small range
	// idea2: test average for rolling dice many times 
	// compare to theoretical average
	
	@Test
	public void testFairness() {
		assertEquals(350, RollDice.rollDice(1000), 50);
	}

}
