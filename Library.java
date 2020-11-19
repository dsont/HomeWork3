/*
Drayson Sanders
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
 */

import java.util.Arrays;
import java.util.Hashtable;
import java.nio.file.*;
import java.io.*;
import java.util.Scanner;

//setting variables
public class Library {
    private String ownerName;
    private SongCollection home;
    private Hashtable<String, Playlist> playlists;


    //constructor
    public Library (String ownerName){
        this.ownerName=ownerName;
        this.home=new SongCollection("home");
        this.playlists=new Hashtable<String, Playlist>();//creating a new Hashtable called playlists
    }

    //getters
    public String getOwnerName(){
        return this.ownerName;
    }
    public SongCollection getHome(){
        return this.home;
    }
    public Hashtable getPlaylists(){
        return this.playlists;
    }

    //Program uploads songs provided in a .txt file
    public void uploadDemoSongs(){
        Path file=Paths.get("/Users/draysonsanders/IdeaProjects/Homework3/demo_songs.txt");//Path to upload for .txt
        InputStream input=null;

        //Reade the .txt file line by line in order to add songs to overall library
        try{
            input=Files.newInputStream(file);
            BufferedReader reader=new BufferedReader(new InputStreamReader(input));
            String s=null;
            while ((s = reader.readLine()) != null) {

                String songDetails[] = s.split(",");
                String title=songDetails[0];
                String artist=songDetails[1];
                String genre=songDetails[2];

                Song song=new Song(title,artist,genre);
                this.home.addSong(song);
            }
            System.out.println("Demo Songs were added to Library.");
            input.close();
        }
        //throws and exception if above code in this method does not work
        catch (IOException e){
            System.out.println(e);
        }
    }

    //Allows users to name their new playlist as well as give it a description displayed in a print statement
    public Playlist createPlaylist(Scanner inputDevice){
    System.out.println("What would you like to name the playlist?");
    String name = inputDevice.nextLine();
    System.out.println("What do you want the description to be?");
    String description =  inputDevice.nextLine();
    Playlist playlist = new Playlist(name,description);
        char addAnother='n';//automatically sets the response of adding another song to 'n' unless otherwise stated by user

        //Allows user to add a song to the playlist by asking song name, artist and genre
        do {
            System.out.println("Lets add a song to the " +name+ " playlist.");
            System.out.print("Song name: ");
            String title = inputDevice.nextLine();
            System.out.print("Artist name: ");
            String artist = inputDevice.nextLine();
            System.out.print("Genre: ");
            String genre = inputDevice.nextLine();
            Song song =new Song(title, artist, genre);
            playlist.addSong(song);
            System.out.print("Would you like to add another song? (y/n): ");
            addAnother = inputDevice.nextLine().charAt(0);
        } while (Character.toLowerCase(addAnother) == 'y');
    return playlist;
    }


    public void addPlaylist(Playlist playlist) {
        this.playlists.put(playlist.getName(),playlist);
        //For each loop allows program to add each song from playlist into the song collection object
        playlist.getSongs().forEach((title, song) -> {
            this.home.addSong((Song) song);
        });
    }

    public Hashtable<String, Playlist> getPlaylist(){
    return playlists;
    }

    //Program prints the library including playlists and all songs in a final print statement
    public void printLibrary(){
        System.out.println("Library Owner "+ownerName);
        System.out.println("Songs in Library: ");
        System.out.println("---------");
        this.home.printSongs();
        //for each loop prints each playlist set in the playlist hashtable
        this.playlists.forEach((name, playlist) -> {
            System.out.println("PLAYLIST NAME: " +playlist.getName());
            System.out.println("PLAYLIST DESCRIPTION: "+playlist.getDescription());
            playlist.printSongs();
        });
    }
}
