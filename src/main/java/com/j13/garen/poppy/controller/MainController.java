package com.j13.garen.poppy.controller;

import com.alibaba.fastjson.JSON;
import com.j13.garen.core.ErrorCode;
import com.j13.garen.poppy.RequestData;
import com.j13.garen.poppy.doc.DocManager;
import com.j13.garen.poppy.doc.MethodDoc;
import com.j13.garen.poppy.ErrorResponse;
import com.j13.garen.poppy.exceptions.CommonException;
import com.j13.garen.utils.JSONV2;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private static Logger LOG = LoggerFactory.getLogger(MainController.class);

    @Autowired
    ApiDispatcher dispatcher;
    @Autowired
    DocManager docManager;


    @RequestMapping("/api")
    public String api(HttpServletRequest request, HttpServletResponse response) throws IOException, FileUploadException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

//        String postData = parseRequestPostData(request);
//        if (!StringUtils.isEmpty(postData)) {
//            LOG.info("post data . {}", postData);
//        }
        RequestData requestData = parseRequest(request);
        String act = requestData.getData().get("act").toString();
        String postData = "";

        LOG.info("request : {}", JSONV2.toJSONString(requestData));
        Object obj = null;
        try {
            obj = dispatcher.dispatch(act, requestData, postData);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            obj = new ErrorResponse(ErrorCode.System.SYSTEM_ERROR);
        }
        String responseJson = null;
        if (obj instanceof String) {
            responseJson = (String) obj;
        } else {
            responseJson = JSON.toJSONString(obj);
        }
        LOG.info("response : {}", responseJson);
        response.getWriter().write(responseJson);
        response.flushBuffer();
        return null;
    }


    @RequestMapping("/wechat")
    public String wechat(HttpServletRequest request, HttpServletResponse response) throws IOException, FileUploadException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String postData = parseRequestPostData(request);
        if (!StringUtils.isEmpty(postData)) {
            LOG.info("post data . {}", postData);
        }
        RequestData requestData = parseRequest(request);
        String act = requestData.getData().get("act").toString();

        LOG.info("request : {}", JSONV2.toJSONString(requestData));
        Object obj = null;
        try {
            obj = dispatcher.dispatch(act, requestData, postData);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            obj = new ErrorResponse(ErrorCode.System.SYSTEM_ERROR);
        }
        String responseJson = null;
        if (obj instanceof String) {
            responseJson = (String) obj;
        } else {
            responseJson = JSON.toJSONString(obj);
        }
        LOG.info("response : {}", responseJson);
        response.getWriter().write(responseJson);
        response.flushBuffer();
        return null;
    }

    @RequestMapping("/doc")
    public String doc(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) throws NoSuchFieldException {
        String method = request.getParameter("method");
        if (method == null) {
            List<MethodDoc> methodList = docManager.getAllMothods();
            model.put("methodList", methodList);
            return "/list";
        } else {
            MethodDoc doc = docManager.getDocByMethodName(method);
            model.put("doc", doc);
            return "/method";
        }
    }


    private RequestData parseRequest(HttpServletRequest request) throws FileUploadException {
        RequestData requestData = new RequestData();
        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                if (!item.isFormField()) {
                    requestData.getData().put(item.getFieldName(), item);
                } else {
                    requestData.getData().put(item.getFieldName(), item.getString());
                }
            }
            return requestData;
        } else {
            Enumeration<String> enumKeys = request.getParameterNames();
            while (enumKeys.hasMoreElements()) {
                String key = enumKeys.nextElement();
                String value = request.getParameter(key);
                requestData.getData().put(key, value);
            }

            return requestData;
        }


    }


    public String parseRequestPostData(HttpServletRequest request) {
        StringBuffer sb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                sb.append(line);
            return sb.toString();
        } catch (Exception e) {
            LOG.error("parse request post data error.", e);
            throw new CommonException(ErrorCode.System.PARSE_REQUEST_POST_DATA_ERROR);
        }
    }

}
