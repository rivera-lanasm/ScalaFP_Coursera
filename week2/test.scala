
object rationals {
    
    val x = new Rational(1,3)
    val y = new Rational(5,7)
    
}


class Rational(x: Int, y: Int) {
    
    // pre-condition on rational instance
    require(y != 0, "denominator must be non-zero")

    def this(x: Int) = this(x, 1)

    // automatically simplify fracation upon entry
    private def gcd(a: Int, b: Int): Int = {
        if (b==0) a else gcd(b, a%b)
    }
    private val g = gcd(x,y)
    def numer = x/g
    def denom = y/g

    // method for pretty printing
    override def toString: String = {
      s"${numer}" + "/" + s"${denom}"
    }

    // method for adding rationals
    def add(that:Rational) = {
        new Rational(
            numer * that.denom + that.numer * denom, 
            denom * that.denom)
        }

    // alternative for adding, using **symbolic identfier**
    def + (that:Rational) = {
        new Rational(
            numer * that.denom + that.numer * denom, 
            denom * that.denom)
        }

    // method to return the negative of a rational
    def neg: Rational = {
      new Rational(-1*numer, denom)
    }

    //method to subtract two rationals (add the neg)
    def sub(that:Rational) = {
      add(that.neg)
    }


    // metod to determine if one rational is less than another
    def less(that:Rational) = {
        numer * that.denom < that.numer * denom
    }

    // methiod for finding max between two rationals
    def max(that:Rational) = {
        if (this.less(that)) that else this
    }
}
