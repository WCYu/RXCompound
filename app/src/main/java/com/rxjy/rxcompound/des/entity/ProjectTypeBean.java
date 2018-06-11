package com.rxjy.rxcompound.des.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/12/22.
 */

public class ProjectTypeBean {


    private ArrayList<FatherDataBean> Body;

    public ProjectTypeBean() {super();
    }

    @Override
    public String toString() {
        return "ProjectTypeBean{" +
                "Body=" + Body +
                '}';
    }

    public ArrayList<FatherDataBean> getBody() {
        return Body;
    }

    public void setBody(ArrayList<FatherDataBean> body) {
        Body = body;
    }

    public class FatherDataBean {
        private String ID;
        private String MingCheng;
        private ArrayList<SonDataBean> ziji;

        public FatherDataBean() {
            super();
        }

        @Override
        public String toString() {
            return "FatherDataBean{" +
                    "ID='" + ID + '\'' +
                    ", MingCheng='" + MingCheng + '\'' +
                    ", ziji=" + ziji +
                    '}';
        }

        public String getMingCheng() {
            return MingCheng;
        }

        public void setMingCheng(String mingCheng) {
            MingCheng = mingCheng;
        }

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public ArrayList<SonDataBean> getZiji() {
            return ziji;
        }

        public void setZiji(ArrayList<SonDataBean> ziji) {
            this.ziji = ziji;
        }

        public class SonDataBean {
            private String ID;
            private String FuID;
            private String MingCheng;

            public SonDataBean() {
                super();
            }

            @Override
            public String toString() {
                return "SonDataBean{" +
                        "ID='" + ID + '\'' +
                        ", FuID='" + FuID + '\'' +
                        ", MingCheng='" + MingCheng + '\'' +
                        '}';
            }

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public String getFuID() {
                return FuID;
            }

            public void setFuID(String fuID) {
                FuID = fuID;
            }

            public String getMingCheng() {
                return MingCheng;
            }

            public void setMingCheng(String mingCheng) {
                MingCheng = mingCheng;
            }
        }

    }


}
