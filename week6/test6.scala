object Week6 {

    // 6.1
    //list all combinations of numbers x and y where x is drawn from 1...M and y is drawn from 1...N
    def all_comb(M: Int, N: Int) = {

        (1 to M) flatMap (x => (1 to N) map (y => (x,y) ) )

        }

    // scalar product
    def scalarProduct(xs: Vector[Double], ys: Vector[Double]): Double = {

        ((xs zip ys) map (x => x._1 * x._2) ).sum

        // can also use pattern matching 
        // (xs zip ys).map{ case (x,y) => x*y}.sum

        }

    // primailty test
    def isPrime(n: Int): Boolean = {

        (2 to n-1) forall (x => n % x != 0)

        }

    // ==========================
    // 6.2 

    // scalar product
    def scalarProduct_forExpr(xs: Vector[Double], ys: Vector[Double])= { //: Double = {

        (for {
            xy <- (xs zip ys)
        } yield (xy._1 * xy._2) ).sum

        }


}