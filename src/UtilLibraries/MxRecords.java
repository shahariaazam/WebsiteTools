package UtilLibraries;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.InitialDirContext;

public class MxRecords {
    public String getMx(String domainName){
        InitialDirContext iDirC = null;
        try {
            iDirC = new InitialDirContext();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        // get the MX records from the default DNS directory service provider
        //    NamingException thrown if no DNS record found for domainName
        Attributes attributes = null;
        try {
            attributes = iDirC.getAttributes("dns:/" + domainName, new String[] {"MX"});
        } catch (NamingException e) {
            e.printStackTrace();
        }
        // attributeMX is an attribute ('list') of the Mail Exchange(MX) Resource Records(RR)
        Attribute attributeMX = attributes.get("MX");

        return attributeMX.toString();
    }
}
