public class DC2{

    //declearation of method in a class....
    public static int add(int a,int b){
        return a+b;
    }
    
    //main methdod where we do all coding.....
    public static void main (String args[]){
        System.out.println("Hello Again");
        String saurAdd = "lanak";
        System.out.println(saurAdd);
        int a = 5;
        int b = 6;
        System.out.println(a+b);

        //iterative statement...
        for(int i=0;i<5;i++){
            System.out.println(i);
        }
        int j=5;
        while(j!=0){
            System.out.println(j);
            j--;
            if(j==2){
                break;      // break statement
            }         
        }

        System.out.println("the sum is :-"+add(4,5));
    }
}
