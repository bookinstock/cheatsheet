



package play


object TestBasic {

    def test() {
        test_varialbe()
        test_control_flow()
        test_exception()
        test_for()
    }

    def test_varialbe() = {
        val immut = 1
        var mut = 2

        println("immut=", immut, "mut=", mut)

        val user = new User(name="sam", age=18)
        println("user=", user)
    }

    def test_control_flow() = {
        val r1 = if (false) {
            0
        } else if (false) {
            -1
        } else {
            1
        }
        println("r1=", r1)

        val (a,b) = (1,2)
        val r2 = if (a > b) a else b
        println("r2=", r2)

        val c = 3
        val r3 = c match {
            case 1 => "one"
            case 2 => "two"
            case 3 => "three"
            case _ => "?"
        }
        println("r3=", r3)

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
        val lst1 = for (e <- 0 to 5) yield e
        val lst2 = for (e <- 10 to 0 by -2) yield e
        val lst3 = for (e <- 0 to 5) yield e * 2
        val lst4 = for (e <- 0 to 10 if e % 2 == 0) yield e

        println("lst0=", lst0)
        println("lst1=", lst1)
        println("lst2=", lst2)
        println("lst3=", lst3)
        println("lst4=", lst4)
    }

    def _get_type(value: Any):String = value match {
        case v: String => s"str ($v)"
        case v: Integer => s"int ($v)"
        case v: Float => s"float ($v)"
        case v: List[_] => s"lst ($v)"
        case v: User => s"user ($v)"
        case _ => "?"
    }
}

class User(name: String, age: Integer) {
    override def toString(): String = f"$name($age)"
}