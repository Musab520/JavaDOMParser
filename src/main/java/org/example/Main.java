package org.example;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter book id: ");
            String bookID = scanner.nextLine();
            scanner.close();
            File inputFile = new File("src/sample.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("book");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String id = eElement.getAttribute("id");

                    if (id.equals(bookID)) {
                        String author = eElement.getElementsByTagName("author").item(0).getTextContent();
                        String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                        String genre = eElement.getElementsByTagName("genre").item(0).getTextContent();
                        String price = eElement.getElementsByTagName("price").item(0).getTextContent();
                        String publish_date = eElement.getElementsByTagName("publish_date").item(0).getTextContent();
                        String description = eElement.getElementsByTagName("description").item(0).getTextContent();

                        System.out.println("Book ID: " + id);
                        System.out.println("Author: " + author);
                        System.out.println("Title: " + title);
                        System.out.println("Genre: " + genre);
                        System.out.println("Price: " + price);
                        System.out.println("Publish Date: " + publish_date);
                        System.out.println("Description: " + description);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}