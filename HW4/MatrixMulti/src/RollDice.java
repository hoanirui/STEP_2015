
import java.util.Random;

public class RollDice {

	public static double rollDice() {
		// function that produce a random number within the range 1-6
		Random num = new Random();
		double DiceNum = num.nextInt(6) + 1;
		return DiceNum;
	

	}
	
	public static double DiceAve(int times){
		// cumulate results and calculate the average
		double sum = 0;
		for (int i = 0; i <= times; i++){
			sum += RollDice.rollDice();
		}
		double avg = sum/times;
		return avg;
	}
	
	public static double OddEven(){
		// addition of 2 times of rolling dices
		double s = (RollDice.DiceAve(2) * 2);
		return s;
		
	}
	
	

}
