/*
 * 
 */
package util;

import exception.CfeException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.text.Normalizer;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

/**
 * Classe com Metodos referentes ao XML
 * @author Everton Alvaro
 */
public class XmlUtil {
    /**
     * Transforma o String do XML em Objeto
     *
     * @param <T>
     * @param xml
     * @param classe
     * @return T
     * @throws javax.xml.bind.JAXBException
     */
    public static <T> T xmlToObject(String xml, Class<T> classe) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(classe);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(new StreamSource(new StringReader(removeAcentos(xml))), classe).getValue();
    }
    
    public static String removeAcentos(String str) {
        str = str.replaceAll("\r", "");
        str = str.replaceAll("\t", "");
        str = str.replaceAll("\n", "");
        str = str.replaceAll("&", "E");
        str = str.replaceAll(">\\s+<", "><");
        return Normalizer.normalize(str, Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").replaceAll("[^\\p{ASCII}]", "");
    }
    
    /**
     * Le o Arquivo XML e retona String
     *
     * @param arquivo
     * @return String
     * @throws exception.CfeException
     */
    public static String leXml(String arquivo) throws CfeException {
        StringBuilder xml = new StringBuilder();
        BufferedReader in;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(arquivo), "UTF-8"));
            String linha;

            while ((linha = in.readLine()) != null) {
                xml.append(linha);

            }
            in.close();
        } catch (IOException e) {
            throw new CfeException("Ler Xml: " + e.getMessage());
        }
        return xml.toString();
    }
}
