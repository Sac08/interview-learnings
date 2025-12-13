package LLD.PracticeProblems.TokenBucketRateLimiter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Low-Level Design Implementation of a Rate Limiter using the Token Bucket Algorithm.
 */
public class TokenBucketRateLimiter {

    // --- 1. Data Structure for the Bucket State ---
    private static class TokenBucket {
        double tokens;             // Current number of available tokens
        long lastRefillTime;       // Last time the tokens were refilled (Unix milliseconds)

        public TokenBucket(double capacity) {
            this.tokens = capacity;
            this.lastRefillTime = System.currentTimeMillis();
        }
    }

    // --- 2. Main Rate Limiter Fields ---

    // Key: Client ID (e.g., User ID, IP Address), Value: TokenBucket state
    private final Map<String, TokenBucket> buckets = new HashMap<>();

    // Rate Limiting parameters
    private final int RATE_LIMIT_RPS; // R: Tokens added per second
    private final int CAPACITY_C;     // C: Maximum number of tokens the bucket can hold

    // Concurrency Lock for mutual exclusion over the 'buckets' map
    private final Lock lock = new ReentrantLock();

    /**
     * Constructor
     * @param rps The rate limit (e.g., 10 for 10 requests per second)
     * @param capacity The maximum burst capacity (usually set equal to rps)
     */
    public TokenBucketRateLimiter(int rps, int capacity) {
        this.RATE_LIMIT_RPS = rps;
        this.CAPACITY_C = capacity;
        System.out.printf("Rate Limiter initialized: %d RPS with capacity %d.%n", rps, capacity);
    }

    // --- 3. Core Logic: Refill and Check ---

    /**
     * Attempts to consume one token. If successful, the request is allowed.
     * @param clientId The unique identifier for the client (e.g., "user_123").
     * @return true if the request is allowed, false if rate limited.
     */
    public boolean allowRequest(String clientId) {
        lock.lock(); // Acquire lock for atomicity
        try {
            // Get or create the bucket for the client
            TokenBucket bucket = buckets.computeIfAbsent(clientId,
                    k -> new TokenBucket(CAPACITY_C)
            );

            // Crucial: Refill tokens before checking
            refillTokens(bucket);

            if (bucket.tokens >= 1) {
                // Consume a token and allow the request
                bucket.tokens -= 1;
                return true;
            } else {
                // No tokens left, deny the request
                return false;
            }

        } finally {
            lock.unlock(); // Always release the lock
        }
    }

    /**
     * Refills the token bucket based on the time elapsed since the last update.
     * This method is called under a lock, so no external synchronization is needed.
     */
    private void refillTokens(TokenBucket bucket) {
        long currentTime = System.currentTimeMillis();
        long timeElapsed = currentTime - bucket.lastRefillTime;

        // Calculate tokens to add: (Time elapsed in seconds) * (Rate per second)
        // Note: Using 1000.0 ensures floating-point division
        double tokensToAdd = timeElapsed * (RATE_LIMIT_RPS / 1000.0);

        // Add tokens, but cap the total at the bucket capacity (C)
        bucket.tokens = Math.min(bucket.tokens + tokensToAdd, CAPACITY_C);

        // Update the last successful refill time (prevents accumulated debt)
        bucket.lastRefillTime = currentTime;
    }

    // --- 4. Example Usage/Demo ---

    public static void main(String[] args) throws InterruptedException {
        // Set up a rate limit of 5 requests per second (RPS) with capacity 5
        final TokenBucketRateLimiter limiter = new TokenBucketRateLimiter(5, 5);
        final String userId = "user_A";

        System.out.println("\n--- Burst Test (5 requests allowed instantly) ---");

        // Burst 7 requests
        for (int i = 1; i <= 7; i++) {
            boolean allowed = limiter.allowRequest(userId);
            if (allowed) {
                System.out.printf("Request %d: ALLOWED (Tokens left: %.2f)%n", i, limiter.buckets.get(userId).tokens);
            } else {
                System.out.printf("Request %d: DENIED (Rate Limited)%n", i);
            }
        }

        System.out.println("\n--- Refill Test (Waiting 1 second should refill all tokens) ---");

        // Wait for 1 second (should refill 5 tokens)
        TimeUnit.SECONDS.sleep(1);

        // Try 2 more requests
        for (int i = 8; i <= 9; i++) {
            boolean allowed = limiter.allowRequest(userId);
            if (allowed) {
                System.out.printf("Request %d: ALLOWED (Tokens left: %.2f)%n", i, limiter.buckets.get(userId).tokens);
            } else {
                System.out.printf("Request %d: DENIED (Rate Limited)%n", i);
            }
        }
    }
}
