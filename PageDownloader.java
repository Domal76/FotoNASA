package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PageDownloader {

           public String downloadWebPage(String url)  {
            StringBuilder result = new StringBuilder();
            String line;
                URLConnection urlConnection = null;
                try {
                    urlConnection = new URL(url).openConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (InputStream is = urlConnection.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                while ((line = br.readLine()) != null) {
                    result.append(line);
                }
            } catch (IOException e) {
                    e.printStackTrace();
                }
                return result.toString();
        }
    }
