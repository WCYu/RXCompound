package com.rxjy.rxcompound.supervision.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AAA on 2017/12/21.
 */

public class DatumListInfo {

    /**
     * StatusCode : 1
     * StatusMsg : 成功
     * Body : {"agoInfo":[{"info_distribution_id":71692,"orderid":1621,"orderno":"11-179106","attr_category":6,"attr_type":2,"attr_model_id":"39","remark":null,"create_time":"2017-09-04T14:54:41.303","attr_name":"前期受教育人员签到表","area_no":null,"area_name":null,"confirm_time":"2017/9/29 19:29:38","confirm_status":5,"Is_group_ok":1,"groupaudittime":"2017-11-03T11:14:36.47","Is_build_ok":1,"buildaudittime":"2017-10-04T13:35:49.093","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/0595wKgBtFnOLJaAL3PtAACt0GGUPWc421.jpg","ID":0},{"info_distribution_id":71683,"orderid":1621,"orderno":"11-179106","attr_category":6,"attr_type":2,"attr_model_id":"30","remark":null,"create_time":"2017-09-04T14:54:40.583","attr_name":"现场工人工资发放表","area_no":null,"area_name":null,"confirm_time":"2017/9/29 19:29:37","confirm_status":5,"Is_group_ok":2,"groupaudittime":"2017-11-03T11:14:05.653","Is_build_ok":1,"buildaudittime":"2017-10-04T13:35:40.073","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/0595wKgBtFnOLFKALqpIAADKNPQw7u0020.jpg","ID":0},{"info_distribution_id":71699,"orderid":1621,"orderno":"11-179106","attr_category":6,"attr_type":2,"attr_model_id":"82","remark":null,"create_time":"2017-09-04T14:54:41.863","attr_name":"前期材料小样确认单","area_no":null,"area_name":null,"confirm_time":"2017/9/29 19:29:38","confirm_status":5,"Is_group_ok":2,"groupaudittime":"2017-11-03T11:14:45.507","Is_build_ok":1,"buildaudittime":"2017-10-04T13:35:49.277","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/0595wKgBtFnOLKKADmkHAACxg7j3KIM523.jpg","ID":0},{"info_distribution_id":71684,"orderid":1621,"orderno":"11-179106","attr_category":6,"attr_type":2,"attr_model_id":"31","remark":null,"create_time":"2017-09-04T14:54:40.663","attr_name":"安全技术交底","area_no":null,"area_name":null,"confirm_time":"2017/9/29 19:29:37","confirm_status":5,"Is_group_ok":2,"groupaudittime":"2017-11-03T11:14:16.783","Is_build_ok":1,"buildaudittime":"2017-10-04T13:35:42.973","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/0595wKgBtFnOLGKAVQqjAADJYmWzJBs477.jpg","ID":0},{"info_distribution_id":71703,"orderid":1621,"orderno":"11-179106","attr_category":6,"attr_type":2,"attr_model_id":"101","remark":null,"create_time":"2017-09-04T14:54:42.16","attr_name":"项目会交接单","area_no":null,"area_name":null,"confirm_time":"2017/9/29 19:29:38","confirm_status":5,"Is_group_ok":2,"groupaudittime":"2017-11-03T11:13:49.943","Is_build_ok":1,"buildaudittime":"2017-10-04T13:35:39.213","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/0595wKgBtFnOLDeAHTzGAAC7IKp80Pg622.jpg","ID":0},{"info_distribution_id":71685,"orderid":1621,"orderno":"11-179106","attr_category":6,"attr_type":2,"attr_model_id":"32","remark":null,"create_time":"2017-09-04T14:54:40.74","attr_name":"技术交底","area_no":null,"area_name":null,"confirm_time":"2017/9/29 19:29:38","confirm_status":5,"Is_group_ok":2,"groupaudittime":"2017-11-03T11:14:23.437","Is_build_ok":1,"buildaudittime":"2017-10-04T13:35:48.177","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/0595wKgBtFnOLIiAf2u3AACI-lZ2J2Q431.jpg","ID":0}],"midInfo":[{"info_distribution_id":71716,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"77","remark":"","create_time":"2017-09-04T14:54:43.143","attr_name":"中期现场工人工资发放表","area_no":null,"area_name":null,"confirm_time":"2017/10/13 15:23:57","confirm_status":5,"Is_group_ok":2,"groupaudittime":"2017-11-03T11:16:16.597","Is_build_ok":1,"buildaudittime":"2017-10-13T15:53:08.897","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/05F3wKgBtFngZ9mANp0KAAD4VyWhsDU514.jpg","ID":0},{"info_distribution_id":71709,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"33","remark":"","create_time":"2017-09-04T14:54:42.597","attr_name":"隐蔽-弱电","area_no":null,"area_name":null,"confirm_time":"2017/10/13 15:23:57","confirm_status":5,"Is_group_ok":2,"groupaudittime":"2017-11-03T11:14:52.863","Is_build_ok":1,"buildaudittime":"2017-10-13T15:51:35.083","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/05F3wKgBtFngZ6CANwlcAADME6D0-lM840.jpg","ID":0},{"info_distribution_id":71712,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"36","remark":"","create_time":"2017-09-04T14:54:42.83","attr_name":"隐蔽-钢结构","area_no":null,"area_name":null,"confirm_time":"2017/10/13 15:23:57","confirm_status":5,"Is_group_ok":1,"groupaudittime":"2017-11-03T11:15:51.213","Is_build_ok":1,"buildaudittime":"2017-10-13T15:52:01.13","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/05F3wKgBtFngZ8GASIqmAACw6fFcF9Q050.jpg","ID":0},{"info_distribution_id":71717,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"88","remark":"","create_time":"2017-09-04T14:54:43.22","attr_name":"中期材料小样确认单","area_no":null,"area_name":null,"confirm_time":"2017/10/13 15:23:56","confirm_status":5,"Is_group_ok":1,"groupaudittime":"2017-11-03T11:16:22.63","Is_build_ok":1,"buildaudittime":"2017-10-13T15:51:58.313","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/05F2wKgBtFngZ4-ANaHkAADXiusIPXU831.jpg","ID":0},{"info_distribution_id":71710,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"34","remark":"","create_time":"2017-09-04T14:54:42.677","attr_name":"隐蔽-吊顶","area_no":null,"area_name":null,"confirm_time":"2017/10/13 15:23:57","confirm_status":5,"Is_group_ok":1,"groupaudittime":"2017-11-03T11:15:12.833","Is_build_ok":1,"buildaudittime":"2017-10-13T15:51:35.98","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/05F3wKgBtFngZ6eAA0TjAADSxSiawH8302.jpg","ID":0},{"info_distribution_id":71713,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"37","remark":"","create_time":"2017-09-04T14:54:42.91","attr_name":"隐蔽-强电","area_no":null,"area_name":null,"confirm_time":"2017/10/13 15:23:57","confirm_status":5,"Is_group_ok":1,"groupaudittime":"2017-11-03T11:15:57.367","Is_build_ok":1,"buildaudittime":"2017-10-13T15:53:32.85","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/05F3wKgBtFngZ8qAdBy9AADME6D0-lM746.jpg","ID":0},{"info_distribution_id":71715,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"40","remark":"","create_time":"2017-09-04T14:54:43.067","attr_name":"中期受教育人员签到表","area_no":null,"area_name":null,"confirm_time":"2017/10/13 15:23:57","confirm_status":5,"Is_group_ok":1,"groupaudittime":"2017-11-03T11:16:07.6","Is_build_ok":1,"buildaudittime":"2017-10-13T15:52:41.597","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/05F3wKgBtFngZ9-AJ6YYAADnrp_Kr-U335.jpg","ID":0},{"info_distribution_id":71718,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"90","remark":"","create_time":"2017-09-04T14:54:43.313","attr_name":"防水工程闭水验收记录","area_no":null,"area_name":null,"confirm_time":"2017/10/13 15:23:57","confirm_status":5,"Is_group_ok":2,"groupaudittime":"2017-11-03T11:16:35.787","Is_build_ok":1,"buildaudittime":"2017-10-13T15:51:59.21","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/05F2wKgBtFngZ5WActOrAADKeSfMI_k065.jpg","ID":0},{"info_distribution_id":71711,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"35","remark":"","create_time":"2017-09-04T14:54:42.753","attr_name":"隐蔽-隔墙","area_no":null,"area_name":null,"confirm_time":"2017/10/13 15:23:57","confirm_status":5,"Is_group_ok":1,"groupaudittime":"2017-11-03T11:15:20.913","Is_build_ok":1,"buildaudittime":"2017-10-13T15:52:30.44","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":"http://img9.rxjy.com:9120/image/05F3wKgBtFngZ7mAOkeuAADRYWi4aYo912.jpg","ID":0},{"info_distribution_id":71714,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"38","remark":"","create_time":"2017-09-04T14:54:42.987","attr_name":"隐蔽工程检查记录","area_no":null,"area_name":null,"confirm_time":"2017/9/4 14:54:43","confirm_status":3,"Is_group_ok":0,"groupaudittime":"0001-01-01T00:00:00","Is_build_ok":0,"buildaudittime":"0001-01-01T00:00:00","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":null,"ID":0},{"info_distribution_id":71719,"orderid":1621,"orderno":"11-179106","attr_category":7,"attr_type":2,"attr_model_id":"99","remark":"","create_time":"2017-09-04T14:54:43.393","attr_name":"饰面工程验收","area_no":null,"area_name":null,"confirm_time":"2017/9/4 14:54:43","confirm_status":3,"Is_group_ok":0,"groupaudittime":"0001-01-01T00:00:00","Is_build_ok":0,"buildaudittime":"0001-01-01T00:00:00","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":null,"ID":0}],"endInfo":[{"info_distribution_id":71694,"orderid":1621,"orderno":"11-179106","attr_category":8,"attr_type":2,"attr_model_id":"41","remark":null,"create_time":"2017-09-04T14:54:41.46","attr_name":"工程决算单","area_no":null,"area_name":null,"confirm_time":"2017/9/4 14:54:41","confirm_status":3,"Is_group_ok":0,"groupaudittime":"0001-01-01T00:00:00","Is_build_ok":0,"buildaudittime":"0001-01-01T00:00:00","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":null,"ID":0},{"info_distribution_id":71698,"orderid":1621,"orderno":"11-179106","attr_category":8,"attr_type":2,"attr_model_id":"78","remark":null,"create_time":"2017-09-04T14:54:41.787","attr_name":"后期现场工人工资发放表","area_no":null,"area_name":null,"confirm_time":"2017/9/4 14:54:41","confirm_status":3,"Is_group_ok":0,"groupaudittime":"0001-01-01T00:00:00","Is_build_ok":0,"buildaudittime":"0001-01-01T00:00:00","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":null,"ID":0},{"info_distribution_id":71695,"orderid":1621,"orderno":"11-179106","attr_category":8,"attr_type":2,"attr_model_id":"42","remark":null,"create_time":"2017-09-04T14:54:41.537","attr_name":"竣工验收移交单","area_no":null,"area_name":null,"confirm_time":"2017/9/4 14:54:41","confirm_status":3,"Is_group_ok":0,"groupaudittime":"0001-01-01T00:00:00","Is_build_ok":0,"buildaudittime":"0001-01-01T00:00:00","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":null,"ID":0},{"info_distribution_id":71696,"orderid":1621,"orderno":"11-179106","attr_category":8,"attr_type":2,"attr_model_id":"66","remark":null,"create_time":"2017-09-04T14:54:41.613","attr_name":"后期受教育人员签到表","area_no":null,"area_name":null,"confirm_time":"2017/9/4 14:54:41","confirm_status":3,"Is_group_ok":0,"groupaudittime":"0001-01-01T00:00:00","Is_build_ok":0,"buildaudittime":"0001-01-01T00:00:00","GroupManagerTime":"0001-01-01T00:00:00","GroupManagerIsOk":0,"url":null,"ID":0}]}
     */

