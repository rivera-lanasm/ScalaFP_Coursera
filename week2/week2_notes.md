### Week 2 Outline: Higher Order Functions
 
#### ========================
**Lecture 2.1: Higher-Order Functions:**
#### ========================
 
FP languages treat functions as **first class** values
- function can be passed as a parameter and returned as a result
- **higher order functions** take other functions as parameters or return functions as results, as opposed to **first order functions**
 
There are many variations of the pattern, $\textstyle\sum_{x=1}^nf(x)$, can we generalize using programming as well?
- using higher order function
- nest the f(x) from above, as a parameter, into a general sum function 
   ```
   def sum(f: Int => Int, a: Int, b:Int): Int = {
       if (a>b) 0 else f(a) + sum(f,a+1, b)}
   ```
- where `f(a)` is a custom function, like factorial or cube
 
Note the use of **function type** in the above function, `f: A => B`
- Indicates that f(x) takes in a value of type A and returns a value of type B
 
Getting around writing separate auxillary functions to pass as `f(x)` -> **Anonymous Functions**
- Think about passing strings to functions, like print...we do not need to define a values prior to passing to print()
- because strings exist as **literals**...analogously, we would like **function literals**, which let us write a function without giving it a name
 
   ```
   (x: Int) => x*x*x
   ```
- `(x:Int)` is the parameter, and `x*x*x` is the body
   ```
   def sumInts(a: Int, b:Int)= sum(x=>x, a, b)
   def sumCubes(a: Int, b:Int)= sum(x:Int =>x*x*x, a, b)
   ```
 
**Exercise: Write tail recursve version of sum**
 
```
def sum(f: Int => Int, a: Int, b: Int): Int = {
 
 def loop(a: Int, acc: Int): Int = {
   if (a>b) acc else loop(a+1, acc+f(a))
   }
  loop(a, 0)
}
```
 
#### ========================
**Lecture 2.2: Currying:**
#### ========================
 
Special form for writing higher-order functions: **Currying**
- recall, the summation function from above wherein the first parameter represents the f(x)
 ```
 def sumInts(a: Int, b: Int) = {
   sum(x => x*x, a, b)
 }
 ```
- notice that a and b get passed **unchanged** to sum()
 
**Functions Returning Functions**
```
def sum(f: Int => Int): (Int, Int) => Int = {
   def sumF(a: Int, b: Int): Int = {
       if (a>b) 0
       else f(a) + sumF(a + 1, b)
   }
  
   sumF
   }
```
- note that the function `sum()` takes in a function and also retuns a funtion
- the returned function,`sumF`, applies the given function parameter, f, and sums the results
- now we can write, `def sumCubes = sum(x => x*x*x)`
- and then apply, `sumCubes(1,10)`
- **Can we avoid** writing the **intermediate function, sumCube?**
 - `sum(x => x*x*x)(1,10)`
 
**Scala: Multiple Parameter Lists**
```
def sum(f: Int => Int)(a: Int, b: Int): Int = {
   if (a>b) 0 else f(a) + sum(f)(a+1,b)
}
```
- notice how in the **recursive** call, `sum` is called with **two sets of parameter lists**
 
**Expand multiple parameter lists**
- `def f(args,1)...(args,n-1) = E` is equivalent to a function with **no paramter list**, but equal to **n nested anonymous functions**
- `def f = (args,1 => (args,2 => ...(args,n => E)...))`
 
 
**Exercise: Write a product function that calculates the product of the values of a function from the points on a given interval**
```
def product(f: Int => Int)(a: Int, b: Int): Int = {
   if (a>b) 1
   else f(a) * product(f)(a+1,b)
}
```
**Exercise: Write factorial in terms of product()**
```
def fact(n:Int):Int = {
 
   if (n==1) 1
   else product(x=>x)(1,n)
}
```
**Exercise: Generalize sum() and product(): mapReduce()**
```
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero:Int)(a: Int, b: Int): Int = {
   if (a>b) zero
   else combine( f(a),mapReduce(f, combine, zero)(a+1,b))
}
 
// Redefine product()
 
def product(f: Int => Int)(a: Int, b: Int): Int = {
   mapReduce(f, (x,y) => x*y, 1)(a,b)
}
 
```
- combine parameter defined how values are combined in the recursive call
- zero paramter defines what value to return in the degenerate case, when the interval is 0
 
#### ========================
**Lecture 2.3: Finding Fixed Points:**
#### ========================
 
