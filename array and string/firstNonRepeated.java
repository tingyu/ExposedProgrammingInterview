public static Character firstNonRepeated(String str){
	HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();
	int i, length;
	Character c;

	length = str.length();
	//scan str, building hash table
	for(i =0; i < length; i++){
		c = str.charAt(i);
		if(charHash.containsKey(c)) {
			//Increment count corresponding to c
			charHash.put(c, charHash.get(c) + 1);
		}else{
			charHash.put(c, 1);
		}
	}
	//Search hash table in order of str
	for(i = 0; i < length; i++){
		c = str.charAt(i);
		if(charHash.get(c)==1)
			return c;
	}
	return null;
}