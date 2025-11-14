package genericutility;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public String getSystemDataYYYYMMDD() {
		Date DATE=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(DATE);
		return date;
	}
	
	public String getRequiredDate() {
		Date DATE=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		sdf.format(DATE);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String Reqdate = sdf.format(cal.getTime());
		return Reqdate;
	}
	
	public int getRandomNumber() {
		Random Rnum=new Random();
		int randomNUM = Rnum.nextInt(5000);
		return randomNUM;
	}
	
	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}

}
