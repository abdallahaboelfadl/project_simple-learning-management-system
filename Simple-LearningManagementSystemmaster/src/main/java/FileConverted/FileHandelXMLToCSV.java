package FileConverted;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;


public class FileHandelXMLToCSV {                   // convert course Data (file.xml) to (file.csv)
    // convert course data file.xnl to course data file.csv
    public static void csvConvertor(String courseSourceData, String courseData) throws Exception {
        File stylesheet = new File("src/main/FileUsed/DataStyle.xsl");
        File xmlSource = new File("src/main/FileUsed/CourseData.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlSource);

        StreamSource styleSource = new StreamSource(stylesheet);
        Transformer transformer = TransformerFactory.newInstance().newTransformer(styleSource);
        Source source = new DOMSource(document);
        // saving new course Data and parsing it into file.csv
        Result outputTarget = new StreamResult(new File("FileOut/CourseData.csv"));
        transformer.transform(source, outputTarget);
    }
}
