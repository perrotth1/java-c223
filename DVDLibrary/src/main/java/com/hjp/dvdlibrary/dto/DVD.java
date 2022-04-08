package com.hjp.dvdlibrary.dto;

/**
 *
 * @author Henry Perrottet
 */
public class DVD {
    private String title, releaseDate, rating, director, studio, note;
    
    public DVD( String _title, String _releaseDate, String _rating, 
                String _director, String _studio, String _note) {
        this.title = _title;
        this.releaseDate = _releaseDate;
        this.rating = _rating;
        this.director = _director;
        this.studio = _studio;
        this.note = _note;
    }
    
    public String getTitle() {
        return this.title;
    }
    public String getReleaseDate() {
        return this.releaseDate;
    }
    public String getRating(){ 
        return this.rating;
    }
    public String getDirector(){ 
        return this.director;
    }
    public String getStudio(){ 
        return this.studio;
    }
    public String getNote(){ 
        return this.note;
    }
    
    public void setTitle(String _title) {
        this.title = _title;
    }
    public void setReleaseDate(String _date) {
        this.releaseDate = _date;
    }
    public void setRating(String _rating){ 
        this.rating = _rating;
    }
    public void setDirector(String _director){ 
        this.director = _director;
    }
    public void setStudio(String _studio){ 
        this.studio = _studio;
    }
    public void setNote(String _note){ 
        this.note = _note;
    }
}
