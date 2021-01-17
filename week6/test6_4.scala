
import scala.io.Source

object NumsToSentences {

    // convert telephone numbers to sentences 
    val in = Source.fromURL("https://www.epfl.ch/labs/lamp/wp-content/uploads/2019/01/linuxwords.txt")

    // must clean dictionary 
    val words = in.getLines.toList filter (word => word forall (chr => chr.isLetter))

    val mnem = Map(
        '2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", 
        '6' -> "MNO", '7'-> "PQRS", '8'->"TUV", '9'->"WXYZ")

    // 1) Invert the mnem map to give a map from chars 'A',...,'Z' to '2',...,'9'
    val charCode: Map[Char, Char] = {
        
        ((for ((num, letters) <- mnem.toSeq) yield letters map (l => Map(l -> num))).flatten).reduceLeft(_ ++ _)

        }


    // 2) Map a word to the digit string it can represent, example: "Java" -> "5282"
    def wordCode(word: String): String = {

        (word map (ltr => (charCode get ltr.toUpper).get )).mkString("")

        }

    
    // 3) a map from digit strings; "5282" => List("Java", "Kata", "Lava"), if none return List(), like for "1111"
    val wordsForNum: Map[String, Seq[String]] = {

        words groupBy (w => wordCode(w))

        }

    // 4) return all ways to encode a number as a list of words 
    // num --> Set(List("hello", "mig"), List("hemig", "llo"))
    def encode(number: String): Set[List[String]] = {

        wordsForNum

        }


}