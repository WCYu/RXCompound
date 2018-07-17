package com.rxjy.rxcompound.activity.guwen;

import java.util.List;

public class XingZhiInfo  {

    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : {"Messenger":[{"ID":1,"MingCheng":"中介","FuID":"0","ziji":[{"ID":57,"MingCheng":"专写：专业写字楼租售","FuID":"52","ziji":null},{"ID":58,"MingCheng":"专商：专业商业租售","FuID":"52","ziji":null},{"ID":59,"MingCheng":"商写：商业和写字楼租售","FuID":"52","ziji":null},{"ID":60,"MingCheng":"宅写：住宅和写字楼租售","FuID":"52","ziji":null},{"ID":61,"MingCheng":"宅商：住宅和商业租售","FuID":"52","ziji":null}]},{"ID":2,"MingCheng":"物业","FuID":"0","ziji":[{"ID":62,"MingCheng":"物业工作人员","FuID":"53","ziji":null},{"ID":63,"MingCheng":"物业租赁人员","FuID":"53","ziji":null}]},{"ID":3,"MingCheng":"售楼","FuID":"0","ziji":[{"ID":66,"MingCheng":"专写：专业写字楼售楼","FuID":"54","ziji":null}]},{"ID":4,"MingCheng":"招商","FuID":"0","ziji":[{"ID":64,"MingCheng":"专商：专业商业租售","FuID":"55","ziji":null},{"ID":65,"MingCheng":"专写：专业写字楼租售","FuID":"55","ziji":null}]},{"ID":5,"MingCheng":"其他","FuID":"0","ziji":[{"ID":67,"MingCheng":"商铺租售网站","FuID":"56","ziji":null},{"ID":68,"MingCheng":"写字楼租售网站","FuID":"56","ziji":null},{"ID":69,"MingCheng":"装修网站平台","FuID":"56","ziji":null},{"ID":70,"MingCheng":"同行业装修公司","FuID":"56","ziji":null},{"ID":71,"MingCheng":"家装公司","FuID":"56","ziji":null},{"ID":72,"MingCheng":"办公家具、消防空调等","FuID":"56","ziji":null},{"ID":73,"MingCheng":"其他","FuID":"56","ziji":null}]}]}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        private List<MessengerBean> Messenger;

        public List<MessengerBean> getMessenger() {
            return Messenger;
        }

        public void setMessenger(List<MessengerBean> Messenger) {
            this.Messenger = Messenger;
        }

        public static class MessengerBean {
            /**
             * ID : 1
             * MingCheng : 中介
             * FuID : 0
             * ziji : [{"ID":57,"MingCheng":"专写：专业写字楼租售","FuID":"52","ziji":null},{"ID":58,"MingCheng":"专商：专业商业租售","FuID":"52","ziji":null},{"ID":59,"MingCheng":"商写：商业和写字楼租售","FuID":"52","ziji":null},{"ID":60,"MingCheng":"宅写：住宅和写字楼租售","FuID":"52","ziji":null},{"ID":61,"MingCheng":"宅商：住宅和商业租售","FuID":"52","ziji":null}]
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
                 * ID : 57
                 * MingCheng : 专写：专业写字楼租售
                 * FuID : 52
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
}
