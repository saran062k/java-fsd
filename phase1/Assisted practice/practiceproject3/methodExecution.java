package practiceproject3;

public class methodExecution {

public int additionnumbers(int a,int b) {
	int z=a+b;
	return z;
}

public static void main(String[] args) {

	methodExecution b=new methodExecution();
	int ans= b.additionnumbers(10,3);
	System.out.println("addition is :"+ans);
	}
}

