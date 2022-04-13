package com.hjp.dvdlibrary;

import com.hjp.dvdlibrary.dao.*;
import com.hjp.dvdlibrary.ui.*;
import com.hjp.dvdlibrary.controller.*;

/**
 *
 * @author Henry Perrottet
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDaoAgg dao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(view, dao);
        
        controller.run();
    }
}
