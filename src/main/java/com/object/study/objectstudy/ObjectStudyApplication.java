package com.object.study.objectstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObjectStudyApplication {

    public static void main(String[] args) {
        // SpringApplication.run(ObjectStudyApplication.class, args);
        Theater theater = new Theater();
        Audience audience1 = new Audience(0L);
        Audience audience2 = new Audience(50L);

        Movie movie1 = new Movie("곡성");
        Movie movie2 = new Movie("엑시트");
        Movie movie3 = new Movie("라이언킹");

        theater.setMovies(movie1);
        theater.setMovies(movie2);
        theater.setMovies(movie3);

        TicketOffice ticketOffice = new TicketOffice(theater, 0L);
        TicketSeller ticketSeller = new TicketSeller();

        theater.setTicketOffices(ticketOffice);

        theater.setTicket(ticketOffice, movie1, 80L, 10L);
        theater.setTicket(ticketOffice, movie1, 100L, 20L);
        theater.setTicket(ticketOffice, movie2, 100L, 40L);
        theater.setTicket(ticketOffice, movie3, 0L, 1L);

        theater.setInvitation(audience1, movie1);

        ticketSeller.setTicketOffice(ticketOffice);

        audience1.setMovies(movie2);
        audience1.setMovies(movie3);

        audience1.buyTicket(ticketSeller);
        audience2.buyTicket(ticketSeller);

        boolean isOk1 = theater.enter(audience1);
        boolean isOk2 = theater.enter(audience2);

        System.out.println(isOk1);
        System.out.println(isOk2);
    }

}