    private int StatusCode;
    private String StatusMsg;
    private DatumInfo Body;

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg) {
        this.StatusMsg = StatusMsg;
    }

    public DatumInfo getBody() {
        return Body;
    }

    public void setBody(DatumInfo Body) {
        this.Body = Body;
    }

    public static class DatumInfo {
        private List<Datum> agoInfo;
        private List<Datum> midInfo;
        private List<Datum> endInfo;
        private List<Datum> otherInfo;

        public List<Datum> getOtherInfo() {
            return otherInfo;
        }

        public void setOtherInfo(List<Datum> otherInfo) {
            this.otherInfo = otherInfo;
        }

        public List<Datum> getAgoInfo() {
            return agoInfo;
        }

        public void setAgoInfo(List<Datum> agoInfo) {
            this.agoInfo = agoInfo;
        }

        public List<Datum> getMidInfo() {
            return midInfo;
        }

        public void setMidInfo(List<Datum> midInfo) {
            this.midInfo = midInfo;
        }

        public List<Datum> getEndInfo() {
            return endInfo;
        }

        public void setEndInfo(List<Datum> endInfo) {
            this.endInfo = endInfo;
        }

        public static class Datum implements Serializable {
            /**
             * info_distribution_id : 71692
             * orderid : 1621
             * orderno : 11-179106
             * attr_category : 6
             * attr_type : 2
             * attr_model_id : 39
             * remark : null
             * create_time : 2017-09-04T14:54:41.303
             * attr_name : 前期受教育人员签到表
             * area_no : null
             * area_name : null
             * confirm_time : 2017/9/29 19:29:38
             * confirm_status : 5
             * Is_group_ok : 1
             * groupaudittime : 2017-11-03T11:14:36.47
             * Is_build_ok : 1
             * buildaudittime : 2017-10-04T13:35:49.093
             * GroupManagerTime : 0001-01-01T00:00:00
             * GroupManagerIsOk : 0
             * url : http://img9.rxjy.com:9120/image/0595wKgBtFnOLJaAL3PtAACt0GGUPWc421.jpg
             * ID : 0
             */

            private int info_distribution_id;
            private int orderid;
            private String orderno;
            private int attr_category;
            private int attr_type;
            private int attr_model_id;
            private String create_time;
            private String attr_name;
            private String confirm_time;
            private int confirm_status;
            private String url;
            private int isHeader;
            private String headerName;

            public Datum(int isHeader, String headerName) {
                this.isHeader = isHeader;
                this.headerName = headerName;
            }

            public Datum() {
            }

            public int getIsHeader() {
                return isHeader;
            }

            public void setIsHeader(int isHeader) {
                this.isHeader = isHeader;
            }

            public String getHeaderName() {
                return headerName;
            }

            public void setHeaderName(String headerName) {
                this.headerName = headerName;
            }

            public int getInfo_distribution_id() {
                return info_distribution_id;
            }

            public void setInfo_distribution_id(int info_distribution_id) {
                this.info_distribution_id = info_distribution_id;
            }

            public int getOrderid() {
                return orderid;
            }

            public void setOrderid(int orderid) {
                this.orderid = orderid;
            }

            public String getOrderno() {
                return orderno;
            }

            public void setOrderno(String orderno) {
                this.orderno = orderno;
            }

            public int getAttr_category() {
                return attr_category;
            }

            public void setAttr_category(int attr_category) {
                this.attr_category = attr_category;
            }

            public int getAttr_type() {
                return attr_type;
            }

            public void setAttr_type(int attr_type) {
                this.attr_type = attr_type;
            }

            public int getAttr_model_id() {
                return attr_model_id;
            }

            public void setAttr_model_id(int attr_model_id) {
                this.attr_model_id = attr_model_id;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getAttr_name() {
                return attr_name;
            }

            public void setAttr_name(String attr_name) {
                this.attr_name = attr_name;
            }

            public String getConfirm_time() {
                return confirm_time;
            }

            public void setConfirm_time(String confirm_time) {
                this.confirm_time = confirm_time;
            }

            public int getConfirm_status() {
                return confirm_status;
            }

            public void setConfirm_status(int confirm_status) {
                this.confirm_status = confirm_status;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
