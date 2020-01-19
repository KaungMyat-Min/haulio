package com.kaungmyatmin.haulio.common.constant;

/*
    Holder of various constants.
    Modified constants according to MyConfig.
 */

public final class Constant implements MyConfig, MyKeys, MyUrls {

    public static final String BASE_URL = IS_PRODUCTION ? URL_PRODUCTION : URL_STAGING;
    public static final String PAYMENT_URL =  URL_PAYMENT_PRODUCTION ;

}
