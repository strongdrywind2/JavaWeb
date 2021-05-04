package com.test.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws DocumentException {
        //read xml to generate xml obj
        SAXReader saxReader = new SAXReader();
        //read
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }
    @Test

    /*
    generate the book class
    */
    public void test2() throws DocumentException {
        //read book.xml
        SAXReader saxReader = new SAXReader();
        //path starts from module
        Document document = saxReader.read("src/books.xml");
        //get document's root element
        Element rootElement = document.getRootElement();
        //System.out.println(rootElement);

        //element and elements: get child by tag
        List<Element> books = rootElement.elements("book");
        //iterate
        for(Element book : books){
            //asXML: convert element to xml string
//            System.out.println(book.asXML());
            Element nameElement = book.element("name");
//            System.out.println(nameElement.asXML());
            String nameString = nameElement.getText();
            System.out.println(nameString);
            String priceText  = book.elementText("price");
            System.out.println(priceText);

            String snValue = book.attributeValue("sn");
            String authorText = book.elementText("author");
            new Book(snValue, nameString, BigDecimal.valueOf(Double.parseDouble(priceText)), authorText);
        }
    }
}
