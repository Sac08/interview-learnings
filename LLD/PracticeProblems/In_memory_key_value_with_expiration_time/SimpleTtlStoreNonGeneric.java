package LLD.PracticeProblems.In_memory_key_value_with_expiration_time;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

/**
 * A simple in-memory Key-Value Store with TTL, using Object for non-generic storage.
 * NOTE: This requires manual casting on 'get' and is not type-safe.
 */
public class SimpleTtlStoreNonGeneric {

    // Helper class stores the value as an Object
    private static class CacheEntry {
        // The value is stored as a generic Object
        final Object value;
        final long expiryTimeMillis;

        public CacheEntry(Object value, long ttlSeconds) {
            this.value = value;
            this.expiryTimeMillis = System.currentTimeMillis() + (ttlSeconds * 1000);
        }
    }

    // Main storage: Key (Object) -> CacheEntry (contains Object value)
    private final Map<Object, CacheEntry> store = new HashMap<>();

    // Concurrency control: Read-Write lock
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    private final ScheduledExecutorService cleanerService;

    public SimpleTtlStoreNonGeneric() {
        this.cleanerService = Executors.newSingleThreadScheduledExecutor();
        this.cleanerService.scheduleAtFixedRate(this::activeCleanup, 5, 5, TimeUnit.SECONDS);
    }

    /**
     * Stores a key-value pair. Both key and value are stored as Objects.
     */
    public void set(Object key, Object value, long ttlSeconds) {
        writeLock.lock();
        try {
            store.put(key, new CacheEntry(value, ttlSeconds));
            System.out.println("SET: Key '" + key + "' stored with TTL of " + ttlSeconds + "s.");
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * Retrieves the value for a key. Returns an Object, which MUST be cast by the caller.
     * @return The value as an Object, or null if expired or not found.
     */
    public Object get(Object key) {
        readLock.lock();
        try {
            CacheEntry entry = store.get(key);
            if (entry == null) {
                return null;
            }

            // Lazy Deletion Check
            if (System.currentTimeMillis() > entry.expiryTimeMillis) {
                readLock.unlock(); // Release read lock to acquire write lock

                writeLock.lock();
                try {
                    // Double-check: ensure the key is still the one we saw
                    if (store.get(key) == entry) {
                        store.remove(key);
                        System.out.println("EXPIRED (Lazy): Key '" + key + "' removed.");
                    }
                } finally {
                    writeLock.unlock();
                }
                return null;
            }

            return entry.value; // Return the value as a raw Object
        } finally {
            if (lock.getReadHoldCount() > 0) {
                readLock.unlock();
            }
        }
    }

    /**
     * The background task to proactively remove expired keys.
     */
    private void activeCleanup() {
        writeLock.lock();
        try {
            long now = System.currentTimeMillis();

            // Remove entries where the expiry time is in the past
            store.entrySet().removeIf(entry -> {
                if (entry.getValue().expiryTimeMillis <= now) {
                    System.out.println("EXPIRED (Active): Key '" + entry.getKey() + "' removed by cleaner.");
                    return true;
                }
                return false;
            });

        } catch (Exception e) {
            System.err.println("Active Cleanup error: " + e.getMessage());
        } finally {
            writeLock.unlock();
        }
    }

    public void shutdown() {
        cleanerService.shutdown();
        System.out.println("Store shutdown initiated.");
    }
}