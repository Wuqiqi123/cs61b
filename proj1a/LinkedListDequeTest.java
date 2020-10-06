/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	
	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	public static boolean checkValue(int expected, int actual) {
		if (expected != actual) {
			System.out.println("get() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
		ArrayDeque<String> ad1 = new ArrayDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		ad1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && checkSize(1, ad1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && checkEmpty(false, ad1.isEmpty()) && passed;

		lld1.addLast("middle");
		ad1.addLast("middle");
		passed = checkSize(2, lld1.size()) && checkSize(2, ad1.size()) && passed;

		lld1.addLast("back");
		ad1.addLast("back");
		passed = checkSize(3, lld1.size())  && checkSize(3, ad1.size())&& passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();
		ad1.printDeque();
		printTestStatus(passed);
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		ad1.addFirst(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && checkEmpty(false, ad1.isEmpty())&& passed;

		lld1.removeFirst();
		ad1.removeFirst();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty())  && checkEmpty(true, ad1.isEmpty())&& passed;

		printTestStatus(passed);

	}

	public static void copyTest() {
		System.out.println("Running get copy.");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addLast(10);
		ad1.addLast(10);

		lld1.addLast(20);
		ad1.addLast(20);
		// should be empty
		lld1.addLast(30);
		ad1.addLast(30);

		LinkedListDeque<Integer> lld2 = new LinkedListDeque<Integer>(lld1);
		ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>(ad1);
		lld2.printDeque();
		ad2.printDeque();

		passed = checkValue(lld2.get(0), 10) && checkValue(ad2.get(0), 10) && passed;
		passed = checkValue(lld2.get(1), 20) && checkValue(ad2.get(1), 20) && passed;
		passed = checkValue(lld2.get(2), 30) && checkValue(ad2.get(2), 30) && passed;

		passed = checkValue(lld2.getRecursive(0), 10) && passed;
		passed = checkValue(lld2.getRecursive(1), 20) && passed;
		passed = checkValue(lld2.getRecursive(2), 30) && passed;

		printTestStatus(passed);

	}

	public static void getTest() {

		System.out.println("Running get test.");

		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addLast(10);
		ad1.addLast(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && checkEmpty(false, ad1.isEmpty()) && passed;

		lld1.addLast(20);
		ad1.addLast(20);
		// should be empty
		lld1.addLast(30);
		ad1.addLast(30);

		lld1.printDeque();
		ad1.printDeque();

		passed = checkValue(lld1.get(0), 10) && checkValue(ad1.get(0), 10) && passed;
		passed = checkValue(lld1.get(1), 20) && checkValue(ad1.get(1), 20) && passed;
		passed = checkValue(lld1.get(2), 30) && checkValue(ad1.get(2), 30) && passed;

		passed = checkValue(lld1.getRecursive(0), 10) && passed;
		passed = checkValue(lld1.getRecursive(1), 20) && passed;
		passed = checkValue(lld1.getRecursive(2), 30) && passed;

		printTestStatus(passed);

	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		getTest();
	}
} 