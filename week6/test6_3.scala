
object polynomials {

    // =============================
    // Polynom
    class Polynom(val terms: Map[Int, Double]) {

        override def toString(): String = {
            (for ((exp, coeff) <- terms) yield s"$coeff x^ $exp") mkString " + "
        }

        def + (other: Polynom) = {
            
            // simple way:
            //new Poly(self.terms ++ other.terms)

            // with recursion:
            def add(terms: Map[Int, Double], other_terms: Map[Int, Double]):Map[Int, Double] = {
                other_terms.tail.isEmpty match {
                    case true => terms
                    // print intermediate results
                    case false => if (terms.contains(other_terms.head._1)) add( terms + (other_terms.head._1 -> (other_terms.head._2 + terms(other_terms.head._1) ) ) , other_terms.tail)
                                  else add( (terms + other.terms.head) , other_terms.tail)
                    }
                }
            new Polynom(add(this.terms, other.terms))


        }


        }


    val p1 = new Polynom(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
    val p2 = new Polynom(Map(0 -> 3.0, 3 -> 7.0))

    val p3 = p1 + p2
    
    }




