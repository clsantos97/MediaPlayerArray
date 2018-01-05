package carlos.mediaplayerarray;

/**
 * Created by Carlos on 1/5/2018.
 */

public class Song {
    private String filename;
    private String title;
    private String artist;
    private int id;
    private int idimg;

    public Song(int id,String filename,String title, String artist, int idimg){
        this.id=id;
        this.filename=filename;
        this.title=title;
        this.artist=artist;
        this.idimg=idimg;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdimg() {
        return idimg;
    }

    public void setIdimg(int idimg) {
        this.idimg = idimg;
    }
}
