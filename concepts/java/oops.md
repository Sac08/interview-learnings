mock interview on oops - https://claude.ai/chat/8d6696d1-31e9-4616-8bb2-78250b73b80b

1. Constructor Chaining in Inheritance
Context: Parent and Child classes, creating new Child()
Your mistake: Said only "Child constructor" prints
Correct: Parent constructor always executes first automatically
Parent constructor  ← Always first
Child constructor
2. Variable Access with Inheritance
Context: Parent has private int x, Child has private int x
Your mistake: Called it "override" and said super.x works
Correct: Variables get shadowed (not overridden), super.x fails because private members never inherited
3. Polymorphism with Reference Types
Context: Animal animal = new Dog(); animal.wagTail();
Your mistake: Thought it works because "it has instance of Dog"
Correct: Compilation error - compiler checks reference type (Animal), not object type (Dog)
Fix: Cast ((Dog) animal).wagTail()
4. Static Method Hiding vs Instance Method Overriding
Context: Animal animal = new Dog(); animal.staticMethod();
Your mistake: Expected Dog's static method to run
Correct:

Instance methods: Runtime binding → Dog's version runs
Static methods: Compile-time binding → Animal's version runs

5. Method Hiding Definition
Context: Explaining difference between overriding and hiding
Your mistake: "hiding details of method"
Correct: Method hiding = when child class static method hides parent's static method (no polymorphism)
Key: Reference type vs Object type matters differently for static vs instance!