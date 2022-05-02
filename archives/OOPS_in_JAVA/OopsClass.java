package OOPS_in_JAVA;

public class OopsClass {
    public static void main(String[] args) {
        // We create a new object here called p1.
        Person p1 = new Person(); // a new person
        p1.age = 10;
        p1.name = "Asshis";
        
        Developer d1 = new Developer(24, "Vishal");
        d1.die(30);
    }
}




// Static: 
// We can make class properties using static. We do need to create an object for it.

// This doesn't take part in runtime as long as it doesn't have any objects. 
// With this person we can make multiple persons

// Constructors: 
// When we need to initialise our properties we also use the constructors. 

// this() keyword is used when we need to call one constructor from another constructor. 
// so from this() we can call all other constructors from the class  


// Inheritance: 

// child class
class Developer extends Person
{
    // super is used to call the constructors fot he parent class
    public Developer(int age, String name)
    {
        super(age, name);
    }
}

class Person
{

    public Person()
    {
        System.out.println("Creating an object");
    }

    public Person(int age, String name)
    {
        this.name = name;
        this.age = age;
    }
    // Properties
    String name;
    int age;
    static int count; // a class property
    // Behaviour / Methods

    // Compile time Polymorphism
    void walk()
    {
        System.out.println(name + "is walking");
    }
    void walk(int steps)
    {
        System.out.println(name + "walked" + steps);
    }
    // Constructors
    void die(int x)
    {
        System.out.println("Developer will die in " + x + " days");
    }
     

}
