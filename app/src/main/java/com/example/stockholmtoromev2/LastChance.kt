package com.example.stockholmtoromev2

class LastChance(
    var country: String,
    var image: Int,
    var question: String,
    var answer: List<String>,
    var correctAnswer: Int){
}

class LastChanceQuestionsList() {
    var listOfQuestionslC: MutableList<LastChance> = mutableListOf()

    init {
        val denmark = LastChance(
            "Denmark",
            R.drawable.stop_sign1,
            "What is the national dish in Denmark?",
            listOf("Fried pork with parsleysause","Meatballs","Deepfried Fish","Fermented cabbage"),
            1)

        val germany = LastChance(
            "Germany",
            R.drawable.stop_sign1,
            "What of the following political parties are not from Germany?",
            listOf("CDU","VOX","ÖDP","Volt"),
            2
        )

        val switzerland = LastChance(
            "Switzerland",
            R.drawable.stop_sign1,
            "What cheese do not come fron Switzerland?",
            listOf("Emmentaler","Raclette","Gruyéré","Goda"),
            4
        )

        val italy = LastChance(
            "Italy",
            R.drawable.stop_sign1,
            "What is the nickname of the Italian footballteam?",
            listOf("gli Azzurri","Forza Fratelli","Nerazzurri","Blucerchiati"),
            1
        )
        listOfQuestionslC.add(denmark)
        listOfQuestionslC.add(germany)
        listOfQuestionslC.add(switzerland)
        listOfQuestionslC.add(italy)
    }


}