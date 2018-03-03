package calendar;

import java.util.Calendar;
import java.util.Random;
//import java.util.LinkedList;
import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
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
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		//try{
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 //Construct a new Appointment object with the initial data
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
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

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		//}catch(NullPointerException e){

		//}

		 System.out.println("Done testing...");
	 }
	 @Test
	  public void randomtestHour()  throws Throwable  {

	 	long startTime = Calendar.getInstance().getTimeInMillis();
	 	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


	 	System.out.println("Start testing...");

	  try{
	 	 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 		 long randomseed =System.currentTimeMillis(); //10
	 //			System.out.println(" Seed:"+randomseed );
	 		 Random random = new Random(randomseed);

	 			int startHour=ValuesGenerator.getRandomIntBetween(random, -10, 30);
	 			int startMinute=ValuesGenerator.RandInt(random);
	 			int startDay=ValuesGenerator.RandInt(random);
	 			int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	 			int startYear=ValuesGenerator.RandInt(random);
	 			String title="Birthday Party";
	 			String description="This is my birthday party.";
	 			//Construct a new Appointment object with the initial data
	 			Appt appt = new Appt(startHour,
	 							 startMinute ,
	 							 startDay ,
	 							 startMonth ,
	 							 startYear ,
	 							 title,
	 							description);
	 		 if(!appt.getValid())continue;
	 	  for (int i = 0; i < NUM_TESTS; i++) {
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

	 			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 			 		 if((iteration%10000)==0 && iteration!=0 )
	 			 					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

	 	 }
	  }catch(NullPointerException e){

	  }

	 	System.out.println("Done testing...");
	 }
	 @Test
	  public void randomtestMinute()  throws Throwable  {

	  long startTime = Calendar.getInstance().getTimeInMillis();
	  long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


	  System.out.println("Start testing...");

	  try{
	 	for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 		long randomseed =System.currentTimeMillis(); //10
	 //			System.out.println(" Seed:"+randomseed );
	 		Random random = new Random(randomseed);

	 		 int startHour=ValuesGenerator.RandInt(random);
	 		 int startMinute=ValuesGenerator.getRandomIntBetween(random, -60, 120);
	 		 int startDay=ValuesGenerator.RandInt(random);
	 		 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	 		 int startYear=ValuesGenerator.RandInt(random);
	 		 String title="Birthday Party";
	 		 String description="This is my birthday party.";
	 		 //Construct a new Appointment object with the initial data
	 		 Appt appt = new Appt(startHour,
	 							startMinute ,
	 							startDay ,
	 							startMonth ,
	 							startYear ,
	 							title,
	 						 description);
	 		if(!appt.getValid())continue;
	 	 for (int i = 0; i < NUM_TESTS; i++) {
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

	 			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 					if((iteration%10000)==0 && iteration!=0 )
	 								System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

	 	}
	  }catch(NullPointerException e){

	  }

	  System.out.println("Done testing...");
	 }
	 @Test
	  public void randomtestDay()  throws Throwable  {

	  long startTime = Calendar.getInstance().getTimeInMillis();
	  long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


	  System.out.println("Start testing...");

	  try{
	  for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 	 long randomseed =System.currentTimeMillis(); //10
	 //			System.out.println(" Seed:"+randomseed );
	 	 Random random = new Random(randomseed);

	 		int startHour=ValuesGenerator.RandInt(random);
	 		int startMinute=ValuesGenerator.RandInt(random);
	 		int startDay=ValuesGenerator.getRandomIntBetween(random, -30, 60);
	 		int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	 		int startYear=ValuesGenerator.RandInt(random);
	 		String title="Birthday Party";
	 		String description="This is my birthday party.";
	 		//Construct a new Appointment object with the initial data
	 		Appt appt = new Appt(startHour,
	 						 startMinute ,
	 						 startDay ,
	 						 startMonth ,
	 						 startYear ,
	 						 title,
	 						description);
	 	 if(!appt.getValid())continue;
	 	for (int i = 0; i < NUM_TESTS; i++) {
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

	 		 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 				 if((iteration%10000)==0 && iteration!=0 )
	 							 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

	  }
	  }catch(NullPointerException e){

	  }

	  System.out.println("Done testing...");
	 }

	 // @Test (expected = ArrayIndexOutOfBoundsException.class)
		// public void randomtestMonth()  throws Throwable  {
   //
		// long startTime = Calendar.getInstance().getTimeInMillis();
		// long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
   //
   //
		// System.out.println("Start testing...");
   //
		// try{
		// for (int iteration = 0; elapsed < TestTimeout; iteration++) {
		//  // long randomseed =System.currentTimeMillis(); //10
		//  // Random random = new Random(randomseed);
		//  // System.out.println("setting shit");
		// 	// int startHour=ValuesGenerator.RandInt(random);
		// 	// int startMinute=ValuesGenerator.RandInt(random);
		// 	// int startDay=ValuesGenerator.RandInt(random);
		// 	// int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
		// 	// int startYear=ValuesGenerator.RandInt(random);
		// 	// String title="Birthday Party";
		// 	// String description="This is my birthday party.";
		// 	// //Construct a new Appointment object with the initial data
		// 	// Appt appt = new Appt(startHour,startMinute ,startDay ,startMonth , startYear ,title, description);
		//  // if(!appt.getValid())continue;
		//  // 		 System.out.println("appt made");
   //   //
		//  // //int badMonth=ValuesGenerator.getRandomIntBetween(random, -10, 20);
		//  // appt.setStartMonth(-5);
   //   // System.out.println("badmonth set");
   //   // assertFalse(appt.getValid());
		//  // //if(!appt.getValid())continue;
   //   Appt appt = new Appt(21, 30 , 15 , 01 , 2018 , "Therapy", "I need this shit.");
   //
   //   			appt.setStartMonth(-1);
   //   			assertFalse(appt.getValid());
   //   System.out.println("continuing");
		// 	 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
		// 			 if((iteration%10000)==0 && iteration!=0 )
		// 						 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
   //
		// }
		// }catch(NullPointerException e){
   //
		// }
   //
		// System.out.println("Done testing...");
	 // }
	 @Test
	  public void randomtestRecurr()  throws Throwable  {

	  long startTime = Calendar.getInstance().getTimeInMillis();
	  long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


	  System.out.println("Start testing...");

	  try{
	  for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 	 long randomseed =System.currentTimeMillis(); //10
	 //			System.out.println(" Seed:"+randomseed );
	 	 Random random = new Random(randomseed);

	 		int startHour=ValuesGenerator.RandInt(random);
	 		int startMinute=ValuesGenerator.RandInt(random);
	 		int startDay=ValuesGenerator.getRandomIntBetween(random, -30, 60);
	 		int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	 		int startYear=ValuesGenerator.RandInt(random);
	 		String title="Birthday Party";
	 		String description="This is my birthday party.";
	 		//Construct a new Appointment object with the initial data
	 		Appt appt = new Appt(startHour,
	 						 startMinute ,
	 						 startDay ,
	 						 startMonth ,
	 						 startYear ,
	 						 title,
	 						description);
	 	 if(!appt.getValid())continue;
	 	for (int i = 0; i < NUM_TESTS; i++) {
	 		 String methodName = ApptRandomTest.RandomSelectMethod(random);
	 				if (methodName.equals("setTitle")){
	 					String newTitle=(String) ValuesGenerator.getString(random);
	 					appt.setTitle(newTitle);
	 			 }
	 				else if (methodName.equals("setRecurrence")){
	 					int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
	 					int[] recurDays=null;
	 					int recur=ApptRandomTest.RandomSelectRecur(random);
	 					int recurIncrement = ValuesGenerator.RandInt(random);
	 					int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
	 					appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
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


}
