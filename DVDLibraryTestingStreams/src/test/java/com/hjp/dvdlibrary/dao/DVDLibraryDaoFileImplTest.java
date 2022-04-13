package com.hjp.dvdlibrary.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//import com.hjp.dvdlibrary.dao.*;
import com.hjp.dvdlibrary.dto.*;
import java.io.FileWriter;
import java.util.List;
/**
 *
 * @author Henry
 */
public class DVDLibraryDaoFileImplTest {
    
    /**
     *  TEST PLAN
     * 
     *  testAddGetDVD() - Add a DVD, get it and prove it was added by checking the data is equal
     * testAddGetAllDVD()
     */
    
    private DVDLibraryDao testDao;
    
    public DVDLibraryDaoFileImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception{
        //Before each test, wipe the test txt file and re-initialize testDao
        new FileWriter("TEST_LIBRARY.txt");
        this.testDao = new DVDLibraryDaoFileImpl("TEST_LIBRARY.txt");      
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetDVD() throws Exception{
        //ARRANGE
        DVD newDVD = new DVD("title","release","rating","director","studio","note");
        testDao.addDVD(newDVD);
        
        //ACT
        DVD retrievedDVD = testDao.getDVD(newDVD.getTitle());
        
        //ASSERT
        assertEquals(newDVD, retrievedDVD);
    }
    
    @Test
    public void testAddGetAllDVD() throws Exception{
        //ARRANGE
        DVD dvd1 = new DVD("title1","release","rating","director","studio","note");
        DVD dvd2 = new DVD("title2","release2","rating2", "director2","studio2","note2");
    
        testDao.addDVD(dvd1);
        testDao.addDVD(dvd2);
        
        //ACT
        List<DVD> retrievedList = testDao.listDVD();
        
        //ASSERT
        assertNotNull( retrievedList, "List should not be null");
        assertEquals( 2, retrievedList.size(), "List should be size 2 ");
        
        assertTrue( retrievedList.contains(dvd1) , "List should contain title1");
        assertTrue( retrievedList.contains(dvd2) , "List should contain title2" );
    }
    
    @Test
    public void testAddUpdateGetDVD() throws Exception {
        //ARRANGE
        DVD dvd = new DVD("title1","release","rating","director","studio","note");
        testDao.addDVD(dvd);
        String title = dvd.getTitle();
        
        dvd.setRating("NewRating");
        dvd.setDirector("NewDirector");
        
        //ACT
        testDao.updateDVD(title, dvd);
        testDao.updateDVD(title, dvd);
    }
}
