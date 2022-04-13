package com.hjp.dvdlibrary.dao;

import com.hjp.dvdlibrary.dto.*;

import java.util.List;
/**
 *
 * @author Henry Perrottet
 */
public interface DVDLibraryDao {
    public DVD addDVD(DVD _DVD) throws DVDLibraryDaoException;
    
    public DVD removeDVD(String _title) throws DVDLibraryDaoException;
    
    public DVD updateDVD(String _title, DVD _newDVD) throws DVDLibraryDaoException;
    
    public List<DVD> listDVD() throws DVDLibraryDaoException;
    
    public DVD getDVD(String _title) throws DVDLibraryDaoException;
    
    public List<DVD> searchDVDByTitle(String _searchTerm) throws DVDLibraryDaoException;
  
}
