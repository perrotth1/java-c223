package com.hjp.dvdlibrary.ui;

import com.hjp.dvdlibrary.dto.*;

import java.util.List;
/**
 *
 * @author Henry Perrottet
 */
public class DVDLibraryView {
    private UserIO io;
    
    public DVDLibraryView(UserIO _io) {
        this.io = _io;
    }
    public void bar(){
        io.print("\n\n\n================================\n\n\n");
    }
    public void displayMenu() {
        io.print(" === DVD COLLECTION MENU === ");
        io.print(" 1) Add DVD \n 2) Remove DVD \n 3) Edit DVD \n 4) List DVDs \n"
                + " 5) Show a DVD \n 6) Search DVDs");
        io.print(" 7) Get movies released in the last N years");
        io.print(" 8) Get movies by MPAA rating");
        io.print(" 9) Get movies by director");   
        io.print(" 10) Get movies by studio");
        io.print(" 11) Get average age of movies in collection");
        io.print(" 12) Get newest movie in collection");
        io.print(" 13) Get oldest movie in collection");
        io.print(" 14) Get average number of notes associated with movies");
    }
    public int getSelection() {
        return io.readInt("Please Enter Selection >");
    }
    public String readTitle() {
        return io.readString("Please Enter Movie Title: ");
    }
    public String readReleaseDate() {
        return io.readString("Please Enter Movie Release Date (MM/DD/YYYY): ");
    }
    public String readRating() {
        return io.readString("Please Enter Movie MPAA Rating: ");
    }
    public String readDirector() {
        return io.readString("Please Enter Movie Director: ");
    }
    public String readStudio() {
        return io.readString("Please Enter Studio: ");
    }
    public String readNote() {
        return io.readString("Please Enter a Note (opinions, score, etc): ");
    }
    public int displayEditMenuGetSelect() {
        io.print("  1) Title\n  2) Release Date\n  3) Rating\n  4) Director\n  5) Studio\n  6) Notes\n  0) Exit\n");
        return io.readInt("Please Select Which Value to Update: ", 0, 6);
    }
    public boolean displayEditAgain(){
        if(io.readString("Edit Another Value? (y/n)").equalsIgnoreCase("y")){
            return true;
        }
        return false;
    }
    public void printDVD(DVD _DVD) {
        io.print("\n Title: " + _DVD.getTitle() + "\n Release Date: " + _DVD.getReleaseDate()  
                    + "\n Rating: " + _DVD.getRating() + "\n Director: " + _DVD.getDirector() 
                    + "\n Studio: " + _DVD.getStudio() + "\n Notes: " + _DVD.getNote());
    }
    public void listDVD(List<DVD> _DVDList){
        for(DVD dvd : _DVDList){
            printDVD(dvd);
        }
    }

    public int readYearsForQuery(){
        return io.readInt("Enter number of years N to show movies within last N years:");
    }
            
    public String readSearchTerm(){
        return io.readString("Please Enter Search Term: ");
    }
    public void displayShowingResults() {
        io.print("Search Results: ");
    }
    public boolean areYouSure(){
        return io.readString("Are You Sure? (y/n): ").equalsIgnoreCase("Y");
    }
    public void displayDuplicate(){
        io.print("Identical DVD Already in Collection!");
    }
    public void displayNotFound(){
        io.print("No DVD Found !");
    }
    public void displaySuccess() {
        io.print("Operation Successful! \n");
    }
    public void displayContinue() {
        io.readString("Press Enter to Continue...\n");
    }
    public void displayAddDVDBanner(){
        io.print(" === ADD DVD === \n");
    }
    public void displayRemoveDVDBanner(){
        io.print(" === REMOVE DVD === \n");
    }
    public void displayEditDVDBanner(){
        io.print(" === EDIT DVD === \n");
    }
    public void displayListDVDBanner(){
        io.print(" === DVD LIST === \n");
    }
    public void displayShowDVDBanner(){
        io.print(" === SHOW DVD === ");
    }
    public void displaySearchDVDBanner(){
        io.print(" === SEARCH DVDs ===");
    }
    public void displayExit(){
        io.print("Exiting. Goodbye! ");
    }
    public void displayUnknownCommand(){
        io.print("Unknown Command! ");
    }
    public void displayError(String _msg){
        io.print("ERROR: " + _msg);
    }
    public void displayGetDVDInLastYearsBanner(){
        io.print(" === GET DVDS WITHIN LAST N YEARS === \n");
    }
    public void displayGetDVDByRatingBanner(){
        io.print(" === GET DVDS BY RATING === \n");
    }
    public void displayGetDVDSByDirectorBanner(){
        io.print(" === GET DVDS BY DIRECTOR === \n");
    }
    public void displayGetDVDSByStudioBanner(){
        io.print(" === GET DVDS BY SUDIO === \n");
    }
    public void displayGetAverageAgeBanner(){
        io.print(" === GET AVERAGE AGE OF DVDS === \n");
    }
    public void displayGetNewestDVDBanner(){
        io.print(" === GET NEWEST DVD === \n");
    }
    public void displayGetOldestDVDBanner(){
        io.print(" === GET OLDEST DVD === \n");
    }
    public void displayGetAverageNotesBanner(){
        io.print(" === GET AVERAGE NOTES === \n");
    }
}
