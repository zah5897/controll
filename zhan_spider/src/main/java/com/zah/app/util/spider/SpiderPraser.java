package com.zah.app.util.spider;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.zah.app.util.EncodeUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class SpiderPraser {
    public static synchronized String getHtml(String url, String encode) throws IOException {
        String parentPath = "D:\\soft\\phantomjs-2.1.1-windows\\bin\\";
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(parentPath + "phantomjs.exe " + parentPath + "codes_encode.js " + url + " " + encode);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = null;
        while ((tmp = br.readLine()) != null) {
            sbf.append(tmp);
        }
        String result = sbf.toString();
        return result;
    }

    public static synchronized String getHtmlWithScroll(String url, String encode) throws IOException {
        String parentPath = "D:\\soft\\phantomjs-2.1.1-windows\\bin\\";
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec(parentPath + "phantomjs.exe " + parentPath + "codes_scroll_encode.js " + url + " " + encode);
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer sbf = new StringBuffer();
        String tmp = null;
        while ((tmp = br.readLine()) != null) {
            sbf.append(tmp);
        }
        String result = sbf.toString();
        return result;
    }


//    public static synchronized Document spiderByJsoup(String url) throws IOException {
//        Document doc = Jsoup.connect(url).get();
//        return doc;
//    }
//
//    public static synchronized Document spiderByJsoup(String url, String encode) throws IOException {
//
//        URL urL = new URL(url);
//        HttpURLConnection connection = (HttpURLConnection) urL.openConnection();
//        Document doc = Jsoup.parse(connection.getInputStream(), encode, url);
//        return doc;
//    }

    public static synchronized Document toDoc(String content) throws IOException {
        Document doc = Jsoup.parse(content);
        return doc;
    }
}
