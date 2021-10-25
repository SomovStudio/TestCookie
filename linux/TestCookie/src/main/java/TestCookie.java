import java.io.*;
import java.net.*;

public class TestCookie {

    public String getCookie(String linkURL) {
        String result = "";
        try {
            CookieManager cookieManager = new CookieManager();
            CookieHandler.setDefault(cookieManager);

            URL url = new URL(linkURL);
            URLConnection urlConnection = url.openConnection();
            urlConnection.getContent();

            CookieStore cookieStore = cookieManager.getCookieStore();

            for (HttpCookie cookie : cookieStore.getCookies()) {
                result = result + "\n Cookie: " + cookie.getName();
                result = result + "\t Domain: " + cookie.getDomain();
                result = result + "\t Value: " + cookie.getValue();
            }

        } catch (IOException malformedURLException) {
            malformedURLException.printStackTrace();
            result = malformedURLException.getMessage();
        }
        return result;
    }
}
