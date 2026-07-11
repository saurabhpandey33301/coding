public class DataStructure {
    public static void main(String[] args) {
        System.out.println("Welcome to Data structure file");

        //Array -> store multiple values of a common type (like int, String)
        int[] arr = {1,2,3};
        int[] arr2 = new int[4]; // by default all ele will be zero.
        for (int idx = 0; idx < arr.length; idx++) {
            int val = arr[idx];
            System.out.println("This is "+idx+" index value: "+val);
            
        }
        

    }
}
