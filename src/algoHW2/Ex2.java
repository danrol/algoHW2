package algoHW2;

public class Ex2 {
	
	public static int findMinEnergyNeededToFinish(int[] arrayOfHeights) {
		
		int[] minEnergyPerStep = new int[arrayOfHeights.length];
		minEnergyPerStep[0] = arrayOfHeights[0];
		minEnergyPerStep[1] = Math.abs(arrayOfHeights[1]-arrayOfHeights[0]);
		
		for (int i=2;i<minEnergyPerStep.length;i++) {
			minEnergyPerStep[i] = Math.min(minEnergyPerStep[i-1]+Math.abs(arrayOfHeights[i] - arrayOfHeights[i-1]), 
					minEnergyPerStep[i-2] + Math.abs(arrayOfHeights[i]-arrayOfHeights[i-2])*3);
		}
		
		return minEnergyPerStep[minEnergyPerStep.length-1];
	}
		
	public static void printArr(int arr[]) {
		for(int a: arr){
			System.out.print(a+" ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		int[] arrayOfHeights = new int[]{0,3, 5, 1, 8, 23,26}; //player starts from zero, that's why 0 is first value
		
		System.out.println("\nMinimal energy needed: " + findMinEnergyNeededToFinish(arrayOfHeights));
	}
}
