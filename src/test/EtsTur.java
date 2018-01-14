package test;


import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;


import javax.net.ssl.HttpsURLConnection;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by zulfuadar on 8/22/17.
 */
public class EtsTur {

    public static void main(String args[]) throws IOException {


        String urlLink ="https://www.etstur.com/Eskisehir-Otelleri?adultCount=2&startDate=20170823&endDate=20170825&bookMark=%7B%22startDate%22%3A%2220170823%22%2C%22endDate%22%3A%2220170825%22%2C%22adultCount%22%3A%222%2" +
                "2%2C%22page%22%3A1%2C%22sortType%22%3A%22searchRank%22%7D";
        HttpsURLConnection urlConnection = null;
        try {
            //aa
            URL url = new URL(urlLink);
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            StringBuffer sb = new StringBuffer();
            String line;

            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            in.close();
            System.out.println(sb.toString());



    }
}
