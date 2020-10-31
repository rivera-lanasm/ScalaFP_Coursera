package idealized.scala

// ==========================
// Pure OO boolean
// ==========================
abstract class Boolean {

    def ifThenElse[T](t: => T, e: => T): T

    def && (x: =>Boolean) = ifThenElse(x,False)
    def || (x: =>Boolean) = ifThenElse(True,x)  
    def unary_! :Boolean = ifThenElse(False,True)
    def ==(x: =>Boolean):Boolean= ifThenElse(x, x.unary_!)
    def !=(x: =>Boolean):Boolean= ifThenElse(x.unary_!,x)

    def less(x: => Boolean): Boolean = {
        // true with false, false
        // true with true, false
        // false with false, false
        // false with true, true
        ifThenElse(False,x)

        }
}

object True extends Boolean {
    // if (true) te else ee ==> 
    def ifThenElse[T](t: => T, e: => T) = t
    }

object False extends Boolean {
    def ifThenElse[T](t: => T, e: => T) = e
    }

