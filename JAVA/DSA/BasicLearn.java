import java.util.ArrayList;
import java.util.Scanner;


/*
 * ==========================================================
 *  JAVA BASICS — BEGINNER LEARNING FILE
 * ==========================================================
 *
 * MEMORY MODEL (important to visualize as you read the code):
 * - Every time you create an object with "new", its instance
 *   variables (fields) are stored in the HEAP.
 * - Every time a method is called, a new STACK FRAME is
 *   created for it, holding its local variables and parameters.
 *   That frame is destroyed when the method returns.
 * - A reference variable (e.g. Calculator cal) itself lives on
 *   the stack, but it just POINTS to the object's data on the heap.
 */

// A simple class to demonstrate objects, methods, and overloading
class Calculator {

    // Instance variable (would live in the heap, one copy per object)
    // int a = 5;

    // Method: adds two ints. n1 and n2 are LOCAL variables (stack).
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public int sub(int n1, int n2) {
        return n1 - n2;
    }

    // METHOD OVERLOADING:
    // Same method name "add", but a different parameter list
    // (here: three ints instead of two). Java decides which
    // version to call based on the arguments you pass.
    public int add(int n1, int n2, int n3) {
        return n1 + n2 + n3;
    }

    // Overloading also works with different parameter TYPES
    public double add(double n1, double n2) {
        return n1 + n2;
    }

    // CONSTRUCTOR: a special method with no return type, same
    // name as the class. It runs automatically when you do
    // "new Calculator()". Since we didn't write one before,
    // Java was silently using a default empty constructor.
    public Calculator() {
        System.out.println("Calculator object created!");
    }
}

public class BasicLearn {
    public static void main(String[] args) {
        System.out.println("Hello world");

        // ----------------------------------------------------
        // 1. VARIABLES & PRIMITIVE DATA TYPES
        // ----------------------------------------------------
        // byte   -> 1 byte   (-128 to 127)
        // short  -> 2 bytes  (-32,768 to 32,767)
        // int    -> 4 bytes  (most commonly used whole number type)
        // long   -> 8 bytes  (needs an 'L' suffix for big literals)
        // float  -> 4 bytes  (needs an 'f' suffix)
        // double -> 8 bytes  (DEFAULT type for decimal numbers in Java)
        // char   -> 2 bytes  (single character, in single quotes)
        // boolean-> true/false only
        // String -> NOT a primitive! It's a class/object (multiple bytes)

        String name = "Saurabh";
        Integer age = 25;      // "Integer" = wrapper class (object) version of int
        int age2 = 23;         // "int" = primitive version (this is what you use 95% of the time)
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

        // NOTE on Integer vs int (very important as a beginner):
        // - int is a primitive: fast, stored directly, cannot be null.
        // - Integer is a wrapper CLASS around int: it's an object,
        //   can be null, and is required when you use collections
        //   like ArrayList<Integer> (collections cannot hold primitives).
        // - Java automatically converts between them (this is called
        //   "autoboxing" / "unboxing"), e.g. Integer age = 25; works
        //   because Java silently does Integer.valueOf(25).

        // ----------------------------------------------------
        // 2. LITERALS (different ways to write constant values)
        // ----------------------------------------------------
        int num1 = 0b01;        // binary literal (starts with 0b)
        int num2 = 10_00_000;   // underscores allowed for readability (= 1000000)
        double num3 = 5;        // int literal auto-converted to double
        double num4 = 12e10;    // scientific notation (12 * 10^10)
        char c2 = 'a';
        c2++;                   // chars can be incremented like numbers (uses ASCII/Unicode value)
        System.out.println(num1 + " " + num2 + " " + num3 + " " + num4 + " " + c2);

        // ----------------------------------------------------
        // 3. TYPE CASTING & TYPE CONVERSION
        // ----------------------------------------------------
        // Implicit conversion (widening): small type -> big type, automatic, safe.
        // Explicit casting (narrowing): big type -> small type, you must write (type), may lose data.
        int a = 259;
        byte b2 = 127;
        int a2 = b2;              // implicit conversion (byte -> int, always safe)
        byte b3 = (byte) a;       // explicit cast (int -> byte, can overflow!)
        // If the value is too big for the target type, Java wraps it using
        // modulo-like arithmetic on the type's range, so the result can look
        // like "garbage" — this is a classic beginner bug source.
        System.out.println(a2 + " " + b2 + " " + b3);

        // Type promotion: in an expression, smaller types are automatically
        // promoted to a bigger type before the operation happens.
        int result = b2 * b2; // byte * byte is promoted to int automatically
        System.out.println(result);

        // ----------------------------------------------------
        // 4. OPERATORS
        // ----------------------------------------------------
        // Arithmetic: + - * / % += -= *= /= ++ --
        System.out.println(++result); // pre-increment: increment FIRST, then use the value
        System.out.println(result++); // post-increment: use the value FIRST, then increment

        // Relational (always return boolean): == != > < >= <=
        // Logical: && (AND)  || (OR)  ! (NOT)
        boolean check = (a > 10) && (b2 < 200); // both sides must be true for &&
        System.out.println("Logical AND result: " + check);

        // ----------------------------------------------------
        // 5. CONDITIONAL STATEMENTS
        // ----------------------------------------------------
        if (a > b2) {
            System.out.println("if condition");
        } else if (a > b3) {
            System.out.println("else if condition");
        } else {
            System.out.println("else condition");
        }

        // Ternary operator: condition ? valueIfTrue : valueIfFalse
        result = a % 2 == 0 ? 10 : 20;
        System.out.println(result);

        // ----------------------------------------------------
        // 6. TAKING INPUT WITH SCANNER
        // ----------------------------------------------------
        // "try (...) { }" here is a try-with-resources block — it
        // automatically closes the Scanner for you when done, so you
        // don't need to manually call sc.close().
        int n;
        System.out.println("Enter a number between 1 and 7 (for the switch demo below): ");
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
        }

