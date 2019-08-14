package com.object.study.objectstudy;


import java.util.ArrayList;
import java.util.List;

public class TicketSeller {
    private TicketOffice ticketOffice;

    //생성자에서 받아버리면 종신계약.. 변경될거라는 판단하에 setter
    public void setTicketOffice(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    //갑은 셀러다
    //트랜잭션에서는 객체와 주체를 잘 파악해야한다.
    public Ticket getTicket(Audience audience) {
        Ticket ticket = Ticket.EMPTY;
        List<Movie> movies = new ArrayList<>();

        for (Movie movie : audience.getMovies()) {
            if (movie != Movie.EMPTY) movies.add(movie);
        }

        if (movies.size() != 0) {

            Invitation invitation = audience.getInvitation();
            if (invitation != Invitation.EMPTY || invitation.getTheater()!= ) {


                ticket = ticketOffice.getTicketWithNoFee();
                if (ticket != Ticket.EMPTY) audience.removeInvitation();
            } else {
                Long price = ticketOffice.getTicketPrice();
                if (price > 0 && audience.hasAmount(price)) {
                    ticket = ticketOffice.getTicketWithFee();
                    if (ticket != Ticket.EMPTY) audience.minusAmount(price);
                }
            }
        }
        return ticket;

    }
}
