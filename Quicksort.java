package quicksort;
import java.util.Random;

/**
 *
 * @author Paul Bosonetto
 * CSCI 333
 * HW3 Quicksort
 * 2018.09.22
 * 
 * This program implements quicksort, a recursive sorting algorithm. It implements
 * both a naive version 'quicksort' and a randomized version 'randomizedQuicksort' 
 */
public class Quicksort {
    
    Random rand = new Random();
    /**
     * Helper method for quicksort, makes it very easy for the end user
     * Users can still call other method if they like
     * @param A An int array to be sorted
     */
    public void quicksort(int[] A){
        quicksort(A, 0, A.length-1);
    }
    
    /**
     * Helper method for randomizedQuicksort, makes it very easy for the end user
     * Users can still call other method if they like
     * @param A An int array to be sorted
     */
    public void randomizedQuicksort(int[] A){
        randomizedQuicksort(A, 0, A.length-1);
    }
    
    /**
     * This method will recursively sort an array
     * Uses an exclusive upper bound and a randomized pivot
     * @param A an int array to be sorted
     * @param start start index
     * @param end end index
     */
    public void randomizedQuicksort(int[] A, int start, int end){
        
        //pivot splits the array
        int pivot;
        if (start < end){
            pivot = randomizedPartition(A, start, end);
            quicksort(A, start, pivot-1);
            quicksort(A, pivot+1, end);
        }        
    }

