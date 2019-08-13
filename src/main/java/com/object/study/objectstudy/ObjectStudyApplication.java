package com.object.study.objectstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObjectStudyApplication {

    public static void main(String[] args) {
        // SpringApplication.run(ObjectStudyApplication.class, args);
        Theater theater = new Theater(100L);
        Audience audience1 = new Audience(0L);
        Audience audience2 = new Audience(50L);

        TicketOffice ticketOffice = new TicketOffice(0L);
        TicketSeller ticketSeller = new TicketSeller();

        theater.setTicketOffices(ticketOffice);
        theater.setTicket(ticketOffice, 10L);
        theater.setInvitation(audience1);

        ticketSeller.setTicketOffice(ticketOffice);
        audience1.buyTicket(ticketSeller);
        audience2.buyTicket(ticketSeller);

        boolean isOk1 = theater.enter(audience1);
        boolean isOk2 = theater.enter(audience2);

        System.out.println(isOk1);
        System.out.println(isOk2);
    }

}
