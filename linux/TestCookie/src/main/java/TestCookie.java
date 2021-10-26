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
                result = result + "\n Domain: " + cookie.getDomain();
                result = result + "\n Value: " + cookie.getValue();
                result = result + "\n";
            }

        } catch (IOException malformedURLException) {
            malformedURLException.printStackTrace();
            result = malformedURLException.getMessage();
        }
        return result;
    }
}