        // ----------------------------------------------------
        // 7. SWITCH STATEMENT (modern Java style)
        // ----------------------------------------------------
        // Old-style switch used ":" and needed "break;" after every case,
        // otherwise execution would "fall through" into the next case.
        // Modern Java (14+) lets you use "->" and it auto-breaks — no
        // fall-through bugs, and it can directly return/assign a value.
        String ans = switch (n) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "No day";
        };
        System.out.println("Arrow-style switch result: " + ans);

        // Same idea, but using "yield" when you need a code block
        // instead of a single expression per case.
        ans = switch (n) {
            case 1: yield "Monday";
            case 2: yield "Tuesday";
            default: yield "No day";
        };
        System.out.println("Yield-style switch result: " + ans);

        // ----------------------------------------------------
        // 8. LOOPS (syntax is basically identical to C++)
        // ----------------------------------------------------
        // for loop
        for (int i = 0; i < 3; i++) {
            System.out.println("for loop iteration: " + i);
        }
        // while loop
        int w = 0;
        while (w < 2) {
            System.out.println("while loop iteration: " + w);
            w++;
        }
        // do-while loop (runs body at least once, checks condition after)
        int dw = 0;
        do {
            System.out.println("do-while iteration: " + dw);
            dw++;
        } while (dw < 1);

        // ----------------------------------------------------
        // 9. ARRAYS (fixed size, zero-indexed, like C++)
        // ----------------------------------------------------
        int[] numbers = {10, 20, 30, 40};
        System.out.println("Array length: " + numbers.length); // .length is a field, no parentheses
        for (int num : numbers) {          // for-each loop
            System.out.println("Array value: " + num);
        }

        // ----------------------------------------------------
        // 10. STRINGS (Strings are IMMUTABLE — every change makes a new object)
        // ----------------------------------------------------
        String greeting = "Hello";
        String changed = greeting + " World";   // this creates a NEW String object
        System.out.println(greeting + " | " + changed);
        System.out.println("Length: " + greeting.length());
        System.out.println("Upper: " + greeting.toUpperCase());
        System.out.println("Equals check (never use =='): " + greeting.equals("Hello"));

        // ----------------------------------------------------
        // 11. CLASSES & OBJECTS
        // ----------------------------------------------------
        // A class is a blueprint. An object is an actual instance
        // built from that blueprint, with its own copy of the data.
        Calculator cal = new Calculator(); // "new" triggers the constructor above
        System.out.println(cal.add(3, 4));
        System.out.println(cal.add(3, 4, 5));   // calls the 3-argument overload
        System.out.println(cal.add(3.5, 4.5));  // calls the double overload

        // ----------------------------------------------------
        // 12. A QUICK LOOK AT COLLECTIONS (beyond arrays)
        // ----------------------------------------------------
        // ArrayList = a resizable array (like C++'s vector).
        // Unlike arrays, it can grow/shrink, but it can only hold
        // OBJECTS, so we use the wrapper class Integer, not int.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0); // removes the element at index 0 (removes value "1")
        System.out.println("ArrayList after removal: " + list);

        // ----------------------------------------------------
        // 13. BASIC EXCEPTION HANDLING (try/catch)
        // ----------------------------------------------------
        // Java forces you to handle certain errors gracefully instead
        // of crashing the whole program. This is called an "exception".
        try {
            int badResult = 10 / 0; // this will throw ArithmeticException
            System.out.println(badResult);
        } catch (ArithmeticException e) {
            System.out.println("Caught an error: " + e.getMessage());
        } finally {
            System.out.println("This 'finally' block always runs, error or not.");
        }
    }
}

