### Week 3 Outline: Data and Abstraction
 
#### ========================
**Lecture 3.1: CLass Hierarchies:**
#### ========================

**Class Hierarchies: CLasses that extend eachother**
- model of evluation changes
  - method calls might depend on runtime type of receiver of a given method --> **dynamic binding** 
  - revisit family writing

**Abstract Class**
- Abstract classes can contain members which are missing an implementation
  - so no new instances can be created with `new` operator
```
abstract class IntSet { 
    def incl(x: Int): IntSet
    def containes(x: Int): Boolean 
    }
```
- Thus IntSet is incomplete, must be suplemented by classes that **extend it**

**Class Extension**
- implement sets as binary trees
  - a tree for the empty set
  - a tree consisting of an integer and two sub-trees
- want to maintain invariant, property that rhs values are greater than the node, and LHS values are less than node
- purely functional, no mutation 


**References for Sets represented as binary trees:** 
- http://ethanp.github.io/blog/2014/05/16/scala-union-beauty/
  - "how the union method retains the sortedness for the BST. Short answer... ``this union other` --> each element of `this` is passed through `incl` to be inserted into `other`. 
- 



