#### ================================
**Lecture 5.1: More Functions on Lists**
#### ================================ 

**Sublists and element access:**
- xs.head
- xs.tail (all elements except head)
- xs.length
- xs.last
- xs.init => list of all elements of xs exccept the last one (last)
- xs take n => list of first n elements
- xs drop n => remaining sublist after taking n elements
- xs(n) => element of xs at index n 

**Creating New Lists:**
- `xs ++ ys`: concatenation;
- `xs.reverse`; reverse order
- `xs updated (n,x)`; replace index n with x
  
**Finding Elements**
- `xs indexOf x`; yield index of first elem in xs equal to x, or yields -1 if x not in xs 
- `xs contains x`; boolean
 
**implementation of List methods**
- **last** runtime is proportional to length of the list
- **init** runtime also proportional to len of list
- **concat** complexity proportional to |xs|
- **reverse** n for concat (:::) and n for reverse --> n*n (quadratic)
```
object Week5 {


    def last[T](xs: List[T]): T = {

        xs match {
            case List() => throw new Error("last of empty list")
            case List(x) => x
            case y :: ys => last(ys)
            }
        }

    def init[T](xs: List[T]): List[T] = {

        xs match {
            case List() => throw new Error("init of empty list")
            case List(x) => List()
            case y :: ys => List(y) ++ init(ys)
            }

        }

    def concat[T](xs: List[T], ys: List[T]): List[T] = {

        // depends on xs --> concatenation defined by ::: operator
        // xs ::: ys is basically a prepend of xs onto ys
        // thus makes sense to pattern match on xs

        xs match {
            case List() => ys
            case z :: zs => z :: concat(zs , ys) 
        }


    def reverse[T](xs: List[T]): List[T] = {

        xs match {
            case List() => List()
            case y :: ys => reverse(ys) ::: List(y)
            }
        }

}  
```

