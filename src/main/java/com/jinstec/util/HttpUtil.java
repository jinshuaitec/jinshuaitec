package com.jinstec.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;*/

/**
 * Created by fonlin on 2017/8/4.
 * http工具类
 */
public class HttpUtil {

    /**
     * httpUtil请求超时时间
     */
    private static final int HTTP_TIME_OUT = 100000;

    public static JSONObject get(String url, Map<String, String> params) throws IOException {
        JSONObject json = new JSONObject();
        HttpClient client = new HttpClient();
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            nameValuePairs.add(new NameValuePair(entry.getKey(), entry.getValue()));
        }
        GetMethod method = new GetMethod(url);
        //设置超时时长
        method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, HTTP_TIME_OUT);

        method.setQueryString(nameValuePairs.toArray(new NameValuePair[params.size()]));
        HttpMethodParams param = method.getParams();
        param.setContentCharset("utf-8");
        json.put("code", client.executeMethod(method));
        json.put("result", method.getResponseBodyAsString());
        return json;
    }

    public static JSONObject post(String url, String jsonValue) throws IOException {
        JSONObject json = new JSONObject();
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        //设置超时时长
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, HTTP_TIME_OUT);
        postMethod.setRequestHeader("Content-Type", "application/json");
        RequestEntity requestEntity = new StringRequestEntity(jsonValue, null, "utf-8");
        postMethod.setRequestEntity(requestEntity);
        json.put("code", client.executeMethod(postMethod));
        json.put("result", postMethod.getResponseBodyAsString());
        return json;
    }

    public static JSONObject postForWeiXin(String url,String jsonValue) throws IOException {
        JSONObject json = new JSONObject();
        HttpClient client = new HttpClient();
        PostMethod postMethod=new PostMethod(url);
        //设置超时时长
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,HTTP_TIME_OUT);
        postMethod.setRequestHeader("Content-Type","application/json");
        RequestEntity requestEntity = new StringRequestEntity(jsonValue);
        postMethod.setRequestEntity(requestEntity);
        json.put("code", client.executeMethod(postMethod));
        json.put("result", postMethod.getResponseBodyAsString());
        return json;
    }

    public static JSONObject get(String url) throws IOException {
        JSONObject json = new JSONObject();
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        //设置超时时长
        method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, HTTP_TIME_OUT);
        HttpMethodParams param = method.getParams();
        param.setContentCharset("utf-8");
        json.put("code", client.executeMethod(method));
        json.put("result", method.getResponseBodyAsString());
        return json;
    }

    public static String post(HttpClient httpClient, String url, NameValuePair[] data) {
        if (httpClient == null) {
            httpClient = new HttpClient();
        }
        PostMethod post = null;
        GetMethod get = null;
        String rtn = null;
        try {
            byte[] responseBody = null;
            post = new PostMethod(url);
            post.setRequestBody(data);
            int statusCode = httpClient.executeMethod(post);
            if (isRedirect(statusCode)) {
                Header header = post.getResponseHeader("location");
                String location = header.getValue();
                if (location == null || location.equals("")) {
                    location = "/";
                }
                get = new GetMethod(location);
                httpClient.executeMethod(get);
                responseBody = get.getResponseBody();
            } else {
                responseBody = post.getResponseBody();
            }
            rtn = new String(responseBody, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (post != null) {
                post.releaseConnection();
            }
            if (get != null) {
                get.releaseConnection();
            }
        }
        return rtn;
    }

    private static boolean isRedirect(int statusCode) {
        // 302
        if (statusCode != 200) {
            return true;
        }
        return false;
    }

/*    public static String getUrl(String url){
        String result = null;
        try {
            // 根据地址获取请求
            HttpGet request = new HttpGet(url);
            // 获取当前客户端对象
            org.apache.http.client.HttpClient httpClient = HttpClients.createDefault();
            // 通过请求对象获取响应对象
            HttpResponse response = httpClient.execute(request);
            // 判断网络连接状态码是否正常(0--200都数正常)
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result= EntityUtils.toString(response.getEntity(), HTTP.UTF_8);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }*/
}
