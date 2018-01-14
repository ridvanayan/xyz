package test;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import pu.web.library.RFileHelper;
import pu.web.library.RImageHelper;
import pu.web.modules.content.RFileUploadHelper;
import ra.library.cryptography.cipher.RRaCipher;
import ra.library.cryptography.cipher.RRaCipherAESBase64;

/**
 *
 * @author ridvanayan
 */
public class TestAkgunler
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, Exception
    {
        String str = "";
        String[] splitted = str.split("\\n");
        int i = 0;
        int startIndex = 0;
        ArrayList<String> list = new ArrayList<>();
        for (String delim : splitted)
        {
            //System.out.println("i:" + (i++) + ":" + delim);
            if(i%3==0)
            {
                System.out.println(splitted[i+1]+" "+splitted[i+2]+splitted[i]+";");
            }
            i++;
        }
    }

    private static String encrypt(String data) throws Exception
    {
//        if( json == null )
//            return "";
        try
        {
            String token = RRaCipherAESBase64.encrypt(data);
            token = new RRaCipher(RRaCipher.MODE_STRING).encrypt(token);
            token = RRaCipherAESBase64.encrypt(token);
            return token;
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

    private static String decrypt(String token) throws Exception
    {
        try
        {
            token = RRaCipherAESBase64.decrypt(token);
            token = new RRaCipher(RRaCipher.MODE_STRING).decrypt(token);
            token = RRaCipherAESBase64.decrypt(token);
            return token;
        }
        catch (Exception ex)
        {
            throw ex;
        }
    }

}
