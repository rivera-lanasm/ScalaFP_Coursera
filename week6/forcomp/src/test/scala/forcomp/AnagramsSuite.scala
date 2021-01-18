package forcomp

import org.junit._
import org.junit.Assert.assertEquals


class AnagramsSuite {
  import Anagrams._

  //@Ignore("not ready yet")
  @Test def `wordOccurrences: abcd (3pts)`: Unit =
    assertEquals(List(('a', 1), ('b', 1), ('c', 1), ('d', 1)), wordOccurrences("abcd"))

  //@Ignore("not ready yet")
  @Test def `wordOccurrences: Robert (3pts)`: Unit =
    assertEquals(List(('b', 1), ('e', 1), ('o', 1), ('r', 2), ('t', 1)), wordOccurrences("Robert"))

  //@Ignore("not ready yet")
  @Test def `sentenceOccurrences: abcd e (5pts)`: Unit =
    assertEquals(List(('a', 1), ('b', 1), ('c', 1), ('d', 1), ('e', 1)), sentenceOccurrences(List("abcd", "e")))

  //@Ignore("not ready yet")
  @Test def `dictionaryByOccurrences.get: eat (10pts)`: Unit =
    assertEquals(Some(Set("ate", "eat", "tea")), dictionaryByOccurrences.get(List(('a', 1), ('e', 1), ('t', 1))).map(_.toSet))

  //@Ignore("not ready yet")
  @Test def `wordAnagrams married (2pts)`: Unit =
    assertEquals(Set("married", "admirer"), wordAnagrams("married").toSet)

  //@Ignore("not ready yet")
  @Test def `wordAnagrams player (2pts)`: Unit =
    assertEquals(Set("parley", "pearly", "player", "replay"), wordAnagrams("player").toSet)


  //@Ignore("not ready yet")
  @Test def `subtract: lard - r (10pts)`: Unit = {
    val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
    val r = List(('r', 1))
    val lad = List(('a', 1), ('d', 1), ('l', 1))
    assertEquals(lad, subtract(lard, r))
  }

  //@Ignore("not ready yet")
  @Test def `combinations: [] (8pts)`: Unit =
    assertEquals(List(Nil), combinations(Nil))

  //@Ignore("not ready yet")
  @Test def `combinations: abba (8pts)`: Unit = {
    val abba = List(('a', 2), ('b', 2))
    val abbacomb = List(
      List(),
      List(('a', 1)),
      List(('a', 2)),
      List(('b', 1)),
      List(('a', 1), ('b', 1)),
      List(('a', 2), ('b', 1)),
      List(('b', 2)),
      List(('a', 1), ('b', 2)),
      List(('a', 2), ('b', 2))
    )
    assertEquals(abbacomb.toSet, combinations(abba).toSet)
  }

  //@Ignore("not ready yet")
  @Test def `sentence anagrams: [] (10pts)`: Unit = {
    val sentence = List()
    assertEquals(List(Nil), sentenceAnagrams(sentence))
  }

  //@Ignore("not ready yet")
  @Test def `sentence anagrams: Linux rulez (10pts)`: Unit = {
    val sentence = List("Linux", "rulez")
    val anas = List(
      List("Rex", "Lin", "Zulu"),
      List("nil", "Zulu", "Rex"),
      List("Rex", "nil", "Zulu"),
      List("Zulu", "Rex", "Lin"),
      List("null", "Uzi", "Rex"),
      List("Rex", "Zulu", "Lin"),
      List("Uzi", "null", "Rex"),
      List("Rex", "null", "Uzi"),
      List("null", "Rex", "Uzi"),
      List("Lin", "Rex", "Zulu"),
      List("nil", "Rex", "Zulu"),
      List("Rex", "Uzi", "null"),
      List("Rex", "Zulu", "nil"),
      List("Zulu", "Rex", "nil"),
      List("Zulu", "Lin", "Rex"),
      List("Lin", "Zulu", "Rex"),
      List("Uzi", "Rex", "null"),
      List("Zulu", "nil", "Rex"),
      List("rulez", "Linux"),
      List("Linux", "rulez")
    )
    assertEquals(anas.toSet, sentenceAnagrams(sentence).toSet)
  }

  //@Ignore("not ready yet")
  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
