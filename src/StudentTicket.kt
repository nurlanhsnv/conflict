class StudentTicket(movieName: String, showTime: String) : Ticket(movieName, showTime, 8.0) {
    override val type: String = "Student"

    override fun printDetails() {
        println("Movie: ${getMovieName()}, Show Time: ${getShowTime()}, Type: $type, Price: ${getPrice()}$")
    }
}