    /**
     * Partitions an array or subarray using a random pivot
     * @param A int array to be sorted
     * @param start start index
     * @param end end index
     * @return int 'pivot'
     */   
    private int randomizedPartition(int[] A, int start, int end){
        
        int random = rand.nextInt((end - start)+1) + start;
        
        //swap a random value with the A[end]
        int swap = A[end];
        A[end] = A[random];
        A[random] = swap;
        
        int x = A[end];
        int i = start-1;
        
        for (int j = start; j < end; j++){
            
            if (A[j] <= x){ //swap A[i] with A[j]
                i = i + 1;
                
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        //swap A[i+1] with A[end]
        int temp1 = A[i+1];
        A[i+1] = A[end];
        A[end] = temp1;
        
        return i + 1;     
    }
    
    
    /**
     * This method will recursively sort an array
     * Uses an exclusive upper bound
     * @param A an int array to be sorted
     * @param start start index
     * @param end end index
     */
    public void quicksort(int[] A, int start, int end){
        
        //pivot splits the array
        int pivot;
        if (start < end){
            pivot = partition(A, start, end);
            quicksort(A, start, pivot-1);
            quicksort(A, pivot+1, end);
        }
    }
    
    /**
     * Paritions an array or subarray using A[end] as pivot
     * @param A int array to be sorted
     * @param start start index
     * @param end end index
     * @return int 'pivot'
     */
    private int partition(int[] A, int start, int end) {
        
        int x = A[end];
        int i = start-1;
        
        for (int j = start; j < end; j++){
            
            if (A[j] <= x){ //swap A[i] with A[j]
                i = i + 1;
                
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }
        //swap A[i+1] with A[end]
        int temp1 = A[i+1];
        A[i+1] = A[end];
        A[end] = temp1;
        
        return i + 1;
        
    } 
    
    /**
     * 
     * @param A An int array to be printed
     */
    public void printArray(int[] A){
        
        for (int i: A){
            System.out.print(i+", ");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        


        int[] nums1 = {2,14,16,24,10};
        int[] nums2 = {1,5,4,7,8,34,16,9,2};
        int[] nums3 = {32, 25, 16, 98, 28, 87, 36, 5, 58, 21, 40, 71, 55, 21, 4, 52, 32, 51, 4, 44};
        int[] nums4 = {27, 5, 21, 51, 64, 88, 5, 77, 67, 87, 81, 17, 95, 88, 46, 32, 63, 76, 18, 83};
        int[] nums5 = {49, 52, 34, 47, 62, 71, 12, 6, 63, 87, 85, 94, 69, 55, 39, 46, 3, 70, 57, 65,
            67, 58, 84, 43, 21, 50, 93, 74, 96, 43, 20, 50, 7, 25, 77, 73, 12, 28, 9, 58, 30, 16, 23,
            48, 72, 22, 63, 73, 60, 99, 60, 80, 69, 58, 43, 16, 46, 37, 81, 5, 59, 61, 84, 14, 84, 19,
            98, 3, 45, 46, 25, 77, 50, 14, 29, 50, 54, 53, 1, 59};
        
        
        Quicksort qs = new Quicksort();
        
        System.out.print("Before: ");
        qs.printArray(nums1);
        qs.quicksort(nums1);
        System.out.print("\nAfter: ");
        qs.printArray(nums1);
        System.out.println();
        
        System.out.print("\nBefore:");
        qs.printArray(nums2);
        qs.quicksort(nums2);
        System.out.print("\nAfter: ");
        qs.printArray(nums2);
        System.out.println();
        
        System.out.print("\nBefore:");
        qs.printArray(nums3);
        qs.quicksort(nums3);
        System.out.print("\nAfter: ");
        qs.printArray(nums3);
        System.out.println(); 
        
        System.out.print("\nBefore:");
        qs.printArray(nums4);
        qs.quicksort(nums4);
        System.out.print("\nAfter: ");
        qs.printArray(nums4);
        System.out.println();    
        
        System.out.print("\nBefore:");
        qs.printArray(nums5);
        qs.quicksort(nums5);
        System.out.print("\nAfter: ");
        qs.printArray(nums5);
        System.out.println();
        
        System.out.println("");
        System.out.println("------------RANDOMIZED QUICKSORT BELOW ----------------");
        System.out.println("");
        
        int[] nums6 = {2,14,16,24,10};
        int[] nums7 = {1,5,4,7,8,34,16,9,2};
        int[] nums8 = {32, 25, 16, 98, 28, 87, 36, 5, 58, 21, 40, 71, 55, 21, 4, 52, 32, 51, 4, 44};
        int[] nums9 = {27, 5, 21, 51, 64, 88, 5, 77, 67, 87, 81, 17, 95, 88, 46, 32, 63, 76, 18, 83};
        int[] nums10 = {49, 52, 34, 47, 62, 71, 12, 6, 63, 87, 85, 94, 69, 55, 39, 46, 3, 70, 57, 65,
            67, 58, 84, 43, 21, 50, 93, 74, 96, 43, 20, 50, 7, 25, 77, 73, 12, 28, 9, 58, 30, 16, 23,
            48, 72, 22, 63, 73, 60, 99, 60, 80, 69, 58, 43, 16, 46, 37, 81, 5, 59, 61, 84, 14, 84, 19,
            98, 3, 45, 46, 25, 77, 50, 14, 29, 50, 54, 53, 1, 59};
        
        System.out.print("Before: ");
        qs.printArray(nums6);
        qs.randomizedQuicksort(nums6);
        System.out.print("\nAfter: ");
        qs.printArray(nums6);
        System.out.println();
        
        System.out.print("\nBefore:");
        qs.printArray(nums7);
        qs.randomizedQuicksort(nums7);
        System.out.print("\nAfter: ");
        qs.printArray(nums7);
        System.out.println();
        
        System.out.print("\nBefore:");
        qs.printArray(nums8);
        qs.randomizedQuicksort(nums8);
        System.out.print("\nAfter: ");
        qs.printArray(nums8);
        System.out.println(); 
                
        System.out.print("\nBefore:");
        qs.printArray(nums9);
        qs.randomizedQuicksort(nums9);
        System.out.print("\nAfter: ");
        qs.printArray(nums9);
        System.out.println();
        
        System.out.print("\nBefore:");
        qs.printArray(nums10);
        qs.randomizedQuicksort(nums10);
        System.out.print("\nAfter: ");
        qs.printArray(nums10);
        System.out.println(); 
    }


    
}
