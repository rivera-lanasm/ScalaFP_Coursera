package funsets

import org.junit._


/**
 * This class is a test suite for the methods in object FunSets..
 *
 * To run this test suite, start "sbt" then run the "test" command.
 */
class FunSetSuite {

  import FunSets._

  @Test def `contains is implemented`: Unit = {
    val s100 = singletonSet(100)
    assert(contains(s100, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
  }

  /**
   * This test is currently disabled (by using @Ignore) because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", remvoe the
   * @Ignore annotation.
   */
  //@Ignore("not ready yet") 
  @Test def `singleton set one contains one`: Unit = {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton: 1")
      assert(!contains(s1, 2), "Singleton: 1 not 2")

    }
  }

  //@Ignore("not ready yet") 
  @Test def `union contains all elements of each set`: Unit = {

    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }


  @Test def `intersect contains all elements in both sets`: Unit = {
    
    new TestSets {
      val s = union(s1, s2)

      val a = intersect(s,s1)
      val b = intersect(s,s2)
      val c = intersect(s,s3)

      assert(contains(a, 1), "Intersect 1")
      assert(!contains(a, 2), "Intersect 2")
      assert(contains(b, 2), "Intersect 3")
      assert(!contains(c, 2), "Intersect 4")
      assert(!contains(c, 1), "Intersect 3")
    }
  }

  @Test def `diff "contains" all elements in one set but not the other`: Unit = {
    
    new TestSets {
      val s = union(s1, s2)
      val a = union(s2,s3)

      val diff_a = diff(s,s1) //should contain 2 
      val diff_b = diff(a,s) // should contain 3

      assert(contains(diff_a, 2), "Intersect 1")
      assert(!contains(diff_a, 1), "Intersect 2")
      assert(contains(diff_b, 3), "Intersect 3")
      assert(!contains(diff_b, 2), "Intersect 4")
    }
  }

  @Test def `filter creates sub-set containing elements of one set satisfying predicate`: Unit = {
    
    new TestSets {
      val s = union(s1, s2)
      val a = union(s2,s3)
      val pred = (x:Int) => (x%2)==0 //test if even

      val filter_s = filter(s,pred) 

      assert(contains(filter_s, 2), "Intersect 1")
      assert(!contains(filter_s, 1), "Intersect 2")
      assert(!contains(filter_s, 3), "Intersect 3")
    }
  }

  @Test def `forall tests whether a given predicate is true for all elements of the set`: Unit = {
    
    new TestSets {
      val s = union(s1, s2)
      val a = union(s2,s3)
      val pred = (x:Int) => (x%2)==0 //test if even

      assert(!forall(s,pred), "forall 1")
      assert(forall(s2,pred), "forall 2")
    }
  }

  @Test def `exists tests whether a set contains at least one element for which the given predicate is true`: Unit = {
    
    new TestSets {
      val s = union(s1, s2)
      val a = union(s2,s3)
      val pred = (x:Int) => (x%2)==0 //test if even

      assert(exists(s,pred), "exists 1")
      assert(!exists(s1,pred), "exists 2")
    }
  }

  @Test def `Map Returns a set transformed by applying f to each element of s.`: Unit = {
    
    new TestSets {
      val s = union(s1, s2)
      val a = union(s2,s3)
      val f = (x:Int) => (x*x) 

      assert(contains(map(s2,f),4), "map 1")
      assert(contains(map(s3,f),9), "forall 2")
    }
  }


  @Rule def individualTestTimeout = new org.junit.rules.Timeout(10 * 1000)
}
