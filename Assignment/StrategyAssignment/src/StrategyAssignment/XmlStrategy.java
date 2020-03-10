package StrategyAssignment;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Scanner;

public class XmlStrategy implements IConvertionMethod
{
    @Override
    public void convert(File file) throws FileNotFoundException {

        BufferedReader in;
        StreamResult out;
        TransformerHandler th;


        try {
            in = new BufferedReader(new FileReader(file.getAbsolutePath()));
            out = new StreamResult(file.getAbsolutePath() + "_converted.xml");
            SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            th = tf.newTransformerHandler();

            // pretty XML output
            Transformer serializer = th.getTransformer();
            serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");

            th.setResult(out);
            th.startDocument();
            th.startElement(null, null, "Document", null);
            String str;
            while ((str = in.readLine()) != null) {
                th.startElement(null, null, "Student", null);

                Scanner cin = new Scanner(str).useDelimiter(",");

                String temp = "";

                th.startElement(null, null, "Name", null);
                temp = cin.next();
                th.characters(temp.toCharArray(), 0, temp.length());
                th.endElement(null, null, "Name");

                th.startElement(null, null, "Roll", null);
                temp = cin.next();
                th.characters(temp.toCharArray(), 0, temp.length());
                th.endElement(null, null, "Roll");

                th.startElement(null, null, "Number", null);
                temp = cin.next();
                th.characters(temp.toCharArray(), 0, temp.length());
                th.endElement(null, null, "Number");

                th.endElement(null, null, "Student");
            }
            in.close();
            th.endElement(null, null, "Document");
            th.endDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
