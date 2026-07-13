

class Human
{
    private int age;
    private String name;    // private instance variables

    public Human(){              // default contructor  // Example of method overlaoding.
        age = 24;
        name = "saurabh";
    }

    public Human(int age, String name){   //Parameterized contructor //Example of method overloading.
        this.age = age;
        this.name = name;
    }

    public int getAge() {   // Getter method
        return age;
    }

    public void setAge(int age) {         //Setter method
        this.age = age; // this is keyboard representing current obj.
    }

    public String getName() {        //Getter method
        return name;
    }

    public void setName(String name) {      //Setter method
        this.name = name;
    }
   
}


class AdvanceCalc extends Calculator{
    int mul(int a,int b){
        return a*b;
    }
    int div(int a,int b){
        return a/b;
    }
}

class ScientifCalc extends AdvanceCalc{
    double power(int num, int expo){
        return Math.pow(num,expo);
    }
}

class ClassA extends Object{  // every class by default extends(Inherit) to Object class in Java
      
    public ClassA(){
        super();
        System.out.println("I am in A");
    }
    public ClassA(int a){
        super();
        System.out.println("I am in A with "+a);
    }
    public void show(){
        System.out.println("show of A");
    }
}

class ClassB extends ClassA{

    public ClassB(){
        super();
        System.out.println("I am in B");
    }
    public ClassB(int a){
        //super(a);  // call constructer of parent class // it is hidden by default
        this();  // envoke constructor of the same class
        System.out.println("I am in B with "+a);
    }
    //method overriding
    public void show(){
        System.out.println("Show of B");
    }
}

public class OopsLearn {
    public static void main(String[] args) {
        System.out.println("Welcome to learning Opps in Java");
        
        // Encapsulation (keeping it tight)
        // Encapsulating the data & methods 
        Human h1 = new Human();    // calling default constructor
        // h1.setAge(20);
        // h1.setName("Saurabh");
        System.out.println(h1.getName()+":"+h1.getAge());
        Human h2 = new Human(12,"Simran"); //calling parametrized constructor
        System.out.println(h2.getName()+":"+h2.getAge());

        // Inheritance 
        // Inheritance means when child class/derived inhert the property of the parent/base class. 
        // ScientifCalc->AdvanceCalc->Calculator 
        // Java does not support multiple-Inheritence to reduce ambiguity. 
        // Class A extends B,C {} (don't work)
        AdvanceCalc advCal = new AdvanceCalc();
        advCal.add(3, 4);  // calling method of it's parent class
        advCal.mul(3, 4); // calling method of it's own class
        ScientifCalc scCal = new ScientifCalc();
        scCal.power(2, 2); //own class method
        scCal.mul(2, 2); // Immediate parent class
        scCal.add(2, 2);  // super-parent class

        ClassB cb = new ClassB(2);  // to see constructor class & super()
        cb.show(); // caling overrided method show of A that is present in B
        
        //Polymorphism
        // poly -> Many ; morphism -> Behaviour
        // Compiler time polymorphism
        // Run time polymorphism.
        








    }
}
