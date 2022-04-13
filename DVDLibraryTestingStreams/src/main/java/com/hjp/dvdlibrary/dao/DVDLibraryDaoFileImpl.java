package com.hjp.dvdlibrary.dao;

import com.hjp.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.Map;

/**
 *
 * @author Henry Perrottet
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDaoAgg {
    private final List<DVD> DVDList = new ArrayList<>();
    private final String DATA_FILE;
    private final String DELIMITER = "::";

    public DVDLibraryDaoFileImpl(){
        this.DATA_FILE = "DVD_file.txt";
    }

    public DVDLibraryDaoFileImpl(String _dataFile){
        this.DATA_FILE = _dataFile;
    }

    public boolean checkDuplicate(DVD _DVD) throws DVDLibraryDaoException {
        loadDVDList();
        for(DVD dvd : DVDList){
            if(_DVD.equals(dvd)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public DVD addDVD(DVD _DVD) throws DVDLibraryDaoException {
        loadDVDList();
        if(checkDuplicate(_DVD)){
            return null;
        }
        else{
            DVDList.add(_DVD);
            storeDVDList();
            return _DVD;
        }
    }

    @Override
    public DVD removeDVD(String _title) throws DVDLibraryDaoException {
        loadDVDList();
        DVD target = getDVD(_title);
        if(target == null) {
            return null;
        }
        else {
            DVDList.remove(target);
            storeDVDList();
            return target;
        }
    }

    @Override
    public DVD updateDVD(String _title, DVD _newDVD) throws DVDLibraryDaoException {
        loadDVDList();
        for(DVD dvd : DVDList) {
            if(dvd.getTitle().equalsIgnoreCase(_title)){
                dvd.setTitle(_newDVD.getTitle());
                dvd.setReleaseDate(_newDVD.getReleaseDate());
                dvd.setRating(_newDVD.getRating());
                dvd.setDirector(_newDVD.getDirector());
                dvd.setStudio(_newDVD.getStudio());
                dvd.setNote(_newDVD.getNote());
                storeDVDList();
                return dvd;
            }
        }
        return null;
    }

    @Override
    public List<DVD> listDVD() throws DVDLibraryDaoException {
        loadDVDList();
        return DVDList;
    }

    @Override
    public DVD getDVD(String _title) throws DVDLibraryDaoException {
        loadDVDList();
        for(DVD dvd : DVDList){
            if(dvd.getTitle().equalsIgnoreCase(_title)){
                return dvd;
            }
        }
        return null;
    }

    @Override
    public List<DVD> searchDVDByTitle(String _searchTerm) throws DVDLibraryDaoException {
        loadDVDList();
        List<DVD> results = new ArrayList<>();
        for(DVD dvd : DVDList) {
            if(dvd.getTitle().contains(_searchTerm)) {
                results.add(dvd);
            }
        }
        return results;
    }

    public String marshalData(DVD _dvd) {
        String line = _dvd.getTitle() + DELIMITER + _dvd.getReleaseDate() + DELIMITER
                        + _dvd.getRating() + DELIMITER + _dvd.getDirector() + DELIMITER
                        + _dvd.getStudio() + DELIMITER + _dvd.getNote();
        return line;
    }

    public DVD unmarshalData(String _line) {
        String[] tokens = _line.split(DELIMITER);
        return( new DVD( tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5] ) );
    }

    public void storeDVDList() throws DVDLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter( new FileWriter( DATA_FILE ) );
        }
        catch(IOException e) {
            throw new DVDLibraryDaoException( "Unable to Write File" );
        }

        for( DVD dvd : DVDList ){
            out.println( marshalData( dvd ) );
        }

        out.close();
    }

    public void loadDVDList() throws DVDLibraryDaoException {
        Scanner in;
        try {
            in = new Scanner( new BufferedReader( new FileReader( DATA_FILE ) ) );
        }
        catch(FileNotFoundException e){
            throw new DVDLibraryDaoException("Unable to Read File");
        }
        DVDList.clear();

        String buffer;
        while( in.hasNextLine() ){
            buffer = in.nextLine();
            if(buffer.length() > 0) {
                DVDList.add( unmarshalData( buffer ) );
            }
        }
    }

    @Override
    public List<DVD> searchDVDByStudio(String _studio) throws DVDLibraryDaoException {
        loadDVDList();
        return DVDList.stream()
                .filter(dvd -> dvd.getStudio().equals(_studio))
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageAgeOfMovies() throws DVDLibraryDaoException {
        loadDVDList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate today = LocalDate.now();

        double averageDays = DVDList.stream()
                .map(dvd -> LocalDate.parse(dvd.getReleaseDate(), formatter))
                .mapToLong(releaseDate -> ChronoUnit.DAYS.between(releaseDate, today))
                .average()
                .getAsDouble();

        System.out.println(averageDays);

        return 0;
    }

    @Override
    public List<DVD> getDVDInLastNYears(int _years) throws DVDLibraryDaoException  {
        loadDVDList();
        int yearNow = LocalDate.now().getYear();
        return DVDList.stream()
                .filter((p) -> Integer.parseInt(p.getReleaseDate().split("/")[2]) >= yearNow-_years )
                .collect(Collectors.toList());                          
    }

    @Override
    public List<DVD> getDVDByRating(String _rating) throws DVDLibraryDaoException  {
        loadDVDList();
        return DVDList.stream()
                .filter((p) -> p.getRating().equalsIgnoreCase(_rating))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<DVD>> getDVDByDirector(String _director) throws DVDLibraryDaoException {
        loadDVDList();
        return DVDList.stream()
                .filter((p) -> p.getDirector().contains(_director) || p.getDirector().equalsIgnoreCase(_director))
                .collect(Collectors.groupingBy( (p) -> p.getRating() ));
    }

}
