import java.util.Scanner;
fun main() {
    val scanner = Scanner(System.`in`);
    val purchasedTickets = mutableListOf<TicketPurchase>();
    val ticketManager = TicketManager();

    while (true) {
        try {
            println("Hello from Nihat");
            println("Welcome to the Ticket App!");
            println("Do you want to buy a Regular, VIP, or Student ticket?");
            println("Regular--> r");
            println("VIP--> v");
            println("Student--> s");
            val ticketTypeCode = scanner.nextLine();
            val ticketType = TicketTypeEnum.fromCode(ticketTypeCode) ?: throw IllegalArgumentException("Invalid ticket type. Please choose r, v, or s.");

            println("Select a movie:");
            ticketManager.movies.forEachIndexed { index, movie ->
                println("$index. $movie");
            }

            val movieIndex = scanner.nextLine().toIntOrNull() ?: throw NumberFormatException("Invalid movie selection, please choose a valid movie index.");
            if (movieIndex !in ticketManager.movies.indices) throw IllegalArgumentException("Invalid movie index.");

            println("Available time:");
            val times = listOf("28.05.2024 6PM", "29.05.2024 4PM", "30.05.2024 8PM");
            times.forEachIndexed { index, time ->
                println("$time  ---> ${index + 1}");
            }

            val showTimeIndex = scanner.nextLine().toIntOrNull() ?: throw NumberFormatException("Invalid show time selection, please choose a valid show time index.");
            val showTime = times.getOrNull(showTimeIndex - 1) ?: throw IllegalArgumentException("Invalid show time.");

            val ticketPurchase = ticketManager.buyTicket(ticketType, movieIndex, showTime) ?: throw IllegalStateException("Error in ticket creation.");
            println("Ticket Details:");
            println(ticketPurchase.getTicketDetails());
            ticketPurchase.ticket.printDetails();

            println("Do you want to buy this ticket? (yes/no)");
            val buyDecision = scanner.nextLine();
            if (buyDecision.equals("yes", ignoreCase = true)) {
                purchasedTickets.add(ticketPurchase.copy(buyDecision = "yes"));
                println("Ticket purchased successfully. Enjoy the movie!");
            } else {
                purchasedTickets.add(ticketPurchase.copy(buyDecision = "no"));
                println("Ticket not purchased.");
            }
        } catch (e: NumberFormatException) {
            println("Input error: ${e.message}. Please enter valid numeric values where required.");
        }   catch (e: IllegalArgumentException) {
            println("Argument error: ${e.message}. Please choose valid options.");
        } catch (e: Exception) {
            println("An unexpected error occurred: ${e.message}. Please try again.");
        }
    }
}