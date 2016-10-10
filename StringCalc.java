package stringCalc;

public class StringCalc {
	
	/**
	 * 
	 * @param numbers: a string of numbers separated by a comma or a newline
	 * The separator can be changed by starting the input with "//[new separator]\n[numbers]. Regex operators (f.x '+') cannot be used as separators.
	 * @return result of adding numbers
	 */
	public static int add(String numbers) {
		int sum = 0;
		String negatives = "";
		if(numbers == "")
			return sum;
		
		
		String delimiter = "";
		
		// If the input starts with "//", anything up to the next newline will be used as a delimiter instead
		if(numbers.startsWith("//")) {
			int i = numbers.indexOf("\n");
			delimiter = numbers.substring(2, i);
			numbers = numbers.substring(i+1);
		}
		else
			delimiter = ",|\\n";
		

		//Split the input string on commas or newlines into an array of strings
		String[] splitnums = numbers.split(delimiter);
		for(String s : splitnums) {
			if(s.contains("-")) {
				if(!negatives.isEmpty())
					negatives += ",";	//add a comma before all but the first number
				negatives += s;
				continue;	//Skip the rest of this loop
			}
			
			// Convert string to integer
			int num = Integer.parseInt(s);	
			if(num > 1000)
				continue;	//Don't add numbers above 1000 to the sum
				
			sum += num;
		}
		if(!negatives.isEmpty())
			throw new IllegalArgumentException("Negatives not allowed: " + negatives);
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("Testing ',' and '\\n' as seperators. Next line should be 6");
		System.out.println(add("1\n2,3"));
		
		System.out.println("Next line should be 0");
		System.out.println(add(""));
		
		System.out.println("Next 2 lines should be 1 and 3");
		System.out.println(add("1"));
		System.out.println(add("3"));
		
		System.out.println("Next 3 lines should be 3, 6, 2");
		System.out.println(add("1,2"));
		System.out.println(add("3,3"));
		System.out.println(add("1,1"));
		
		System.out.println("Testing add function on 4 numbers. Next two lines should be 4");
		System.out.println(add("1,1,1,1"));
		System.out.println(add("1\n1\n1\n1"));
		
		try {
			System.out.println("Testing illegal input containing negatives, should throw an exception.");
			System.out.println(add("2,-4,3,-5"));
		}
		catch (IllegalArgumentException ex) {
			System.out.println("IllegalArgumentException caught. Message is: " + ex.getMessage());
		}
		
		System.out.println();
		System.out.println("Checking if numbers greater than 1000 are ignored. Next line should be 1000");
		System.out.println(add("1000\n1001"));
		
		System.out.println("Checking if delimiter can be changed. Next two lines should be 20");
		System.out.println(add("//;\n5;5;5;5"));
		System.out.println(add("//z\n5z5z5z5"));
	}

}
