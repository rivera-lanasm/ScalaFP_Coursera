#### ================================
**Lecture 6.1: Other Collections**
#### ================================

Other Sequences
- another Seq implementation, **Vector**
- has more evenly balanced access patterns than List
  - recall that lists are **linear**, access to the first elem is faster than access to the middle or end of a list

**Vector**
- essentially, a very shallow tree
- A vector of up to 32 elements is just an array, where the elements are stored in sequence.
  - as the array grows larger, the representation changes, so that each element of the original array points, instead of to a value, to a another array with 32 elements
    - array of level 0: 32 elements
    - array of level 1: 32*32 elements
    - array of level 2: 32* 32 * 32 elements

**retrieval/access performance**
- log(32)n complexity 
- very good random access profile 
- good for **bulk operations**
  - those that traverse a sequence
  - **map, fold**, etc
- **locality** is also better for Vectors than lists
  - more certainty about **cache lines**

**Choice between List and Vector**
- depends on access pattern

**Operations on Vectors**
- created analogously no lists
  - `val nums = Vector(1, 2, 3)`
- support same operations as lists, except for `::`, prepend 
- instead of `x :: xs`,
  - `x +: xs` => creates a new vector w leading elem x
  - `xs :+ x` => create a new vector w trailing elem x
- 





