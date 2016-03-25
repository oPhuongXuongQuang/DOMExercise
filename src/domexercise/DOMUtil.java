/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domexercise;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 *
 * @author Gunner
 */
public class DOMUtil implements Serializable {

    public DOMUtil() {
    }
    
    
    public Document ParseDOMFromFile(String filePath) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            File file = new File(filePath);
            try {
                Document doc = db.parse(file);
                return doc;
            } catch (SAXException ex) {
                Logger.getLogger(DOMUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DOMUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOMUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   

    public void tranformDOMtoStream(Document doc, String filePath) {
        try {
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            File file = new File(filePath);
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            tf.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        } catch (TransformerException ex) {
            Logger.getLogger(DOMUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Element createNewElement(Document doc, String elementName, String elementContext) {
        Element elem = doc.createElement(elementName);
        if (elementContext != null) {
            elem.setTextContent(elementContext);

        }
        return elem;
    }

    public void createNewAttr(Element elem, String attname, String attValue) {
        elem.setAttribute(attname, attValue);
    }
}
