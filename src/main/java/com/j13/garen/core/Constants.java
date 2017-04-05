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

    public static class OrderActionType {
        public static final int DELETE = 3;
        public static int ADD = 0;
        public static int UPDATE_STATUS = 1;
        public static int UPDATE_BASIC_INFO = 2;
    }


}
