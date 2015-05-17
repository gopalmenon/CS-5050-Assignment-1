package menon.cs5050.assignment1;

public class TwoKnapsacks {
	
	int objectSizes[]; //array containing object sizes 
	int knapsack1Size; //Size of first knapsack
	int knapsack2Size; //Size of second knapsack
	
	//Constructor
	public TwoKnapsacks(int objectSizes[], int knapsack1Size, int knapsack2Size) {
		this.objectSizes = objectSizes;
		this.knapsack1Size = knapsack1Size;
		this.knapsack2Size = knapsack2Size;
	}
	
	//Call a recursive method that checks if there exists a subset of objects that fill both knapsacks exactly
	public boolean knap() {	
		
		return willTheyExactlyFitRecursive(this.objectSizes.length - 1, this.knapsack1Size, this.knapsack2Size);
	}
	
	//This is the recursive method called from method knap
	private boolean willTheyExactlyFitRecursive(int numberOfObjects, int knapsack1Size, int knapsack2Size) {
		
		//Both knapsacks are empty, then it means that they are filled
		if (knapsack1Size == 0 && knapsack2Size == 0) {
			return true;
		}
		
		//If there are no more objects left, since the knapsacks are both not empty, it means that the objects do not
		//fill the knapsacks exactly
		if (numberOfObjects == 0) {
			return false;
		}
		
		//The knapsacks should not have a negative length
		if (knapsack1Size < 0 || knapsack2Size < 0) {
			return false;
		}
		
		return willTheyExactlyFitRecursive(numberOfObjects - 1, knapsack1Size, knapsack2Size) || //discard the object
			   willTheyExactlyFitRecursive(numberOfObjects - 1, knapsack1Size - this.objectSizes[numberOfObjects], knapsack2Size) || //put the object in knapsack1
		       willTheyExactlyFitRecursive(numberOfObjects - 1, knapsack1Size, knapsack2Size - this.objectSizes[numberOfObjects]); //put the object in knapsack2

	}

}
