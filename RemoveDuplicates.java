package week2.day2;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// To Remove Duplicates
		String text = "We learn java basics as part of java sessions in java week1";
		int count = 1, i = 0, j = 0;
		String[] word = text.split(" ");
		for (i = 0; i < word.length; i++) {
			for (j = i + 1; j < word.length; j++) {
				if (word[i].equals(word[j])) {
					count = count + 1;
					word[j] = "";
				}

			}
			System.out.print(word[i]);
			System.out.print(" ");
		}

	}
}
