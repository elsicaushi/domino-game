package org.game.model;

/**
 * This class serves as the testing framework for the classes
 * that are developed in this project.
 * <p>
 * Each method is responsible for performing tests on a specific developed class. 
 * @author Richard Walker
 *
 */
public class Tester {
	
	public static void main(String[] args) {
		DominoClass();
		PlayerClass();
	}

	/**
	 * This method is used to test the Domino Class.
	 * @see Domino
	 */
	@SuppressWarnings("unused")
	private static void DominoClass(){
		
		System.out.println("-- Testing the Domino Class --");
		System.out.println();
		
		/*Creates Pack of Dominos*/
		OpenPack();
		
		/* Make the dominos for testing */
		Domino dom1 = new Domino(5,5); // 5 | 5
		Domino dom2 = new Domino(6,4); // 6 | 4
		Domino dom3 = new Domino(); // double blank
		Domino dom4 = new Domino(5,5); // 5 | 5
		
		/* Print the dominos */
		System.out.println("This domino is " + dom1);
		System.out.println("This domino is " + dom2);
		System.out.println("This domino is " + dom3);
		
		/* Get the total values */
		System.out.println();
		System.out.println("The total value for " + dom1 + " is " + dom1.getTotalValue());
		System.out.println("The total value for " + dom2 + " is " + dom2.getTotalValue());
		System.out.println("The total value for " + dom3 + " is " + dom3.getTotalValue());
		
		/* Test the isDouble() method */
		System.out.println();
		System.out.println(dom1 + " is a double domino " + dom1.isDouble());
		System.out.println(dom2 + " is a double domino " + dom2.isDouble());
		System.out.println(dom3 + " is a double domino " + dom3.isDouble());
		
		/* Test the isSameValue() method */
		System.out.println();
		System.out.println(dom1 + " and " + dom2 + " have the same total value " + dom1.isSameValue(dom2)); // true 
		System.out.println(dom1 + " and " + dom3 + " have the same total value " + dom1.isSameValue(dom3)); // false
		
		/* Test the equals() method */
		System.out.println();
		System.out.println("Are " + dom1 + " and " + dom1 + " are the same? " + dom1.equals(dom1)); // true 
		System.out.println("Are " + dom1 + " and " + dom2 + " are the same? " + dom1.equals(dom2)); // false
		System.out.println("Are " + dom1 + " and " + dom4 + " are the same? " + dom1.equals(dom4)); // true
		
	}
	
	/**
	 * This method is used to test the Player Class.
	 * @see Player
	 */
	@SuppressWarnings("unused")
	private static void PlayerClass(){
		System.out.println("-- Testing the Player Class --");
		System.out.println();
		
		/* Make the players for testing */
		Player richie = new Player("Richie"); 
		Player dwayne = new Player("Dwayne"); 
		
		/* Should be 2 players now */
		System.out.println("There are " + Player.getNumOfPlayers() + " players");
		
		System.out.println();
		/* Print players info */
		System.out.println(richie + "\n");
		System.out.println(dwayne);
		
		/* The hands should be empty */
		System.out.println();
		System.out.println("Is " + richie.getName() + " hand empty? " + richie.isHandEmpty()); // should be false;
		
		/* Make the dominos for testing */
		Domino dom1 = new Domino(5,5); // 5 | 5
		Domino dom2 = new Domino(6,4); // 6 | 4
		Domino dom3 = new Domino(); // double blank
		Domino dom4 = new Domino(1,0); // 1 | 0
		
		/* Prompt */
		System.out.println("Adding dominos to the players hand...");
		
		/* Add dominos to Richie hand */
		richie.addDomino(dom1);
		richie.addDomino(dom2);
		
		/* Add dominos to Dwayne hand */
		dwayne.addDomino(dom1);
		dwayne.addDomino(dom3);
		dwayne.addDomino(dom4);
		
		/* Print the hands */
		System.out.println();
		System.out.println(richie.getName() + "'s hand:\n");
		for (Domino dom : richie.getHand()){
			System.out.println(dom);
		}
		
		System.out.println();
		System.out.println(dwayne.getName() + "'s hand:\n");
		for (Domino dom : dwayne.getHand()){
			System.out.println(dom);
		}
		
		/* Dwayne should have 3 dominos in his hand */
		System.out.println();
		System.out.println("Is " + dwayne.getName() + " hand empty? " + dwayne.isHandEmpty()); // should be false;

		/* The number of dominos in each hand */
		System.out.println();
		System.out.println(richie.getName() + " has " + richie.numOfDomInHand() + " in their hand."); // should be 2
		System.out.println(dwayne.getName() + " has " + dwayne.numOfDomInHand() + " in their hand."); // should be 3
		
		/* Test the hasPlay() method */
		System.out.println();
		System.out.println(richie.getName() + " can play a matching domino with a side of " + dom1.getSide1() + "? " + richie.hasPlay(dom1.getSide1())); // should be true 
		System.out.println(dwayne.getName() + " can play a matching domino with a side of " + dom2.getSide1() + "? " + dwayne.hasPlay(dom2.getSide1())); // should be false
		System.out.println(dwayne.getName() + " can play a matching domino with a side of " + dom3.getSide1() + "? " + dwayne.hasPlay(dom3.getSide1())); // should be true
		
		/* Check hasDomino() method */
		System.out.println();
		System.out.println(dwayne.getName() + " has " + dom3 + " in his hand? " + dwayne.hasDominoInHand(dom3) ); // should be true 
		System.out.println(richie.getName() + " has " + dom3 + " in his hand? " + richie.hasDominoInHand(dom3) ); // should be false 
		
		/* The value of the hands */
		System.out.println();
		System.out.println(richie.getName() + " counts " + richie.valueOfHand()); // should be 20
		System.out.println(dwayne.getName() + " counts " + dwayne.valueOfHand()); // should be 11
		
		/* Remove double blank from Dwayne's hand */
		System.out.println("\nRemoving " + dom3 +" from " + dwayne.getName() + " hand.");
		dwayne.removeDom(1);
		
		/* Reprint Dwayne's updated hand */
		System.out.println();
		System.out.println(dwayne.getName() + "'s hand:\n");
		for (Domino dom : dwayne.getHand()){
			System.out.println(dom);
		}
		
	}
	
	/*Creates the Pack of dominos by creating a Domino Array and using a 2-Dimensional loop to populate it*/	
	public static void OpenPack()
	{
		Pack newPack = new Pack();
		
			System.out.print("      "+newPack);
		
		
		System.out.println("Pack opened. please Shuffle.\n");
	}
	
	
}
