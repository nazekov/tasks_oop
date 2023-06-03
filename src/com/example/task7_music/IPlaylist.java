package com.example.task7_music;

import java.util.List;

public interface IPlaylist {

    List<ISong> getSongList();

    void addSong(ISong song);

    void remove(int index);

    void playAllSongs();
}
