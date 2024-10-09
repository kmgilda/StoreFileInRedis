/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.storefileindatabase;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import redis.clients.jedis.UnifiedJedis;
/**
 *
 * @author kshiteej
 */
public class StoreFileInDatabase {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        File sourceFile = new File("taj_mahal_desktop_background.jpg");
        //String stringToWrite = "foo";
        
        try {
        
        String str = FileUtils.readFileToString(sourceFile,"ISO-8859-1");
        //System.out.println(str);
        
        UnifiedJedis jedis = new UnifiedJedis("redis://localhost:6379");
        String res1 = jedis.set("file1",str);
        System.out.println(res1); // OK
        String res2 = jedis.get("file1");
        jedis.close();
        System.out.println(res2);
        File destinationFile = new File("taj_mahal_backup.jpg");
        FileUtils.writeStringToFile(destinationFile,res2,"ISO-8859-1");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        
       }
}
