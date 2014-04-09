public static final int MAX_DIGITS = 10;
public static String intToStr(int num){
	int i = 0;
	boolean isNeg = false;
	//Buffer big enough for largest int and - sign
	char[] temp = new char[MAX_DIGITS + 1];
	//check to see if the number is negative
	if(num < 0){
		num = -num;
		isNeg = true;
	}

	//fill buffer with digit characters in reverse oder
	//while(num != 0){
	do{
		temp[i++] = (char)((num % 10) + '0');
		num /= 10;
	}while(num != 0)
	//}
	StringBuilder b = new StringBuilder();
	if(isNeg)
		b.append('-');

	while(i > 0){
		b.append(temp[--i]);
	}
	return b.toString();
}