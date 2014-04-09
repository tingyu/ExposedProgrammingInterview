public static String removeChars(String str, String remove){
	char[] s = str.toCharArray();
	char[] r = remove.toCharArray();
	int src, dst = 0;

	//flags automatically initialized to false, size of 128 assumes ASCII
	boolean[] flags = new boolean[128];

	//Set flags for characters to be removed
	for(src = 0; src < r.length; ++src){
		flags[r[src]] = true;
	}

	//Now loop through all the characters,
	//copying only if they aren't flagged
	for(src = 0; src < s.length; ++src){
		if(!flags[s[src]]){
			s[dst++] = s[src];
		}
	}
	return new String(s, 0, dst);
}