package com.company.duplicatedchecker;

public class Pair<Boolean,Int> {
    public final Boolean duplicated;
    public final Int index;

    public Pair(Boolean duplicated, Int index) {
        this.duplicated = duplicated;
        this.index = index;
    }
}