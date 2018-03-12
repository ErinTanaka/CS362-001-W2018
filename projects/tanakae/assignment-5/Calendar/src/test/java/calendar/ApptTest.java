package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";

		 int[] checkRecur = new int[0];

		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 //assertEquals(checkRecur[0],appt.getRecurNumber());
		 assertEquals(2,appt.getRecurBy());
		 //assertEquals(0,appt.getRecurDays());
		 assertEquals(0,appt.getRecurIncrement());
	 }

	 @Test
	  public void test02()  throws Throwable  { //tests for setters
		 //setters
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(21, 30 , 15 , 01 , 2018 , "Birthday Party", "This is my birthday party.");
	 	 appt.setStartHour(23);
		 assertEquals(23, appt.getStartHour());
		 //public void set start min
		 appt.setStartMinute(45);
		 assertEquals(45, appt.getStartMinute());
		 //start day
		 appt.setStartDay(20);
		 assertEquals(20, appt.getStartDay());
		 //start month
		 appt.setStartMonth(03);
		 assertEquals(03, appt.getStartMonth());
		 //start year
		 appt.setStartYear(2020);
		 assertEquals(2020, appt.getStartYear());
		 //title
		 appt.setTitle(null);
		 assertEquals("", appt.getTitle());
		 appt.setDescription(null);
		 assertEquals("", appt.getDescription());
	 }
	 @ Test
		public void test03() throws Throwable{
	 	//tests for getters
		 Appt appt = new Appt(21, 30 , 15 , 01 , 2018 , "Birthday Party", "This is my birthday party.");
		 //appt.setStartHour(23);
	 	int testvar;
	 	String testString;
	 	//startHour
	 	testvar=appt.getStartHour();
	 	assertEquals(21, testvar);
		 //startminute
		 testvar=appt.getStartMinute();
		 assertEquals(30, testvar);
		 //startDay
		 testvar=appt.getStartDay();
		 assertEquals(15, testvar);
		 //startMonth
		 testvar=appt.getStartMonth();
		 assertEquals(01, testvar);
		 //startYear
		 testvar=appt.getStartYear();
		 assertEquals(2018, testvar);
		 //title
		 testString=appt.getTitle();
		 assertEquals("Birthday Party", testString);
		 //description
		 testString=appt.getDescription();
		 assertEquals("This is my birthday party.", testString);

		 boolean testValid;
		 testValid=appt.getValid();
		 assertTrue(testValid);
	 }
	 @ Test
	 	public void test04() throws Throwable{
		 Appt appt = new Appt(21, 30 , 15 , 01 , 2018 , "Therapy", "I need this shit.");
		 boolean recurs=appt.isRecurring();
		 assertFalse(recurs);
		 int[] days=new int[] {3, 5};
		 int recurBy=1;
		 int recurIncrement=1;
		 int recurNumber=50;
		 appt.setRecurrence(days, recurBy, recurIncrement, recurNumber);
		 //getters
		 assertEquals(50, appt.getRecurNumber());
		 assertEquals(1, appt.getRecurBy());
		 assertEquals(days, appt.getRecurDays());
		 assertEquals(1, appt.getRecurIncrement());
		 recurs=appt.isRecurring();
		 assertTrue(recurs);
		 Appt apptB = new Appt(21, 30 , 15 , 01 , 2018 , "Birthday Party", "This is my birthday party.");
		 apptB.setRecurrence(null, 1, 1, 50);


	 }
	 @ Test   //various invalid info for isValid
		public void test05() throws Throwable{
		 Appt appt = new Appt(21, 30 , 15 , 01 , 2018 , "Therapy", "I need this shit.");

		 appt.setStartHour(27);
		 assertFalse(appt.getValid());
		 appt.setStartHour(-5);
		 assertFalse(appt.getValid());
		 appt.setStartHour(0);
		 assertTrue(appt.getValid());
		 appt.setStartHour(23);
		 assertTrue(appt.getValid());

		 appt.setStartHour(21);
		 assertTrue(appt.getValid());


		 appt.setStartMinute(500);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(-5);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(0);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(59);
		 assertTrue(appt.getValid());

		 appt.setStartMinute(30);
		 assertTrue(appt.getValid());


		 appt.setStartDay(45);
		 assertFalse(appt.getValid());
		 appt.setStartDay(-5);
		 assertFalse(appt.getValid());
		 appt.setStartDay(1);
		 assertTrue(appt.getValid());
		 appt.setStartDay(31);
		 assertTrue(appt.getValid());

 		 appt.setStartDay(15);
		 assertTrue(appt.getValid());

		 appt.setStartMonth(1);
		 assertTrue(appt.getValid());
		 appt.setStartMonth(12);
		 assertTrue(appt.getValid());
		 //appt.setStartMonth(15);
		 //assertFalse(appt.getValid());
		 //appt.setStartYear(-99999999);
 		 //assertFalse(appt.getValid());

	 }
	@ Test // toString
		public void test06() throws Throwable{
		Appt appt = new Appt(40, 30 , 15 , 01 , 2018 , "Therapy", "I need this shit.");
		String str=appt.toString();
		assertEquals(null, str);

		appt.setStartHour(11);
		str=appt.toString();
		assertEquals("	1/15/2018 at 11:30am ,Therapy, I need this shit.\n", str);

		appt.setStartHour(12);
		str=appt.toString();
		assertEquals("	1/15/2018 at 12:30pm ,Therapy, I need this shit.\n", str);

		appt.setStartHour(21);
		str=appt.toString();
		assertEquals("	1/15/2018 at 9:30pm ,Therapy, I need this shit.\n", str);
	}
//add more unit tests as you needed
	@ Test //compareto
		public void test07() throws Throwable{
		Appt apptA = new Appt(21, 30 , 15 , 01 , 2018 , "Therapy", "I need this shit.");
		Appt apptB = new Appt(7, 30 , 15 , 01 , 2018 , "Homework", "Wow, productivity.");
    int cmp=apptA.compareTo(apptB);
    assertEquals(14, cmp);
		apptA.setStartHour(7);

		apptA.setStartMinute(35);
		assertEquals(5, apptA.compareTo(apptB));
		apptA.setStartMinute(30);

		apptA.setStartDay(10);
		assertEquals(-5, apptA.compareTo(apptB));
		apptA.setStartDay(15);

		apptA.setStartMonth(02);
		assertEquals(1, apptA.compareTo(apptB));
		apptA.setStartMonth(01);

		apptA.setStartYear(2020);
		assertEquals(2, apptA.compareTo(apptB));

	}
	@ Test (expected = ArrayIndexOutOfBoundsException.class)
	public void test08() throws Throwable{
		Appt appt = new Appt(21, 30 , 15 , 01 , 2018 , "Therapy", "I need this shit.");

			appt.setStartMonth(-1);
			assertFalse(appt.getValid());

	}
	@ Test (expected = ArrayIndexOutOfBoundsException.class)
	public void test09() throws Throwable{
		Appt apptB = new Appt(21, 30 , 1 , 17 , 2018 , "Therapy", "I need this shit.");
		assertFalse(apptB.getValid());
		apptB.setStartMonth(01);
		//apptB.setStartYear(2018);
		assertTrue(apptB.getValid());

	}

}
