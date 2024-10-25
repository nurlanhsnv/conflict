class TicketManager {
    val movies = listOf("Kung Fu Panda 4", "The Silent Voice", "Demon Slayer: Mugen Train", "Your Name")

    fun buyTicket(ticketType: TicketTypeEnum, movieIndex: Int, showTime: String): TicketPurchase? {
        val selectedMovie = movies.getOrNull(movieIndex)
        return when (ticketType) {
            TicketTypeEnum.REGULAR -> selectedMovie?.let { TicketPurchase(RegularTicket(it, showTime), "") }
            TicketTypeEnum.VIP -> selectedMovie?.let { TicketPurchase(VIPTicket(it, showTime), "") }
            TicketTypeEnum.STUDENT -> selectedMovie?.let { TicketPurchase(StudentTicket(it, showTime), "") }
        }
    }
}