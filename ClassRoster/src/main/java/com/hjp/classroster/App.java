package com.hjp.classroster;

import com.hjp.classroster.ui.*;
import com.hjp.classroster.dao.*;
import com.hjp.classroster.controller.*;
import com.hjp.classroster.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author Henry
 */
public class App {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        //instantiate object from bean. First param is id of bean to get, second is what type of 
        //class this will be instantiating
        ClassRosterController controller = ctx.getBean("controller", ClassRosterController.class);
        controller.run();
        
        
    }
}
