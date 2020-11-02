

#### ================================
**Lecture 4.1: Objects Everywhere**
#### ================================

**Pure Object Orientation**
- in which **every value is an object**
- if lang is based on classes, this means that **the type** of each value **is also a class**
- what about **primitive types?**

**Standard Classes: Pure Booleans**
- the `Boolean` type maps to the JVM's primitive type boolean 
- but you could define it as a class just as well without any changes in user code!
  - thus, scala can be considered Pure OO based on the language's capabilities 
```
from test4.scala --> link to git and hardcode
```

**Standard Classes: Pure Natural Numbers**

- do not use standard numerical classes
- implement a sub-object and a sub-class
- Peano Numbers

```
From test4_1
```

#### ================================
**Lecture 4.2: Functions and Objects**
#### ================================
- After encoding **primitive types** as classes, the other two fundamental types of values that are left are **instances of classes** and **functions**
- How do function types relate to classes?
- How do function values relate to objects?

**Functions are treated as objects in scala**
- `A => B` is an abbreviation for the class `scala.Function[A,B]`, which translates roughly to:
```
package scala

trait Function[A,B] {
  def apply(x: A): B
  }
```
- so functions are objects with `apply` methods 
- other traits, `Function2, ...,FunctionN` for functions with more parameters (limit of 22)

**Function Values: Lambda functions**
- `(x: Int) => x*x` expands to:
```
{class AnonFun extends Function1[Int,Int] {
  def apply(x: Int) = x*x
  }
  new AnonFun
}
```

**Function Calls**
- a function call, `f(a,b)` -> `f.apply(a,b)`
```
// OO Translation of:
val f = (x: Int) => x*x
f(7)

// Following:
val f = new FUnction[Int, Int] {
  def apply(x: Int) = x*x

  }
f.apply(7)
```
**however, is the `apply` method inside f also an object?**
- no, because would lead to an infinite expansion of object definitions 
-  `def` methods are not function values 
-  **Eta-expansion**
   -  wherever methods are passed as arguments expecting a Function type, the method is **translated into a function value**
   -  `def f(x:Int): Boolean = ...` --> `(x: Int) =>f(x)` == `new FUnction1[Int, Boolean] { def apply(x: Int) = f(x)}`

#### ================================
**Lecture 4.3: Subtyping and Generics, types of Polymorphism**
#### ================================

Investigate **interactions between generics and subtyping**
- **Bounds**
- **Variance**

**Type Bounds**
- revisit `IntSet` (test3.scala)
- consider method `assertAllPos`, which 
  - takes an IntSet 
  - returns the INtset itself if all elements are positive 
  - throws an exception otherwise
- **what type** can you can give to  `assertAllPos`?
  - `def assertAllPos(s: IntSet): Intset`
  - fine for most situations
- Consider two possible situations:
  - 1) `assertAllPos(Empty) = {Empty}`
  - 2) `assertAllPos(NonEmpty) = { {Empty} OR {throw Exception} }`


current typing of this method (`IntSet`) does not reflect fact that the assertAllPos method can return **either a result of type Empty or of type NonEmpty**
- can employ **Type Bounds**
- `def assertAllPos[S <: IntSet](r: s): S`
- here, `<: IntSet` is an **upper bound** of the type parameter, `S:`
  - meaning `S` can be instantiated only to types **that conform to IntSet**
  - `S <: T` --> S is a **subtype of T**
  -  `S >: T` --> **lower bound:** S is a **supertype of T, or T is a subtype of S**
- can **mix upper and lower bounds**
  - `[S >: NonEmty <: IntSet]`
  - retricts S any type on the interval between NonEmpty and IntSet

**What about Lists of Sets?**
- Given **NonEmpty <: IntSet**, is it the case that `List[NoneEmpty]` is a subtype of `List[Intset]`?
- this makes sense, a list of non-empty sets is a secial case of a list of arbitrary sets 
- call types for which this relationship holds, **Covariant** --> **subtyping relationship varies with the Type Parameter**

**Liscov Substitution Principle**
- **When can a type be a subtype of another?**
- *If A <: B, then everything one can do with a value of type B, one should also be able to do with a value of type A*
Stated in the languate Liskov used, 
- *Let q(x) be a property provable about objects x of type B. Then q(y) should be provable for objects y of type A, where A <: B*
- **Not the other way around!**

**example**
- `type A = IntSet => NonEmpty`
- `type B = NonEmpty => IntSet`
- from this, we can say that A <: B
- type A satisfies the contract specified by type B, and express a particular case of this contract

#### ==============================================
**Lecture 4.4: Subtyping and Generics, Variance**
#### ==============================================

**Variance:** How subtyping relates to genericity


Recall that some types should be coviariant (Lists) while others are not (Arrays)
- roughly, a type that **accepts mutation of its elements** should not be covariant
- **immutable types** can be covariant, if some conditions on method implementation are met

**Not binary between Covariant and non-Covariant**
- say `C[T]` is a parameterized type (like Array[Int]), and A,B are types s.t. A <: B
**Three possible relationships between C[A] and C[B]**
  1) C[A] <: C[B] --> c is **covariant**
  2) C[A] >: C[B] --> c is **contravariant**
  3) neither C[B] nor C[B] is a subtype of the other --> **nonvariant**

Scala allows you to **declare the variance of a type** by annotating the **type parameter**
- class Array[+Int] {...} --> Array is covariant
- class C[-A] {...} --> C is contravariant
- class C[A] {...} --> C is nonvariant

