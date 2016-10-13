package stringCalc;

public class StringCalc {
	
	/**
	 * 
	 * @param numbers: a string of numbers separated by a comma or a newline
	 * The separator can be changed by starting the input with "//[new separator]\n[numbers]. Regex operators (f.x '+') cannot be used as separators.
	 * @return result of adding numbers
	 */
	public int add(String numbers) {
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
}
