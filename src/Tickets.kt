abstract class Ticket(private val movieName: String, private val showTime: String, private val price: Double) {
    abstract fun printDetails()
    abstract  val type: String
    fun getMovieName(): String {
        return movieName
    }

    fun getShowTime(): String {
        return showTime
    }

    fun getPrice(): Double {
        return price
    }
}
