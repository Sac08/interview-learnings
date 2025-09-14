concurrency vs parellelism:
concurrency is running a multiple task on single cpu processor, this is achieved by threads and multiple context switches
parellelism is running multiple task on multiple cpu's

---------
# Data Structures for HLD Interviews

## B-Tree
**What**: Self-balancing tree with multiple keys per node, sorted order maintained  
**Use Cases**: SQL database indexes (MySQL, PostgreSQL), file systems  
**Pros**: Fast reads O(log n), range queries, ACID-friendly  
**Cons**: Write-heavy workloads cause frequent rebalancing  
**HLD Context**: Primary choice for RDBMS, when you need consistent read performance

---

## LSM Tree
**What**: Multi-level append-only structure (MemTable → SSTables → Compaction)  
**Use Cases**: NoSQL databases (Cassandra, DynamoDB, RocksDB)  
**Pros**: Excellent write performance, handles high insert volume  
**Cons**: Read amplification (check multiple levels), write amplification during compaction  
**HLD Context**: Choose for write-heavy systems, big data, real-time analytics

---

## Inverted Index
**What**: Maps each word/term to list of documents containing it  (Eg Document - ["I am sachin", "I am Asha"], inverted index - {I:2 pointers to above 2 strings, am: 2 pointers to above 2 strings, sachin:1 pointer to I am sachin})\
**Use Cases**: Search engines (Elasticsearch, Solr), full-text search  
**Pros**: Fast text search, supports complex queries with boolean operators  
**Cons**: Large storage overhead, expensive updates  
**HLD Context**: Core component of search systems, document retrieval

---

## Quadtree
**What**: Tree where each node has 4 children, recursively subdivides 2D space  
**Use Cases**: Spatial databases, game engines, image processing, maps  
**Pros**: Efficient spatial queries, collision detection  
**Cons**: Unbalanced with skewed data distribution  
**HLD Context**: Location-based services, gaming, GIS systems

---

## Merkle Tree
**What**: Binary tree where each leaf is hash of data, internal nodes are hash of children  
**Use Cases**: Blockchain, Git, distributed systems, data verification  
**Pros**: Tamper detection, efficient data integrity checks, partial verification  
**Cons**: Overhead for small datasets  
**HLD Context**: Distributed systems consistency, replication verification, blockchain

---

## R-Tree
**What**: Tree for indexing multi-dimensional spatial data using bounding rectangles  
**Use Cases**: Geographic databases, CAD systems, spatial queries  
**Pros**: Efficient range queries on spatial data, handles overlapping regions  
**Cons**: Complex insertion/deletion, performance degrades with high overlap  
**HLD Context**: Map services, location-based features, spatial analytics


---

## What is a Bloom Filter?
A probabilistic data structure that tells you if an element is definitely not in a set or might be in a set.
Key Properties:

✅ No False Negatives: If it says "NO", the element is definitely not there\
❌ Possible False Positives: If it says "YES", the element might or might not be there

---

## Quick Selection Guide

| Requirement | Choose |
|------------|--------|
| ACID + Complex Queries | B-Tree |
| High Write Throughput | LSM Tree |
| Text Search | Inverted Index |
| 2D Spatial Data | Quadtree |
| Data Integrity/Blockchain | Merkle Tree |
| Multi-dimensional Spatial | R-Tree |

--------
1. Long Polling
How it works:

Client sends a request to the server
Server holds the request open until it has new data or a timeout
Once response is sent, the client immediately re-requests
Feels like real-time, but it's just repeated HTTP requests

Pros ✅

Works with plain HTTP (easy to implement)
No special server setup needed

Cons ❌

Wasteful (lots of repeated connections)
Higher latency compared to WebSockets
Not true real-time, just "fast enough"


2. WebSockets
How it works:

Starts as an HTTP handshake
Then upgrades to a WebSocket connection
Creates a full-duplex channel: both client and server can send messages anytime

Pros ✅

True real-time (instant communication)
Efficient (one persistent connection)
Great for chat apps, games, stock tickers

Cons ❌

More complex to implement
Requires server support for WebSocket protocol
Not always ideal for simple request/response use cases

--------