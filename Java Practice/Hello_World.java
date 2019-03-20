import java.io.IOException; //need this for exception second exception handling(?)

class Hello_World{
	//Start point of execution
	public static void main (String ...args){ //--Main Thread 
	/* string[] args are commandline arguments
	if (args[0] != null){
		System.out.println("Hello World! " +args[0]);
	}
	else{
		System.out.println("Hello World!");
	} 
	/*Doesn't like if statements on this
		System = package; out = class; =println function of out.class*/
	/*
	try{
	System.out.println("Hello World! "+args[0]);
	}
	catch(ArrayIndexOutOfBoundsException ex)
	{
		System.out.println("You are trying to read CLI args that have not been passed "+ex.getMessage());
	}
	catch(Exception ex){
		System.out.println(ex.getMessage());
	}
	//First most specific exception to most generic exception
	*/
	//---Next ---
	int result = add(args);
	System.out.println(result);
	try{
		int argslength=args.length;
		if(argslength>0)
			System.out.println("Hello World! "+args[0]);
		else	
			throw new IOException("No CLI commands"); //--Command Line Interface
	}
	catch(ArrayIndexOutOfBoundsException ex)
	{
		System.out.println("You are trying to read CLI args that have not been passed "+ex.getMessage());
	}
	catch(Exception ex){
		System.out.println(ex.getMessage());
	}
	}
	/*public static int add(int a, int b){
		return a+b;
	}
	can add more arguments. VarArgs below
	*/
	public static int add(String ...a){
		int result = 0;
		for (int i=0; i<=a.length; i++){
			result += Integer.parseInt(a[i]);
			}
		return result;
	}
}
