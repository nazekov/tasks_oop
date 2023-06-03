package com.example.task7_music;

import com.example.task7_music.impl.PlaylistServiceImpl;

public class Main {
    public static void main(String[] args) {
        PlaylistService playlistService = new PlaylistServiceImpl();
        playlistService.run();
    }
}
