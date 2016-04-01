

public class Activity {

	public static int fact(int x)
	{
		if(x<=1)return 1 ;
		return x*fact(x-1);

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.printf("%d" ,fact(5));
	}

}
