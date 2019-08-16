package com.object.study.objectstudy;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public void setTicketOffice(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    //갑은 셀러
    //트랜잭션에서는 객체와 주체를 잘 파악해야한다.
    public List<Ticket> getTicket(Audience audience) {
        List<Ticket> tickets = new ArrayList<>();

        List<Movie> movies = audience.getMovies()
                .stream()
                .filter(movie -> movie != Movie.EMPTY || this.ticketOffice.getMovies().contains(movie))
                .collect(Collectors.toList());

        if (movies.size() == 0) {
            return tickets;
        }

        // 한사람당 각 다른 영화만 다중 구입 가능한 전제
        for (Movie movie : movies) {
            Ticket ticket = Ticket.EMPTY;

            if (isNoFee(audience, movie)) {
                ticket = ticketOffice.getTicketWithNoFee(movie);
                if (ticket != Ticket.EMPTY) audience.removeInvitation();
            } else {
                Long price = ticketOffice.getTicketPrice(movie);
                if (price > 0 && audience.hasAmount(price)) {
                    ticket = ticketOffice.getTicketWithFee(movie);
                    if (ticket != Ticket.EMPTY) audience.minusAmount(price);
                } else if (price == 0) {
                    ticket = ticketOffice.getTicketWithNoFee(movie);
                }
            }

            tickets.add(ticket);
        }

        return tickets;
    }

    public boolean isNoFee(Audience audience, Movie movie) {
        return audience.getInvitation() != Invitation.EMPTY || audience.hasInvitationOfMovie(movie);
    }
}
