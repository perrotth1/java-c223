package com.hjp.dvdlibrary.dao;

/**
 *
 * @author Henry Perrottet
 */
public class DVDLibraryDaoException extends Exception {
    public DVDLibraryDaoException(String _message) {
        super(_message);
    }
    
    public DVDLibraryDaoException(String _message, Throwable _cause) {
        super(_message, _cause);
    }
}
