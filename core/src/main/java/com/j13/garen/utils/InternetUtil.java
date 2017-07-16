package com.j13.garen.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.j13.garen.core.ErrorCode;
import com.j13.poppy.RequestParams;
import com.j13.poppy.exceptions.CommonException;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InternetUtil {
    private static Logger LOG = LoggerFactory.getLogger(InternetUtil.class);

    public static String get(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String rawResponse = EntityUtils.toString(entity);
            return rawResponse;
        } catch (IOException e) {
            LOG.error("url={}", url, e);
            throw new CommonException(ErrorCode.System.SYSTEM_ERROR);
        } finally {

            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    LOG.error("url={}", url, e);
                    throw new CommonException(ErrorCode.System.SYSTEM_ERROR);
                }

            }
            try {
                httpclient.close();
            } catch (IOException e) {
                LOG.error("url={}", url, e);
                throw new CommonException(ErrorCode.System.SYSTEM_ERROR);
            }
        }
    }

    public static String post(String url, Map<String, Object> params) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> nvps = Lists.newLinkedList();

            Set<String> keySet = params.keySet();
            for (String key : keySet) {
                if (params.get(key) != null)
                    nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
            }


            HttpEntity httpEntity = new UrlEncodedFormEntity(nvps, Charset.forName("UTF-8"));

            httpPost.setEntity(httpEntity);

            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String rawResponse = EntityUtils.toString(entity);
            return rawResponse;
        } catch (IOException e) {
            LOG.error("url={}", url, e);
            throw new CommonException(ErrorCode.System.SYSTEM_ERROR);
        } finally {

            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    LOG.error("url={}", url, e);
                    throw new CommonException(ErrorCode.System.SYSTEM_ERROR);
                }

            }
            try {
                httpclient.close();
            } catch (IOException e) {
                LOG.error("url={}", url, e);
                throw new CommonException(ErrorCode.System.SYSTEM_ERROR);
            }
        }
    }


    public static String post(String url, String data) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            StringEntity content = new StringEntity(data, Charset.forName("utf-8"));
            httpPost.setEntity(content);
            content.setContentType("application/json; charset=UTF-8");
            content.setContentEncoding("utf-8");
            response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            String rawResponse = EntityUtils.toString(entity);
            return rawResponse;
        } catch (IOException e) {
            LOG.error("url={}", url, e);
            throw new CommonException(ErrorCode.System.SYSTEM_ERROR);
        } finally {

            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    LOG.error("url={}", url, e);
                    throw new CommonException(ErrorCode.System.SYSTEM_ERROR);
                }

            }
            try {
                httpclient.close();
            } catch (IOException e) {
                LOG.error("url={}", url, e);
                throw new CommonException(ErrorCode.System.SYSTEM_ERROR);
            }
        }
    }

    public static String post(String url, RequestParams p) {
        return InternetUtil.post(url, p.end());
    }


}
