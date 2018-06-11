package com.rxjy.rxcompound.business.entity;

/**
 * Created by hjh on 2017/12/2.
 */

public class MessageHouseBean {

    private int StatusCode;
    private String StatusMsg;
    private HBodyBean Body;

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

    public HBodyBean getBody() {
        return Body;
    }

    public void setBody(HBodyBean body) {
        Body = body;
    }

    @Override
    public String toString() {
        return "MessageHouseBean{" +
                "StatusCode=" + StatusCode +
                ", StatusMsg='" + StatusMsg + '\'' +
                ", Body=" + Body +
                '}';
    }

    public MessageHouseBean() {super();
    }

    public class HBodyBean{
        private int KeHuBaseID;
        private int ShenFenID;
        private int ZhuZhongDianID;
        private int NianLingID;
        private int XingBie;
        private int YuJiZhuangXiu;
        private int ChengJiaoLeiXing;
        private int MianZuQi;
        private String JiaoFangShiJian;
        private String LiangFangDiZhi;
        private int ZhuangXiuYuSuan;
        private String YuJiZhuangXiuShiJian;
        private String YuJiLiangFang;
        private int ZhuangXiuXuQiu;
        private int XiangMuShuXing;
        private int QiYeGuiMoID;

        public int getKeHuBaseID() {
            return KeHuBaseID;
        }

        public void setKeHuBaseID(int keHuBaseID) {
            KeHuBaseID = keHuBaseID;
        }

        public int getShenFenID() {
            return ShenFenID;
        }

        public void setShenFenID(int shenFenID) {
            ShenFenID = shenFenID;
        }

        public int getZhuZhongDianID() {
            return ZhuZhongDianID;
        }

        public void setZhuZhongDianID(int zhuZhongDianID) {
            ZhuZhongDianID = zhuZhongDianID;
        }

        public int getNianLingID() {
            return NianLingID;
        }

        public void setNianLingID(int nianLingID) {
            NianLingID = nianLingID;
        }

        public int getXingBie() {
            return XingBie;
        }

        public void setXingBie(int xingBie) {
            XingBie = xingBie;
        }

        public int getYuJiZhuangXiu() {
            return YuJiZhuangXiu;
        }

        public void setYuJiZhuangXiu(int yuJiZhuangXiu) {
            YuJiZhuangXiu = yuJiZhuangXiu;
        }

        public int getChengJiaoLeiXing() {
            return ChengJiaoLeiXing;
        }

        public void setChengJiaoLeiXing(int chengJiaoLeiXing) {
            ChengJiaoLeiXing = chengJiaoLeiXing;
        }

        public int getMianZuQi() {
            return MianZuQi;
        }

        public void setMianZuQi(int mianZuQi) {
            MianZuQi = mianZuQi;
        }

        public String getJiaoFangShiJian() {
            return JiaoFangShiJian;
        }

        public void setJiaoFangShiJian(String jiaoFangShiJian) {
            JiaoFangShiJian = jiaoFangShiJian;
        }

        public String getLiangFangDiZhi() {
            return LiangFangDiZhi;
        }

        public void setLiangFangDiZhi(String liangFangDiZhi) {
            LiangFangDiZhi = liangFangDiZhi;
        }

        public int getZhuangXiuYuSuan() {
            return ZhuangXiuYuSuan;
        }

        public void setZhuangXiuYuSuan(int zhuangXiuYuSuan) {
            ZhuangXiuYuSuan = zhuangXiuYuSuan;
        }

        public String getYuJiZhuangXiuShiJian() {
            return YuJiZhuangXiuShiJian;
        }

        public void setYuJiZhuangXiuShiJian(String yuJiZhuangXiuShiJian) {
            YuJiZhuangXiuShiJian = yuJiZhuangXiuShiJian;
        }

        public String getYuJiLiangFang() {
            return YuJiLiangFang;
        }

        public void setYuJiLiangFang(String yuJiLiangFang) {
            YuJiLiangFang = yuJiLiangFang;
        }

        public int getZhuangXiuXuQiu() {
            return ZhuangXiuXuQiu;
        }

        public void setZhuangXiuXuQiu(int zhuangXiuXuQiu) {
            ZhuangXiuXuQiu = zhuangXiuXuQiu;
        }

        public int getXiangMuShuXing() {
            return XiangMuShuXing;
        }

        public void setXiangMuShuXing(int xiangMuShuXing) {
            XiangMuShuXing = xiangMuShuXing;
        }

        public int getQiYeGuiMoID() {
            return QiYeGuiMoID;
        }

        public void setQiYeGuiMoID(int qiYeGuiMoID) {
            QiYeGuiMoID = qiYeGuiMoID;
        }

        @Override
        public String toString() {
            return "HBodyBean{" +
                    "KeHuBaseID=" + KeHuBaseID +
                    ", ShenFenID=" + ShenFenID +
                    ", ZhuZhongDianID=" + ZhuZhongDianID +
                    ", NianLingID=" + NianLingID +
                    ", XingBie=" + XingBie +
                    ", YuJiZhuangXiu=" + YuJiZhuangXiu +
                    ", ChengJiaoLeiXing=" + ChengJiaoLeiXing +
                    ", MianZuQi=" + MianZuQi +
                    ", JiaoFangShiJian='" + JiaoFangShiJian + '\'' +
                    ", LiangFangDiZhi='" + LiangFangDiZhi + '\'' +
                    ", ZhuangXiuYuSuan='" + ZhuangXiuYuSuan + '\'' +
                    ", YuJiZhuangXiuShiJian='" + YuJiZhuangXiuShiJian + '\'' +
                    ", YuJiLiangFang='" + YuJiLiangFang + '\'' +
                    ", ZhuangXiuXuQiu=" + ZhuangXiuXuQiu +
                    ", XiangMuShuXing=" + XiangMuShuXing +
                    ", QiYeGuiMoID=" + QiYeGuiMoID +
                    '}';
        }

        public HBodyBean() {super();
        }
    }

}
