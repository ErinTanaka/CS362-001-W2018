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

	 @Test
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
	 	//assertEquals(32, appRangeList.size());

	 	int[] days=new int[] {0,1,2,3,4,5,6};

	 	Appt appt1= new Appt(21, 30 , 10 , 01 , 2018 , "Therapy", "I need this shit.");
	 	appt1.setRecurrence(days, 1, 1, -1);
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

        //weekly recurrances
		appRangeList=testTT.getApptRange(allAppts, calOne, calTwo);
		appt1.setRecurrence(null, 1, 1, 10);
		appRangeList=testTT.getApptRange(allAppts, calOne, calTwo);
		appt1.setRecurrence(days, 1, 1, 10);
		appRangeList=testTT.getApptRange(allAppts, calOne, calTwo);

		//monthly occurrences
		appt1.setRecurrence(days, 2, 1, 10);
		appRangeList=testTT.getApptRange(allAppts, calOne, calThree);
		//yearly
		 appt1.setRecurrence(days, 3, 1, 10);
		 appRangeList=testTT.getApptRange(allAppts, calOne, calFour);
		 appt1.setRecurrence(days, 0, 1, 10);
		 appRangeList=testTT.getApptRange(allAppts, calOne, calFour);




		 //appRangeList=testTT.getApptRange(allAppts, calTwo, calOne); //should throw


	 }
	 @Test
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

         LinkedList<Appt> rmList = testTT.deleteAppt(allAppts, appt1);
         rmList = testTT.deleteAppt(allAppts, appt8);
         rmList = testTT.deleteAppt(noAppts, appt1);
         Appt nullappt = null;
         allAppts.add(nullappt);
         rmList = testTT.deleteAppt(allAppts, nullappt);



     }
     @ Test
     public void test03() throws Throwable{
         
         LinkedList<Appt> allAppts= new LinkedList<Appt>();
         TimeTable testTT= new TimeTable();

         Appt appt1= new Appt(21, 30 , 10 , 01 , 2018 , "Therapy", "I need this shit.");
         Appt appt2= new Appt(16, 00 , 11 , 02 , 2018 , "Yoga", "Ommmmm.");

         allAppts.add(appt1);
         allAppts.add(appt2);

         int [] pv = {0,1};
         LinkedList<Appt> shuffList= new LinkedList<Appt>();
         shuffList=testTT.permute(allAppts,pv);

         int [] pv2={0};
         shuffList=testTT.permute(allAppts, pv2);
    }
//add more unit tests as you needed
}
