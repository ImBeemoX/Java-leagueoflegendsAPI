import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SummonorGetter {
        String apikey = "RGAPI-a588dba3-8907-4cd6-9982-65223e4fac43";
        String baseURL;
        JSONObject obj;

        public SummonorGetter() {}

    private String parseSummonorName(String name){
            if(name.contains(" ")){
                name = name.replaceAll(" ", "%20");
            }
            return name;
        }

        public JSONObject getSummonorByName(String name) {
            try {
                name = parseSummonorName(name);
                baseURL = "https://oc1.api.riotgames.com/lol/summoner/v4/summoners/by-name/" + name + "?api_key="+apikey;

                URL url = new URL(baseURL);
                URLConnection conn = url.openConnection();
                InputStream is = conn.getInputStream();
                Scanner sc = new Scanner(is);
                //Reading line by line from scanner to StringBuffer
                StringBuffer sb = new StringBuffer();
                while(sc.hasNext()){
                    sb.append(sc.nextLine());
                }
                obj = new JSONObject(sb.toString());
                return obj;


            } catch (Exception e) {
                System.out.println("Something went wrong");
                System.out.println(e.getMessage());
            }
            return null;
        }




}
