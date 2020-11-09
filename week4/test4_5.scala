object ListSort {

    
    def insert(x: Int, xs: List[Int]): List[Int] = {

        xs match {
            case List() => List(x)
            case y :: ys => {
                if (x > y) y :: insert(x,ys) 
                else x :: xs}
        }
    }

    def isort(xs: List[Int]): List[Int] = {
        
        // list pattern matching
        xs match {
            case List() => List()
            case y :: ys => insert(y, isort(ys))
        }
    }
}

 