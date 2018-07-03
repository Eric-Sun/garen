package com.j13.garen.core;


public class Constants {

    public static int USER_IS_MACHINE = 1;
    public static int DEFAULT_IMG_ID = 0;
    public static int ADMIN_ACCOUNT_ID = -1;

    public static class ResponseStatus {
        public static int SUCCESS = 0;
        public static int FAILURE = 1;
        public static int UNEXCEPED_FAILURE = 2;
    }

    public static class DB {
        public static int NOT_DELETED = 0;
        public static int DELETED = 1;
    }

    public static class OrderStatus {
        public static int QUERY_ALL_STATUS = -1;
        public static int ORDER_CREATED = 0;
    }

    public static class OrderRecordActionType {
        // 创建order
        public static int ADD = 0;
        // 修改状态
        public static int UPDATE_STATUS = 1;
        // 取消订单（只能是管理员）
        public static int CANCEL = -1;
        // 上传进度图片
        public static int UPLOAD_IMG = 2;
        // 画家完成画作，在线审核
        public static int FINISH = 3;
    }

    public static class Order {
        public static int NO_PAINTER = -1;
    }

    public static class Wechat {
        public static String TOKEN = "aaaa";
//        public static String APPID = "wx0d07487890a95d68";
//        public static String AppSecret = "e71556c2f7b94b916451e0fc81b04f02";

        public static String APPID = "wxe2ff872ab7c97d17";
        public static String AppSecret = "62bc146e2e9e29c8973d814949dd7a9f";
    }


    public static class Banner {
        public static int ONLINE = 1;
        public static int OFFLINE = 0;

    }
}
