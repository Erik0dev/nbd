import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`
import scala.util.control.Breaks.{break, breakable}

object Main {
  def main(args: Array[String]) = {

    val dniTygodnia = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

    println("Zadanie 1: ")

    println("a) ")
    zadanie1a(dniTygodnia)

    println("b) ")
    println(zadanie1b(dniTygodnia))

    println("c) ")
    println(zadanie1c(dniTygodnia))


    println("Zadanie 2: ")
    println("a) ")
    println(zadanie2a(dniTygodnia))

    println("b) ")
    println(zadanie2b(dniTygodnia))

    println("Zadanie 3: ")
    println(zadanie3(dniTygodnia))


    println("Zadanie 4: ")
    println("a) ")
    println(zadanie4a(dniTygodnia))

    println("b) ")
    println(zadanie4b(dniTygodnia))

    println("c) ")
    println(zadanie4c(dniTygodnia))


    println("Zadanie 5: ")
    val produkty = Map("Mleko" -> 4, "Ser" -> 3, "Woda" -> 2)
    val wyprzedaz = produkty map { case (key, value) => (key, value * 0.9) }
    println(wyprzedaz)


    println("Zadanie 6:")
    zadanie6("abc", 3, dniTygodnia)


    println("Zadanie 7:")

    val mlekoCena = produkty.get("Mleko")
    println(mlekoCena)

    val serCena = produkty.get("Ser")
    println(serCena)


    println("Zadanie 8: ")
    val lista = List(3, 0, 8, -5, 0, 3, 2, 1, 7, 3, 0)
    println(zadanie8(lista))


    println("Zadanie 9: ")
    println(zadanie9(lista))


    println("Zadanie 10: ")
    val biggerIntList = List(-100, -6, -5, -3, 2, 0, 1, 2, 3, 4, 5, 6, 8, 15, 20, 300)
    println(zadanie10(biggerIntList))
  }

  def zadanie1a(dniTygodnia: List[String]) = {
    var polaczenie = "";
    for (i <- 0 until dniTygodnia.length) {
      if (polaczenie != "")
        polaczenie += ", " + dniTygodnia.get(i)
      else
        polaczenie += dniTygodnia.get(i)
    }
    println(polaczenie)

  }

  def zadanie1b(dniTygodnia: List[String]) = {
    var polaczenie = "";
    for (i <- 0 until dniTygodnia.length) {
      breakable {
        if (!dniTygodnia.get(i).startsWith("P")) break
        if (polaczenie != "")
          polaczenie += ", " + dniTygodnia.get(i)
        else
          polaczenie += dniTygodnia.get(i)
      }


    }
    polaczenie;
  }

  def zadanie1c(dniTygodnia: List[String]) = {
    var polaczenie = ""
    var index = 0;
    while (index < dniTygodnia.length) {
      if (polaczenie != "")
        polaczenie += ", " + dniTygodnia.get(index)
      else
        polaczenie += dniTygodnia.get(index)

      index = index + 1;
    }

    polaczenie
  }

  def zadanie2a(dniTygodnia: List[String]) = {
    def kolejnyDzien(i: Int): String = {
      if (i == dniTygodnia.length) return ""

      val obecnyDzien = if (i == dniTygodnia.length - 1) dniTygodnia.get(i) else dniTygodnia.get(i) + ", "

      obecnyDzien + kolejnyDzien(i + 1)
    }

    kolejnyDzien(0);
  }

  def zadanie2b(dniTygodnia: List[String]): String = {
    def kolejnyDzien(i: Int): String = {
      if (i == -1) return ""

      val obecnyDzien = if (i == 0) dniTygodnia.get(i) else dniTygodnia.get(i) + ", "

      obecnyDzien + kolejnyDzien(i - 1)
    }

    kolejnyDzien(dniTygodnia.length - 1)
  }

  def zadanie3(dniTygodnia: List[String]) = {
    @tailrec
    def kolejnyDzien(i: Int, polaczenie: String) : String = {
      if (i == dniTygodnia.length) return polaczenie

      val obecnyDzien = if (i == dniTygodnia.length - 1) dniTygodnia.get(i) else dniTygodnia.get(i) + ", "

      kolejnyDzien(i + 1, polaczenie + obecnyDzien)
    }
    kolejnyDzien(0, "")
  }

  def zadanie4a(dniTygodnia: List[String]) : String = {
    dniTygodnia.fold("") {(sum, curr) => {
      sum + curr + ", "
    }}.dropRight(2)
  }

  def zadanie4b(dniTygodnia: List[String]) : String = {
    dniTygodnia.foldRight("") {(sum, curr) => {
      sum + ", " + curr
    }}.dropRight(2)
  }

  def zadanie4c(dniTygodnia: List[String]) : String = {
    dniTygodnia.fold("") {(sum, curr) => {
     if (curr.startsWith("P"))
      sum + curr + ", "
     else sum

    }}.dropRight(2)
  }

  def zadanie6(tup: (String, Int, Any)) = {
    println(tup._1)
    println(tup._2)
    println(tup._3)
  }

  def zadanie8(lista: List[Int]): List[Int] = {
    def iter(index: Int, obecnaLista: List[Int]): List[Int] = {
      if (index >= obecnaLista.length) return obecnaLista;

      val (part1, part2) = obecnaLista.splitAt(index)

      if (obecnaLista.get(index) == 0)
        iter(index + 1, part1 ++ part2.tail)
      else
        iter(index + 1, obecnaLista)
    }

    iter(0, lista)
  }

  def zadanie9(lista: List[Int]): List[Int] = {
    lista map (el => el + 1)
  }

  def zadanie10(lista: List[Int]): List[Int] = {
    val filtrowanaLista = lista filter (el => el >= -5 && el <= 12)

    filtrowanaLista map (el => el.abs)
  }
}
