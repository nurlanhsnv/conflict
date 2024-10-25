class RegularTicket(movieName: String, showTime: String) : Ticket(movieName, showTime, 10.0) {
    override val type: String = "Regular"

    override fun printDetails() {
        println("Movie: ${getMovieName()}, Show Time: ${getShowTime()}, Type: $type, Price: ${getPrice()}$")
    }
}