package com.object.study.objectstudy;

public class Movie {
    final static public Movie EMPTY = new Movie(null);
    private String name;

    public Movie(String name) {
        this.name = name;
    }

}
