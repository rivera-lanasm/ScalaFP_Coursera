 
object MergeSort {
 
   def merge_1(xs: List[Int], ys: List[Int]): List[Int] = {
 
       (xs, ys) match {
 
           case (Nil, ys) => ys // returns arbitrary ys
           case (xs, Nil) => xs
           case(x :: xs1, y :: ys1) => {
               // ys not ys1
               // xs1 not xs
               if (x<y) x :: merge_1(xs1,ys)
                  
               // other way around
               else y ::  merge_1(xs, ys1)
               }
 
           }
 
       }
  
   def merge(xs: List[Int], ys: List[Int]): List[Int] = {
 
       xs match {
           case Nil => ys
 
           // NOte the nested pattern match!
           case x :: xs1 => ys match {
               case Nil => xs
               case y :: ys1 => {
                   // ys not ys1
                   // xs1 not xs
                   if (x<y) x :: merge_1(xs1,ys)
                  
                   // other way around
                   else y ::  merge_1(xs, ys1)
                   }
               }
           }
 
       }
 
   def msort(xs: List[Int]): List[Int] = {
 
       val n = xs.length/2
       if (n==0) xs
       else {
          
           // splitAt method
           val (fst, snd) = xs splitAt n
           merge(msort(fst), msort(snd))
       }
   }
 
 
   // =========================
   // GEN APPLICAITON
   // ========================
   def msort_gen[T](xs: List[T])(lt: (T,T) => Boolean): List[T] = {
      
       val n = xs.length/2
       if (n==0) xs
       else {
 
           def merge_2(xs: List[T], ys: List[T]): List[T] = {
 
               (xs, ys) match {
 
                   case (Nil, ys) => ys // returns arbitrary ys
                   case (xs, Nil) => xs
                   case(x :: xs1, y :: ys1) => {
                       // ys not ys1
                       // xs1 not xs
 
                       // notice new version of comparison
                       if (lt(x,y)) x :: merge_2(xs1,ys)
                          
                       // other way around
                       else y ::  merge_2(xs, ys1)
                       }
                   }
               }
          
           // splitAt method
           val (fst, snd) = xs splitAt n
           merge_2(msort_gen(fst)(lt), msort_gen(snd)(lt))
           }
       }
 
 
   // =========================
   // GEN APPLICAITON
   // ========================
   import math.Ordering
  
   def msort_gen_1[T](xs: List[T])(ord: Ordering[T]): List[T] = {
      
       val n = xs.length/2
       if (n==0) xs
       else {
 
           def merge_3(xs: List[T], ys: List[T]): List[T] = {
 
               (xs, ys) match {
 
                   case (Nil, ys) => ys // returns arbitrary ys
                   case (xs, Nil) => xs
                   case(x :: xs1, y :: ys1) => {
                       // ys not ys1
                       // xs1 not xs
 
                       // notice new version of comparison
                       if (ord.lt(x,y)) x :: merge_3(xs1,ys)
                          
                       // other way around
                       else y ::  merge_3(xs, ys1)
                       }
                   }
               }
          
           // splitAt method
           val (fst, snd) = xs splitAt n
           merge_3(msort_gen_1(fst)(ord), msort_gen_1(snd)(ord))
           }
       }
 
 
}
 
 
 

