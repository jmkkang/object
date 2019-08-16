package com.object.study.objectstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Audience {
    private List<Ticket> tickets = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();
    private Invitation invitation = Invitation.EMPTY;
    private Long amount;

    public Audience(Long amount) {
        this.amount = amount;
    }

    public void buyTicket(TicketSeller seller) {

        tickets = seller.getTicket(this);
    }

    public boolean hasAmount(Long amount) {
        return this.amount >= amount;
    }

    public boolean minusAmount(Long amount) {
        if (amount > this.amount) return false;
        this.amount -= amount;
        return true;
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public void removeInvitation() {
        invitation = Invitation.EMPTY;
    }

    public List<Ticket> getTicket() {
        return tickets;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public void setMovies(Movie... movies) {
        this.movies.addAll(Arrays.asList(movies));
    }

    public List<Movie> getMovies() {
        return this.movies;
    }

    public Long getAmount() {
        return this.amount;
    }

    public boolean hasInvitationOfMovie(Movie movie) {
        return this.invitation.hasMovie(movie);
    }
}
