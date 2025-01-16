## Eulerian Graphs
An **Eulerian graph** is a type of graph that contains an Eulerian circuit (or Eulerian cycle), which is a trail that visits every edge of the graph exactly once and returns to the starting vertex. Eulerian graphs are named after the mathematician **Leonhard Euler**, who studied these properties in the 18th century.

### Key Characteristics of Eulerian Graphs

1. **Eulerian Circuit**: A graph is said to have an Eulerian circuit if:
   - It is connected (ignoring isolated vertices).
   - Every vertex has an even degree.

2. **Eulerian Path**: A graph may have an Eulerian path (a trail that visits every edge exactly once but does not have to return to the starting vertex) if:
   - It is connected.
   - Exactly **0 or 2 vertices** have an odd degree.
   - If 0 vertices have an odd degree, the path is also an Eulerian circuit.

### Conditions for Eulerian Graphs

- **Eulerian Circuit**: 
  - The graph is connected.
  - All vertices have even degrees.

- **Eulerian Path**: 
  - The graph is connected.
  - Exactly 0 or 2 vertices have odd degrees.

### Example of Eulerian Graphs

#### Example 1: Eulerian Circuit

Consider the following graph:

```
    A
   / \
  B---C
   \ /
    D
```

- **Vertices**: \( A, B, C, D \)
- **Degrees**:
  - \( \text{deg}(A) = 2 \)
  - \( \text{deg}(B) = 3 \)
  - \( \text{deg}(C) = 3 \)
  - \( \text{deg}(D) = 2 \)

This graph has vertices with odd degrees (\( B \) and \( C \)). Therefore, it does not have an Eulerian circuit, but it has an Eulerian path since it has exactly 2 vertices with odd degrees.

#### Example 2: Eulerian Circuit

Consider the following graph:

```
    A
   / \
  B---C
   \ /
    D
```

- **Vertices**: \( A, B, C, D \)
- **Degrees**:
  - \( \text{deg}(A) = 2 \)
  - \( \text{deg}(B) = 2 \)
  - \( \text{deg}(C) = 2 \)
  - \( \text{deg}(D) = 2 \)

In this case, all vertices have even degrees, and the graph is connected, so it has an Eulerian circuit.

### Applications of Eulerian Graphs

Eulerian graphs have practical applications in various fields, such as:

1. **Route Planning**: Finding efficient routes for garbage collection, snow plowing, and mail delivery where every path must be covered without retracing steps.
  
2. **Network Design**: Designing networks where every connection (edge) needs to be utilized exactly once.

3. **Puzzles and Games**: Solving puzzles like the **Seven Bridges of Königsberg**, which led to the development of graph theory.


---
## Hamiltonian Graph
A **Hamiltonian graph** is a type of graph that contains a **Hamiltonian circuit** (or Hamiltonian cycle), which is a cycle that visits every vertex exactly once and returns to the starting vertex. The concepts of Hamiltonian graphs and circuits are named after the mathematician **Sir William Rowan Hamilton**.

### Key Characteristics of Hamiltonian Graphs

1. **Hamiltonian Circuit**: A Hamiltonian circuit in a graph is a closed loop that visits every vertex once and only once, returning to the starting vertex.

2. **Hamiltonian Path**: A Hamiltonian path is a path that visits every vertex exactly once but does not have to return to the starting vertex.

### Conditions for Hamiltonian Graphs

There are no simple, general conditions to determine if a graph is Hamiltonian, unlike Eulerian graphs. However, there are several sufficient conditions and theorems that can help identify Hamiltonian graphs:

1. **Dirac's Theorem**: If a graph \( G \) has \( n \) vertices (where \( n \geq 3 \)) and every vertex has a degree of at least \( \frac{n}{2} \), then \( G \) is Hamiltonian.

2. **Ore's Theorem**: If for every pair of non-adjacent vertices \( u \) and \( v \) in a graph \( G \) with \( n \) vertices (where \( n \geq 3 \)), the sum of their degrees is at least \( n \), then \( G \) is Hamiltonian.

