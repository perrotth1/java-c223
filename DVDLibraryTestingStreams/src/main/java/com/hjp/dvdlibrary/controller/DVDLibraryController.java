package com.hjp.dvdlibrary.controller;

import com.hjp.dvdlibrary.dao.*;
import com.hjp.dvdlibrary.ui.*;
import com.hjp.dvdlibrary.dto.*;

import java.util.List;

/**
 *
 * @author Henry Perrottet
 */
public class DVDLibraryController {
    private DVDLibraryView view;
    private DVDLibraryDaoAgg dao;

    public DVDLibraryController(DVDLibraryView _view, DVDLibraryDaoAgg _dao) {
        this.view = _view;
        this.dao = _dao;
    }

public void run() {
        boolean keepGoing = true;

        try{
            while(keepGoing) {
                switch(displayMenuGetSelect()){
                    case 1:
                        addDVD();
                        break;
                    case 2:
                        removeDVD();
                        break;
                    case 3:
                        editDVD();
                        break;
                    case 4:
                        listDVD();
                        break;
                    case 5:
                        showDVD();
                        break;
                    case 6:
                        searchDVD();
                        break;
                    case 7:
                        getDVDInLastNYears();
                        break;
                    case 8:
                        
                        break;
                    case 9:
                        
                        break;
                    case 10:
                        
                        break;
                    case 11:
                        
                        break;
                    case 12:
                        
                        break;
                    case 13:
                        
                        break;
                    case 14:
                        
                        break;
                    case 0:
                        keepGoing = false;
                        view.displayExit();
                        break;
                    default:
                        view.displayUnknownCommand();
                }
            }
        }
        catch(Exception e) {
            view.displayError(e.getMessage());
        }

    }

    public int displayMenuGetSelect() {
        view.displayMenu();
        return view.getSelection();
    }
    public void addDVD() throws DVDLibraryDaoException{
        view.bar();
        view.displayAddDVDBanner();
        String title = view.readTitle();
        String release = view.readReleaseDate();
        String rating = view.readRating();
        String director = view.readDirector();
        String studio = view.readStudio();
        String note = view.readNote();
        DVD newDVD = new DVD(title, release, rating, director, studio, note);
        if( dao.addDVD(newDVD) == null ){
            view.displayDuplicate();
        }
        else {
            view.displaySuccess();
        }
        view.displayContinue();
    }

    public void removeDVD() throws DVDLibraryDaoException{
        view.bar();
        view.displayRemoveDVDBanner();
        String title = view.readTitle();
        DVD target = dao.getDVD(title);
        if( target == null ){
            view.displayNotFound();
        }
        else{
            if( view.areYouSure() ){
                dao.removeDVD(title);
                view.displaySuccess();
            }
        }
        view.displayContinue();
    }
    public void editDVD() throws DVDLibraryDaoException{

        view.bar();
        view.displayEditDVDBanner();
        String title = view.readTitle();
        DVD target = dao.getDVD(title);
        DVD updatedDVD = target;
        if(target == null){
            view.displayNotFound();
            view.displayContinue();
        }
        else {
            boolean keepGoing = true;
            while(keepGoing){
                view.printDVD(updatedDVD);
                switch( view.displayEditMenuGetSelect() ){
                    case 1:
                        updatedDVD.setTitle( view.readTitle() );
                        break;
                    case 2:
                        updatedDVD.setReleaseDate( view.readReleaseDate() );
                        break;
                    case 3:
                        updatedDVD.setRating( view.readRating() );
                        break;
                    case 4:
                        updatedDVD.setDirector( view.readDirector() );
                        break;
                    case 5:
                        updatedDVD.setStudio( view.readStudio() );
                        break;
                    case 6:
                        updatedDVD.setNote( view.readNote() );
                        break;
                    case 0:
                    default:
                        keepGoing = false;
                        break;
                }
                if(keepGoing){
                    dao.updateDVD(title, updatedDVD);
                    view.displaySuccess();
                    if( view.displayEditAgain() == false ){
                        keepGoing = false;
                    }
                }
            }
        }
    }

    public void listDVD() throws DVDLibraryDaoException{
        view.bar();
        view.displayListDVDBanner();
        view.listDVD( dao.listDVD() );
        view.displayContinue();
    }

    public void showDVD() throws DVDLibraryDaoException{
        view.bar();
        view.displayShowDVDBanner();
        String title = view.readTitle();
        DVD dvd = dao.getDVD(title);
        if(dvd == null){
            view.displayNotFound();
        }
        else {
            view.printDVD(dvd);
        }
        view.displayContinue();
    }
    public void searchDVD() throws DVDLibraryDaoException{
        view.bar();
        view.displaySearchDVDBanner();
        List<DVD> results = dao.searchDVDByTitle( view.readSearchTerm() );
        view.displayShowingResults();
        view.listDVD( results );
        view.displayContinue();
    }
    public void getDVDInLastNYears() throws DVDLibraryDaoException {
        view.bar();
        view.displayGetDVDInLastYearsBanner();
        int years = view.readYearsForQuery();
        List<DVD> results = dao.getDVDInLastNYears(years);
        view.displayShowingResults();
        view.listDVD(results);
        view.displayContinue();
    }
}
