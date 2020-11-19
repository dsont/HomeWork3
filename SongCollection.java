/*
Drayson Sanders
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
 */

import java.util.Hashtable;

//Creates variables
public class SongCollection {
    private String name;
    private Hashtable<String,Song> songs;

    //constructor
    public SongCollection(String name){
        this.name=name;
        songs=new Hashtable<String,Song>();//Creates a new hashtable for the input songs
    }

    //setter
    public void setName(String name){
        this.name=name;
    }

    //getters
    public Hashtable getSongs(){
        return songs;
    }
    public String getName(){
        return name;
    }

    //Allows user to add songs
    public void addSong(Song song){
        this.songs.put(song.getTitle(), song);
    }

    //Prints songs that are added
    public void printSongs(){
        this.songs.forEach((title, song) -> {
           String artist=song.getArtist();
           String genre=song.getGenre();
           System.out.println("Title "+title);
           System.out.println("Artist "+artist);
           System.out.println("Genre " +genre);
           System.out.println("---------");
        });
    }

    public Song lookUpSong(String title){
        return this.songs.get(title);
    }

}
