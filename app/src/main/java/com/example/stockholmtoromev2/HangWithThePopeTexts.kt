package com.example.stockholmtoromev2

class HangWithThePope(
                            var image: Int,
                            var facts: String)


class HangWithThePopeFactList() {
    var listOfFacts: MutableList<HangWithThePope> = mutableListOf()


    init {
      val fontanaDiTrevi = HangWithThePope(
                                            R.drawable.fontana_de_trevi,
                                            "The Trevi Fountain (Italian: Fontana di Trevi)" +
                                                    " is a fountain in the Trevi district in Rome, designed by Italian architect Nicola Salvi and completed by Giuseppe Pannini and several others." +
                                                    " Standing 26.3 metres (86 ft) high and 49.15 metres (161.3 ft) wide, it is the largest Baroque fountain in the city and one of the most famous fountains in the world.")


        val colosseum = HangWithThePope(
                                            R.drawable.colosseum,
                                            "The Colosseum was used to host gladiatorial shows as well as a variety of other events." +
                                                    " The shows, called munera, were always given by private individuals rather than the state." +
                                                    " They had a strong religious element but were also demonstrations of power and family prestige," +
                                                    " and were immensely popular with the population. Another popular type of show was the animal hunt")


        val pizzaAlTaglio = HangWithThePope(
                                            R.drawable.pizza_taglio,
                                            "Pizza al taglio is a variety of pizza baked in large rectangular trays," +
                                                    "and generally sold in rectangular or square slices by weight, with prices marked per kilogram or per 100 grams." +
                                                    " This type of pizza was invented in Rome, Italy, and is common throughout Italy." +
                                                    " Many variations and styles of pizza al taglio exist, and the dish is available in other areas of the world in addition to Italy.")


        val romaLoggo = HangWithThePope(
                                            R.drawable.roma_loggo,
                                            "A.S. Roma was founded in the spring of 1927 when Italo Foschi initiated the merger of three older Italian Football Championship clubs from the city of Rome:" +
                                                    " Roman FC, SS Alba-Audace and Fortitudo-Pro Roma SGS. Italo Foschi was an important Roman representative of the ruling National Fascist Party")

        listOfFacts.add(fontanaDiTrevi)
        listOfFacts.add(colosseum)
        listOfFacts.add(pizzaAlTaglio)
        listOfFacts.add(romaLoggo)


    }

}