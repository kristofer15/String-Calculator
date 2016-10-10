package stringCalc;

public class StringCalc {
	
	public static int add(String numbers) {
		int sum = 0;
		if(numbers == "")
			return sum;
		String[] splitnums = numbers.split(",|\\n");
		
		for(String s : splitnums) {
			sum += Integer.parseInt(s);
		}
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
	}

}
