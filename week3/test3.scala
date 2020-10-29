
object intsets { 

}

abstract class IntSet { 
    def incl(x: Int): IntSet
    def contains(x: Int): Boolean 
    }


class Empty extends IntSet {
    def contains(x: Int): Boolean = false 

    // adds an element to the BST
    def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
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

}

