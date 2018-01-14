package test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import pu.web.modules.hotel.util.RHotelExcelData;
import pu.web.modules.hotel.util.RHotelExcelReader;
import pu.web.modules.hotel.util.RHotelExcelRow;
import ra.library.helpers.RDateHelper;

/**
 *
 * @author ridvanayan
 */
public class ExcelReader
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException
    {
        //xx
        System.out.println("local change");
        int x = RDateHelper.findDayNumberByTurkishName("Pazartesi");
        System.out.println("x:"+x);
        RHotelExcelReader r = new RHotelExcelReader();
        RHotelExcelData excelData = r.readDataFromExcelFile("C:\\Users\\ridvanayan\\Documents\\NetBeansProjects\\YoreTur\\web\\WEB-INF\\backend\\assets\\docs\\yoretur-prices_maliyetli.xlsx");

        for (RHotelExcelRow excelrow : excelData.getRows())
        {
            System.out.println("excelrow:" + String.valueOf(excelrow));
        }

    }
//
//    public void createFile() throws IOException
//    {
//        String physicalPath = "C:\\Users\\ridvanayan\\Documents\\NetBeansProjects\\KombosTaxi\\build\\web\\WEB-INF\\view\\frontend\\en\\pages\\100.jsp";
////        String newPhyPath =1 "C:\\Users\\ridvanayan\\Documents\\NetBeansProjects\\KombosTaxi\\build\\web\\WEB-INF\\view\\frontend\\en\\pages\\old\\100_20151210.171634.jsp";
//        new File(newPhyPath).mkdirs();
//        if (new File(physicalPath).exists())
//        {
//            //save old version
//            Files.move(Paths.get(physicalPath), Paths.get(newPhyPath), REPLACE_EXISTING);
//        }
//
//        System.out.println("OK");
//    }

}
