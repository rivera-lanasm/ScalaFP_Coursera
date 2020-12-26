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
- List good for operations with recursive structure
- Vector good for bulk operations like map, filter, or fold 

**Operations on Vectors**
- created analogously to lists
  - `val nums = Vector(1, 2, 3)`
- support same operations as lists, except for `::`, prepend 
- instead of `x :: xs`,
  - `x +: xs` => creates a new vector w leading elem x
  - `xs :+ x` => create a new vector w trailing elem x
- how append elem to vector works: immutable structure
  - copy last array create new array with additional element, in addition to existing array contents
  - add pointers to all children of array 
  - copy parent arrays and point these to new array instead of old one

**Sequence**
- common base class of List and VEctor is Seq, the class of all sequences
- Seq is a subclass of Iterable 
- Set, Seq, Map are subclasses of Iterable 
- Arrays and Strings are Seq like structures, support same operations, but these classes come from Java
- Range: another kind of Sequence
  - to, until and by are its operators
  - `val r: Range = 1 until 5`
  - `val s: RAnge = 1 to 5`
  - `1 to 10 by 3`
  - generator? 

**Seq Operations**
- xs exists p : Boolean
- xs forall p : Boolean
- xs zip ys : List( (xi, yi)) 
- xs.unzip: (List(x1, x2, x3), List(y1, y2, y3))
- xs.flatMap f : 1) appy f to xs, where f yields some collection, 2) concatenate results into a single collection 
- xs.sum, xs.product, xs.max, xs.min 

- Example; All combinations, scalar product, isPrime see test6.scala


#### ================================
**Lecture 6.2: COmbinatorial Search and For-Expressions**
#### ================================



