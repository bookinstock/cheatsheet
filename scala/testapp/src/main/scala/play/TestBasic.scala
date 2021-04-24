

package play


object TestBasic {

    def test() {
        println("##basic")
        test_varialbe()
        test_if_else()
        test_pattern_match()
        // test_exception()
        // test_for()
        // test_trait()
        // test_collection()
        // test_tuple()
    }

    def test_varialbe() {
        println("###test_varialbe")
        val immut = 1
        var mut = 2
        mut = 3
        println("immut=", immut, "mut=", mut)

        val user = new User(name="sam", age=18)
        println("user=", user)
    }

    def test_if_else() = {
        println("###test_if_else")
        val r = if (false) 1 else if (false) -1 else 0
        println("r=", r)

        val (a,b) = (1,2)
        val max = if (a > b) a else b
        println("max=", max)
    }

    def test_pattern_match() {
        println("###test_pattern_match")

        val c = 3
        val r3 = c match {
            case 1 => "one"
            case 2 => "two"
            case 3 => "three"
            case _ => "?"
        }
        println("r3=", r3)

        def _get_type(value: Any):String = value match {
            case v: String => s"str ($v)"
            case v: Integer => s"int ($v)"
            case v: Float => s"float ($v)"
            case v: List[_] => s"lst ($v)"
            case v: User => s"user ($v)"
            case _ => "?"
        }

        val user = new User(name="sam", age=18)
        val r4 = _get_type(user)
        println("r4=", r4)
    }


    def test_exception() {
        try {
            1/0
        } catch {
            case e: Exception => println("e=", e)
        }
    }

    def test_for() {
        val lst0 = for (e <- List(1,2,3,4,5)) yield e
        val vec1 = for (e <- 0 to 5) yield e
        val vec2 = for (e <- 10 to 0 by -2) yield e
        val vec3 = for (e <- 0 to 5) yield e * 2
        val vec4 = for (e <- 0 to 10 if e % 2 == 0) yield e

        println("lst0=", lst0)
        println("vec1=", vec1)
        println("vec2=", vec2)
        println("vec3=", vec3)
        println("vec4=", vec4)

        val map = Map(
            "a" -> 1,
            "b" -> 2,
            "c" -> 3
        )

        val x = for ((k, v) <- map) yield (k,v* 2)
        println(x)

        println("---")
        val s = Seq(1,2,3,4,5)
        println("aa")
        for (e<- s) println(e)
        println("bb")
        s.foreach(println)
    }

    def test_trait() =  {
        trait A  {
            def a(): Int
        }

        trait B {
            def b(): Int = 2
        }

        class C extends A with B {
            override def a(): Int = 1
        }

        val c = new C

        println(c.a)
        println(c.b)
    }


    def test_collection() = {
        // list
        val lst = List.range(0, 5)

        println("lst=", lst)

        val lst2 = (0 to 5 by 2).toList

        println("lst2=", lst2)

        println("--1")

        lst.map(_* 2).filter(_ < 5).foreach(println)

        println("--2")

        val sum = lst.foldLeft(0)(_ + _)

        println("sum=", sum)

        // vector

        val vec = Vector.range(0, 5)

        println("vec=", vec)

        // map

        // set
    }

    def test_tuple() = {
        val t = (1, 1.0, "1", true)

        println("t=", t)

        println(t._1, t._2)

        val (a,b,c,d) = t

        println( a,b,c,d)
    }


}

class User(name: String, age: Integer) {
    override def toString(): String = f"$name($age)"
}