package com.object.study.objectstudy;

public class Movie {
    final static public Movie EMPTY = new Movie(null);
    private String name;
    private Long fee;

    public Movie(String name) {
        this.name = name;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Long getFee() {
        return fee;
    }
}
