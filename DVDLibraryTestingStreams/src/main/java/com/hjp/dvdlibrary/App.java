package com.hjp.dvdlibrary;

import com.hjp.dvdlibrary.controller.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Henry Perrottet
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.hjp.dvdlibrary");
        appContext.refresh();

        DVDLibraryController controller = appContext.getBean("DVDLibraryController", DVDLibraryController.class);
        
        controller.run();
    }
}
