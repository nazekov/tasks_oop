package com.example.task7_music.impl;

import com.example.task7_music.Author;
import com.example.task7_music.IPlaylist;
import com.example.task7_music.PlaylistService;
import java.util.Scanner;

public class PlaylistServiceImpl implements PlaylistService {

    private IPlaylist iPlaylist;

    private boolean isWork;

    private Scanner sc;

    public PlaylistServiceImpl() {
        iPlaylist = new Playlist();
        sc = new Scanner(System.in);
        isWork = true;
    }

    @Override
    public IPlaylist getIPlaylist() {
        return iPlaylist;
    }

    public void setiPlaylist(IPlaylist iPlaylist) {
        this.iPlaylist = iPlaylist;
    }

    @Override
    public void run() {
        while (isWork) {
            int cmd = getCmd();
            if (cmd < 1 || cmd > 4) {
                System.out.println("Такой команды нет");
                continue;
            }

            if (cmd == 1) {
                addSongToPlaylist();
            } else if (cmd == 2) {
                removeSongFromPlaylist();
            } else if (cmd == 3) {
                playAllSongs();
            } else {
                finish();
            }
        }
    }

    private int getCmd() {
        System.out.println("\nMenu:\n" +
                "1 - добавить песню \n" +
                "2 - удалить песню \n" +
                "3 - включить плеер \n" +
                "4 - выйти\n" +
                "Введите команду: ");
        return Integer.parseInt(sc.nextLine());
    }

    private void finish() {
        System.out.println("\nКонец работы програмы");
        isWork = false;
    }

    private void playAllSongs() {
        System.out.println("\nИграют все песни:");
        iPlaylist.playAllSongs();
    }

    private void removeSongFromPlaylist() {
        System.out.print("\nВведите id песни для его удаления: ");
        int id = Integer.parseInt(sc.nextLine());
        if (isNotCorrectIndex(id)) {
            System.out.println("Песни под таким номером нет");
            return;
        }
        iPlaylist.remove(id);
        System.out.println("Песня удалена");
    }

    private void addSongToPlaylist() {
        System.out.print("\nВведите название песни: ");
        String nameSong = sc.nextLine();
        System.out.print("Введите имя автора: ");
        String nameAuthor = sc.nextLine();
        iPlaylist.addSong(new Song(nameSong, new Author(nameAuthor)));
        System.out.println("Песня добавлена.");
    }

    private boolean isNotCorrectIndex(int id) {
        return id < 0 || id >= iPlaylist.getSongList().size();
    }
}
