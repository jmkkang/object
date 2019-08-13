package com.object.study.objectstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObjectStudyApplication {

    public static void main(String[] args) {
        // SpringApplication.run(ObjectStudyApplication.class, args);
        Theater theater = new Theater(100L);
        Theater theater2 = new Theater(100L);

        Audience audience1 = new Audience(0L);
        Audience audience2 = new Audience(50L);

        TicketOffice ticketOffice = new TicketOffice(0L);
        //극장과 N:1관계이며 변경가능하다는 전제, 티켓 발부할 떄 소속극장 체크 필요.
        ticketOffice.setTheater(theater);

        TicketSeller ticketSeller = new TicketSeller();

        theater.setTicketOffices(ticketOffice);
        theater.setTicket(ticketOffice, 10L);
        theater.setInvitation(audience1);

        ticketSeller.setTicketOffice(ticketOffice);
        audience1.buyTicket(ticketSeller);
        audience2.buyTicket(ticketSeller);

        boolean isOk1 = theater.enter(audience1);
        boolean isOk2 = theater.enter(audience2);

        System.out.println(isOk1); //true
        System.out.println(isOk2); //false
    }

}
