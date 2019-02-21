/*
 * 
 */
package java_cfe_sat;

import util.XmlUtil;
import cfe.EnvTeste;
import exception.CfeException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 * Classe principal
 * @author Everton Alvaro
 */
public class Main {
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        try {
            // TODO code application logic here
            String xml = XmlUtil.leXml("D:\\teste.xml");
            EnvTeste.CFe nota = XmlUtil.xmlToObject(xml, EnvTeste.CFe.class);
            System.out.println(nota.getInfCFe().getIde().getDEmi());
            System.out.println(nota.getInfCFe().getIde().getCNPJ());
        } catch (JAXBException | CfeException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
