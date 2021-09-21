package com.example.stockholmtoromev2

data class BorderControll(  var country: String,
                            var image: Int,
                            var question: String,
                            var answer: List<String>,
                            var correctAnswer: Int) {
}

class QuestionsListBorderControll() {
    var listOfQuestionsBC: MutableList<BorderControll> = mutableListOf()

    init {
        val denmarkBC = BorderControll("Denmark",
            R.drawable.stop_sign1,
            "The danish people like beer, what is the beer consumption pp/year?",
            listOf("45l", "60l", "30l", "80l"),
            2)


        val germanyBC = BorderControll("Germany",
            R.drawable.stop_sign1,
            "Germany are famous for their carindustry, what brand is not from Germany?",
            listOf("Audi", "Porsche", "Fiat", "Volkswagen"),
            3)


        val switzerlandBC = BorderControll("Switzerland",
            R.drawable.stop_sign1,
            "What are the swiss not famous of?",
            listOf("Fondue", "Chocolate", "Cable cars", "Swiss cutlery"),
            4)

        val italyBC = BorderControll("Italy",
            R.drawable.stop_sign1,
            "What was the currency in Italy before they adopted the Euro?",
            listOf("Dinar", "Lira", "Franc", "Peso"),
            2)


        listOfQuestionsBC.add(denmarkBC)
        listOfQuestionsBC.add(germanyBC)
        listOfQuestionsBC.add(switzerlandBC)
        listOfQuestionsBC.add(italyBC)
    }
}