/*
 * ==========================================================
 *  EXTRA NOTES FOR BEGINNERS
 * ==========================================================
 *
 * COMPILE & RUN:
 *   javac Basic.java     -> compiles Basic.java into Basic.class (bytecode)
 *   java Basic            -> runs the compiled class on the JVM
 *
 * WHAT HAPPENS UNDER THE HOOD:
 *   You write Java code (.java)
 *     -> javac (the compiler) turns it into bytecode (.class)
 *       -> the JVM (Java Virtual Machine) reads that bytecode
 *         -> the JVM talks to the OS/hardware to actually run it
 *   This is why Java is "write once, run anywhere" — the same
 *   .class file runs on any machine that has a JVM installed,
 *   regardless of OS.
 *
 * JVM vs JRE vs JDK (layers, from bottom to top):
 *   JVM (Java Virtual Machine)   -> actually executes bytecode
 *   JRE (JVM + core libraries)   -> what you need to RUN Java programs
 *   JDK (JRE + compiler + tools) -> what you need to WRITE & compile Java programs
 *   Other languages (Kotlin, Scala, Groovy) also compile down to
 *   JVM bytecode and can run on the same JVM.
 *
 * JShell:
 *   Introduced in Java 9. A REPL (Read-Eval-Print-Loop) that lets
 *   you run single lines of Java instantly without writing a whole
 *   class — great for quickly testing small snippets.
 *
 * WHY EVERYTHING IS INSIDE A CLASS:
 *   Java is a purely object-oriented language, so unlike C++,
 *   there's no "loose" function floating outside a class — even
 *   main() must live inside a class.
 *
 * printf FORMAT SPECIFIERS CHEAT SHEET:
 *   | Data Type          | Specifier | Example       |
 *   |---------------------|-----------|---------------|
 *   | String              | %s        | "Hello"       |
 *   | int, Integer        | %d        | 25            |
 *   | long                | %d        | 123456789L    |
 *   | float, double       | %f        | 24.00         |
 *   | char                | %c        | 'A'           |
 *   | boolean             | %b        | true          |
 *   | Hexadecimal (int)   | %x        | 255 -> ff     |
 *   | Octal (int)         | %o        | 10  -> 12     |
 *
 * NEXT TOPICS TO LEARN AFTER THIS FILE:
 *   1. static vs instance members (why "main" is static)
 *   2. Inheritance, interfaces, and polymorphism
 *   3. HashMap / HashSet / TreeMap (used constantly in real code)
 *   4. Exception hierarchy: checked vs unchecked exceptions
 *   5. Generics (the <Integer> style syntax you saw in ArrayList)
 */
