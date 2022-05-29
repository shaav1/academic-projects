package edu.qc.seclass;



public class MyCustomString implements MyCustomStringInterface{
	
	String currentString;

	@Override
	public String getString() {
		// TODO Auto-generated method stub
		return currentString;
	}

	@Override
	public void setString(String string) {
		// TODO Auto-generated method stub
		this.currentString=string;
	}

	@Override
	public int countNumbers() {
		// TODO Auto-generated method stub
		
		int count=0;//counts the number of numbers 
		boolean lastNumber= false; //checks to see if the previous character was a number 
		char c;
		
		if(currentString == null) {
			throw new NullPointerException("This string is null");
		}
		
		
		for(int i=0; i<currentString.length();i++) {
			c=currentString.charAt(i);
			if(Character.isDigit(c)&& lastNumber==false) {
				count++;
				lastNumber = true;
			}
			else {
				if(!Character.isDigit(c)&& lastNumber==true) {
				lastNumber=false;
				}
			}
		}
		
		return count;
	}

	@Override
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
		// TODO Auto-generated method stub
		
		StringBuilder temp = new StringBuilder();
		char c;
		
		if(currentString.length()==0 || currentString.length()<n) {//if the string is empty or has less than n characters
			return "";
		}
		
		else if(n<=0) {//If "n" less than or equal to zero
			throw new IllegalArgumentException("Error");
		}
		
		else if(currentString==null && n>0) {//If the current string is null and "n" is greater than zero
			throw new NullPointerException("Error");
		}
		
		if(startFromEnd==false) {//checks the start position, if it starts from the beginning 
			for(int i=n-1; i< currentString.length();i+=n) {
				c=currentString.charAt(i);
				temp.append(c);
			}
		}
		else if(startFromEnd==true) {//if you start from the end
			for(int i=currentString.length()-n; i>=0; i-=n) {
				c=currentString.charAt(i);
				temp.append(c);

			}
			temp.reverse();//to show the order in which they appear in the string when starting from the end
			
		}
		
		String str = temp.toString();
		
		return str;
	}

	@Override
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
		// TODO Auto-generated method stub
		
		if(startPosition > endPosition) {
			throw new IllegalArgumentException("illegal argument");
		}
		
		else if(startPosition <= endPosition && (startPosition<1 || endPosition> currentString.length())) {
			throw new MyIndexOutOfBoundsException("error");
		}
		
		else if(startPosition <= endPosition&& startPosition >0  && currentString==null) {
			throw new NullPointerException("Null pointer");
		}
		
		String [] numbers = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};//store all the number names 

		
		StringBuilder str = new StringBuilder(currentString.substring(0,startPosition-1));
		
		char c;
		
		for(int i=startPosition-1; i<endPosition; i++) {
			c=currentString.charAt(i);
			if(Character.isDigit(c)) {//if c is a digit then set a to its number value
				int a=Integer.parseInt(String.valueOf(c)); 
				str.append(numbers[a]);
			}
			else {
				str.append(c);
			}
		}
		
			str.append(currentString.substring(endPosition));//add the rest of the string 
		
		
		currentString= str.toString();		
		
	}

}
