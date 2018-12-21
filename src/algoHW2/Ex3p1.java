package algoHW2;

public class Ex3p1 {
	public static void main(String[] args) throws Exception {
        int val[] = {16, 32, 56, 28, 30};
        int wt[] = {1, 4, 5, 2, 4};
        int W = 16;
        
        System.out.println("Maximum value for given items "+ knapsack(val, wt, W));
    }
	
	// method will return maximum value that can be taken in backpack for 
	//given items and will print # of item that can be taken in backpack
    public static int knapsack(int val[], int wt[], int W) {
        int N = wt.length; // Get the total number of items. Could be wt.length or val.length. Doesn't matter
        int[][] V = new int[N + 1][W + 1]; //Create a matrix. Items are in rows and weight at in columns +1 on each side
        //What if the knapsack's capacity is 0 - Set all columns at row 0 to be 0
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }
        //What if there are no items at home.  Fill the first row with 0
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item=1;item<=N;item++){
            //Let's fill the values row by row
            for (int weight=1;weight<=W;weight++){
                //Is the current items weight less than or equal to running weight
                if (wt[item-1]<=weight){
                    //Given a weight, check if the value of the current item + value of the item that we could 
                	//afford with the remaining weight
                    //is greater than the value without the current item itself
                    V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);
                }
                else {
                    //If the current item's weight is more than the running weight, just carry 
                	//forward the value without the current item
                    V[item][weight]=V[item-1][weight];
                }
            }
        }

        //Printing the matrix
        for (int[] rows : V) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        
        System.out.println("\nItem # entering backpack:");
        int i = N, w = W;
        while (i>0 && w>0) {
        	if (V[i][w] != V[i-1][w]) {
        		//Item should be taken so we print it to the console
        		System.out.print(i+" ");
        		w = w - wt[i-1];
        		i--;
        	}
        	else
        		i--;
        }
        System.out.println("\n");
        return V[N][W];
    }
}
