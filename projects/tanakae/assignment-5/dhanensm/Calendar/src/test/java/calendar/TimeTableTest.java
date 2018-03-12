package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test (expected = DateOutOfRangeException.class)
	  public void test01()  throws Throwable  {
	    //wow none of this actually works because of my bug
	 	GregorianCalendar calOne=new GregorianCalendar(2018, 0, 10);
	 	CalDay dayOne= new CalDay(calOne);
	 	GregorianCalendar calTwo=new GregorianCalendar(2018, 1, 11);
	 	CalDay dayTwo= new CalDay(calTwo);
	 	GregorianCalendar calThree=new GregorianCalendar(2018, 2, 12);
	 	CalDay dayThree= new CalDay(calThree);
	 	GregorianCalendar calFour=new GregorianCalendar(2020, 2, 12);
	 	CalDay dayFour= new CalDay(calFour);

	 	LinkedList<Appt> allAppts= new LinkedList<Appt>();
	 	TimeTable testTT= new TimeTable();
	 	LinkedList<CalDay> appRangeList= testTT.getApptRange(allAppts, calOne, calTwo);
	 	assertEquals(32, appRangeList.size());

	 	int[] days=new int[] {0,1,2,3,4,5,6};

	 	Appt appt1= new Appt(21, 30 , 10 , 01 , 2018 , "Therapy", "I need this shit.");
	 	//appt1.setRecurrence(days, 1, 1, -1);
	 	Appt appt2= new Appt(16, 00 , 10 , 01 , 2018 , "Yoga", "Ommmmm.");
	 	Appt appt3= new Appt(11, 15 , 11 , 02 , 2018 , "Class", "Yay learnin.");
	 	Appt appt4= new Appt(13, 30 , 11 , 02 , 2018 , "Food", "Healthy.");
	 	Appt appt5= new Appt(20, 45 , 12 , 03 , 2018 , "Basketball Game", "Go Beavs!");
	 	Appt appt6= new Appt(10, 30 , 12 , 03 , 2018 , "Nap", "Catchin' some zzz's");
	 	Appt appt7= new Appt(8, 30 , 12 , 03 , 2018 , "Gym", "I hate exercise.");
	 	Appt appt8= new Appt(50, 30 , 11 , 02 , 2018 , "Not a Real Thing", "it's all in ur head.");

		allAppts.add(appt1);
		allAppts.add(appt2);
		allAppts.add(appt3);
		allAppts.add(appt4);
		allAppts.add(appt5);
		allAppts.add(appt6);
		allAppts.add(appt7);
		allAppts.add(appt8);
		dayOne.addAppt(appt1);
		dayOne.addAppt(appt2);


        //weekly recurrances
		appRangeList=testTT.getApptRange(allAppts, calOne, calTwo);
		assertEquals(32, appRangeList.size());
		//assertEquals(dayOne, appRangeList.get(0));
		appt1.setRecurrence(null, 1, 1, 10);
		appRangeList=testTT.getApptRange(allAppts, calOne, calTwo);
		assertEquals(32, appRangeList.size());
		appt1.setRecurrence(days, 1, 1, 10);
		appRangeList=testTT.getApptRange(allAppts, calOne, calTwo);
		assertEquals(32, appRangeList.size());
		//monthly occurrences
		appt1.setRecurrence(days, 2, 1, 10);
		appRangeList=testTT.getApptRange(allAppts, calOne, calThree);
		//yearly
		 appt1.setRecurrence(days, 3, 1, 10);
		 appRangeList=testTT.getApptRange(allAppts, calOne, calFour);
		 appt1.setRecurrence(days, 0, 1, 10);
		 appRangeList=testTT.getApptRange(allAppts, calOne, calFour);

		 appRangeList=testTT.getApptRange(allAppts, calTwo, calOne); //should throw


	 }
	 @Test //remove
	  public void test02()  throws Throwable {
         LinkedList<Appt> allAppts = new LinkedList<Appt>();
         LinkedList<Appt> noAppts = null;
         TimeTable testTT = new TimeTable();
         int[] days = new int[]{0, 1, 2, 3, 4, 5, 6};
         Appt appt1 = new Appt(21, 30, 10, 01, 2018, "Therapy", "I need this shit.");
         appt1.setRecurrence(days, 1, 1, -1);
         Appt appt2 = new Appt(16, 00, 10, 01, 2018, "Yoga", "Ommmmm.");
         Appt appt3 = new Appt(11, 15, 11, 02, 2018, "Class", "Yay learnin.");
         Appt appt4 = new Appt(13, 30, 11, 02, 2018, "Food", "Healthy.");
         Appt appt5 = new Appt(20, 45, 12, 03, 2018, "Basketball Game", "Go Beavs!");
         Appt appt6 = new Appt(10, 30, 12, 03, 2018, "Nap", "Catchin' some zzz's");
         Appt appt7 = new Appt(8, 30, 12, 03, 2018, "Gym", "I hate exercise.");
         Appt appt8 = new Appt(4, 300, -800, 02, 2018, "Not a Real Thing", "it's all in ur head.");
         allAppts.add(appt1);
         allAppts.add(appt2);
         allAppts.add(appt3);
         allAppts.add(appt4);
         allAppts.add(appt5);
         allAppts.add(appt6);
         allAppts.add(appt7);
         allAppts.add(appt8);

         LinkedList<Appt> rmList = testTT.deleteAppt(allAppts, appt2);
				 assertEquals(7, rmList.size());
				 assertEquals(appt1, rmList.get(0));
				 assertEquals(appt3, rmList.get(1));
				 assertEquals(appt4, rmList.get(2));
				 assertEquals(appt5, rmList.get(3));
				 assertEquals(appt6, rmList.get(4));
				 assertEquals(appt7, rmList.get(5));
				 assertEquals(appt8, rmList.get(6));

				 rmList = testTT.deleteAppt(allAppts, appt8);
				 assertEquals(null, rmList);

         rmList = testTT.deleteAppt(noAppts, appt1);
				 assertEquals(null, rmList);
         Appt nullappt = null;
         allAppts.add(nullappt);
         rmList = testTT.deleteAppt(allAppts, nullappt);
				 assertEquals(null, rmList);

				 LinkedList<Appt> oneAppt = new LinkedList<Appt>();
         oneAppt.add(appt6);
				 rmList=testTT.deleteAppt(oneAppt, appt2);
				 assertEquals(null, rmList);
				 rmList=testTT.deleteAppt(oneAppt, appt6);
				 assertEquals(null, rmList);

     }
     @ Test //permute
     public void test03() throws Throwable{

         LinkedList<Appt> allAppts= new LinkedList<Appt>();
         TimeTable testTT= new TimeTable();

         Appt appt1= new Appt(21, 30 , 10 , 01 , 2018 , "Therapy", "I need this shit.");
         Appt appt2= new Appt(16, 00 , 11 , 02 , 2018 , "Yoga", "Ommmmm.");
 			 	 Appt appt3 = new Appt(11, 15, 11, 02, 2018, "Class", "Yay learnin.");
         allAppts.add(appt1);
         allAppts.add(appt2);
				 allAppts.add(appt3);
         assertEquals(appt1, allAppts.get(0));

         int [] pv = {1, 2, 0};
         LinkedList<Appt> shuffList= new LinkedList<Appt>();
         shuffList=testTT.permute(allAppts,pv);
				 assertEquals(appt1, shuffList.get(0));
				 assertEquals(appt2, shuffList.get(1));
				 assertEquals(appt3, shuffList.get(2));

    }
		@ Test (expected = IllegalArgumentException.class) //permute
		public void test04() throws Throwable{
			LinkedList<Appt> allAppts= new LinkedList<Appt>();
			TimeTable testTT= new TimeTable();

			Appt appt1= new Appt(21, 30 , 10 , 01 , 2018 , "Therapy", "I need this shit.");
			Appt appt2= new Appt(16, 00 , 11 , 02 , 2018 , "Yoga", "Ommmmm.");
			Appt appt3 = new Appt(11, 15, 11, 02, 2018, "Class", "Yay learnin.");
			allAppts.add(appt1);
			allAppts.add(appt2);
			allAppts.add(appt3);
			int [] pv = {1, 2};
			LinkedList<Appt> shuffList= new LinkedList<Appt>();
			shuffList=testTT.permute(allAppts,pv);

		}
		@ Test (expected = DateOutOfRangeException.class)
		public void test05() throws Throwable{
			GregorianCalendar calOne=new GregorianCalendar(2018, 0, 10);
		 	CalDay dayOne= new CalDay(calOne);
		 	GregorianCalendar calTwo=new GregorianCalendar(2018, 1, 11);
		 	CalDay dayTwo= new CalDay(calTwo);
			TimeTable timetable=new TimeTable();
			LinkedList<Appt> noAppts = null;
			LinkedList<CalDay> result= timetable.getApptRange(noAppts, calOne, calOne);
      assertEquals(null, result);
		}
		@ Test
		public void test06() throws Throwable{
			GregorianCalendar calOne=new GregorianCalendar(2018, 0, 10);
			CalDay dayOne= new CalDay(calOne);
			GregorianCalendar calTwo=new GregorianCalendar(2018, 1, 11);
			CalDay dayTwo= new CalDay(calTwo);

			TimeTable timetable=new TimeTable();
			LinkedList<Appt> apptList=new LinkedList<Appt>();
			Appt appt1= new Appt(21, 30 , 11 , 01 , 2018 , "Therapy", "I need this shit.");
			Appt appt2= new Appt(16, 00 , 14 , 02 , 2018 , "Yoga", "Ommmmm.");
			Appt appt3 = new Appt(4, 300, 10, 02, 2018, "Not a Real Thing", "it's all in ur head.");

			apptList.add(appt1);
			apptList.add(appt3);
			apptList.add(appt2);


			LinkedList<CalDay> result=timetable.getApptRange(apptList, calOne, calTwo);


		}
		@ Test
		public void test07() throws Throwable{
			GregorianCalendar feb10=new GregorianCalendar(2018, 1, 10);
		 	GregorianCalendar feb11=new GregorianCalendar(2018, 1, 11);
	 		CalDay dayfeb10= new CalDay(feb10);
			CalDay dayfeb11= new CalDay(feb11);
			Appt appt2 = new Appt(16, 00, 10, 01, 2018, "Yoga", "Ommmmm.");
			Appt appt3 = new Appt(11, 15, 10, 01, 2018, "Class", "Yay learnin.");
			Appt appt4 = new Appt(13, 30, 11, 01, 2018, "Food", "Healthy.");
			Appt appt5 = new Appt(20, 45, 11, 01, 2018, "Basketball Game", "Go Beavs!");
			Appt appt6 = new Appt(10, 30, 12, 01, 2018, "Nap", "Catchin' some zzz's");
			Appt appt7 = new Appt(8, 30, 12, 01, 2018, "Gym", "I hate exercise.");

			dayfeb10.addAppt(appt2);
			dayfeb10.addAppt(appt3);
			dayfeb11.addAppt(appt4);
			dayfeb11.addAppt(appt5);

			LinkedList<Appt> allAppts = new LinkedList<Appt>();
			allAppts.add(appt7);
			allAppts.add(appt6);
			allAppts.add(appt5);
			allAppts.add(appt4);
			allAppts.add(appt3);
			allAppts.add(appt2);

			TimeTable myTt=new TimeTable();
			LinkedList<CalDay> range = myTt.getApptRange(allAppts, feb10, feb11);
			assertEquals(1, range.size());
			assertEquals(dayfeb10.getAppts().get(0), range.get(0).getAppts().get(0));
		}
		@ Test
		public void test08() throws Throwable{
			GregorianCalendar feb10=new GregorianCalendar(2018, 1, 10);
		 	GregorianCalendar feb17=new GregorianCalendar(2018, 1, 17);
	 		CalDay dayfeb10= new CalDay(feb10);
			CalDay dayfeb17= new CalDay(feb17);
			Appt appt2 = new Appt(16, 00, 10, 01, 2018, "Yoga", "Ommmmm.");
			Appt appt3 = new Appt(11, 15, 10, 01, 2018, "Class", "Yay learnin.");
			Appt appt4 = new Appt(13, 30, 11, 01, 2018, "Food", "Healthy.");
			Appt appt5 = new Appt(20, 45, 11, 01, 2018, "Basketball Game", "Go Beavs!");
			Appt appt6 = new Appt(10, 30, 12, 01, 2018, "Nap", "Catchin' some zzz's");
			Appt appt7 = new Appt(8, 30, 12, 01, 2018, "Gym", "I hate exercise.");

			dayfeb10.addAppt(appt2);
			dayfeb10.addAppt(appt3);

			int[] days=new int[] {0,1,2,3,4,5,6};

			appt2.setRecurrence(days, 1, 1, 7);

			LinkedList<Appt> allAppts = new LinkedList<Appt>();
			allAppts.add(appt7);
			allAppts.add(appt6);
			allAppts.add(appt5);
			allAppts.add(appt4);
			allAppts.add(appt3);
			allAppts.add(appt2);

			TimeTable myTt=new TimeTable();
			LinkedList<CalDay> range = myTt.getApptRange(allAppts, feb10, feb17);
			assertEquals(7, range.size());
			assertEquals(dayfeb10.getAppts().get(0), range.get(0).getAppts().get(0));
			assertEquals(appt2, range.get(0).getAppts().get(1));
			assertEquals(appt2, range.get(1).getAppts().get(1));
			assertEquals(appt2, range.get(2).getAppts().get(2));
			assertEquals(appt2, range.get(3).getAppts().get(0));
			assertEquals(appt2, range.get(4).getAppts().get(0));
			assertEquals(appt2, range.get(5).getAppts().get(0));
			assertEquals(appt2, range.get(6).getAppts().get(0));
		}
		@ Test
		public void test09() throws Throwable{
			GregorianCalendar feb10=new GregorianCalendar(2018, 1, 10);
		 	GregorianCalendar feb17=new GregorianCalendar(2018, 1, 17);
	 		CalDay dayfeb10= new CalDay(feb10);
			CalDay dayfeb17= new CalDay(feb17);
			Appt appt2 = new Appt(16, 00, 10, 01, 2018, "Yoga", "Ommmmm.");
			Appt appt3 = new Appt(11, 15, 10, 01, 2018, "Class", "Yay learnin.");
			Appt appt4 = new Appt(13, 30, 11, 01, 2018, "Food", "Healthy.");
			Appt appt5 = new Appt(20, 45, 11, 01, 2018, "Basketball Game", "Go Beavs!");
			Appt appt6 = new Appt(10, 30, 12, 01, 2018, "Nap", "Catchin' some zzz's");
			Appt appt7 = new Appt(8, 30, 12, 01, 2018, "Gym", "I hate exercise.");

			dayfeb10.addAppt(appt2);
			dayfeb10.addAppt(appt3);

			int[] days=new int[] {0,2,4,5,6};

			appt2.setRecurrence(days, 1, 1, 7);

			LinkedList<Appt> allAppts = new LinkedList<Appt>();
			allAppts.add(appt7);
			allAppts.add(appt6);
			allAppts.add(appt5);
			allAppts.add(appt4);
			allAppts.add(appt3);
			allAppts.add(appt2);

			TimeTable myTt=new TimeTable();
			LinkedList<CalDay> range = myTt.getApptRange(allAppts, feb10, feb17);
			assertEquals(7, range.size());
			assertEquals(dayfeb10.getAppts().get(0), range.get(0).getAppts().get(0));
			assertEquals(appt2, range.get(0).getAppts().get(1));
			assertEquals(appt5, range.get(1).getAppts().get(1));
			assertEquals(appt2, range.get(2).getAppts().get(2));
			LinkedList<Appt> emptylist=new LinkedList<Appt>();
			assertEquals(emptylist, range.get(3).getAppts());
			assertEquals(appt2, range.get(4).getAppts().get(0));
			assertEquals(appt2, range.get(5).getAppts().get(0));
			assertEquals(appt2, range.get(6).getAppts().get(0));
		}
		@ Test
		public void test10() throws Throwable{
			GregorianCalendar feb10=new GregorianCalendar(2018, 1, 10);
		 	GregorianCalendar feb13=new GregorianCalendar(2018, 1, 13);
	 		CalDay dayfeb10= new CalDay(feb10);
			CalDay dayfeb13= new CalDay(feb13);
			Appt appt2 = new Appt(16, 00, 10, 01, 2018, "Yoga", "Ommmmm.");
			Appt appt3 = new Appt(11, 15, 10, 01, 2018, "Class", "Yay learnin.");
			Appt appt4 = new Appt(13, 30, 11, 01, 2018, "Food", "Healthy.");
			Appt appt5 = new Appt(20, 45, 11, 01, 2018, "Basketball Game", "Go Beavs!");
			Appt appt6 = new Appt(10, 30, 12, 01, 2018, "Nap", "Catchin' some zzz's");
			Appt appt7 = new Appt(8, 30, 12, 01, 2018, "Gym", "I hate exercise.");

			dayfeb10.addAppt(appt2);
			dayfeb10.addAppt(appt3);

			int[] days=new int[] {0};

			appt2.setRecurrence(days, 1, 1, 7);

			LinkedList<Appt> allAppts = new LinkedList<Appt>();
			allAppts.add(appt7);
			allAppts.add(appt6);
			allAppts.add(appt5);
			allAppts.add(appt4);
			allAppts.add(appt3);
			allAppts.add(appt2);

			TimeTable myTt=new TimeTable();
			LinkedList<CalDay> range = myTt.getApptRange(allAppts, feb10, feb13);
			assertEquals(3, range.size());
			assertEquals(dayfeb10.getAppts().get(0), range.get(0).getAppts().get(0));
			assertEquals(appt2, range.get(0).getAppts().get(1));
			assertEquals(appt5, range.get(1).getAppts().get(1));
			assertEquals(appt6, range.get(2).getAppts().get(1));

		}
		@ Test
		public void test11() throws Throwable{
			GregorianCalendar feb10=new GregorianCalendar(2018, 1, 10);
		 	GregorianCalendar feb13=new GregorianCalendar(2018, 1, 13);
	 		CalDay dayfeb10= new CalDay(feb10);
			CalDay dayfeb13= new CalDay(feb13);
			Appt appt2 = new Appt(16, 00, 10, 01, 2018, "Yoga", "Ommmmm.");
			Appt appt3 = new Appt(11, 15, 10, 01, 2018, "Class", "Yay learnin.");
			Appt appt4 = new Appt(13, 30, 11, 01, 2018, "Food", "Healthy.");
			Appt appt5 = new Appt(20, 45, 11, 01, 2018, "Basketball Game", "Go Beavs!");
			Appt appt6 = new Appt(10, 30, 12, 01, 2018, "Nap", "Catchin' some zzz's");
			Appt appt7 = new Appt(8, 30, 12, 01, 2018, "Gym", "I hate exercise.");

			dayfeb10.addAppt(appt2);
			dayfeb10.addAppt(appt3);

			int[] days=new int[] {0,1,2,3,4,5,6};

			appt2.setRecurrence(days, 1, 1, -1);
			assertTrue(appt2.getValid());
			LinkedList<Appt> allAppts = new LinkedList<Appt>();
			allAppts.add(appt7);
			allAppts.add(appt6);
			allAppts.add(appt5);
			allAppts.add(appt4);
			allAppts.add(appt3);
			allAppts.add(appt2);

			TimeTable myTt=new TimeTable();
			LinkedList<CalDay> range = myTt.getApptRange(allAppts, feb10, feb13);
			assertEquals(3, range.size());
			assertEquals(dayfeb10.getAppts().get(0), range.get(0).getAppts().get(0));
			assertEquals(appt3, range.get(0).getAppts().get(0));
			//assertEquals(appt2, range.get(0).getAppts().get(1));
			assertEquals(appt4, range.get(1).getAppts().get(0));
			assertEquals(appt5, range.get(1).getAppts().get(1));
			assertEquals(appt7, range.get(2).getAppts().get(0));
			assertEquals(appt6, range.get(2).getAppts().get(1));
			//assertEquals(null, range.get(3));

		}

//add more unit tests as you needed
}
