/*
Drayson Sanders
UNIVERSITY OF PITTSBURGH AT BRADFORD
CIST 1450 - FALL 2020
HOMEWORK 3
 */

//method that is inheriting from SongCollection.java
public class Playlist extends SongCollection {
    private String description;
    public Playlist(String name, String description){
        super(name);//referring to parent class constructor
        this.description=description;
    }

    //setters
    public void setDescription(String description){
        this.description=description;
    }

    //getters
    public String getDescription(){
        return this.description;
    }
}
