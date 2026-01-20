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
One example of handling conflict was when our leadership launched an initiative allowing any team to propose a visibility solution for vehicle coverage data. My teammates suggested onboarding the data into a new warehouse, but I was concerned that would slow us down and another team might beat us to the punch. Instead of debating tech choices right away, I reached out to leadership to clarify the exact requirements—like how fresh the data really needed to be. Once we knew they mostly needed historical data and real-time updates weren’t critical, I proposed a simpler solution using our existing APIs and a lightweight React-based tool. We delivered the solution in 15 days, and leadership really appreciated the speed and pragmatism. In the end, we resolved the conflict by focusing on the actual requirements rather than getting stuck on the technology debate.


## Tell me about a time you had a disagreement with your manager
At one point, we were discussing how to approach a leadership-driven request where multiple teams could propose solutions. My manager initially leaned toward a more comprehensive long-term solution, even though it required onboarding new infrastructure and a longer delivery timeline.

I was concerned that this approach might delay delivery and reduce our chances of adding value quickly, especially since the problem was still not clearly scoped.

Instead of pushing back emotionally, I asked if we could first validate the actual requirements. I reached out to leadership to clarify how much data was really needed, the acceptable staleness, and the vehicle categories they cared about.

Based on those discussions, it became clear that a simpler solution using our existing APIs would meet the immediate need. I shared this proposal with my manager, along with the risks and benefits of both approaches.

My manager agreed to try the simpler approach first. We delivered a working solution within about two weeks, and leadership appreciated the speed and clarity.

**** later on we wanted to migrate all of our analytics data from postgres to BQ because of data growth, so i migrated this one as well & showed in looker dashboard (so long term is taken care)


## Tell me about a time you failed. How did you deal with the situation?
she was prioriatizing more buisiness initiative & less scope for tech debts 
because of this any issue comes in middle dev's just solve that by temp fix without looking at RCA and all
for support tickets also creating FAQ instead of just we solving them 


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


## how do you mentor your juniors to deliver a feature ? 
I mentor juniors and interns by first giving them clear context on the problem, business impact, and how the feature fits into the existing system so they understand the “why” before coding. I then help break the requirement into small, achievable tasks and ask them to propose an initial design, which we review together to catch edge cases early. During implementation, I stay available for guidance without hand-holding, encourage them to reason through trade-offs, and review code with detailed, constructive feedback focused on quality, performance, and maintainability. After delivery, we do a short retrospective so they learn from the experience and gradually take full ownership of features end to end.


## theres a timeline fixed for feature delivery & also critical bug i found which alter timelines how do you convince PM
If there is a fixed timeline but I find a critical bug, I first make sure I fully understand how serious the bug is and what will happen if we ignore it. Then I talk to the PM with clear and simple points: what the bug is, how it affects users or the business, and the risk of releasing without fixing it. I also suggest options, like fixing the bug first and delaying the feature a bit, reducing the feature scope, or adding a temporary workaround. This way, the PM can choose the best option, and the decision is based on impact and risk, not just delay.