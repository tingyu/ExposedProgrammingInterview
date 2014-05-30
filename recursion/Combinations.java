/**
combinations of a string

ProbLem Implement a function that prints all possible combinations of the characters in a string. 
These combinations range in length from one to the length of the string. 
Two combinations that differ only in ordering of their characters are the same combination. 
In other words, “12” and “31” are different combinations from the input string “123”, but “21” is the same as “12”.
*/

public class Combinations{
	private StringBuilder out = new StringBuilder();
	private final String in;

	public Combinations(final String str){
		in = str;
	}

	public void combine(){
		combine(0);
	}

	private void combine(int start){
		for(int i = start; i < in.length; ++i){
			out.append(int.charAt(i));
			System.out.println(out);
			if(i < in.length)
				combine(i + 1);
			out.setLength(out.length() - 1);
		}
	}
}


//minor optimize
private void combine(int start){
	for(int i = start; i < in.length() - 1; ++i){
		out.append(in.charAt(i));
		System.out.println(out);
		combine(i + 1);
		out.setLength(out.length() - 1);
	}
	out.append(in.charAt(in.length() - 1));
	System.out.println(out);
	out.setLength(out.length() - 1);
}