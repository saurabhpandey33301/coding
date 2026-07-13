/*
    Access Modifiers in Java

    There are four access modifiers:

    1. private   -> Accessible only within the same class.
    2. default   -> Accessible only within the same package.
                    (No keyword is used.)
    3. protected -> Accessible within the same package and
                    outside the package through inheritance.
    4. public    -> Accessible from anywhere in the project.

    Accessibility Table

    -------------------------------------------------------------
    Modifier      Same Class   Same Package   Subclass   Anywhere
    -------------------------------------------------------------
    private           ✔             ✖            ✖          ✖
    default           ✔             ✔            ✖*         ✖
    protected         ✔             ✔            ✔          ✖
    public            ✔             ✔            ✔          ✔
    -------------------------------------------------------------

    *Default members are NOT accessible in subclasses if the
     subclass is in a different package.
*/

class AccessClass {

    // Accessible only inside this class.
    private int privateVar = 10;

    // Accessible everywhere.
    public int publicVar = 20;

    // Accessible within the package and in subclasses.
    protected int protectedVar = 30;

    // Default (package-private) access.
    // Accessible only within the same package.
    int defaultVar = 40;

    // Method inside the same class can access everything.
    public void display() {
        System.out.println("private   : " + privateVar);
        System.out.println("public    : " + publicVar);
        System.out.println("protected : " + protectedVar);
        System.out.println("default   : " + defaultVar);
    }
}

public class AccessModifierLearn {

    public static void main(String[] args) {

        System.out.println("=== Java Access Modifiers ===\n");

        AccessClass obj = new AccessClass();

        // ✅ Accessible
        System.out.println("Public Variable    : " + obj.publicVar);

        // ✅ Accessible (same package)
        System.out.println("Protected Variable : " + obj.protectedVar);

        // ✅ Accessible (same package)
        System.out.println("Default Variable   : " + obj.defaultVar);

        // ❌ Compile-time Error
        // System.out.println(obj.privateVar);

        // Method inside the class can access everything.
        obj.display();
    }
}


// Top-level classes can only be public or default.
// Constructors can have any access modifier.
// Private methods are not inherited.
// protected does not mean "accessible from every subclass instance"—outside 
// the package, access is only through inheritance, not arbitrary object references.
// Java follows the principle of least privilege: make members private by default
//  and only widen access when necessary.