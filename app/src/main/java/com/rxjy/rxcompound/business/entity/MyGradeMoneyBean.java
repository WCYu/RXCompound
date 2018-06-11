package com.rxjy.rxcompound.business.entity;


import java.util.ArrayList;

/**
 * Created by hjh on 2017/11/24.
 */

public class MyGradeMoneyBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MyGradeMoneyBean() {super();
    }

    @Override
    public String toString() {
        return "MyGradeMoneyBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }

    public String getStatusMsg() {
        return StatusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        StatusMsg = statusMsg;
    }

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean body) {
        Body = body;
    }

    public class BodyBean{
        private ArrayList<PackageTypeBean> PackageType;

        public BodyBean() {super();
        }

        public ArrayList<PackageTypeBean> getPackageType() {
            return PackageType;
        }

        public void setPackageType(ArrayList<PackageTypeBean> packageType) {
            PackageType = packageType;
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "PackageType=" + PackageType +
                    '}';
        }

        public class PackageTypeBean{
            private int ChenJiuLeiJi;
            private int shengjichaE;

            public PackageTypeBean() {super();
            }

            @Override
            public String toString() {
                return "PackageTypeBean{" +
                        "ChenJiuLeiJi=" + ChenJiuLeiJi +
                        ", shengjichaE=" + shengjichaE +
                        '}';
            }

            public int getChenJiuLeiJi() {
                return ChenJiuLeiJi;
            }

            public void setChenJiuLeiJi(int chenJiuLeiJi) {
                ChenJiuLeiJi = chenJiuLeiJi;
            }

            public int getShengjichaE() {
                return shengjichaE;
            }

            public void setShengjichaE(int shengjichaE) {
                this.shengjichaE = shengjichaE;
            }
        }
    }

}
