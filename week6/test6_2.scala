object maps {

// Map[String, Int]
val romanNumerals = Map("I" -> 1, "V" -> 5, "X"->10)

def showNumeral(symbol: String) = romanNumerals.get(symbol) match {
    case Some(value) => value 
    case None => "no corresponding numeral"
    }


}

//=========== test
//maps.romanNumerals('V')
//maps.romanNumerals get "V" --> Option val = None, or Some


