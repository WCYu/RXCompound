package com.rxjy.rxcompound.business.entity;

import java.util.ArrayList;

/**
 * Created by hjh on 2017/12/1.
 */

public class IndustryBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public IndustryBean() {super();
    }

    @Override
    public String toString() {
        return "IndustryBean{" +
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
        private ArrayList<CusTomerBean> CusTomer;

        public BodyBean() {super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "PackageType=" + PackageType +
                    ", CusTomer=" + CusTomer +
                    '}';
        }

        public ArrayList<PackageTypeBean> getPackageType() {
            return PackageType;
        }

        public void setPackageType(ArrayList<PackageTypeBean> packageType) {
            PackageType = packageType;
        }

        public ArrayList<CusTomerBean> getCusTomer() {
            return CusTomer;
        }

        public void setCusTomer(ArrayList<CusTomerBean> cusTomer) {
            CusTomer = cusTomer;
        }

        public class PackageTypeBean{
            private int ID;
            private int PackageGrade;
            private int MeasureMoney;
            private int Commission;
            private int Status;
            private String PackageName;
            private String CreateTime;

            public PackageTypeBean() {super();
            }

            @Override
            public String toString() {
                return "PackageTypeBean{" +
                        "ID=" + ID +
                        ", PackageGrade=" + PackageGrade +
                        ", MeasureMoney=" + MeasureMoney +
                        ", Commission=" + Commission +
                        ", Status=" + Status +
                        ", PackageName='" + PackageName + '\'' +
                        ", CreateTime='" + CreateTime + '\'' +
                        '}';
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public int getPackageGrade() {
                return PackageGrade;
            }

            public void setPackageGrade(int packageGrade) {
                PackageGrade = packageGrade;
            }

            public int getMeasureMoney() {
                return MeasureMoney;
            }

            public void setMeasureMoney(int measureMoney) {
                MeasureMoney = measureMoney;
            }

            public int getCommission() {
                return Commission;
            }

            public void setCommission(int commission) {
                Commission = commission;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int status) {
                Status = status;
            }

            public String getPackageName() {
                return PackageName;
            }

            public void setPackageName(String packageName) {
                PackageName = packageName;
            }

            public String getCreateTime() {
                return CreateTime;
            }

            public void setCreateTime(String createTime) {
                CreateTime = createTime;
            }
        }

        public class CusTomerBean{
            private int ID;
            private String MingCheng;
            private String FuID;
            private ArrayList<ChildCusTomerBean> ziji;

            public CusTomerBean() {super();
            }

            @Override
            public String toString() {
                return "CusTomerBean{" +
                        "ID=" + ID +
                        ", MingCheng='" + MingCheng + '\'' +
                        ", FuID='" + FuID + '\'' +
                        ", ziji=" + ziji +
                        '}';
            }

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getMingCheng() {
                return MingCheng;
            }

            public void setMingCheng(String mingCheng) {
                MingCheng = mingCheng;
            }

            public String getFuID() {
                return FuID;
            }

            public void setFuID(String fuID) {
                FuID = fuID;
            }

            public ArrayList<ChildCusTomerBean> getZiji() {
                return ziji;
            }

            public void setZiji(ArrayList<ChildCusTomerBean> ziji) {
                this.ziji = ziji;
            }

            public class ChildCusTomerBean{
                private int ID;
                private String MingCheng;
                private String FuID;

                public ChildCusTomerBean() {super();
                }

                @Override
                public String toString() {
                    return "ChildCusTomerBean{" +
                            "ID=" + ID +
                            ", MingCheng='" + MingCheng + '\'' +
                            ", FuID='" + FuID + '\'' +
                            '}';
                }

                public int getID() {
                    return ID;
                }

                public void setID(int ID) {
                    this.ID = ID;
                }

                public String getMingCheng() {
                    return MingCheng;
                }

                public void setMingCheng(String mingCheng) {
                    MingCheng = mingCheng;
                }

                public String getFuID() {
                    return FuID;
                }

                public void setFuID(String fuID) {
                    FuID = fuID;
                }
            }

        }

    }




}
