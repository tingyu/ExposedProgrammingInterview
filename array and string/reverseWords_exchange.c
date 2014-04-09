void wcReverseWords(wchar_t str[]){
	int start = 0, end = 0, length;
	length = wcslen(str);

	//reverse the entire string
	wcReverseString(str, start, length - 1);
	while(end < length){
		if(str[end] != L''){ //skip non-word characters
			//save position of beginning of the word
			start = end;
			//scan to next non-word character
			while(end < length && str[end]!=L'')
				end++;
			//back up to end of word
			end--;
			//reverse word
			wcReverseString(str, start, end);
		}
	}
}

void wcReverseString(wchar_t str[], int start, int end){
	wchar_t temp;
	while(end > start){
		//exchange characters
		tmp = str[start]
		str[start] = str[end];
		str[end] = temp;
		//move indices towards middle
		start++;end--;
	}
}