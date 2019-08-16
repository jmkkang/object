package com.object.study.objectstudy;

public class Ticket {
    final static public Ticket EMPTY = new Ticket(null, null, null);
    final private Theater theater;
    final private Movie movie;
    private boolean isEntered = false;
    final private Long fee;

    public Ticket(Theater theater, Movie movie, Long fee) {
        this.theater = theater;
        this.movie = movie;
        this.fee = fee;
    }

    public boolean isValid(Theater theater) {

        //자신이 null이나 잘못된 값인지를 체크할거면 null 대신에 객체로 사용한다.
        if (isEntered || theater != this.theater || this == EMPTY
                || !theater.getMovies().contains(this.movie)) {
            return false;
        } else {

            //maintenance of state 자기상태를 자기가 관리하는것
            isEntered = true;
            return true;
        }
    }

    public Long getFee() {
        return this.fee;
    }

    public Movie getMovie() {
        return this.movie;
    }
}
