package de.dgbrt.montyhall;

import java.util.Random;

public class MontyHall
{
    static int testLength = 10000;
    static String boxes;
    static int boxesLength;
    int winnerCount = 0;
    int unknownCount = 0;

    public static void main(String[] args)
    {
	MontyHall mh = new MontyHall();
	for (int i = 0; i < testLength; i++)
	{
	    RunTest test = mh.new RunTest();

	    boxes = "ABCD";
	    boxesLength = boxes.length();
	    test.runTestWWM();
	    
//	    boxes = "ABC";
//	    boxesLength = boxes.length();
//	    test.runTestOrig();
	    
//	    boxes = "ABCDE";
//	    boxesLength = boxes.length();
//	    test.runTest5();
	}
    }

    public class RunTest
    {
	public void runTestWWM()
	{
	    char boxWinner = getBox();
	    char boxGuess = getBox();
	    char boxOpen1;
	    char boxOpen2;
	    char boxUnkown = 'A';

	    boxOpen1 = getBox();
	    while (boxOpen1 == boxWinner || boxOpen1 == boxGuess)
	    {
		boxOpen1 = getBox();
	    }
	    boxOpen2 = getBox();
	    while (boxOpen2 == boxWinner || boxOpen2 == boxGuess || boxOpen2 == boxOpen1)
	    {
		boxOpen2 = getBox();
	    }
	    while (boxUnkown == boxGuess || boxUnkown == boxOpen1 || boxUnkown == boxOpen2)
	    {
		boxUnkown = getBox();
	    }
	    System.out.print("All boxes: (guess/unknown/open1/open2) " + boxGuess + boxUnkown + boxOpen1 + boxOpen2);
	    System.out.print(" Winner: " + boxWinner + " - Guess: " + boxGuess + " - Unknown: " + boxUnkown);
	    if (boxWinner == boxGuess)
	    {
		winnerCount++;
	    }
	    if (boxWinner == boxUnkown)
	    {
		unknownCount++;
	    }
	    System.out.print(" WinnerCount: " + winnerCount);
	    System.out.println(" UnknownCount: " + unknownCount);
	}

	public void runTestOrig()
	{
	    char boxWinner = getBox();
	    char boxGuess = getBox();
	    char boxOpen1;
	    char boxUnkown = 'A';

	    boxOpen1 = getBox();
	    while (boxOpen1 == boxWinner || boxOpen1 == boxGuess)
	    {
		boxOpen1 = getBox();
	    }
	    while (boxUnkown == boxGuess || boxUnkown == boxOpen1)
	    {
		boxUnkown = getBox();
	    }
	    System.out.print("All boxes: (guess/unknown/open1) " + boxGuess + boxUnkown + boxOpen1);
	    System.out.print(" Winner: " + boxWinner + " - Guess: " + boxGuess + " - Unknown: " + boxUnkown);
	    if (boxWinner == boxGuess)
	    {
		winnerCount++;
	    }
	    if (boxWinner == boxUnkown)
	    {
		unknownCount++;
	    }
	    System.out.print(" WinnerCount: " + winnerCount);
	    System.out.println(" UnknownCount: " + unknownCount);
	}

	public void runTest5()
	{
	    char boxWinner = getBox();
	    char boxGuess = getBox();
	    char boxOpen1;
	    char boxOpen2;
	    char boxOpen3;
	    char boxUnkown = 'A';

	    boxOpen1 = getBox();
	    while (boxOpen1 == boxWinner || boxOpen1 == boxGuess)
	    {
		boxOpen1 = getBox();
	    }
	    boxOpen2 = getBox();
	    while (boxOpen2 == boxWinner || boxOpen2 == boxGuess || boxOpen2 == boxOpen1)
	    {
		boxOpen2 = getBox();
	    }
	    boxOpen3 = getBox();
	    while (boxOpen3 == boxWinner || boxOpen3 == boxGuess || boxOpen3 == boxOpen1 || boxOpen3 == boxOpen2)
	    {
		boxOpen3 = getBox();
	    }
	    while (boxUnkown == boxGuess || boxUnkown == boxOpen1 || boxUnkown == boxOpen2 || boxUnkown == boxOpen3)
	    {
		boxUnkown = getBox();
	    }
	    System.out.print("All boxes: (guess/unknown/open1/open2/open3) " + boxGuess + boxUnkown + boxOpen1
		    + boxOpen2 + boxOpen3);
	    System.out.print(" Winner: " + boxWinner + " - Guess: " + boxGuess + " - Unknown: " + boxUnkown);
	    if (boxWinner == boxGuess)
	    {
		winnerCount++;
	    }
	    if (boxWinner == boxUnkown)
	    {
		unknownCount++;
	    }
	    System.out.print(" WinnerCount: " + winnerCount);
	    System.out.println(" UnknownCount: " + unknownCount);
	}

	private char getBox()
	{
	    char box;
	    Random r = new Random();
	    box = boxes.charAt(r.nextInt(boxesLength));
	    return box;
	}

    }
}
