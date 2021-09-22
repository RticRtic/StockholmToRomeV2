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
            R.drawable.last_chance2,
            "What is the national dish in Denmark?",
            listOf("Fried pork with parsleysauce","Meatballs","Deepfried Fish","Fermented cabbage"),
            1)

        val germany = LastChance(
            "Germany",
            R.drawable.last_chance2,
            "What of the following political parties are not from Germany?",
            listOf("CDU","VOX","ÖDP","VOLT"),
            2
        )

        val switzerland = LastChance(
            "Switzerland",
            R.drawable.last_chance2,
            "What cheese do not come fron Switzerland?",
            listOf("Emmentaler","Raclette","Gruyéré","Gouda"),
            4
        )

        val italy = LastChance(
            "Italy",
            R.drawable.last_chance2,
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