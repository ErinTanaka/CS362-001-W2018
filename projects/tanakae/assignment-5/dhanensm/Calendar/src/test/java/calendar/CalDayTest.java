package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
	 	//default constructor
	 	CalDay invalidDay = new CalDay();
	 	assertFalse(invalidDay.isValid());
	 	//constructor
	 	GregorianCalendar cal=new GregorianCalendar();
	 	CalDay gregDay = new CalDay(cal);
	 	assertTrue(gregDay.isValid());
	 	assertEquals(cal.get(cal.DAY_OF_MONTH), gregDay.getDay());
	 	assertEquals(cal.get(cal.MONTH), gregDay.getMonth());
	 	assertEquals(cal.get(cal.YEAR), gregDay.getYear());
		assertEquals(0, gregDay.getSizeAppts());

	 }
	 @Test
	  public void test02()  throws Throwable  {		 //addAppt

		 GregorianCalendar cal=new GregorianCalendar();
		 CalDay day = new CalDay(cal);
		 int date=cal.get(cal.DAY_OF_MONTH);
		 int month=cal.get(cal.MONTH);
		 Appt appt1 = new Appt(15, 30 , date, 01, 2018 , "Therapy", "I need this shit.");
		 day.addAppt(appt1);
		 assertEquals(1, day.getSizeAppts());
		 Appt appt2 = new Appt(18, 30 , date, 01, 2018 , "Yoga", "Ommmmmmmmm.");
		 day.addAppt(appt2);
		 assertEquals(2, day.getSizeAppts());
		 Appt appt3 = new Appt(18, 500 , 70, 01, 2018 , "Groceries", "Yummmmmmmmm.");
		 day.addAppt(appt3);
		 assertEquals(2, day.getSizeAppts());


	 }
	@Test
	public void test03()  throws Throwable  {
		GregorianCalendar cal=new GregorianCalendar();
		CalDay day = new CalDay(cal);
		int apptDay=cal.get(cal.DAY_OF_MONTH);
		Appt appt1 = new Appt(15, 30 , apptDay, 01, 2018 , "Therapy", "I need this shit.");

		//getters
		int dateDay=day.getDay();
		assertEquals(apptDay, dateDay);
		int dateMonth=day.getMonth();
		assertEquals(01, dateMonth);
		int dateYear=day.getYear();
		assertEquals(2018, dateYear);

		//not technically a getter but testing it here anyways
		boolean valid=day.isValid();
		assertTrue(valid);


		int checkSize=day.getSizeAppts();
		assertEquals(0, checkSize);
		day.addAppt(appt1);
		checkSize=day.getSizeAppts();
		assertEquals(1, checkSize);


	}
	@ Test
		public void test04() throws Throwable{
	 	CalDay invalidDay= new CalDay();
		String date=invalidDay.toString();
		String cmp="";
		//assertEquals(cmp, date);

		GregorianCalendar cal=new GregorianCalendar();
		CalDay validDay = new CalDay(cal);
		date=validDay.toString();
		cmp="\t --- "+validDay.getMonth()+"/"+validDay.getDay()+"/"+validDay.getYear()+" --- \n"+" --- -------- Appointments ------------ --- \n\n";
		//assertEquals(cmp, date);

		Appt appt=new Appt(21, 30 , validDay.getDay(), 01, 2018 , "Therapy", "I need this shit.");
		validDay.addAppt(appt);
		date=validDay.toString();
		cmp="\t --- "+validDay.getMonth()+"/"+validDay.getDay()+"/"+validDay.getYear()+" --- \n"+" --- -------- Appointments ------------ --- \n\n"+"	1/15/2018 at 9:30pm ,Therapy, I need this shit.\n";
		assertEquals(cmp, date);
	}
	@ Test
		public void test05() throws Throwable{
		GregorianCalendar cal=new GregorianCalendar();
		CalDay validDay = new CalDay(cal);
		int date=cal.get(cal.DAY_OF_MONTH);
		Appt appt1 = new Appt(15, 30 , date, 01, 2018 , "Therapy", "I need this shit.");
		validDay.addAppt(appt1);
		Appt appt2 = new Appt(18, 30 , date, 01, 2018 , "Yoga", "Ommmmmmmmm.");
		validDay.addAppt(appt2);
		Appt appt3 = new Appt(-4, 30 , date, 01, 2018 , "Groceries", "Yummmmmmmmm.");
		validDay.addAppt(appt3);

		CalDay invalidDay=new CalDay();
		assertEquals(null, invalidDay.iterator());
		Iterator i=validDay.iterator();
		int count=1;
		while(i.hasNext()){
			count++;
			Object element=i.next();
		}
		assertEquals(3, count);
		//valid iterator test here
	}
	@ Test
		public void test06() throws Throwable{
			GregorianCalendar cal=new GregorianCalendar();
			CalDay validDay = new CalDay(cal);
			int date=cal.get(cal.DAY_OF_MONTH);
			Appt appt1 = new Appt(15, 30 , date, 01, 2018 , "Therapy", "I need this shit.");
			validDay.addAppt(appt1);
			Appt appt2 = new Appt(18, 30 , date, 01, 2018 , "Yoga", "Ommmmmmmmm.");
			validDay.addAppt(appt2);
			Appt appt3 = new Appt(18, 30 , date, 01, 2018 , "Groceries", "Yummmmmmmmm.");
			validDay.addAppt(appt3);
			Appt appt4 = new Appt(16, 30 , date, 01, 2018 , "Nap", "Zzzzzz.");
			validDay.addAppt(appt4);
			assertEquals(appt1, validDay.getAppts().get(0));
			assertEquals(appt4, validDay.getAppts().get(1));
			assertEquals(appt2, validDay.getAppts().get(2));
			assertEquals(appt3, validDay.getAppts().get(3));

		}
//add more unit tests as you needed
}
