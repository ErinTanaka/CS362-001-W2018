package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;
import java.util.LinkedList;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
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
     * Generate Random Tests that tests TimeTable Class.
     */



	 @Test
	  public void randomtestDeleteAppt()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
		  long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		  System.out.println("Start testing... random delete appt");

			try{
		 	for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
		//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
	//making x appointments
	      int nullList=ValuesGenerator.getRandomIntBetween(random,0,1);
				TimeTable testTT= new TimeTable();
				if (nullList==0){
					LinkedList<Appt> allAppts= null;
					int startHour=ValuesGenerator.RandInt(random);
			 		int startMinute=ValuesGenerator.RandInt(random);
			 		int startDay=ValuesGenerator.getRandomIntBetween(random, -30, 60);
			 		int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
			 		int startYear=ValuesGenerator.RandInt(random);
			 		String title=ValuesGenerator.getString(random);
			 		String description=ValuesGenerator.getString(random);
			 		//Construct a new Appointment object with the initial data
			 		Appt appt = new Appt(startHour, startMinute , startDay ,startMonth ,startYear ,title,description);
					testTT.deleteAppt(allAppts, appt);
				}
				else{
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
					}

					int randToRemove=ValuesGenerator.getRandomIntBetween(random, 0, numberAppts);
					for(int i=0; i<randToRemove-1; i++){
						int randLocation=ValuesGenerator.getRandomIntBetween(random, 0, allAppts.size()-1);
						if (randLocation==randToRemove){
							testTT.deleteAppt(allAppts, null);
						}
						else{
							testTT.deleteAppt(allAppts, allAppts.get(randLocation));
						}
					}
				}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
						if((iteration%10000)==0 && iteration!=0 )
									System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

		 }
		 }catch(NullPointerException e){

		 }

			System.out.println("Done testing...");
	 }
	 @Test //(expected = DateOutOfRangeException.class)
	  public void randomtestGetApptRange()  throws Throwable  {
	 	 long startTime = Calendar.getInstance().getTimeInMillis();
	 	 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


	 	 System.out.println("Start testing... get appt range");
		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis(); //10
				 //System.out.println(" Seed:"+randomseed );
	 		 	 Random random = new Random(randomseed);
	 		 	 TimeTable testTT= new TimeTable();
			   //making two "days"
				 int gDayOne=ValuesGenerator.getRandomIntBetween(random, -30, 60);
			   int gMonthOne=ValuesGenerator.getRandomIntBetween(random, 1, 11);
			   int gYearOne=ValuesGenerator.RandInt(random);
			   int gDayTwo=ValuesGenerator.getRandomIntBetween(random, -30, 60);
			   int gMonthTwo=ValuesGenerator.getRandomIntBetween(random, 1, 11);
			   int gYearTwo=gYearOne+20;
			   GregorianCalendar calOne = new GregorianCalendar(gYearOne, gMonthOne,gDayOne);
			   GregorianCalendar calTwo = new GregorianCalendar(gYearTwo, gMonthTwo, gDayTwo);
		 	   //making random list of appointments
		 		 LinkedList<Appt> allAppts= new LinkedList<Appt>();
		 	   int numberAppts=ValuesGenerator.RandInt(random);
		 		for (int i=0; i<numberAppts; i++){
		 			int startHour=ValuesGenerator.RandInt(random);
		 			int startMinute=ValuesGenerator.RandInt(random);
		 			int startDay=ValuesGenerator.getRandomIntBetween(random, -30, 60);
		 			int startMonth=ValuesGenerator.getRandomIntBetween(random, 2, 10);
		 			int startYear=ValuesGenerator.RandInt(random);
		 			String title=ValuesGenerator.getString(random);
		 			String description=ValuesGenerator.getString(random);
		 			//Construct a new Appointment object with the initial data
		 			Appt appt = new Appt(startHour, startMinute , startDay ,startMonth ,startYear ,title,description);
		 			allAppts.add(appt);
					for (int j = 0; j < NUM_TESTS; j++) {
								String methodName = ApptRandomTest.RandomSelectMethod(random);
									  if (methodName.equals("setTitle")){
										  String newTitle=(String) ValuesGenerator.getString(random);
										  appt.setTitle(newTitle);
										}
									  else if (methodName.equals("setRecurrence")){
										   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
										   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
										   int recur=ApptRandomTest.RandomSelectRecur(random);
										   int recurIncrement = ValuesGenerator.RandInt(random);
										   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
										   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
										}
					}
					LinkedList<CalDay> testApptRange=testTT.getApptRange(allAppts, calOne, calTwo);


	 		 		elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 				 if((iteration%10000)==0 && iteration!=0 ) System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

				 }
			 }
		 }catch(NullPointerException e){

	 	}

	 	 System.out.println("Done testing...");
	 }
	 @Test (expected = DateOutOfRangeException.class)
	  public void randomtestGetApptRangeTwo()  throws Throwable  {
	 	long startTime = Calendar.getInstance().getTimeInMillis();
	 	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


	 	System.out.println("Start testing... get appt range");
	 	try{
	 		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 			long randomseed =System.currentTimeMillis(); //10
	 			//System.out.println(" Seed:"+randomseed );
	 			Random random = new Random(randomseed);
	 			TimeTable testTT= new TimeTable();
	 			//making two "days"
	 			int gDayOne=ValuesGenerator.getRandomIntBetween(random, -30, 60);
	 			int gMonthOne=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	 			int gYearOne=ValuesGenerator.RandInt(random);
	 			int gDayTwo=ValuesGenerator.getRandomIntBetween(random, -30, 60);
	 			int gMonthTwo=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	 			int gYearTwo=ValuesGenerator.RandInt(random);
	 			GregorianCalendar calOne = new GregorianCalendar(gYearOne, gMonthOne,gDayOne);
	 			GregorianCalendar calTwo = new GregorianCalendar(gYearTwo, gMonthTwo, gDayTwo);
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
	 			 for (int j = 0; j < NUM_TESTS; j++) {
	 						 String methodName = ApptRandomTest.RandomSelectMethod(random);
	 								 if (methodName.equals("setTitle")){
	 									 String newTitle=(String) ValuesGenerator.getString(random);
	 									 appt.setTitle(newTitle);
	 								 }
	 								 else if (methodName.equals("setRecurrence")){
	 										int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
	 										int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
	 										int recur=ApptRandomTest.RandomSelectRecur(random);
	 										int recurIncrement = ValuesGenerator.RandInt(random);
	 										int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
	 										appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
	 								 }
	 			 }
	 			 LinkedList<CalDay> testApptRange=testTT.getApptRange(allAppts, calOne, calTwo);


	 			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 				if((iteration%10000)==0 && iteration!=0 ) System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

	 			}
	 		}
	 	}catch(NullPointerException e){

	  }

	 	System.out.println("Done testing...");
	 }


}
