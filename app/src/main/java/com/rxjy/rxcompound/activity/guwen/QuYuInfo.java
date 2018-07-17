package com.rxjy.rxcompound.activity.guwen;

import java.util.List;

public class QuYuInfo  {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : [{"ID":238,"MingCheng":"高新区","FuID":"0","ziji":[{"ID":1268,"MingCheng":"唐延路西部金融街","FuID":"238","ziji":null},{"ID":1269,"MingCheng":"科技路中央商务区","FuID":"238","ziji":null},{"ID":1270,"MingCheng":"锦业路西部总部办公区","FuID":"238","ziji":null}]},{"ID":259,"MingCheng":"城北经开区","FuID":"0","ziji":[{"ID":1271,"MingCheng":"未央商务大道","FuID":"259","ziji":null},{"ID":1272,"MingCheng":"市政府行政中心商业圈","FuID":"259","ziji":null}]},{"ID":260,"MingCheng":"城西咸阳区","FuID":"0","ziji":[{"ID":1273,"MingCheng":"西二环","FuID":"260","ziji":null},{"ID":1274,"MingCheng":"三桥","FuID":"260","ziji":null}]},{"ID":261,"MingCheng":"城东浐灞区","FuID":"0","ziji":[{"ID":1275,"MingCheng":"国际港务区","FuID":"261","ziji":null},{"ID":1276,"MingCheng":"纺织城","FuID":"261","ziji":null},{"ID":1277,"MingCheng":"欧亚大道","FuID":"261","ziji":null},{"ID":1278,"MingCheng":"东二环","FuID":"261","ziji":null}]},{"ID":262,"MingCheng":"城南区","FuID":"0","ziji":[{"ID":1279,"MingCheng":"南门","FuID":"262","ziji":null},{"ID":1280,"MingCheng":"南二环","FuID":"262","ziji":null},{"ID":1281,"MingCheng":"李家村万达","FuID":"262","ziji":null},{"ID":1282,"MingCheng":"小寨","FuID":"262","ziji":null},{"ID":1283,"MingCheng":"电视塔","FuID":"262","ziji":null}]},{"ID":263,"MingCheng":"曲江新区","FuID":"0","ziji":[{"ID":1284,"MingCheng":"曲江文化旅游商务区","FuID":"263","ziji":null},{"ID":1285,"MingCheng":"雁塔南路","FuID":"263","ziji":null},{"ID":1286,"MingCheng":"雁翔路","FuID":"263","ziji":null}]},{"ID":264,"MingCheng":"长安区","FuID":"0","ziji":[{"ID":1287,"MingCheng":"神州路","FuID":"264","ziji":null},{"ID":1288,"MingCheng":"航天路","FuID":"264","ziji":null}]}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<BodyBean> Body;

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

    public List<BodyBean> getBody() {
        return Body;
    }

    public void setBody(List<BodyBean> Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * ID : 238
         * MingCheng : 高新区
         * FuID : 0
         * ziji : [{"ID":1268,"MingCheng":"唐延路西部金融街","FuID":"238","ziji":null},{"ID":1269,"MingCheng":"科技路中央商务区","FuID":"238","ziji":null},{"ID":1270,"MingCheng":"锦业路西部总部办公区","FuID":"238","ziji":null}]
         */

        private int ID;
        private String MingCheng;
        private String FuID;
        private List<ZijiBean> ziji;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getMingCheng() {
            return MingCheng;
        }

        public void setMingCheng(String MingCheng) {
            this.MingCheng = MingCheng;
        }

        public String getFuID() {
            return FuID;
        }

        public void setFuID(String FuID) {
            this.FuID = FuID;
        }

        public List<ZijiBean> getZiji() {
            return ziji;
        }

        public void setZiji(List<ZijiBean> ziji) {
            this.ziji = ziji;
        }

        public static class ZijiBean {
            /**
             * ID : 1268
             * MingCheng : 唐延路西部金融街
             * FuID : 238
             * ziji : null
             */

            private int ID;
            private String MingCheng;
            private String FuID;
            private Object ziji;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getMingCheng() {
                return MingCheng;
            }

            public void setMingCheng(String MingCheng) {
                this.MingCheng = MingCheng;
            }

            public String getFuID() {
                return FuID;
            }

            public void setFuID(String FuID) {
                this.FuID = FuID;
            }

            public Object getZiji() {
                return ziji;
            }

            public void setZiji(Object ziji) {
                this.ziji = ziji;
            }
        }
    }
}
