import scala.math

object nqueens {

    def isSafe(col: Int, queens: List[Int]): Boolean = {
    // test if a queen placed in an indicated col is secure against
    // other placed queens
        val row: Int = queens.length
        
        val quensWithRow = (row -1 to 0 by -1) zip queens // order in list
        quensWithRow forall {
            case (r,c) => (col != c) && 
                          (math.abs(row - r) != math.abs(col - c))
            }            

        }

    def queens(n: Int): Set[List[Int]] = {
    // finds unique set of solutions for placing n queens on a chess 
    // board with n rows 
        
        def placeQueens(k: Int): Set[List[Int]] = {
        // which places a number k queens on a board
        // and produces solutions
            if (k == 0) Set(List())
            else 
                for {
                    // set of partial solutions
                    queens <- placeQueens(k-1)
                    

                    // all possible cols FOR each queens List()
                    // check that col placement does not break non-threaten criteria
                    col <- 0 until n if isSafe(col,queens)
                    
                    } yield col :: queens 
                    // for each c in col for each q in queens
                    // if NO safe cols, then the solution is ELIMINATED ?
            }
            // implement for n
            placeQueens(n)


        }



    }