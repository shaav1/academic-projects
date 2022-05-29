package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test (expected = NullPointerException.class)//NullPointerException test
    public void testCountNumbers2() {
        mycustomstring.setString(null);
        mycustomstring.countNumbers();
    }

    @Test
    public void testCountNumbers3() {//empty string test
        mycustomstring.setString("");
        assertEquals(0,mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("H3110");
        assertEquals(1,mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {//list of different numbers with different lengths 
    	  mycustomstring.setString("1,10,100,1000");
          assertEquals(4,mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {//no numbers in string test 
  	  mycustomstring.setString("There are no numbers in this string");
      assertEquals(0,mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("Testing 4 illegal exception");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }

    @Test(expected = NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.setString(null);
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true);

    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {//empty string test
        mycustomstring.setString("");
        assertEquals("",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));

    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {//testing starting from the end 
    	mycustomstring.setString("314159");
    	assertEquals("345",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {//if n is larger than the string size
        mycustomstring.setString("hello");
        assertEquals("",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {//tests for capitalization
       mycustomstring.setString("Really... Long... Run... On... Sentence...");
       assertEquals("O",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(26, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {//test for multiple lines
    	mycustomstring.setString("Lorem ipsum dolor sit amet, consectetur adipiscing elit,"
    			+ " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Id semper risus "
    			+ "in hendrerit gravida. Consequat id porta nibh venenatis. Lectus arcu bibendum at varius vel. "
    			+ "A pellentesque sit amet porttitor eget dolor morbi. Pulvinar etiam non quam lacus suspendisse faucibus"
    			+ " interdum posuere lorem.");
    	assertEquals("i di q aactero ee",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(20,false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {//test for special characters starting from the front
        mycustomstring.setString("( ͡° ͜ʖ ͡°) ¯\\_(ツ)_/¯");
        assertEquals("( ͡° ͜ʖ ͡°) ¯\\_(ツ)_/¯",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1,false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {//test for special characters starting from the end
    	mycustomstring.setString("¯\\_(ツ)_/¯");
    	assertEquals("\\()/",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2,true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {//test if n is negative, should throw illegal argument exception
    	mycustomstring.setString("hi, how are you?");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, false);

    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("computer science");
       assertEquals("usc",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
    	mycustomstring.setString("computer science");
        assertEquals("oei",mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, true));
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("He11o");
        mycustomstring.convertDigitsToNamesInSubstring(5,1);
    }

    @Test(expected= MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring3() {
    	mycustomstring.setString("He11o");
    	mycustomstring.convertDigitsToNamesInSubstring(1,7);
    }

    @Test(expected= NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring4() {
    	mycustomstring.setString(null);
    	mycustomstring.convertDigitsToNamesInSubstring(1,2);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring5() {//the string is all numbers 
        mycustomstring.setString("01290");
        mycustomstring.convertDigitsToNamesInSubstring(1, 5);
        assertEquals("ZeroOneTwoNineZero",mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring6() {//the string has no numbers
    	 mycustomstring.setString("There are no numbers in here");
    	 mycustomstring.convertDigitsToNamesInSubstring(1, 28);
    	 assertEquals("There are no numbers in here",mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring7() {//the end position is a number 
   	 mycustomstring.setString("blue 42");
	 mycustomstring.convertDigitsToNamesInSubstring(2,7);
	 assertEquals("blue FourTwo",mycustomstring.getString());

    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {//start and end are the name position
    	mycustomstring.setString("H1 H0w are you");
   	 	mycustomstring.convertDigitsToNamesInSubstring(2,2);
   	 	assertEquals("HOne H0w are you",mycustomstring.getString());
    }

}
