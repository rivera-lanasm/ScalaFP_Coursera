package week4

import java.{util => ju}

trait List[T] {

    // what kind of list do we have
    def isEmpty: Boolean 

    // retrive head
    def head: T

    // remaining list
    def tail: List[T]

    // retrieve nth value
    def nthval(n: Int): T

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

    def nthval(n: Int): T = {

        ???

        }

    }

class Nil[T] extends List[T] {

    def isEmpty: Boolean = {true}

    def head: Nothing = throw new NoSuchElementException("Nil.head")

    def tail: Nothing = throw new NoSuchElementException("Nil.tail")

    // implementing head and tail here as type nothing is 
    // valid for implementing abstract class because Nothing 
    // is a SUBTYPE of any other type, including T

    def nthval(n: Int): Nothing = throw new IndexOutOfBoundsException("Nil.nthval")
    }