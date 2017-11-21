import java.util.Scanner;
import java.lang.Math;

public class ArrayExercises {

	// Method to initialize the array

	public static void initializeArray(int[] arr, int initialValue) {
    arr[0] = initialValue;
		int j;
		for (int i=1; i < arr.length; i++) {
			j = 1;
			arr[i] = (j * (int)(Math.random()*10));
			j = 0;
		}
  }

	// Method to display the contents of the array

	public static void display(int[] myArray) {
		System.out.print("Here is your 'random' array: ");
		for (int i=0; i < myArray.length; i++) {
			System.out.print(myArray[i]);
			if (i < myArray.length-1)
					System.out.print(", ");
		}
		System.out.println();
	}

	// Method to display the array's contents in reverse

	public static void reverseDisplayArray(int[] anArray) {
        for (int i=anArray.length-1; i >= 0; i--) {
            System.out.print(anArray[i]);
            if (i > 0)
                System.out.print(", ");
        }
        System.out.println();
  }

	// Write a method that returns the maximum value in an array. Formal parameter: integer array

	public static int maxValue(int[] myArray) {
		int max = 0;
		for (int i=0; i < myArray.length; i++) {
			if (myArray[i] > max)
				max = myArray[i];
		}
		return max;
	}

	// Write a method that rearranges the contents of an array in reverse order
	//(ie. actually change the order in which the contents are stored in the array)

	public static void rearrange(int[] myArray) {
		int [] reverseArray = new int[myArray.length];
		int j=0;
		for (int i = myArray.length-1; i >= 0; i--) {
			reverseArray[j] = myArray[i];
			j++;
		}
		int m=0;
		for (int k=0; k < reverseArray.length; k++) {
			myArray[m] = reverseArray [k];
			m++;
		}
		System.out.println("Your array has now been reversed.");

	}

	// Write a method that returns the index where a particular element is found in an array.
	// Formal parameters: an integer array, an integer

	public static int elementIndex(int[] myArray, int element) {
		int index;
		int count = 0;
		for (index=0; index < myArray.length; index++) {
			if (myArray[index] == element) {
				count++;
				break;
			}
		}
		if (count == 0)
			index = -1;
		return index;
	}

	// Write a method that returns true if a particular element is found in an array

	public static boolean elementFound(int[] myArray, int element) {
		boolean elementThere = false;
		for (int i=0; i < myArray.length; i++) {
			if (myArray[i] == element) {
				elementThere = true;
				break;
			}
		}
		return elementThere;
	}

	// Write a method that returns the number of times a particular element occurs in an array

	public static int numberOfOccurrences(int[] myArray, int element) {
		int numTimes = 0;
		for (int i=0; i < myArray.length; i++) {
			if (myArray[i] == element)
				numTimes++;
		}
		return numTimes;
	}

	// Method to display the menu

	public static void displayMenu () {
		System.out.println("Now please choose from the following options:");
		System.out.println("1 - display the array");
		System.out.println("2 - max value of array");
		System.out.println("3 - display the array in reverse");
		System.out.println("4 - display a certain number's index");
		System.out.println("5 - find out if a certain number's there");
		System.out.println("6 - display the occurrences of a certain number");
		System.out.println("7 - reverse the contents of your array");
		System.out.println("8 - toggle menu");
		System.out.println("0 - exit");
	}

	// Write a main method with a menu to allow the user to choose a method

public static void main (String[] args) {

	Scanner userInput = new Scanner(System.in);

	System.out.println("Welcome to the Array Arranger.");
	System.out.print("Give me an array size: ");
	int size = userInput.nextInt();

	System.out.print("Give me an inital value: ");
	int initialVal = userInput.nextInt();

	int[] userArray = new int[size];

	initializeArray(userArray, initialVal);
	display(userArray);

	int num;
	boolean showMenu = true;
	int choice;

	do {
		if (showMenu)
			displayMenu();

		choice = userInput.nextInt();

		switch (choice) {
			case 1:
				display(userArray);
				break;
			case 2:
				System.out.println("Your max value is: " + maxValue(userArray));
				break;
			case 3:
				System.out.print("Here is your array in reverse: ");
				reverseDisplayArray(userArray);
				break;
			case 4:
				System.out.print("OK, now give me a number from 1-9 to query the array with: ");
				num = userInput.nextInt();
				System.out.println("The index where " + num + " first occurs is: " + elementIndex(userArray, num));
				break;
			case 5:
				System.out.print("OK, now give me a number from 1-9 to query the array with: ");
				num = userInput.nextInt();
				System.out.println("Has " + num + " been found?... " + elementFound(userArray, num));
				break;
			case 6:
				System.out.print("OK, now give me a number from 1-9 to query the array with: ");
				num = userInput.nextInt();
				System.out.println("The number " + num + " occurs " + numberOfOccurrences(userArray, num) + " time(s).");
				break;
			case 7:
				rearrange(userArray);
				break;
			case 8:
				showMenu = !showMenu;
				break;
			case 0:
				System.exit(0);
				break;
		}
	} while (choice >= 0 || choice < 9 );
}
}
