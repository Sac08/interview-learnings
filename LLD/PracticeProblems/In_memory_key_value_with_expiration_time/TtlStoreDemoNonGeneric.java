package LLD.PracticeProblems.In_memory_key_value_with_expiration_time;

public class TtlStoreDemoNonGeneric {
    public static void main(String[] args) throws InterruptedException {
        SimpleTtlStoreNonGeneric cache = new SimpleTtlStoreNonGeneric();

        // Storing a String
        cache.set("username", "Alice", 10);

        // Storing an Integer
        cache.set(123, 42, 5);

        Thread.sleep(6000);

        // --- Retrieval Requires Casting ---

        // Correct retrieval of String
        String name = (String) cache.get("username");
        System.out.println("Retrieved name: " + name);

        // Correct retrieval of Integer
        Integer number = (Integer) cache.get(123);
        System.out.println("Retrieved number: " + number);

        // !!! DANGER: Incorrect cast leads to a runtime crash (ClassCastException) !!!
        try {
            // Trying to cast the stored String "Alice" into an Integer
            Integer wrongCast = (Integer) cache.get("username");
            System.out.println("This line will not be reached.");
        } catch (ClassCastException e) {
            System.err.println("\nERROR: ClassCastException occurred! " +
                    "The compiler couldn't catch this error.");
        }

        cache.shutdown();
    }
}