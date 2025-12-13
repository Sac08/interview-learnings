The Factory Pattern provides a way to create objects without exposing the creation logic to the client. Instead of calling new directly, the client asks a factory class to give it the object.

🚨 Problems before Factory

Clients use new directly → tightly coupled to concrete classes.

Adding a new type (e.g., Triangle) requires changing everywhere the class is created.

Duplicate object creation logic scattered across code.

Violates Open/Closed Principle (code is open to modification). Adding new shapes involves only modifying or extending factory, not client.

Hard to manage runtime decisions (e.g., creating objects based on input/config).

✅ Why we move to Factory

Centralized object creation → only factory decides how to instantiate.

Clients depend only on interface (Shape), not concrete classes.

Easy to add new classes → only update factory, clients stay unchanged.

Supports runtime flexibility (factory can return objects based on user input, config, environment).

Improves maintainability & testability.