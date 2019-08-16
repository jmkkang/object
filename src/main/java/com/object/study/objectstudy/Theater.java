package com.object.study.objectstudy;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Theater {

    final private List<TicketOffice> ticketOffices = new ArrayList<>();
    final private List<Movie> movies = new ArrayList<>();

    public Theater() {
    }

    //다수의 매표소등록
    public void setTicketOffices(TicketOffice... ticketOffices) {
        this.ticketOffices.addAll(Arrays.asList(ticketOffices));
    }

    //극장이 특정 매표소에게 티켓을 배포, 해당 극장에서 배포된 티켓이라는 것이 중요.
    public void setTicket(TicketOffice ticketOffice, Movie movie, Long fee, Long num) {
        if (!ticketOffices.contains(ticketOffice) || !this.movies.contains(movie)) return;
        while (num-- > 0) {
            ticketOffice.addTicket(new Ticket(this, movie, fee));
        }
    }

    public void setInvitation(Audience audience, Movie movie) {
        audience.setInvitation(new Invitation(this, movie));
    }

    public void setMovies(Movie... movies) {
        this.movies.addAll(Arrays.asList(movies));
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public boolean enter(Audience audience) {
        List<Ticket> tickets = audience.getTicket();

        for (Ticket ticket : tickets) {
            if (!ticket.isValid(this)) return false;
        }

        return true;
    }
}
