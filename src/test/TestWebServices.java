        //xx
package test;

import java.util.Date;
import ra.web.services.library.RTokenMapProcessor;

/**
 *
 * @author ridvanayan
 */
public class TestWebServices
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        RTokenMapProcessor tmp = new RTokenMapProcessor();
        String token = tmp.create(Long.valueOf("100000"), "127.0.0.1", new Date().getTime(), 1, "DATA");
        System.out.println(token);
        String resolved = tmp.resolveIp(token);
        System.out.println(resolved);
    }

}
