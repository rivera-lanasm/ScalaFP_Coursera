package patmat

import org.junit._
import org.junit.Assert.assertEquals

class HuffmanSuite {
  import Huffman._

  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }


  @Test def `weight of a larger tree (10pts)`: Unit =
    new TestTrees {
      assertEquals(5, weight(t1))
    }


  @Test def `chars of a larger tree (10pts)`: Unit =
    new TestTrees {
      assertEquals(List('a','b','d'), chars(t2))
    }

  @Test def `string2chars hello world`: Unit =
    assertEquals(List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'), string2Chars("hello, world"))

  // test for times
  @Test def `times test`: Unit = {
    assertEquals(times(List('a', 'b', 'a')) , List(('a', 2), ('b', 1)))
  }

  //@Ignore("not ready yet")
  @Test def `make ordered leaf list for some frequency table (15pts)`: Unit =
    assertEquals(List(Leaf('e',1), Leaf('t',2), Leaf('x',3)), makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))))

  //@Ignore("not ready yet")
  @Test def `new test, for singleton`: Unit = {
    
    new TestTrees {
      assertEquals(false, singleton(List(t1, t2)))
      assertEquals(true, singleton(List(t1)))
      }
    }

  // @Ignore("not ready yet")
  @Test def `combine of some leaf list (15pts)`: Unit = {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assertEquals(List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)), combine(leaflist))
  }

  //@Ignore("not ready yet")
  @Test def `test decode`: Unit =
    new TestTrees {
      assertEquals("ababa".toList, decode(t1, List(0,1,0,1,0)))
    }

  @Test def `test encode`: Unit =
    new TestTrees {
      assertEquals(List(0,1,0,1,0), encode(t1)("ababa".toList))
    }

  //@Ignore("not ready yet")
  @Test def `decode and encode a very short text should be identity (10pts)`: Unit =
    new TestTrees {
      assertEquals("ab".toList, decode(t1, encode(t1)("ab".toList)))
    }


  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
