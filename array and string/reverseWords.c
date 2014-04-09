//this algorithm is not perfect

bool reverseWords(char str[]){
	char *buffer;
	int slen, tokenReadPos, wordReadPos, wordEnd, writePos = 0;

	slen = strlen(str);
	/* Position of the last character is length -1 */
	tokenReadPos = slen -1;
	buffer = (char *) malloc(slen + 1);

	if(!buffer)
		return false;	//reverseWords failed*/
	while(tokenReadPos > 0){
		if(str[tokenReadPos] == ' '){ //non-word characters

			//write character
			buffer[writePos++] = str[tokenReadPos--];
		}else{ //word characters

			//Store position of end of word
			wordEnd = tokenReadPos;
			//scan to next non-word character
			while(tokenReadPos>=0 && str[tokenReadPos]!= ' ')
				tokenReadPos--;
			//tokenreadpos went past the start of the word
			wordReadPos = tokenReadPos +1;
			//copy the characters of the word
			while(wordReadPos<wordEnd){
				buffer[writePos++] = str[wordReadPos++];
			}

		}
	}
	//null terminate buffer and copy over str
	buffer[writePos] = '\0';
	strlcpy(str, buffer, slen+1);
	free(buffer);

	return true; 	//reverseWord sucessfully
}