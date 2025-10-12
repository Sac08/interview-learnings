# SOLID Principles – Interview Notes

SOLID is a set of **five design principles** introduced by Robert C. Martin (Uncle Bob) to make software **more maintainable, flexible, and scalable**.

---

## 1. S – Single Responsibility Principle (SRP)
**Definition:**  
A class should have **only one reason to change** → it should handle **only one responsibility**.

**Why:**
- Reduces coupling
- Easier to test & maintain
- Improves readability

**Java Example:**
```java
// ❌ Violates SRP
class Invoice {
    void calculateTotal() { /* logic */ }
    void saveToDB() { /* DB logic */ }
}

// ✅ Follows SRP
class Invoice {
    void calculateTotal() { /* logic */ }
}
class InvoiceRepository {
    void saveToDB(Invoice invoice) { /* DB logic */ }
}
```

---

## 2. O – Open/Closed Principle (OCP)
**Definition:**  
Classes should be **open for extension, closed for modification**.

**Why:**
- Prevents breaking existing functionality
- Encourages polymorphism & abstraction

**Java Example:**
```java
// ❌ Violates OCP
class AreaCalculator {
    double calculate(Object shape) {
        if (shape instanceof Circle) ...
        if (shape instanceof Rectangle) ...
        return 0;
    }
}

// ✅ Follows OCP
interface Shape { double area(); }

class Circle implements Shape { ... }
class Rectangle implements Shape { ... }

class AreaCalculator {
    double calculate(Shape shape) { return shape.area(); }
}
```

---

## 3. L – Liskov Substitution Principle (LSP)
**Definition:**  
Subtypes must be **substitutable for their base types**.
or
Subclasses should not break the behavior of the parent class

**Why:**
- Avoids surprises in polymorphic code
- Prevents fragile inheritance

**Java Example:**
❌ BAD - Violates LSP
```java
class Bird {
public void fly() {
System.out.println("Bird is flying");
}
}

class Ostrich extends Bird {
@Override
public void fly() {
// Ostrich can't fly!
throw new UnsupportedOperationException("Ostrich cannot fly");
}
}

// This breaks when using Ostrich as Bird
public void makeBirdFly(Bird bird) {
bird.fly(); // Throws exception if bird is Ostrich
}
```
✅ GOOD - Follows LSP
```java
abstract class Bird {
public abstract void move();
}

class Sparrow extends Bird {
@Override
public void move() {
System.out.println("Sparrow is flying");
}
}

class Ostrich extends Bird {
@Override
public void move() {
System.out.println("Ostrich is running");
}
}
```

// Works with any Bird subclass
public void makeBirdMove(Bird bird) {
bird.move(); // Works correctly for all birds
}

---

## 4. I – Interface Segregation Principle (ISP)
**Definition:**  
Clients should **not be forced to implement interfaces they don’t use**.

**Why:**
- Prevents “fat” interfaces
- Reduces unused methods

**Java Example:**
```java
// ❌ Violates ISP
interface Machine { void print(); void scan(); void fax(); }

// ✅ Follows ISP
interface Printer { void print(); }
interface Scanner { void scan(); }
interface Fax { void fax(); }
```

---

## 5. D – Dependency Inversion Principle (DIP)
**Definition:**
- High-level modules should not depend on low-level modules.
- Both should depend on **abstractions**.

**Why:**
- Reduces coupling
- Improves testability

**Java Example:**
```java
// ❌ Violates DIP
class Keyboard {}
class Monitor {}

class Computer {
    private Keyboard keyboard = new Keyboard();
    private Monitor monitor = new Monitor();
}


// ✅ Follows DIP
interface Keyboard {}
interface Monitor {}

class MechanicalKeyboard implements Keyboard {}
class LEDMonitor implements Monitor {}

class Computer {
    private final Keyboard keyboard;
    private final Monitor monitor;

    Computer(Keyboard keyboard, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
    }
}

```

---

## 📌 Quick Recap
- **SRP** → One class = one responsibility
- **OCP** → Extend without modifying
- **LSP** → Subtypes must behave like base types
- **ISP** → Many small interfaces > one fat interface
- **DIP** → Depend on abstractions, not concretions  
