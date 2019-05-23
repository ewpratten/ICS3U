/**
* My PrintF
* By: Evan Pratten
*/

public class MyPrintF {

  // Display value
	static int xx = 4422;
	
	public static void main(String[] args) {
		System.out.printf("| 12345678 |\n");
		System.out.printf("| ======== |\n");
		System.out.printf("| %8d |%n", xx);
		System.out.printf("| %08d |%n", xx);
		System.out.printf("| %+8d |%n", xx);
		System.out.printf("| %-8d |%n", xx);
		System.out.printf("| %8.1f |%n", (double)xx);

	}

}
