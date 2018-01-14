package test;

import com.google.gson.Gson;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import ra.library.cryptography.cipher.RRaCipher;
import ra.library.cryptography.cipher.RRaCipherAESBase64;
import ra.library.helpers.RDateHelper;

/**
 *
 * @author ridvanayan
 */
public class TestIpMac
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, Exception
    {

        InetAddress ip;
        try
        {

            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            System.out.print("Current MAC address : ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++)
            {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());

        }
        catch (SocketException e)
        {

            e.printStackTrace();

        }

        LinkedHashMap<String, String> userDataMap = new LinkedHashMap<>();
        userDataMap.put("WS_RESPONSE_KEY_DATA_USERNAME", "rikasoft");
        userDataMap.put("WS_RESPONSE_KEY_DATA_PASSWORD", "123456");
        String userDataJSon = new Gson().toJson(userDataMap);

        LinkedHashMap<String, String> orderedHashMap = new LinkedHashMap<>();
        orderedHashMap.put("RESPONSE_KEY_TOKEN_CREATETIME", String.valueOf(new RDateHelper().getDayMonthYearHourMinuteSecond()));
        orderedHashMap.put("RESPONSE_KEY_TOKEN_LIFETIME", String.valueOf(1000000));
        orderedHashMap.put("RESPONSE_KEY_TOKEN_IP", String.valueOf("127.0.0.1"));
        orderedHashMap.put("RESPONSE_KEY_TOKEN_LOGIN_TYPE", String.valueOf(1));
        orderedHashMap.put("RESPONSE_KEY_DATA", String.valueOf(userDataJSon));

        String json = new Gson().toJson(orderedHashMap);

        String encrypted = encrypt(json);
        System.out.println(encrypted);
        encrypted = "ZPsbA0Exg7nwFDe3gtJyiDcyYNHhseF7Vh0d1mfVQuZ9ggGUZ/xJTZ+ZqJLw/nV2c1LPG617P5yN6xd2ZW1PtPW/XVEG8e8N5QfSjR9nQlU9sleoTZjSm2SiOyBNMdkKe3ws5roIB6IWmnnEb/r52asQPg7dt2vUPzbSAKGnIRqQWZCRTr4q5e+G1h9p3RBf31JrBAmxpqMJRbfrYjrqwOVlCfPFayU2MZ0fyknyDoe811+oEsPxnPq1zjtGU9bs1GES/iiuByZKxw75tybIZc031JoPkqFqPW+rizmt9S93TF23OBzkbKjYjmXi2mNO........";
        String decrypt = decrypt(encrypted);
        System.out.println(decrypt);
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
