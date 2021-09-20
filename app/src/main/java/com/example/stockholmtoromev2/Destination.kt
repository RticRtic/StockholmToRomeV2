package com.example.stockholmtoromev2

data class Destination( var country: String,
                        var image: Int,
                        var question: String,
                        var answer: List<String>,
                        var correctAnswer: Int) {
}

class QuestionsList() {
    var listOfQuestions: MutableList<Destination> = mutableListOf()

    init {
        val denmark = Destination(      "Denmark",
                                        R.drawable.danmark_flagga,
                                        "Who was the Danish king whom ruled over England during the viking era?",
                                        listOf("Knut the great one","Albert the gready","Björn ironside","Gorm the old"),
                                        1)


        val germnay = Destination(      "Germany",
                                        R.drawable.germany_flag,
                                        "Which river is the longest in Germany?",
                                        listOf("Rhen","Elbe","Donau","Weser"),
                                        1)


        val switzerland = Destination(  "Switzerland",
                                        R.drawable.switzerland_flag,
                                        "What brand does not originate from Switzerland?",
                                        listOf("Knorr","Breitling","Birkenstock","Lindt"),
                                        3)

        val Italy = Destination(        "Italy",
                                        R.drawable.italy_flag,
                                        "What is the most popular food in Italy?",
                                        listOf("Rice","Pasta","Potatoes","Ramen"),
                                        2)


        listOfQuestions.add(denmark)
        listOfQuestions.add(germnay)
        listOfQuestions.add(switzerland)
        listOfQuestions.add(Italy)



    }


}