
object polynomials {

    // =============================
    // Polynom
    class Polynom(val terms: Map[Int, Double]) {

        override def toString(): String = {
            (for ((exp, coeff) <- terms) yield s"$coeff x^ $exp") mkString " + "
        }

        def + (other: Polynom): Polynom = { 
            
            // simple way:
            new Polynom(this.terms ++ other.terms)

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



    val p1 = new Polynom(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
    val p2 = new Polynom(Map(0 -> 3.0))

    val p3 = p1 + p2
    
    }




