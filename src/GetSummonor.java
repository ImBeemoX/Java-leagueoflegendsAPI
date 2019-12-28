import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class GetSummonor {
        String apikey = "RGAPI-cf1cbc36-3973-48c1-bc65-06247adaba2e";
        String baseURL;
        JSONObject obj;

        public GetSummonor() {}

    private String parseSummonorName(String name){
            if(name.contains(" ")){
                name = name.replaceAll(" ", "%20");
            }
            return name;
        }

        public void getName(String name) {
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



            } catch (Exception e) {
                System.out.println("Something went wrong");
                System.out.println(e.getMessage());
            }
        }


}
