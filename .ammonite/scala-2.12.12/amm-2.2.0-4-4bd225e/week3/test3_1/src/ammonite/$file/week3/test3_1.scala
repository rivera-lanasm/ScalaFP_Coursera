
package ammonite
package $file.week3
import _root_.ammonite.interp.api.InterpBridge.{
  value => interp
}
import _root_.ammonite.interp.api.InterpBridge.value.{
  exit
}
import _root_.ammonite.interp.api.IvyConstructor.{
  ArtifactIdExt,
  GroupIdExt
}
import _root_.ammonite.runtime.tools.{
  browse,
  grep,
  time,
  tail
}
import _root_.ammonite.repl.tools.{
  desugar,
  source
}
import _root_.ammonite.main.Router.{
  doc,
  main
}
import _root_.ammonite.repl.tools.Util.{
  pathScoptRead
}


object test3_1{
/*<script>*/object intsets { 
    
    val t1 = new NonEmpty(3, new Empty, new Empty)
    val t2 = t1 incl 4


}

abstract class IntSet { 
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean 
    def union(other: IntSet): IntSet
    }


class Empty extends IntSet {
    def contains(x: Int): Boolean = false 

    // adds an element to the BST
    def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

    def union(other: IntSet) = other

    override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet { 
    
    // traverses the tree via post-order insertion
    // either finds the node where the elem == x 
    // or comes across an elem that corresponds to an empty node
    def contains(x: Int): Boolean = {
        // assumes that the sorted nature of BST is maintained
        if (x < elem) left contains x
        else if (x > elem) right contains x
        else true
        }
    
    // adds element to set, on left or right depending on comp. to elem
    def incl(x: Int): IntSet = {
        if (x < elem) new NonEmpty(elem, left incl x, right)
        else if (x > elem) new NonEmpty(elem, left, right incl x)
        else this 
        }
    
    // functional implementation of union of two immutable binary search trees
    // not commutative
    def union(other: IntSet) = {
        ((left union right) union other) incl elem
        }

    override def toString = "{" + left + elem + right + "}"

}

/*</script>*/ /*<generated>*/
def $main() = { scala.Iterator[String]() }
  override def toString = "test3_1"
  /*</generated>*/
}
