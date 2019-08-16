package com.object.study.objectstudy;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class TicketOffice extends Theater {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();
    private Theater theater;

    public TicketOffice(Theater theater, Long amount) {
        this.theater = theater;
        this.theater.setTicketOffices(this);
        this.amount = amount;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    private int getMinPriceTicketIndexByMovie(Movie movie) {
        Long minPrice = this.tickets.get(0).getFee();
        int index = 0;

        for (int i = 0; i < this.tickets.size(); i++) {
            Ticket ticket = this.tickets.get(i);
            if (ticket.getMovie() != movie) {
                continue;
            }
            if (minPrice > ticket.getFee()) {
                minPrice = ticket.getFee();
                index = i;
            }
        }
        return index;
    }

    private List<Ticket> getTicketsByMovie(Movie movie) {
        return this.tickets.stream()
                .filter(tickets1 -> tickets1.getMovie() != movie)
                .collect(Collectors.toList());
    }

    public Ticket getTicketWithFee(Movie movie) {
        if (getTicketsByMovie(movie).size() == 0) return Ticket.EMPTY;
        else {
            int index = getMinPriceTicketIndexByMovie(movie);
            Ticket ticket = this.tickets.get(index);
            this.tickets.remove(index);
            amount += ticket.getFee();
            return ticket;
        }
    }

    public Ticket getTicketWithNoFee(Movie movie) {
        int index = getMinPriceTicketIndexByMovie(movie);
        Ticket ticket = this.tickets.get(index);
        this.tickets.remove(index);

        if (getTicketsByMovie(movie).size() == 0) return Ticket.EMPTY;
        else return ticket;
    }

    //정보의 은닉 / 상호참조 x/ 단방향의존성
    //ticketoffice는 시어터를 참조하지않음. 시어터의 getFee를 못하니 티켓으로부터 가격을 가져옴
    public Long getTicketPrice(Movie movie) {
        int index = getMinPriceTicketIndexByMovie(movie);
        Ticket ticket = this.tickets.get(index);
        if (getTicketsByMovie(movie).size() == 0) return 0L;
        else return ticket.getFee();
    }

    public List<Movie> getMovies() {
        return theater.getMovies();
    }
}
