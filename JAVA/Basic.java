
import java.util.Scanner;

public class Basic {
    public static void main(String[] args){
        System.out.println("Hello world");
        
        //variables(used to store a data)
        // int(4 byte), float(8 byte), double(8 byte), short(2 Byte), byte(1 Byte),
        //  String(multiple byte), char(1 Byte)
        // Double is considere default in java instead of float.
        String name = "Saurabh";
        Integer age = 25;
        int age2 = 23;
        byte by = 127;
        short sh = 558;
        long l = 5854L;
        float f = 24.00f;
        double d = 24.00;
        char c = 'd';
        boolean b = true;

        System.out.printf(
                "%s %d %d %d %d %d %.2f %.2f %c %b%n",
                name, age, age2, by, sh, l, f, d, c, b);

        //literals
        int num1 = 0b01;
        int num2 = 10_00_000;
        double num3 = 5;
        double num4 = 12e10;
        char c2 = 'a';
        c2++;
        System.out.println(num1+" "+num2+" "+num3+" "+num4+" "+ c2);

        //Type Casting and Type conversion....
        // big value can contain small value byte -> int, int -> double (conversion)  
        int a = 259;
        byte b2 = 127;
        int a2 = b2; // Implicit conversion
        byte b3 = (byte)a;    // type casting (when biger goes to smaller)
        //In type casting if bigger number exceeds small number range then it perform %(module)
        // on bigger number with it's largest value possible (for byte it is 127) & return the remainder
        System.out.println(a2+" "+b2+" "+b3);
        //Type promotion
        int result = b2*b2;
        System.out.println(result);

        //Arthemtic operation
        // + , -, *, /, %, +=, =+, =, -=, =-, ++, -- etc (similar operator)
        System.out.println(++result); //(pre-increment) -> first increment then assign.
        System.out.println(result++); //(post-increment) ->first assign then increment.

        //Relational operation (return boolean value)
        // ==, <=, >=, != 

        //logical operator
        // && , || , ! 

        //Conditional Statement
        // if, else, else if
        if(a>b2){
            System.out.println("if cond st.");
        }else if (a>b3) {
            System.out.println("else if cond st.");
        }else{
            System.out.println("else cond st.");
        }
        //terniary operator
        result = a%2==0 ? 10 : 20;
        System.out.println(result);

        // Scanner in Java to take input value
        int n;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
        }
        //Switch statement
        // rule switch
        //new ways to use switch
        //return the switch value
        String ans = switch (n){
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            default -> "No day";
        };
        //another-way without break statement
        ans = switch(n){
            case 1 : yield "Monday";
            case 2 : yield "tuesday";
            default : yield "No day";
        };

        System.out.println(ans);
         
        //loop statement (same as cpp)

        //class & Object in java
        //An object have some property and some behaviour.
        //A class can have multiple object having similar kind of behaviour.
        // Class -> 







        
        
        
       





    }
}


//Notes
// JVM - many languages run on it like kotin,scala, grovy
//Jshell - introduced in java9 used for single line code in java.
// (How a Java file execution happen) 
// You -> Java Code(.java) -> Javac(Compiler) -> Byte Code(.class) -> JVM -> OS -> Hardware.
// java is object oriented -> every thing should have class
// JVM(Java Virtual Machine) contained in a enviroment called JRE(Java Runtime Environment).
// JVM + some library = JRE 
// Java-> Strongly typed language (catagorigation of data)
// | Data Type         | Specifier | Example      |
// | ----------------- | --------- | ------------ |
// | `String`          | `%s`      | `"Hello"`    |
// | `int`, `Integer`  | `%d`      | `25`         |
// | `long`            | `%d`      | `123456789L` |
// | `float`, `double` | `%f`      | `24.00`      |
// | `char`            | `%c`      | `'A'`        |
// | `boolean`         | `%b`      | `true`       |
// | Hexadecimal       | `%x`      | `255 → ff`   |
// | Octal             | `%o`      | `10 → 12`    |
//

