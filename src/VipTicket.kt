class VIPTicket(movieName: String, showTime: String) : Ticket(movieName, showTime, 20.0)  {
    override val type: String = "VIP"

    override fun printDetails() {
        println("Movie: ${getMovieName()}, Show Time: ${getShowTime()}, Type: $type, Price: ${getPrice()}$")
    }
}