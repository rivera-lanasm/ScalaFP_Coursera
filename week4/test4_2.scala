package week4

trait List[+T] {

    // what kind of list do we have
    def isEmpty: Boolean 

    // retrive head
    def head: T

    // remaining list
    def tail: List[T]

    }

class Cons[T](val head: T, val tail: List[T]) extends List[T] {

    def isEmpty: Boolean = {false}

    // head and tail are already implemented!
    // implementing fields in instantiation is legal 
    // impementation of trait method

    // val definitions are special cases of methods
    // can override methods/implement abstract methods from traits
    
    // val vs. def --> only differ in intialization
    // val evaluated when object first initialized
    // def is evaluated each time it is referenced

    }

    // objects can't have type parameters
    // Nothing is subtype of all types, means Nil can extend any type
object Nil extends List[Nothing] {

    def isEmpty: Boolean = {true}

    def head: Nothing = throw new NoSuchElementException("Nil.head")

    def tail: Nothing = throw new NoSuchElementException("Nil.tail")

    // implementing head and tail here as type nothing is 
    // valid for implementing abstract class because Nothing 
    // is a SUBTYPE of any other type, including T
    }


object List {
    def nthval[T](n: Int, xs: List[T]): T = {
        
        if (xs.isEmpty) throw new IndexOutOfBoundsException
        else if (n==0) xs.head
        else nthval(n-1, xs.tail) 
        }
    
    // val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
    // nthval(2,list)

    // =================================
    // lecture 4.2
    // HERE LIST is being used as a COMPANION OBJECT!

    // List(1,2) --> List.apply(1,2)
    // def apply[T](x1: T, x2: T): List[T] = {
    //     new Cons(x1, new Cons(x2, Nil))
    // }
    // // Function to create list of three elements:
    // def apply[T](x1: T, x2: T, x3: T): List[T] = {
    //     new Cons(x1, new Cons(x2, new Cons(x3, Nil)))
    // }

    }