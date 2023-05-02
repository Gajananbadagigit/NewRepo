package vTiger.Practice;

public class GenericMethodPractice {
	
	public static void main(String[] args) { // caller
		
	//add(300,20);
	int c=sub(50,10);
	System.out.println(c);
	
	}
	
	public static void add(int a, int b) // called
	{
		
		  int c = a+b; // addition is the point
		  
	}

	public static int sub(int a, int b) // called
	{
		int c = a-b; // subtraction
		return c;
	}
	
	
}
