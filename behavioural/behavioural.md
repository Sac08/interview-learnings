## Tell me about yourself 
Hi, I’m Sachin Bagalakoti. I’ve been with Walmart for about five years, and right now I’m part of a team called Fitment. What we do is solve a really crucial problem for customers buying auto parts: we ensure that the parts they choose will actually fit their vehicle. For example, we help them avoid ordering a wiper blade that doesn’t match their car, which saves returns and revenue. In a nutshell, I’ve been handling how we match parts to vehicles to improve customer experience and reduce returns.


## "Tell me about a time you had to work under a tight deadline. How did you handle it, and what was the outcome?"

Situation:
“Last year, just before my marriage, I was responsible for delivering a new service that was critical to an upcoming product launch. The timeline was tight, and I also had a fixed hard stop because of my planned leave.”

Task:
“My responsibility was to ensure the service was fully implemented, tested, and maintainable before I left, so the team wouldn’t be blocked in my absence.”

Action:
“To manage this, I reprioritized my schedule. I aligned with my manager in 1:1s to cut down on low-value activities, such as long standups — I would contribute my updates and return to focus on development.
I also collaborated with a junior engineer, assigning them ownership of writing test cases. This not only accelerated testing but ensured knowledge transfer, so someone else could step in if issues arose during my leave. Additionally, I documented the setup and key workflows for smooth maintainability.”

Result:
“As a result, we delivered the service on time, two days before my leave. The launch went smoothly, and while I was away, the junior was able to handle minor issues without escalations. The manager appreciated both the delivery and the proactive handover, which reinforced trust in my ability to deliver under pressure while ensuring long-term maintainability.”


--------------

## "Tell me about a time when you faced a challenging situation with tight deadlines and unexpected issues. How did you handle it?"

Situation:
“During a new service development project, I was assigned a feature implementation that was running in parallel with another ongoing feature. As we approached the testing phase, I started noticing multiple bugs in my feature — around 4–5 per day — which was concerning given the tight timeline. At the same time, I had a personal constraint: I had a scheduled surgery coming up, so my availability after a certain date was limited.”

Task:
“My task was to ensure that my feature was delivered on time, with high quality, without blocking the parallel feature development or creating friction with my teammate.”

Action:
“To handle this, I first carefully tracked and documented all bugs and their impact on functionality. I then discussed the situation with my manager, presenting clear data on the bugs and potential risks. I suggested a collaborative approach with the teammate working on the parallel feature to prioritize fixes and perform cross-testing where needed. Additionally, I coordinated with a junior engineer to take over some test cases and minor bug fixes so the work could continue smoothly during my absence.”

Result:
“As a result, the feature was delivered on time, with the critical bugs resolved before my surgery. My manager appreciated the proactive escalation and documentation, and the teammate felt supported rather than blamed. This approach minimized risk, maintained quality, and ensured smooth handover while keeping the team morale intact.”

## the most challenging project you worked & why is it challenging & how you solved it? 

this is for developing scalable ingestion platform, there were many challanges like 
 - a bad / incorrect file should not block ingestion of valid files (i solved by adding checks initially at acceptance & failing & also added failure isolation i.e row level & file level errors)
 - incase of issues we should add retries with idempodent & no duplication (chosen cassandra schema carefully so data would be idempotent) and also i had one suggestion of dedupe logic (hashing the file & storing)
 - burst of traffic should not put load on cassandra / nodes (for this kept max 3 jobs processing at a time & controlled scheduling)
 - correctness was very important as in site there will be more returns (made sure ingested data is very accurate comparing with ACA & transactible or not with item data ensuring correct & stock items are returned in the response)
 - sometimes sellers used to see file completion but still at the site the fitment used to say not fit (for this it was necessary to have some consistency model not compromising the speed)
 - the specific features that required some additional read & writes for them added event driven flow so that ingestion doesnt gets slow down 


 ## scalable ingestion platform
 #### challanges : 
 - explain above 
 #### mistakes/failures :
- logging & observability were added later instead of day 1
 #### Technical Decisions : 
 - this comes in schema inorder to fitment to work we need (mpn, ptid, brand & vehicle info & some other mandatory) - big suppliers send varying additional data as well i was of the opinion to dump entire data as is into db, collegues told unnecessary storage would fill up & all. In extended attr feature those info was helpful
 - also for auto light feature they wanted to read & write in ingestion itself which will slow down instead i suggested event driven kafka consr service 

 #### Enjoyed:
