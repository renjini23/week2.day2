package week2.day2;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		// To find the sum of digits from string - "Tes12Le79af65"
		String text = "Tes12Le79af65";
		int sum = 0;
		String replaced = text.replaceAll("\\D", "");
		char[] arr = replaced.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			int num = Character.getNumericValue(arr[i]);
			sum = sum + num;

		}
		System.out.println("Sum of digits in string is:-" + sum);
	}

}
