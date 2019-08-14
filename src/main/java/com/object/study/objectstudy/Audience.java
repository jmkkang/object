package com.object.study.objectstudy;

public class Audience {
    private Ticket ticket = Ticket.EMPTY;
    private Invitation invitation = Invitation.EMPTY;
    private Long amount;
    private Movie movie;

    public Audience(Long amount) {
        this.amount = amount;
    }

    public void buyTicket(TicketSeller seller) {
        ticket = seller.getTicket(this);
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public Movie getMovie(){
        return movie;
    }
}
