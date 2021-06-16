object Main {

  def main(args: Array[String]): Unit = {


    println("zadanie 1:")
    println(zadanie1("Poniedziałek"))
    println(zadanie1("Niedziela"))
    println(zadanie1("Polska"))

    println("zadanie 2:")
    val konto1 = new KontoBankowe(1000)
    println(konto1.stanKonta)

    val konto2 = new KontoBankowe()
    println(konto2.stanKonta)
    println(konto2.wplata(100))
    println(konto2.wyplata(200))

    println("zadanie 3:")

    val osoba1 = Osoba("Eryk", "Dzierzkowski")
    val osoba2 = Osoba("Gabriel", "Anioł")
    val osoba3 = Osoba("Tadeusz", "Rydzyk")
    val osoba4 = Osoba("Janusz", "Nowak")

    przywitanie(osoba1)
    przywitanie(osoba2)
    przywitanie(osoba3)
    przywitanie(osoba4)


    println("zadanie 4:")

    val liczba = 100
    def plus500(num: Int): Int = num + 500
    println(zadanie4(liczba, plus500))


    println("zadanie 5:")

    val osoba5 = new Osoba("Jan", "Kowalski") with Student
    println(s"Podatek studenta wynosi: ${osoba5.podatek}%")

    val osoba6 = new Osoba("Artur", "Kowalski") with Pracownik
    println(s"Podatek pracownika wynosi ${osoba6.podatek}%")

    val osoba7 = new Osoba("Marek", "Kowalski") with Nauczyciel
    println(s"Podatek nauczyciela wynosi ${osoba7.podatek}%")

    val osoba8 = new Osoba("Piotr", "Kowalski") with Student with Pracownik
    println(s"Podatek studenta, który pracuje wynosi ${osoba8.podatek}%")

    val osoba9 = new Osoba("Janusz", "Kowalski") with Pracownik with Student
    println(s"Podatek pracownika, który studiuje wynosi ${osoba9.podatek}%")
  }

  def zadanie1(str: String): String = {
    val praca = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek")
    val weekend = List("Sobota", "Niedziela")

    str match {
      case a if (praca.contains(a)) => "Praca"
      case b if (weekend.contains(b)) => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }

  def przywitanie(osoba: Osoba) = {
    val przywitanie = osoba match {
      case Osoba("Eryk", "Dzierzkowski") => "Jestem Eryk, wystarczy mi zwolnienie z egzaminu."
      case Osoba("Gabriel", "Anioł") => "Hej, jestem Gabriel. Najpierw masa potem rzeźba."
      case Osoba("Tadeusz", "Rydzyk") => "Jestem Tadeusz, Bóg zapłać."
      case _ => "Hej."
    }

    println(przywitanie)
    przywitanie
  }

  def zadanie4(liczba: Int, fun: (Int) => Int): Int = {
    fun(fun(fun(liczba)))
  }
}
