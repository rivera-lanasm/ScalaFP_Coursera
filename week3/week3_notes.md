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

**References for Sets represented as binary trees:** 
- http://ethanp.github.io/blog/2014/05/16/scala-union-beauty/
  - "how the union method retains the sortedness for the BST. Short answer... ``this union other` --> each element of `this` is passed through `incl` to be inserted into `other`. 


**Class Extension**
- implement sets as binary trees
  - a tree for the empty set
  - a tree consisting of an integer and two sub-trees
- want to maintain invariant, property that rhs values are greater than the node, and LHS values are less than node
- purely functional, no mutation --> **persistent data structures**
- Empty and NonEmpty extend and **conform** to type IntSet
  - an object of type Empty or NonEmpty can be used wherever an object of type IntSet is required
- IntSet is the **Superclass**, EMpty and NonEmpty are the **sub classes**
- standard class **object** is the superclass of any class --> base class
- implementation vs. overriding 

**Object Definitions**
- defining EmptySet as an **Object rather than a class**
- defines a **singleton object**
  - cannot create multiple instances of this object with `new`
  - singelton objects are values 

**Programs**
- standalone application in Scala
  - composed of an **object with a main method**
```
object Hello {
    def main(args: Array[String]) = println("hello world!")
}
```
- you can run program from cmd line with `scala Hello.scala`

**Functional Union Method between two IntSets**
- for Empty set, the union of itself with an **other** set is always the equivalent to the other set
- for NonEmpty Sets, 
  - first split the LHS set into left and right, and take union
    - yields IntSet excluding `elem` of LHS set
  - take union between (left union right) and `other` set
  - finally, `incl` elem from LHS set
- each subsequent call **union** is on a set smaller than the previous, so we can safely assume the recursion terminates 

**dynamic method dispatch model**
- OO languates implement this, meaning code invoked by a method call depends on the runtime type of the object that contains the method
- similarity between dynamic dispatch of methods **to higher-order functions** 


#### ========================
**Lecture 3.2: How Classes are Organized**
#### ========================

**Packages**
- classes and objects are organized in **packages**
- a **package clause** at top of source file places subsequent classes and objects into the package
```
package progfun.examples

object Hello()
```
- this would place Hello in the package progfun.examples
- can subsequently refer to Hello by its **fully qualified name**
    - `progfun.examples.Hello`
    - to run the Hello program: `scala progfun.examples.Hello`



