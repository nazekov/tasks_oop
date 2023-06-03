package com.example.task7_music.impl;

import com.example.task7_music.IPlaylist;
import com.example.task7_music.ISong;
import java.util.ArrayList;
import java.util.List;

public class Playlist implements IPlaylist {

    private List<ISong> songList;

    public Playlist() {
        songList = new ArrayList<>();
    }

    public Playlist(List<ISong> songList) {
        if (songList == null) {
            songList = new ArrayList<>();
            return;
        }
        this.songList = songList;
    }

    @Override
    public List<ISong> getSongList() {
        return songList;
    }

    public void setSongList(List<ISong> songList) {
        this.songList = songList;
    }

    @Override
    public void addSong(ISong song) {
        songList.add(song);
    }

    @Override
    public void remove(int index) {
        songList.remove(index);
    }

    @Override
    public void playAllSongs() {
        for (int i = 0; i < songList.size(); i++) {
            System.out.print(i + ") ");
            songList.get(i).play();
        }
    }
}
