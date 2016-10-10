package stringCalc;

public class StringCalc {
	
	public static int add(String numbers) {
		int sum = 0;
		if(numbers == "")
			return sum;
		String[] splitnums = numbers.split(",");
		if(splitnums.length > 2)
			throw new IllegalArgumentException("Invalid input: Too many numbers to add. The function accepts 0-2 numbers");
		for(String s : splitnums) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("Next line should be 0");
		System.out.println(add(""));
		
		System.out.println("Next 2 lines should be 1 and 3");
		System.out.println(add("1"));
		System.out.println(add("3"));
		
		System.out.println("Next 3 lines should be 3, 6, 2");
		System.out.println(add("1,2"));
		System.out.println(add("3,3"));
		System.out.println(add("1,1"));
		
		try {
			System.out.println("Testing illegal argument, should throw exception");
			System.out.println(add("1,1,1"));
		}
		catch (IllegalArgumentException ex) {
			System.out.println("IllegalArgumentException caught. Exception message: ");
			System.out.println(ex.getMessage());
		}
	}

}
