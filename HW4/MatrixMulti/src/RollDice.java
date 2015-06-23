
import java.util.Random;

public class RollDice {

	public static int rollDice(int times) {
		// function that produce a random number within the range 1-6
		// cumulate results and calculate the average
		int sum = 0;
		for (int i = 0; i <= times; i++){
			Random num = new Random();
			int DiceNum = num.nextInt(6) + 1;
			sum += DiceNum;
		}
		int avg = sum/times;
		return avg;
	}

}
