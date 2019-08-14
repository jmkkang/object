package com.object.study.objectstudy;

public class Invitation {
    final static public Invitation EMPTY = new Invitation(null);
    final private Theater theater;
  //  final private Movie movie ;

    public Invitation(Theater theater) {
        this.theater = theater;
   //     this.movie = movie;
    }
}
