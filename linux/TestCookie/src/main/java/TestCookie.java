import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.*;

public class TestCookie {

    public String getCookie(String linkURL) {
        String result = "";

        // Устанавливаем протокол
        // https://coderoad.ru/39157422/%D0%9A%D0%B0%D0%BA-%D0%B2%D0%BA%D0%BB%D1%8E%D1%87%D0%B8%D1%82%D1%8C-TLS-1-2-%D0%B2-Java-7
        System.setProperty("https.protocols", "SSLv3,TLSv1,TLSv1.1,TLSv1.2");
        //System.getProperties().setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1,SSLv3");

        // Разрешение ненадежных сертификатов SSL
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(
                            java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
        };

        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            //SSLContext sc = SSLContext.getInstance("TLSv1.2");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            result = result + "\n URL: " + linkURL;
            result = e.getMessage();
            result = result + "\n";
            return result;
        }

        // Чтение Cookie
        try {

            CookieManager cookieManager = new CookieManager();
            CookieHandler.setDefault(cookieManager);

            URL url = new URL(linkURL);
            URLConnection urlConnection = url.openConnection();
            urlConnection.getContent();

            CookieStore cookieStore = cookieManager.getCookieStore();

            if(cookieStore.getCookies().size() > 0){
                for (HttpCookie cookie : cookieStore.getCookies()) {
                    result = result + "\n URL: " + linkURL;
                    result = result + "\n Domain: " + cookie.getDomain();
                    result = result + "\n Cookie: " + cookie.getName();
                    result = result + "\n Value: " + cookie.getValue();
                    result = result + "\n";
                }
            }else{
                result = result + "\n URL: " + linkURL;
                result = result + "\n Получено: 0 cookie";
                result = result + "\n";
            }

        } catch (IOException malformedURLException) {
            malformedURLException.printStackTrace();
            result = result + "\n URL: " + linkURL;
            result = malformedURLException.getMessage();
            result = result + "\n";
        }
        return result;
    }
}
