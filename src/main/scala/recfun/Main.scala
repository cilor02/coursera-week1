package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = 
  {
   if (c == 0)
     1
   else   
   if (c == r) 1
   else
   pascal(c-1,r-1) + pascal(c,r-1)
  } 
  
  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
     def bracketBalancer (chars : List[Char], balance:Int):Boolean =
     {
      if (chars.isEmpty)
       {
         balance == 0
      }else
      chars.head match 
      {
        case ')'  if balance == 0 => false 
        case ')'  => bracketBalancer(chars.tail, balance + 1)
        case '('  => bracketBalancer(chars.tail, balance - 1)
        case _    => bracketBalancer(chars.tail,balance)
      }
     }
     
    bracketBalancer(chars,0)
   }
     
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = 
  
  //def change (denominations:List[Int], amount:Int):Int =
      {
        if(money == 0)
        {
           1
        } else
        
        if (coins.isEmpty)
        {
           0
        }
        else
        {
        val maxOcc = money / coins.head
        var total = 0
        
        
        for (i <-0 to maxOcc)
        {
          total += countChange (money - i * coins.head,coins.tail )
        }
        total
        }
      } 

 def countChange2(money: Int, coins: List[Int]): Int = 
  
  //def change (denominations:List[Int], amount:Int):Int =
      {
        if(money == 0)
        {
           1
        } else
        
        if (coins.isEmpty)
        {
           0
        }
        else
        {
        val maxOcc = money / coins.head
        var total = 0
        
        
       if(money >= coins.head) 
       {
          return total + countChange2 (money - coins.head,coins )
        }else
        {
          return total + countChange2 (money,coins.tail )
        }
        total
        }
      } 

  
  
}
