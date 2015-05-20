package menon.cs5050.assignment1;

import java.util.Random;

public class KnapsacksUser {
	
	private Random randomNumberGenerator;
	private int objectSizes[];
	private TwoKnapsacks twoKnapsacks;
	
	private static final int MAXIMUM_OBJECT_SIZE = 90;
	private static final int NUMBER_OF_OBJECTS = 100;
	private static final int KNAPSACK_1_SIZE = 1000;
	private static final int KNAPSACK_2_SIZE = 1000;
	
	//Constructor
	public KnapsacksUser() {
		this.randomNumberGenerator = new Random(38905L);
		this.objectSizes = new int[NUMBER_OF_OBJECTS + 1];
		this.objectSizes[0] = 0;
		for (int counter = 1; counter <= NUMBER_OF_OBJECTS; ++counter) {
			this.objectSizes[counter] = getNextRandomObjectSize();
		}
		this.twoKnapsacks = new TwoKnapsacks(this.objectSizes, KNAPSACK_1_SIZE, KNAPSACK_2_SIZE);
	}
	
	//Find out if a subset of the objects will fit exactly into the knapsacks
	
	//Return a random number to be used as the object size
	private int getNextRandomObjectSize() {
		return this.randomNumberGenerator.nextInt(MAXIMUM_OBJECT_SIZE + 1);
	}

	public static void main(String[] args) {
		
		KnapsacksUser knapsacksUser = new KnapsacksUser();
		/*System.out.println("These are the object sizes:");
		for(int objectSize : knapsacksUser.objectSizes) {
			System.out.println(objectSize);
		}*/
		
		long beforeRecursiveRun = System.currentTimeMillis();
		boolean recursionWithMemoRunSuccess = knapsacksUser.twoKnapsacks.knapMemo();
		long afterRecursiveRun = System.currentTimeMillis();
		System.out.println((recursionWithMemoRunSuccess ? "Could" : "Could not") + " fit the objects into the knapsacks using recursive memo. Time taken is " + (afterRecursiveRun - beforeRecursiveRun) + " ms.");
		
		long beforeDpRun = System.currentTimeMillis();
		boolean dpRunSuccess = knapsacksUser.twoKnapsacks.knapDP();
		long afterDpRun = System.currentTimeMillis();		
		System.out.println((dpRunSuccess ? "Could" : "Could not") + " fit the objects into the knapsacks using DP. Time taken is " + (afterDpRun - beforeDpRun) + " ms.");
		
	}

}
