 
// abstract class List[T] {
 
//     def map[U](f: T => U): List[U] = {
//         this match {
//             case Nil => this
//             case x :: xs => f(x) :: xs.map(f)
//         }
//     }
 
//     def filter(p: T => Boolean): List[T] = {
//         this match {
//             case Nil => this
//             case x :: xs => if (p(x)) x :: xs.filter(p) else xs.filter(p)
//         }
//     }
 
// }
 
object HigherOrder {
 
 
   def scaleList(xs: List[Double], factor:Double): List[Double] = {
 
       xs match {
           case Nil => xs
           case x :: xs1 => x*factor :: scaleList(xs1, factor)
       }
   }
 
   def squareList(xs: List[Int]): List[Int] = {
 
       xs match {
           case Nil => xs
           case x :: xs1 => x*x :: squareList(xs1)
       }
   }
 
   def pack[T](xs: List[T]): List[List[T]] = {
 
       xs match {
           case Nil => Nil
           case x :: xs1 => (xs filter((y:T) => (y == x))) :: pack(xs filterNot(y => y == x))
       }
   }
 
   def encode[T](xs: List[T]): List[(T,Int)] = {
 
       pack(xs) map (x => (x.head, x.length))
 
      
   }
 
   // def pack_1[T](xs: List[T]): List[List[T]] = {
 
   //     xs match {
   //         case Nil => Nil
   //         case x :: xs1 => (xs filter((y:T) => (y == x))) :: pack(xs filterNot(y => y == x))
   //     }
   // }
 
 
 
 
 
   // def scaleList1(xs: List[Double], factor: Double) = {
   //     xs map (x => x*factor)
   // }
 
}
 

