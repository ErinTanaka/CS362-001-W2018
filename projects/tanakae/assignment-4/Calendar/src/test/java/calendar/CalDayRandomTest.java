package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import org.junit.Test;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 15 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
		public static String RandomSelectMethod(Random random){
				String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

			int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

				return methodArray[n] ; // return the method name
				}
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
		public static int RandomSelectRecur(Random random){
				int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

			int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
				return RecurArray[n] ; // return the value of the  appointments to recur
				}
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
		public static int RandomSelectRecurForEverNever(Random random){
				int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

			int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
				return RecurArray[n] ; // return appointments to recur forever or Never recur
				}
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


			System.out.println("Start testing...");


			try{
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
					//System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);
					//making two "days"
					int gDayOne=ValuesGenerator.getRandomIntBetween(random, -30, 60);
					int gMonthOne=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					int gYearOne=ValuesGenerator.RandInt(random);
					GregorianCalendar calOne = new GregorianCalendar(gYearOne, gMonthOne,gDayOne);
					CalDay validCalDay= new CalDay(calOne);
					CalDay invalidCalDay= new CalDay();
					//making random list of appointments
					LinkedList<Appt> allAppts= new LinkedList<Appt>();
					int numberAppts=ValuesGenerator.RandInt(random);
				 for (int i=0; i<numberAppts; i++){
					 int startHour=ValuesGenerator.RandInt(random);
					 int startMinute=ValuesGenerator.RandInt(random);
					 int startDay=ValuesGenerator.getRandomIntBetween(random, -30, 60);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 int startYear=ValuesGenerator.RandInt(random);
					 String title=ValuesGenerator.getString(random);
					 String description=ValuesGenerator.getString(random);
					 //Construct a new Appointment object with the initial data
					 Appt appt = new Appt(startHour, startMinute , startDay ,startMonth ,startYear ,title,description);
					 allAppts.add(appt);
					 allAppts.add(appt);

					 }
					 for(int k=0; k<allAppts.size(); k++){
						 validCalDay.addAppt(allAppts.get(k));
					 }


					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
						if((iteration%10000)==0 && iteration!=0 ) System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);


				}
			}catch(NullPointerException e){

		 }

			System.out.println("Done testing...");


	 }



}
