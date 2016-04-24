import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Demo {

	public static void  main(String  []args){
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss").
				format(Calendar.getInstance().getTime());
	    System.out.println(timeStamp);
	}
}
