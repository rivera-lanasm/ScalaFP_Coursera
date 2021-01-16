
object polynomials {

    // =============================
    // Polynom
    class Polynom(val terms0: Map[Int, Double]) {
        def this(bindings: (Int, Double)*) = this(bindings.toMap) // toMap converts sequence to map

        val terms = terms0 withDefaultValue(0.0)

        override def toString(): String = {
            (for ((exp, coeff) <- terms.toSeq.sortWith(_._1 < _._1).reverse) yield s"$coeff x^ $exp") mkString " + "
        }

        // ================================================
        // concatenation ++ (recursive implementation)
        // def + (other: Polynom): Polynom = { 
        //     new Polynom(terms ++ (other.terms map adjust) ) 
        //     }

        // def adjust(term: (Int, Double)): (Int, Double) = {

        //     val (exp, coeff): (Int, Double) = term 

        //     // pattern match method
        //     // terms get exp match {
        //     //     case Some(value) => exp -> (value + coeff)
        //     //     case None => exp -> coeff
        //     //     }

        //     // Default Dict, default map value -> 0.0
        //     exp -> (coeff + terms(exp))

        //     }
        // ================================================


        // ================================================
        // FoldLeft method
        def + (other: Polynom) = {
            new Polynom((other.terms foldLeft terms)(addTerm))
        }

        def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
            
            val (exp, coeff) = term

            terms get exp match {
                case Some(coeff1) => terms + (exp -> (coeff + coeff1))
                case None => terms + (exp -> coeff)
                }
            }

       

        // ================================================


        // =====================================================
        // with recursion: --> CHAMGE FROM OPERATOR ADD TO FUNC ADD, ADD(X,Y) --> BETTER FOR RECURSION
        //     val terms: Map[Int, Double] = this.terms
        //     other.terms.isEmpty match {
        //         case true => new Polynom(terms)
        //         case false => {
        //             val new_other = new Polynom(other.terms.tail)
        //             val terms = add(terms, other.terms.head)
        //             new Polynom(terms) + new_other }
        //         } 
            
        //     }

        // def add(terms: Map[Int, Double], addition: (Int, Double) ):Map[Int, Double] = {
            
        //     val (exp, coeff) = addition

        //     terms get exp match {
        //         case Some(coeff1) => terms + (exp -> (coeff + coeff1))
        //         case None => terms + (exp -> coeff)
        //         }
                
        //     }
        // =====================================================
    
    }

    val p1 = new Polynom(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
    val p2 = new Polynom(0 -> 3.0, 3 -> 7.0)

    val p3 = p1 + p2

}




