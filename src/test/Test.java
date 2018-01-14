package test;

import com.google.gson.Gson;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import javax.imageio.ImageIO;
import pu.web.library.RFileHelper;
import pu.web.library.RImageHelper;
import pu.web.modules.content.RFileUploadHelper;
import ra.library.cryptography.cipher.RRaCipher;
import ra.library.cryptography.cipher.RRaCipherAESBase64;
import ra.library.helpers.RDateHelper;

/**
 *
 * @author ridvanayan
 */
public class Test
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, Exception
    {
        String filePath = "C:\\Users\\ridvanayan\\Documents\\NetBeansProjects\\IncentiveTur\\build\\web\\WEB-INF\\frontend\\assets\\img\\dynamic\\hotel\\Salamis-Bay-Conti-Hotel\\1505853783351-Salamis-Bay-Conti-Hotel-27x98.jpg";
        String filePathThumb;
        filePathThumb = filePath + "_thumb." + RFileHelper.getExtension(filePath);
        BufferedImage img = new RImageHelper(filePath).readImageByForce();
        RFileUploadHelper.saveImgToDisk(RImageHelper.getScaledInstance(img, 100, 100, RenderingHints.VALUE_INTERPOLATION_BICUBIC, false), filePathThumb);
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
