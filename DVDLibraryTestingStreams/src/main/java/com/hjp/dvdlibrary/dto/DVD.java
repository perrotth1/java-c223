package com.hjp.dvdlibrary.dto;

import java.util.Objects;

/**
 *
 * @author Henry Perrottet
 */
public class DVD {
    private String title, releaseDate, rating, director, studio, note;
    
    @Override
    public String toString() {
        return "DVD{" + "title=" + title + ", releaseDate=" + releaseDate + ", rating=" + rating + ", director=" + director + ", studio=" + studio + ", note=" + note + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.title);
        hash = 17 * hash + Objects.hashCode(this.releaseDate);
        hash = 17 * hash + Objects.hashCode(this.rating);
        hash = 17 * hash + Objects.hashCode(this.director);
        hash = 17 * hash + Objects.hashCode(this.studio);
        hash = 17 * hash + Objects.hashCode(this.note);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        return Objects.equals(this.note, other.note);
    }
    
    
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
