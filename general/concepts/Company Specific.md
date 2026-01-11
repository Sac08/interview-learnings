# Testing at my org

Unit test 
- test driven development 
- small unit testing
- integrated with sonar & added check in PR build flow for mandatory 80% coverage
- JUnit

Integration Testing
- multiple small units together testing 
- eg. Testing the complete API that involves DB integration for metadata API
- aces csv ingestion flow
- tools :existing test framework  

E2E Testing 
- complete end to end flow
- selenium automation : upload file from UI & check for its status

Regression Testing:
- Re-running existing test suite after adding new "Apply Coupon" feature to ensure checkout still works
- manual regression test

Performance/Load Testing 
- simulating thousands of concurrant users & aggressively test the API's
- response times like p90, p99 failure rate etc
- tools : automaton

A/B Testing
- was involved in one feature, multiple teams
- at site, the feature was rolled out to specific users and disabled for few
- helps in effectiveness of feature


---------------

# How I review my PR:

The 5-Point PR Review Template
1. LOGIC & EDGE CASES ⚠️ (Most Critical)
Null checks missing?
Empty list/array handling?
Negative numbers where only positive expected?
Division by zero?

2. ERROR HANDLING 🔴
Try-catch blocks missing?
Generic error messages?
What if external API/database fails?

3. TESTS ✅
Are there tests for new code?
Only happy path tested?
Edge cases tested?

4. SECURITY 🔒
SQL queries using string concatenation?
Passwords/API keys hardcoded?
User input not validated?
Sensitive data in logs?


5. PERFORMANCE ⚡
Database query inside a loop?
Loading all records when only few needed?
Same API call repeated multiple times?

6. Generic
Check commit history for meaningful names, check PR if its lengthy ask to breakdown next time, commits to include jira ticket id ?
hardcoded value ? 
meaningful name ? 
missing comments ?
testName meaningful ?
class names & function names same accross everywhere ?
long function ? 
SOLID principles ? 



-------
1. LOGIC & EDGE CASES ⚠️
Null checks missing – user.getName().length() without checking user or name
Empty list or array handling – list.get(0) when list can be empty
Negative numbers where only positive expected – pageSize = -1 not validated
Division by zero – total / count when count can be 0

2. ERROR HANDLING 🔴
Try-catch blocks missing – file read or DB call without handling IOException/SQLException
Generic error messages – throwing RuntimeException("Error occurred")
External API or database failure not handled – payment API timeout not retried or handled

3. TESTS ✅
No tests for new code – new service added without test class
Only happy path tested – valid input tested, invalid input ignored
Edge cases tested – zero, null, negative values covered in tests

4. SECURITY 🔒
SQL queries using string concatenation – "SELECT * FROM users WHERE id=" + id
Passwords or API keys hardcoded – apiKey = "abc123"
User input not validated – directly parsing request parameters
Sensitive data in logs – logging passwords, tokens, card numbers

5. PERFORMANCE ⚡
Database query inside loop – querying DB for each item in a list
Loading all records when few needed – findAll() then filtering
Same API call repeated multiple times – calling config or rate service in loop

6. GENERIC CODE & PR HYGIENE 🧹
Commit history meaningful – commits like "fix bug" instead of "JIRA-123 fix NPE"
PR too large – 1000+ lines touching multiple modules
Jira ticket id included – missing JIRA reference in commits
Hardcoded values – retryCount = 3 inside code
Meaningful variable and method names – x, temp, doStuff()
Missing comments – complex bitwise or business logic without explanation
Test names meaningful – test1(), testCaseA()
Consistent class and method naming – getUser vs fetchUser vs findUser
Long functions – single method with 200+ lines
SOLID principles followed – service doing validation, DB, and notification together
-----

more : https://claude.ai/chat/97f4fcbe-6102-4f03-bc72-e18dc8331391
--------------

https://claude.ai/chat/ee6744d8-8ad5-4478-9518-5825fca92e6d