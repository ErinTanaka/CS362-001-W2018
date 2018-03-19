
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }
    UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES );
   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES );
	//testing url's we know to be valid
	String validUrl01 = "www.google.com/test1";
       assertTrue(urlVal.isValid(validUrl01));

//	String validUrl02 = "http://www.google.com:0";
//       assertTrue(urlVal.isValid(validUrl02)); //fails

	String validUrl03 = "http://www.google.com/t123";
       assertTrue(urlVal.isValid(validUrl03));
       String validUrl04 = "http://www.google.com?action=view";
       assertTrue(urlVal.isValid(validUrl04));
    String validUrl05 = "http://go.com/test1?action=view";
       assertTrue(urlVal.isValid(validUrl05));


	//testing url's we know to be invalid
       String invalidUrl01 = "3ht://go.com:80/test1?action=view";
       String invalidUrl02 = "http://aaa:80/test1?action=view";
       String invalidUrl03 = "http://go.com:-1/test1?action=view";
       String invalidUrl04 = "http://go.com:80/..?action=view";
       String invalidUrl05 = "http://go.com/test?19pwer8gkesmrdfiu";
       assertFalse(urlVal.isValid(invalidUrl01));
       assertFalse(urlVal.isValid(invalidUrl02));
       assertFalse(urlVal.isValid(invalidUrl03));
       assertFalse(urlVal.isValid(invalidUrl04));
       assertFalse(urlVal.isValid(invalidUrl05)); //fails
   }
   
   
   public void testYourFirstPartition() //schemes
   {
	 //You can use this function to implement your First Partition testing
       UrlValidator urlVal = new UrlValidator( UrlValidator.ALLOW_ALL_SCHEMES );
       //valid
       assertTrue(urlVal.isValid("ftp://google.com")); //fails
       //valid
       assertTrue(urlVal.isValid("http://google.com"));
       //valid, none
       assertTrue(urlVal.isValid("google.com")); //fails
       //invalid
       assertFalse(urlVal.isValid("http:google.com"));

   }
   
   public void testYourSecondPartition(){ //authority
		 //You can use this function to implement your Second Partition testing
       UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
       //valid
       assertTrue(urlVal.isValid("http://www.google.com"));
       //invalid
       assertFalse(urlVal.isValid("http://1.2.3.4.5")); //fails
       //none, invalid
       assertFalse(urlVal.isValid("http://")); //fails

   }
    public void testYourThirdPartition(){ //port
        //You can use this function to implement your Second Partition testing
        UrlValidator urlVal = new UrlValidator( UrlValidator.ALLOW_ALL_SCHEMES );
        //valid
        assertTrue(urlVal.isValid("http://www.google.com:80")); //fails
        //none, valid
        assertTrue(urlVal.isValid("http://www.google.com"));
        //invalid
        assertFalse(urlVal.isValid("http://www.google.com:-1"));

    }
    public void testYourFourthPartition(){ //path
        //You can use this function to implement your Second Partition testing
        UrlValidator urlVal = new UrlValidator( UrlValidator.ALLOW_ALL_SCHEMES );
        //valid
        assertTrue(urlVal.isValid("http://www.google.com/test1"));
        //invalid
        assertFalse(urlVal.isValid("http://www.google.com/.."));
        //none, valid
        assertTrue(urlVal.isValid("http://www.google.com"));
    }
    public void testYourFifthPartition(){ //query
        //You can use this function to implement your Second Partition testing
        UrlValidator urlVal = new UrlValidator( UrlValidator.ALLOW_ALL_SCHEMES );
        //valid
        assertTrue(urlVal.isValid("http://www.google.com?action=view"));
        //invalid
        assertFalse(urlVal.isValid("http://www.google.com/test?rftvgybuhnjjjjjuy76@()")); //fails
        //none, valid
        assertTrue(urlVal.isValid("http://www.google.com"));
    }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing
       UrlValidator urlVal = new UrlValidator();

       String[] schemes = {"http://", "", "ftp://", "http:", "://"}; //t, t, t, f, f
       String[] authority = {"google.com", "www.go.com", "255.255.255.255", ".1.2.3.4", "aaa", ""}; //t, t, t, f, f, f
       String[] port = {":80", ":0", "", ":65636", ":65a"}; //t, t, t, f, f
       String[] path = {"/t123", "/test1/file", "", "/../", "/test1//file"}; //t, t, t, f, f
       String[] query = {"?action=view", ""}; //t, t

       for (int s=0; s<5; s++){
           for (int a=0; a<6; a++){
               for (int prt=0; prt<5; prt++){
                   for (int pth=0; pth<5; pth++){
                       for(int q=0; q<2;q++){
                           String testUrlBuffer=schemes[s]+authority[a]+port[prt]+path[pth]+query[q];
//                           System.out.print(testUrlBuffer);
//                           System.out.println();
                           boolean expected=true;
                           if(s>2 || a>2 || prt>2 || pth>2){
                               expected=false;
                           }
                           boolean actual= urlVal.isValid(testUrlBuffer);

                           if(expected != urlVal.isValid(testUrlBuffer)){
                               System.out.print("Url failed validation check: "+testUrlBuffer);
                               System.out.print("   expected: "+expected+" but was: "+actual+"\n");
                           }
                           else{
                               System.out.print("passed validation check: "+testUrlBuffer+"\n");
                           }

                       }
                   }
               }
           }
       }
       System.out.print("out of my fucking forloop bananza\n");
   }
   


}
