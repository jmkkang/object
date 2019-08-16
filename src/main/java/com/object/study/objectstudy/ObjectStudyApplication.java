package com.object.study.objectstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObjectStudyApplication {

    public static void main(String[] args) {
        // SpringApplication.run(ObjectStudyApplication.class, args);
        Theater theater = new Theater();

        Audience audience1 = new Audience(0L);
        Audience audience2 = new Audience(100L);

        Movie movie1 = new Movie("곡성");
        Movie movie2 = new Movie("엑시트");
        Movie movie3 = new Movie("라이언킹");

        theater.setMovies(movie1, movie2);

        TicketOffice ticketOffice = new TicketOffice(theater, 0L);
        TicketSeller ticketSeller = new TicketSeller();

        theater.setTicketOffices(ticketOffice);

        theater.setTicket(ticketOffice, movie1, 0L, 1L);
        theater.setTicket(ticketOffice, movie1, 30L, 1L);
        theater.setTicket(ticketOffice, movie2, 80L, 5L);
        theater.setTicket(ticketOffice, movie3, 20L, 10L);

        theater.setInvitation(audience1, movie1);

        ticketSeller.setTicketOffice(ticketOffice);

        audience1.setMovies(movie1);
        audience1.setMovies(movie1);
        audience2.setMovies(movie1);
        audience2.setMovies(movie2);
        audience2.setMovies(movie3);

        audience1.buyTicket(ticketSeller);
        audience2.buyTicket(ticketSeller);

        boolean isOk1 = theater.enter(audience1);
        boolean isOk2 = theater.enter(audience2);

        for (Ticket ticket : audience1.getTicket()) {
            System.out.println("1번이 구입한 티켓가격 " + ticket.getFee());
        }

        for (Ticket ticket : audience2.getTicket()) {
            System.out.println("2번이 구입한 티켓가격 " + ticket.getFee());
        }

        System.out.println(audience1.getAmount());
        System.out.println(audience2.getAmount());

    }

}
