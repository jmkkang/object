package com.object.study.objectstudy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Theater {

    final private List<TicketOffice> ticketOffices = new ArrayList<>();
    final private Long fee;

    public Theater(Long fee) {
        this.fee = fee;
    }

    Long getFee() {
        return this.fee;
    }

    //다수의 매표소등록
    public void setTicketOffices(TicketOffice... ticketOffices) {
        List<TicketOffice> notBelongTicketOffices = Arrays.stream(ticketOffices)
                .filter(ticketOffice -> ticketOffice.getTheater() != this)
                .collect(Collectors.toList());

        if (notBelongTicketOffices.size() != 0) return;
        this.ticketOffices.addAll(Arrays.asList(ticketOffices));
    }

    //극장이 특정 매표소에게 티켓을 배포, 해당 극장에서 배포된 티켓이라는 것이 중요.
    public void setTicket(TicketOffice ticketOffice, Long num) {
        if (!ticketOffices.contains(ticketOffice) || ticketOffice.getTheater() != this) return;
        while (num-- > 0) {
            ticketOffice.addTicket(new Ticket(this));
        }
    }

    public void setInvitation(Audience audience) {
        audience.setInvitation(new Invitation(this));
    }

    public boolean enter(Audience audience) {
        Ticket ticket = audience.getTicket();
        return ticket.isValid(this);
    }
}
