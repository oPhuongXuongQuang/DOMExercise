/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domexercise;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author quangpx1
 */
public class DOMExercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        DOMUtil dOMUtil = new DOMUtil();
        
        Element toc = dOMUtil.createNewElement(doc, "toc", "Help System Example");
        Element topicIntro = dOMUtil.createNewElement(doc, "topic", "Introduction");
        Element topicTasks = dOMUtil.createNewElement(doc, "topic", "Tasks");
        Element topicCreateProject = dOMUtil.createNewElement(doc, "topic", "Creating a Project");
        Element topicCreateAWeb = dOMUtil.createNewElement(doc, "topic", "Creating a Web Project");
        Element topicCreateAJava = dOMUtil.createNewElement(doc, "topic", "Creating a Java Project");
        Element topicTesting = dOMUtil.createNewElement(doc, "topic", "Testing a Project");
        Element topicSamples = dOMUtil.createNewElement(doc, "topic", "Samples");
        Element topicCreateJava = dOMUtil.createNewElement(doc, "topic", "Creating Java Project");
        Element topicLaunch = dOMUtil.createNewElement(doc, "topic", "Launch a Wizard");
        Element topicSetOption = dOMUtil.createNewElement(doc, "topic", "Set Options");
        Element topicFinishProject = dOMUtil.createNewElement(doc, "topic", "Finish Creating Project");
        
        topicIntro.setAttribute("href", "intro.html");
        topicCreateProject.setAttribute("href", "tasks/task1.html");
        topicCreateAWeb.setAttribute("href", "tasks/task11.html");
        topicCreateAJava.setAttribute("href", "tasks/task12.html");
        topicTesting.setAttribute("href", "tasks/taskn.html");
        topicCreateJava.setAttribute("href", "samples/sample1.html");
        topicLaunch.setAttribute("href", "samples/sample11.html");
        topicSetOption.setAttribute("href", "samples/sample12.html");
        topicFinishProject.setAttribute("href", "samples/sample13.html");
        
        /* Append Child */
        ////// Creating Java Project
        topicCreateJava.appendChild(topicLaunch);
        topicCreateJava.appendChild(topicSetOption);
        topicCreateJava.appendChild(topicFinishProject);
        //// Samples
        topicSamples.appendChild(topicCreateJava);
        ////// Creating a Project
        topicCreateProject.appendChild(topicCreateAWeb);
        topicCreateProject.appendChild(topicCreateAJava);
        //// Tasks
        topicTasks.appendChild(topicCreateProject);
        topicTasks.appendChild(topicTesting);
        // Help System Example
        toc.appendChild(topicIntro);
        toc.appendChild(topicTasks);
        toc.appendChild(topicSamples);
        
        dOMUtil.tranformDOMtoStream(doc, "result.xml");
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
}