- i was focusing on designing a platform such that any new adapter comes in it should fit into existing architecture eg VCDB pcdb

#### conflicts
- there were lot of design discussions on validations, storage, schema but we have created the vibe in team such that it all feels like discussion & we dont take that as personally. 

#### what you would do differently
- logging & observability were from day 1

 ## What are your career goals? (2–3 years)

“In the next 2–3 years, I want to grow as a strong backend engineer who can design and own large, reliable systems.” Longer term, I see myself mentoring others and influencing design decisions across systems.


## What are dealbreakers for you while choosing an opportunity?
I don’t have rigid dealbreakers, but a few things matter to me. 
“No ownership—where engineers just execute tickets without understanding the system.”
“Repeated production issues without addressing root causes.”


## Tell me about a situation when you had a conflict with a teammate.
There was an initiative shared by leadership where any team could propose a solution, and it was important for visibility across teams.

The problem involved generating coverage data for vehicles, which required reverse querying compared to how our data was stored in Cassandra. teammate suggested onboarding the data into a new system like a data warehouse or a wide-column store to support these queries.

I had a different view. My concern was that onboarding a new datastore would significantly delay delivery, and since this was an open initiative, another team might deliver faster.

Instead of pushing back directly, I suggested that we first clarify the actual requirements. I reached out to leadership to understand the expected number of vehicles, acceptable data staleness, and the time range they were interested in.

Once we had that clarity, it turned out the requirement was mostly historical data for a specific vehicle category, and real-time freshness wasn’t critical.

Based on this, I proposed a simpler approach using our existing APIs. I generated a monthly coverage report using multi-threaded API calls and built a small React page to present the data.

We were able to deliver the solution within 10–15 days, and leadership appreciated both the speed and the pragmatic approach. The conflict was resolved by aligning on requirements rather than debating the technology.


## Tell me about a time you had a disagreement with your manager
At one point, we were discussing how to approach a leadership-driven request where multiple teams could propose solutions. My manager initially leaned toward a more comprehensive long-term solution, even though it required onboarding new infrastructure and a longer delivery timeline.

I was concerned that this approach might delay delivery and reduce our chances of adding value quickly, especially since the problem was still not clearly scoped.

Instead of pushing back emotionally, I asked if we could first validate the actual requirements. I reached out to leadership to clarify how much data was really needed, the acceptable staleness, and the vehicle categories they cared about.

Based on those discussions, it became clear that a simpler solution using our existing APIs would meet the immediate need. I shared this proposal with my manager, along with the risks and benefits of both approaches.

My manager agreed to try the simpler approach first. We delivered a working solution within about two weeks, and leadership appreciated the speed and clarity.

**** later on we wanted to migrate all of our analytics data from postgres to BQ because of data growth, so i migrated this one as well & showed in looker dashboard (so long term is taken care)


## Tell me about a time you failed. How did you deal with the situation?
We had a requirement from Product to introduce a new Excel template for sellers. After the development was completed, Product asked us to hold off on releasing it.

I felt that significant effort had went there & deploying the change would still give visibility and more wins to the team, and my manager was aligned with this. To minimize risk, I proposed deploying it behind a feature flag turned off, so it wouldn’t be exposed to users.

Product was okay with this approach, and we went ahead with the deployment.

However, over time, the feature kept getting delayed due to shifting priorities and product scope changes. Nearly a year later, the feature is still not live.

The downside was that the dormant code increased maintenance overhead. Every new change in that area required additional testing, the codebase became slightly bloated, and the cost of keeping the feature compatible kept increasing.

In hindsight, while the intention was good, I underestimated the long-term cost of carrying unfinished features in production.

how i dealt - I also aligned with the new Product Manager to either commit to shipping it or plan a clean removal if it no longer made sense

This taught me that feature flags reduce user risk, but they don’t eliminate maintenance cost. and also clear buisiness alignment on deployment timelines


## What’s the Number One Accomplishment You’re Most Proud Of? 
talk about dynamic extended attribute, i identified this myself the pain point proposed dynamic way of doing to avoid manual task it used to happen 

## what was your managers recent feedback to you (pro & con)
pros 
- relaible in meeting deadlines
- proactive in team discussions
-  i clearly & quickly adapt the requirement & align with stakeholders
- velocity of delivery & effective collaboration with team

cons
- delegation of tasks : for dynamic extended attrs features mostly i was working on the task (I tend to handle things myself to ensure quality) the feedback was to delegate more and trust the team


