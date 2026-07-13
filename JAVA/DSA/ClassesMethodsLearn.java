
// =========================================================
// TOPIC: Classes, Objects, Static vs Instance Members
// =========================================================
//
// KEY CONCEPT: Class Loading vs Object Instantiation
// - A class is loaded into the JVM's Class Loader ONLY ONCE,
//   the very first time it is referenced (either by creating
//   an object, accessing a static member, or via Class.forName()).
// - Loading order per class (happens once):
//      1. Static variables get default values
//      2. Static blocks & static variable initializers run,
//         IN THE ORDER they appear in the source code
// - Object creation order (happens EVERY time "new" is used):
//      1. Instance variables get default values
//      2. Instance initializer blocks & instance variable
//         initializers run, in source order
//      3. Constructor body runs

class Mobile {

    int price;          // Instance variable -> new copy per object
    String brand;       // Instance variable -> new copy per object

    static String name; // Static variable -> ONE copy shared by ALL objects
                         // Belongs to the class, not to any single object

    static int totalMobilesCreated = 0; // NEW: static counter, useful
                                         // real-world example of static state

    // ---- Static Initializer Block ----
    // Runs ONCE, when the class is first loaded (before any object exists)
    static {
        name = "Phones";
        System.out.println("[Static Block] Class 'Mobile' loaded into memory");
    }

    // ---- Instance Initializer Block (NEW) ----
    // Runs EVERY TIME an object is created, right before the constructor body.
    // Rarely used in practice (constructors are preferred), but good to know it exists.
    {
        totalMobilesCreated++;
        System.out.println("[Instance Block] Creating Mobile #" + totalMobilesCreated);
    }

    // ---- Constructor ----
    // Not called "Constructure" -> corrected spelling.
    // Called automatically when you do: new Mobile(...)
    public Mobile(int price, String brand) {
        this.price = price;  // "this" refers to the CURRENT object being built
        this.brand = brand;  // disambiguates instance variable from parameter
        System.out.println("[Constructor] Mobile created -> " + brand);
    }

    // ---- Constructor Overloading (NEW) ----
    // Same method name (constructor), different parameter list.
    // Lets you create a Mobile with just a brand, using a default price.
    public Mobile(String brand) {
        this(0, brand); // "this(...)" calls the OTHER constructor -> avoids code duplication
        System.out.println("[Constructor Overload] Created with default price");
    }

    // Instance method -> needs an object to be called on (m1.show())
    // Can access BOTH instance variables (price, brand) AND static variables (name)
    public void show() {
        System.out.println("Price: " + price);
        System.out.println("Brand: " + brand);
        System.out.println("Name: " + name);
        System.out.println("-----------------------");
    }

    // ---- Static Method ----
    // You CAN use static variables/methods inside a static method.
    // You CANNOT use non-static (instance) variables directly inside a static
    // method, because a static method can be called WITHOUT any object
    // existing at all (e.g. Mobile.Greet() before any "new Mobile()").
    // The JVM would have no idea WHICH object's price/brand to use.
    public static void greet() { // renamed to lowercase -> Java convention:
                                  // methods start with a lowercase letter
        System.out.println("Hello Customer of " + name);
    }

    // ---- toString() Override (NEW) ----
    // Called automatically when you print an object directly,
    // e.g. System.out.println(m1) instead of m1.show()
    // @Override
    // public String toString() {
    //     return brand + " (" + price + ")";
    // }
}


public class ClassesMethodsLearn {
    public static void main(String[] args) {
        System.out.println("Welcome to Learn about Classes & Methods in Java");
        System.out.println("=================================================");

        // First time "Mobile" is referenced -> class loads -> static block runs ONCE
        Mobile m1 = new Mobile(10000, "Iphone");
        m1.show();

        Mobile m2 = new Mobile(8000, "Realme");

        // BAD PRACTICE (but compiles): accessing static via an object reference.
        // Java allows it, but it's misleading -> looks like a per-object change
        // when it's actually changing the ONE shared copy for every object.
        m2.name = "Sa";

        // GOOD PRACTICE: access static members through the class name
        Mobile.name = "SmartPhones";
        // Once changed, ALL objects see the new value, because there's only
        // ever one "name" in memory, no matter how many Mobiles exist.
        m2.show();

        Mobile.greet(); // static method called through the class name -> preferred style

        Mobile m3 = new Mobile(6000, "Redme");
        m3.show();

        // Using the overloaded constructor
        Mobile m4 = new Mobile("Nokia");
        m4.show();

        // Using toString() via println
        System.out.println("m4 as string: " + m4);

        // Static counter proves the instance block ran for every object
        System.out.println("Total Mobiles Created: " + Mobile.totalMobilesCreated);

        // Class.forName("Mobile"); // Would also trigger class loading (and static
        // block) via reflection, WITHOUT creating any object -> proves loading
        // and instantiation are separate events.
    }
}

/*
 * EXPECTED OUTPUT ORDER (trace this yourself to test your understanding):
 *
 * Welcome to Learn about Classes & Methods in Java
 * =================================================
 * [Static Block] Class 'Mobile' loaded into memory     <- only ever prints ONCE
 * [Instance Block] Creating Mobile #1
 * [Constructor] Mobile created -> Iphone
 * Price: 10000
 * Brand: Iphone
 * Name: Phones
 * -----------------------
 * [Instance Block] Creating Mobile #2
 * [Constructor] Mobile created -> Realme
 * Price: 8000
 * Brand: Realme
 * Name: SmartPhones          <- changed by BOTH m2.name and Mobile.name, shared value
 * -----------------------
 * Hello Customer of SmartPhones
 * [Instance Block] Creating Mobile #3
 * [Constructor] Mobile created -> Redme
 * Price: 6000
 * Brand: Redme
 * Name: SmartPhones
 * -----------------------
 * [Instance Block] Creating Mobile #4
 * [Constructor] Mobile created -> Nokia
 * [Constructor Overload] Created with default price
 * Price: 0
 * Brand: Nokia
 * Name: SmartPhones
 * -----------------------
 * m4 as string: Nokia (0)
 * Total Mobiles Created: 4
 */