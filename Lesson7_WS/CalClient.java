package Lesson7_WS;

import com.dataaccess.webservicesserver.*;
import java.io.*;
import java.math.BigInteger;

public class CalClient {

    public static void main(String[] args) throws Exception {
        NumberConversion service = new NumberConversion();
        
        // Lấy đối tượng SOAP
        NumberConversionSoapType port = service.getNumberConversionSoap();
        
        // Gọi phương thức NumberToWords
        String result = port.numberToWords(BigInteger.valueOf(2000));
        
        // Hiển thị kết quả
        System.out.println("Result: " + result);
    }
}