3. **Chvátal's Theorem**: This theorem combines aspects of both Dirac's and Ore's theorems. It states that if the degree of a vertex \( v \) is at least \( k \) and \( n - \text{deg}(v) \) is at least \( k \), then the graph is Hamiltonian.

### Example of a Hamiltonian Graph

Consider the following graph:

```
    A
   / \
  B---C
   \ /
    D
```

- **Vertices**: \( A, B, C, D \)

A Hamiltonian circuit for this graph could be \( A \to B \to C \to D \to A \), visiting each vertex exactly once before returning to the starting vertex.

### Non-Hamiltonian Graph

Not all graphs contain Hamiltonian circuits. For example, a simple path with three vertices (a line) does not have a Hamiltonian circuit because there is no way to return to the starting vertex after visiting each vertex exactly once.

### Applications of Hamiltonian Graphs

Hamiltonian graphs have applications in various fields, including:

1. **Traveling Salesman Problem (TSP)**: Finding the shortest possible route that visits a set of cities (vertices) exactly once and returns to the original city.

2. **Routing Problems**: Designing efficient routing protocols in networks where each node (vertex) needs to be visited exactly once.

3. **Graph Theory**: Studying properties and behaviors of graphs in theoretical computer science and combinatorial optimization.

---
## Difference
Hamiltonian circuits and Eulerian circuits are two fundamental concepts in graph theory, but they refer to different types of paths in a graph. Here’s a detailed comparison of the two:

### Hamiltonian Circuit

1. **Definition**: A **Hamiltonian circuit** (or Hamiltonian cycle) is a closed loop that visits every vertex in a graph exactly once and returns to the starting vertex.

2. **Vertices**: A Hamiltonian circuit focuses on visiting all the vertices of the graph. It does not require that all edges be traversed.

3. **Conditions**: 
   - There are no simple necessary and sufficient conditions for a graph to have a Hamiltonian circuit. 
   - Some theorems, like Dirac's and Ore's theorems, provide sufficient conditions, but the Hamiltonian problem is NP-complete, meaning it is computationally challenging to determine whether such a circuit exists in general.

4. **Examples**:
   - A triangle (3 vertices) has a Hamiltonian circuit, as you can visit all vertices in a loop.
   - A simple path graph (e.g., 3 vertices in a line) does not have a Hamiltonian circuit since you can't return to the starting vertex after visiting all vertices.

### Eulerian Circuit

1. **Definition**: An **Eulerian circuit** (or Eulerian cycle) is a closed trail that visits every edge in a graph exactly once and returns to the starting vertex.

2. **Edges**: An Eulerian circuit focuses on traversing all edges of the graph. It does not require that all vertices be visited.

3. **Conditions**:
   - A graph has an Eulerian circuit if and only if it is connected and every vertex has an even degree.
   - Alternatively, a graph has an Eulerian path (which does not necessarily return to the starting vertex) if it has exactly 0 or 2 vertices of odd degree and is connected.

4. **Examples**:
   - A square (4 vertices in a cycle) has an Eulerian circuit, as you can traverse each edge exactly once and return to the starting vertex.
   - A star graph (one central vertex connected to several outer vertices) does not have an Eulerian circuit since the central vertex has an odd degree.

### Summary of Differences

| Feature        | Hamiltonian Circuit                | Eulerian Circuit                            |
| -------------- | ---------------------------------- | ------------------------------------------- |
| **Definition** | Visits every vertex exactly once   | Visits every edge exactly once              |
| **Focus**      | Vertices                           | Edges                                       |
| **Conditions** | No simple conditions; NP-complete  | Connected and all vertices have even degree |
| **Example**    | Triangle (3 vertices)              | Square (4 vertices in a cycle)              |
| **Traversal**  | Closed loop returning to the start | Closed trail returning to the start         |
