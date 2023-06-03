package com.example.task7_music.impl;

import com.example.task7_music.Author;
import com.example.task7_music.ISong;

public class Song implements ISong {

    private String name;

    private Author author;

    public Song() {
    }

    public Song(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Author getAuthor() {
        return author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public void play() {
        System.out.println("Играет песня: " + name + ", автор: " + author);
    }
}
