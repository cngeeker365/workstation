package cn.dm.util;

import cn.dm.config.WxPayConfig;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * @author taobaibai
 * @create 2020-04-29 20:13
 */
public class WXPayRequest {

    public static WxPayConfig config;

    public WXPayRequest(WxPayConfig config) throws Exception {

        this.config = config;
    }

    /**
     * 请求，只请求一次，不做重试
     * @param reqXml
     * @param reqUrl
     * @return
     * @throws Exception
     */
    public static String requestByXml(String reqXml, String reqUrl, String mchId) throws Exception {
        BasicHttpClientConnectionManager connManager;
        connManager = new BasicHttpClientConnectionManager(
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", PlainConnectionSocketFactory.getSocketFactory())
                        .register("https", SSLConnectionSocketFactory.getSocketFactory())
                        .build(),
                null,
                null,
                null
        );

        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connManager)
                .build();

        HttpPost httpPost = new HttpPost(reqUrl);

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1000).setConnectTimeout(10000).build();
        httpPost.setConfig(requestConfig);

        StringEntity postEntity = new StringEntity(reqXml, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.addHeader("User-Agent", "wxpay sdk java v1.0 "+ mchId);
        httpPost.setEntity(postEntity);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        return EntityUtils.toString(httpEntity, "UTF-8");

    }
}

