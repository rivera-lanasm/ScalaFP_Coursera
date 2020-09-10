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

**COnsider a class for rational numbers**
```
class Rational(x: Int, y: Int) {
    def numer = x
    def denom = y 
}
```
This definition introduces **Two new entities**
- a new **Type** called Rational
- a new **constructor** called Rational, to create elements of this type 
- note that Scala keeps different names for types and values in different **namespaces**, no conflict 




