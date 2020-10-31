// ==========================
// Pure OO Natural Numbers 

// Want to be able to communicate “this object is 1”, “this object is 5” 
// without using the numbers or their representation in the program
// ==========================
abstract class Nat {

    def isZero: Boolean
    def predecessor: Nat
    // implement in abstract class because implementation is uniform in subs
    def successor = new Succ(this)
    def + (that: Nat): Nat
    def - (that: Nat): Nat
}

// represents 0
object Zero extends Nat {
    def isZero = {true}
    def predecessor = {throw new Error("Zero Value")}
    def + (that: Nat): Nat = {that}
    def - (that: Nat): Nat = {if (that.isZero) this else throw new Error("0.predecessor")}

    }

/// represents natural number 1 larger than argument
class Succ(n: Nat) extends Nat {
    def isZero = {false}
    def predecessor = {n}
    def + (that: Nat): Nat = {
        // transfer Succ layers from this to that UNTIL this is ZERO
        if (this.isZero) that else this.predecessor + new Succ(that) 
        }
        // alternatively --> {new Succ(n + that)} --> ???

    def - (that: Nat): Nat = {
        // apply predecessor to that and this UNTIL that is ZERO
        if (that.isZero) this 
        else if (this.isZero && !that.isZero) throw new Error("0.predecessor")
        else this.predecessor - that.predecessor
        }
        // alternatively --> {if (that.isZero) this else n - that.predecessor}
    }

