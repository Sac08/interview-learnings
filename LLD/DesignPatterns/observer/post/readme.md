When the Subject (the one being observed) changes its state, it automatically notifies all dependent objects (Observers), without being tightly coupled to them.

Key Components: Observer, Subject, concrete observers


----
Real-World Examples

YouTube / Instagram: You subscribe → You get updates when new videos/posts are uploaded.

Stock Market Ticker: Traders subscribe to price changes.

Weather Station: Multiple displays updated when weather data changes.

-----
Pros

Loose coupling: Subject doesn’t know details about observers.

Open/Closed: New observers can be added without changing subject.

Promotes reuse of both subject and observers independently.

Cons

Can lead to performance issues if too many observers.

Notification order isn’t guaranteed.

Harder to debug (since updates are automatic and may cascade).


-----
