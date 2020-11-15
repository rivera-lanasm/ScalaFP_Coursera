object ListReduce {

    def sum(xs: List[Int]): Int = {

        xs match {
            case Nil => 0
            case x :: xs1 => x + sum(xs1)
        }
        }

    //=============================
    // lecture 5.5 --> include as exampoes
    def concat[T](xs: List[T], ys: List[T]): List[T] = {

        (xs foldRight ys) ( _ :: _ )

    }

    def mapFun[T, U](xs: List[T], f: T => U): List[U] = {
     
        (xs foldRight List[U]())( f(_)::_ )
        }
    // ListReduce.mapFun(List(1,2,3), (i: Int) => i*i )

    def lengthFun[T](xs: List[T]): Int = {
        
        (xs foldRight 0)( ((x,y) => 1+y) )
    }
    // ListReduce.lengthFun(List(1,2,3))


}