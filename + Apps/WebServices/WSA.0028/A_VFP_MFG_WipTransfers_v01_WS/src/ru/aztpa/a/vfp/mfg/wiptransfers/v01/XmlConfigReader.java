package ru.aztpa.a.vfp.mfg.wiptransfers.v01;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * ������ ���������� ������������ �� XML-�����
 *
 * @author jdeveloper@aztpa.ru
 * @version 1.0.0 24-07-2012
 */
public class XmlConfigReader
{
   private static Document xmlDocument;
   private final static String XML_CONFIG_FILE = "TablePathConfig.xml";

   static
   {
      try
      {
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         xmlDocument = builder.parse(
           XmlConfigReader.class.getResource(XML_CONFIG_FILE).toExternalForm());
      }
      catch (ParserConfigurationException ex)
      {
         Logger.getLogger(XmlConfigReader.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (SAXException ex)
      {
         Logger.getLogger(XmlConfigReader.class.getName()).log(Level.SEVERE, null, ex);
      }
      catch (IOException ex)
      {
         Logger.getLogger(XmlConfigReader.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   private XmlConfigReader()
   {
   }

   /**
    * "��������" XmlConfigReader
    *
    * @return ������ XmlConfigReader
    */
   public static XmlConfigReader getInstance()
   {
      return XmlConfigReaderHolder.INSTANCE;
   }

   private static class XmlConfigReaderHolder
   {
      private static final XmlConfigReader INSTANCE = new XmlConfigReader();

      private XmlConfigReaderHolder()
      {
      }
   }

   /**
    * ������������� ���� � ���� �� ����-�������
    *
    * @param department ��� ����
    * @return ������������� ����
    * @throws WrongConfigurationException
    */
   public String retrieveDepartmentPath(String department) throws WrongConfigurationException
   {
      if (StringUtilities.isNullOrEmpty(department))
      {
         throw new IllegalArgumentException("Department code is empty");
      }

      try
      {
         XPath path = XPathFactory.newInstance().newXPath();
         NodeList nodes = (NodeList) path.evaluate(
           "/root/configuration/path", xmlDocument, XPathConstants.NODESET);
         for (int i = 0; i < nodes.getLength(); i++)
         {
            String textContent = nodes.item(i).getTextContent();
            StringTokenizer tokenizer = new StringTokenizer(textContent);
            if (!tokenizer.hasMoreElements())
            {
               throw new WrongConfigurationException("Department code must be");
            }
            String code = tokenizer.nextElement().toString();
            if (StringUtilities.isNullOrEmpty(code))
            {
               throw new IllegalStateException("derartment code must be not empty");
            }
            if (!tokenizer.hasMoreElements())
            {
               throw new WrongConfigurationException("Path to department file must be");
            }
            String pathToDep = tokenizer.nextElement().toString();
            if (StringUtilities.isNullOrEmpty(pathToDep))
            {
               throw new IllegalStateException("path to derartment must be not empty");
            }
            if (department.equals(code))
            {
               if (!pathToDep.endsWith("\\"))
               {
                  pathToDep += "\\";
               }
               return pathToDep;
            }
         }
         return "";  // �� �������
      }
      catch (XPathExpressionException ex)
      {
         return "";  // ������ � ������������
      }
   }
}
