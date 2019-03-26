package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

//    println(balance(":-)".toList))
    println(countChange(300,List(500,5,50,100,20,200,10)))
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = if(c==0 || c==r) 1 else pascal(c-1,r-1) + pascal(c,r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def balanceMe(count: Int, curr: Int ): Boolean = {

        if(count<0) false

        else if(count > 0 && curr == chars.length) false

        else if (count == 0 && curr == chars.length) true

        else if(chars(curr).equals('(')) balanceMe(count+1, curr+1)

        else if(chars(curr).equals(')'))  balanceMe(count-1,curr+1)

        else balanceMe(count,curr+1)
      }

      balanceMe(0, 0)
    }

  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if(money< 0 || coins.isEmpty) 0

      else if(money == 0) 1

      else countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
