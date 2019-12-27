import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class main {
    static String apikey = "RGAPI-43970297-9683-432d-bb2e-794ef4d439fe";
    static String baseURL = "https://oc1.api.riotgames.com/lol/summoner/v4/summoners/by-name/Im%20Beemo?api_key="+apikey;



    public static void main(String[] args) {
         temp();
    }

    private static void temp() {
        try {
            URL url = new URL(baseURL);


            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            Scanner sc = new Scanner(is);
            //Reading line by line from scanner to StringBuffer
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext()){
                sb.append(sc.nextLine());
            }
            JSONObject obj = new JSONObject(sb.toString());
            System.out.println(obj.getString("name"));
            

        } catch (Exception e) {
            System.out.println("jha");
            System.out.println(e.getMessage());
        }
    }
}
