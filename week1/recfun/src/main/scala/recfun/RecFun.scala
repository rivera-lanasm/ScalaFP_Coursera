package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == r || c ==0) 1 else pascal(c-1, r-1) + pascal(c,r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    val criteria: Int = 0
    def balance_track(chars: List[Char], criteria: Int): Boolean = {
      if (criteria < 0) {
        false
      }
      else if (chars.isEmpty) {
        criteria == 0 
      } else if (!(List(')','(').contains(chars.head))) {
        balance_track(chars.tail, criteria)
      } else if (chars.head == '(') {
        balance_track(chars.tail, criteria + 1)
      } else {
        balance_track(chars.tail, criteria - 1)
      }
    
    }
    balance_track(chars = chars, criteria = criteria)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money==0) {
      1
    } else if (money>0 && !coins.isEmpty){
      countChange(money-coins.head, coins) + countChange(money,coins.tail)
    } else {
      0 }
  }

}
