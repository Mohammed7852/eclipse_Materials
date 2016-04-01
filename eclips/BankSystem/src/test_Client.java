
public class test_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client c1 = new Client() ;
		Client  c2 = new Commercial_Client();
		
		Account a =new Account() , b= new Account();
		
		a.setAccount_number(0005);
		a.setbalance(1580);
		
		b.setAccount_number(0006);
		b.setbalance(2147);
		
		c1.setaccount(a);
		c1.setaddres("faisal");
		c1.setid(123);
		c1.setname("Mohammed Ali");
		c1.setphone(771697102);
		
		
		c2.setaccount(b);
		c2.setaddres("Dokky");
		c2.setid(789);
		c2.setname("nice Company");
		c2.setphone(02222);
		
		
		//String str = c2.toString();
		
		System.out.print(c1);
		
		
		
		
 	}

}
