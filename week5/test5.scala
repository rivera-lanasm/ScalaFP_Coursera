
object Week5 {


    def last[T](xs: List[T]): T = {

        xs match {
            case List() => throw new Error("last of empty list")
            case List(x) => x
            case y :: ys => last(ys)
            }
        }
    
    def init[T](xs: List[T]): List[T] = {

        xs match {
            case List() => throw new Error("init of empty list")
            case List(x) => List()
            case y :: ys => List(y) ++ init(ys)
            }

        }
    
    def concat[T](xs: List[T], ys: List[T]): List[T] = {

        // depends on xs --> concatenation defined by ::: operator
        // xs ::: ys is basically a prepend of xs onto ys
        // thus makes sense to pattern match on xs

        xs match {
            case List() => ys
            case z :: zs => z :: concat(zs , ys) 
            }

        }
    
    def reverse[T](xs: List[T]): List[T] = {

        xs match {
            case List() => List()
            case y :: ys => reverse(ys) ::: List(y)
            }
        }

    
    def removeAt[T](xs: List[T], n: Int): List[T] = {
        
        xs match {
            case List() => List()
            case x :: xs => if (n==0) List(x) else if (n>0) List(x) ::: removeAt(xs, n-1)
            } 
    
        // (xs take n) ::: (xs drop n + 1) --> alternative
    
        }

}  

// Week5.last(List(1,2,3))