A number x is called a **Fixed point** of a function if f(x) = x
- for some functions, we can locatie the fixed points by iteratively applying f to a given initial estimate, x
- x, f(x), f(f(x)),... until the values does not vary anymore, given some epsilon

**Recall square root**
- sqrt(x) is the fixed point of the function, `f(y) = x/y == y`
- suggests we can calculate sqrt(x) by iteration towards fixed point 
- **unfortunately**, this does not converge
- **one solution: Average Damping** --> `f(y) => (y+x/y)/2` 
  
**Notes on root finding methods (Fixed point iteration)**
- https://briangordon.github.io/2014/06/sqrts-and-fixed-points.html
- https://www.lvguowei.me/post/sicp-goodness-sqrt/
- https://medium.com/@JosephJnk/an-introduction-to-function-fixed-points-with-the-y-combinator-e7bd4d00fb62
- https://www.kimsereylam.com/racket/lisp/2019/02/22/fixed-point-and-newton-method.html

**Iterative Fixed Point Estimate of Square Root Using "Damping"**
- Note the use of **currying** and **higher order functions**


**Previously,** we saw that the expressive power of a language increases if we can pass **functions as arguments**
- also the case for **functions that return functions**
- note that the technique of **stabalizing by averaging** is general enough to be abstracted into its own function 
- `def averageDamp(f: Double => Double)(x: Double) = { (x + f(x))/2 }`
- This takes a function as an input, and returns a function as an output


#### ========================
**Lecture 2.4: Scala Syntax Summary**
#### ========================

**Context Free syntax: Extended Backus-Naur Form (EBNF)**:
- add links

**Types:**
- can be numeric, boolean, string, function, and others 
**Expressions**
- identifier, literal, function application, operator application, selection, conditional expr, a block, or an anonymous function
**Definitions**
- a function def
- a value def 
- a **parameter** can be 
  - call by value 
  - call by name 
**attempt, then go back to video for examples**


#### ========================
**Lecture 2.5: Functions and Data**
#### ========================

Ways to use functions to compose and abstract data: introducing **objects and classes**

**Consider a class for rational numbers**
```
class Rational(x: Int, y: Int) {
    require(y != 0, "denominator must be non-zero")

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = {
        if (b==0) a else gcd(b, a%b)
    }
    private val g = gcd(x,y)

    def numer = x/g
    def denom = y/g

    def add(that:Rational) = {
        new Rational(
            numer * that.denom + that.numer * denom, 
            denom * that.denom)
        }
    def less(that:Rational) = {
        numer * that.denom < that.numer * denom
    }
    def max(that:Rational) = {
        if (this.less(that)) that else this
    }
}
```
This definition introduces **Two new entities**
- a new **Type** called Rational
- a new **constructor** called Rational, to create elements of this type 
- note that Scala keeps different names for types and values in different **namespaces**, no conflict 

**Objects**
- a **type** is a set of values
- elements of a class type are **objects**
- `val x = new Rational(1,2)` is an object
- **Members of an object**:
  - `x.numer` and `x.denom`
- **Methods**
  - **functions** that are packaged into classes

#### ========================
**Lecture 2.6: More Fun with Rationals**
#### ========================

Previous example of `Rational` class did not have a method to simplify the results from the `add` method
- we could call a simplify method after any addition operation
- a better alternative, because it does not necessitate coupling the add method with a simplify whenever the first is called, is to simply simplify the representation of the class when object is constructed 
- Note that in the implementation above `gdc()` is defined as a **private** method, indicating that clients of class, Rational, will not be able to acess this method.  
- not that on the inside of a class, **this** represent the object on which the current method is executed. Note that members of a class can also be referencesd with `this.` prefix

**How to prevent users from instantiating irrational numbers, like 1/0**
- note the **Require** predefined function
- if not fulfilled, scala will throw `IllegalArgumentException`
- besides `require` there is also **assert**
```
    val x = sqrt(y)
    assert(x>=0)
```
- like `require`, a failing `assert` also throws a an exception, a `AssertionError`
- **difference in intent:** require is a precondition, and assert is a check on the code of the function itself. 

**Constructors**
- a class implicits introduces a constructor called the **primary constructor**, which:
  - takes paramters of class 
  - executes all statements in class body 
- Scala can include **multiple constructors** for a class
  - note `def this(x: Int) = this(x, 1)` above
  - This represents an alternative constructor, which is **utilitzed when an instance of Rational is constructed with only one argument, x**


#### ========================
**Lecture 2.7: Evaluation and Operators**
#### ========================




