import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class TestCookie {

    public String getCookie(String linkURL) {
        String result = "";

        /*
        try {
            SSLContext context = null;
            context = SSLContext.getInstance("TLSv1.2");
            context.init(null,null,null);
            SSLContext.setDefault(context);
            SSLSocketFactory factory = (SSLSocketFactory)context.getSocketFactory();
            SSLSocket socket = (SSLSocket)factory.createSocket();
            String[] protocols = socket.getEnabledProtocols();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
            result = e.getMessage();
            result = result + "\n";
        } catch (KeyManagementException e) {
            e.printStackTrace();
            result = e.getMessage();
            result = result + "\n";
        }
        */

        try {
            System.setProperty("https.protocols", "SSLv3,TLSv1,TLSv1.1,TLSv1.2");

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
            result = result + "\n";
        }
        return result;
    }
}
