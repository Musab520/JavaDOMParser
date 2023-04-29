package org.example;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            Scanner xmlScanner = new Scanner(System.in);
            System.out.print("Enter book id: ");
            String bookID = xmlScanner.nextLine();
            xmlScanner.close();
            File inputFile = new File("src/sample.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document xmlDocument = documentBuilder.parse(inputFile);

            xmlDocument.getDocumentElement().normalize();

            NodeList xmlNodeList = xmlDocument.getElementsByTagName("book");

            for (int i = 0; i < xmlNodeList.getLength(); i++) {
                Node xmlNode = xmlNodeList.item(i);

                if (xmlNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element xmlElement = (Element) xmlNode;

                    String id = xmlElement.getAttribute("id");

                    if (id.equals(bookID)) {
                        String bookPublishDate = xmlElement.getElementsByTagName("publish_date").item(0).getTextContent();
                        String description = xmlElement.getElementsByTagName("description").item(0).getTextContent();
                        String price = xmlElement.getElementsByTagName("price").item(0).getTextContent();
                        String bookAuthor = xmlElement.getElementsByTagName("author").item(0).getTextContent();
                        String bookTitle = xmlElement.getElementsByTagName("title").item(0).getTextContent();
                        String bookGenre = xmlElement.getElementsByTagName("genre").item(0).getTextContent();


                        System.out.println("Book ID: " + id);
                        System.out.println("Author: " + bookAuthor);
                        System.out.println("Title: " + bookTitle);
                        System.out.println("Price: " + price);
                        System.out.println("Publish Date: " + bookPublishDate);
                        System.out.println("Description: " + description);
                        System.out.println("Genre: " + bookGenre);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}