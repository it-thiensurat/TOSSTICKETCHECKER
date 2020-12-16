package com.tsr.tsrproblemreport_tossticket_checker;

import java.util.Date;

public abstract class TOSSGeneral {

    public enum SERVICE_TYPE{
         PRODUCTION,UAT
    }

	public final static boolean DEVELOPER_MODE = false;
    public final static boolean BARCODE_KEY_IN_MODE = true;

    //public final static SERVICE_TYPE SERVICE_MODE = SERVICE_TYPE.UAT;
    public final static SERVICE_TYPE SERVICE_MODE = GetServiceType();//SERVICE_TYPE.UAT;

    private final static SERVICE_TYPE GetServiceType() {
        try {
            return  Enum.valueOf(SERVICE_TYPE.class, BuildConfig.SERVICE_MODE);
            //return SERVICE_TYPE.DEV;
        } catch (Exception e){
            return SERVICE_TYPE.UAT;
        }
    }


}
