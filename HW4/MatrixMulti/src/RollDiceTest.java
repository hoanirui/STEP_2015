import static org.junit.Assert.*;
import java.math.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;


public class RollDiceTest {

	// idea1: call the function rollDice many times(1000, 10000)
	// compare to theoretical average
	// idea2: test 
	
	@Test
	public void testFairness() {
		assertEquals(3.5, RollDice.DiceAve(1000), 0.5);
		assertEquals(3.5, RollDice.DiceAve(10000), 0.5);
	}
	
	@Test
	public void testOddEven(){
		List<Double> sumTwo = new ArrayList<Double>();
		for(int i = 0; i <= 100; i++){
			sumTwo.add(RollDice.OddEven());
		}
		int odd = 0;
		int even = 0;
		for(Double nums: sumTwo){
			if((nums % 2) != 0 ){
				odd += 1;
			}else{
				even += 1;
			}
		}
		assertEquals(1.0, odd/even, 0.1);
	}

}
