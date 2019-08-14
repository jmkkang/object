package com.object.study.objectstudy;

import java.util.ArrayList;
import java.util.List;


public class TicketOffice extends Theater {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();
    private Theater theater;

    public TicketOffice(Theater theater, Long amount) {
        this.theater = theater;
        this.theater.setTicketOffices(this);
        this.amount = amount;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Theater getTheater() {
        return this.theater;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public Ticket getTicketWithFee() {
        if (tickets.size() == 0) return Ticket.EMPTY;
        else {
            Ticket ticket = tickets.remove(0);
            amount += ticket.getFee();
            return ticket;
        }
    }

    //ticketoffice는 invitation의 존재를 모르니, invitation이라는 명칭을 사용하지 않음.
    public Ticket getTicketWithNoFee() {
        if (tickets.size() == 0) return Ticket.EMPTY;
        else return tickets.remove(0);
    }

    //정보의 은닉 / 상호참조 x/ 단방향의존성
    //ticketoffice는 시어터를 참조하지않음. 시어터의 getFee를 못하니 티켓으로부터 가격을 가져옴
    public Long getTicketPrice() {
        if (tickets.size() == 0) return 0L;
        else return tickets.get(0).getFee();
    }


}
