package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/10/23.
 */

public class GetZaishiInfo implements Serializable{

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"ci_RwdId":"12-186672","ci_ClientName":"北京杰控科技有限公司","ci_DecorationAddress":"永定路口长银大厦10层b07","ci_DesignerCard":"03710123","sg_TrueTime":"2016-06-30","sg_StateName":"施工"},{"ci_RwdId":"12-186762","ci_ClientName":"常营未来时大厦10层装修项目","ci_DecorationAddress":"常营未来时大厦10层","ci_DesignerCard":"03710123","sg_TrueTime":"2016-08-04","sg_StateName":"竣工"},{"ci_RwdId":"12-188919","ci_ClientName":"IT类试完研发公司","ci_DecorationAddress":"朝阳未来大厦","ci_DesignerCard":"03710123","sg_TrueTime":"2016-08-25","sg_StateName":"竣工"},{"ci_RwdId":"12-191248","ci_ClientName":"北京雷霆万钧网络科技有限责任公司办公装修工程","ci_DecorationAddress":"东城区房东广场w3座8层","ci_DesignerCard":"03710123","sg_TrueTime":"2017-01-04","sg_StateName":"竣工"},{"ci_RwdId":"12-191333","ci_ClientName":"北京房金时代金融服务外包有限公司办公装饰工程","ci_DecorationAddress":"瀚海大厦","ci_DesignerCard":"03710123","sg_TrueTime":"2016-12-06","sg_StateName":"竣工"},{"ci_RwdId":"12-190329","ci_ClientName":"三辰影库音像出版社有限公司","ci_DecorationAddress":"双桥金隅可乐A座","ci_DesignerCard":"03710123","sg_TrueTime":"2016-12-06","sg_StateName":"竣工"},{"ci_RwdId":"12-191569","ci_ClientName":"北京长江证卷公司办公装饰工程","ci_DecorationAddress":"北京市朝阳区中海广场23层2301室","ci_DesignerCard":"03710123","sg_TrueTime":"2016-12-14","sg_StateName":"竣工"},{"ci_RwdId":"12-193162","ci_ClientName":"北京市光华机电有限公司办公装施工程","ci_DecorationAddress":"北京经济技术开发区路东区科创十三街31号院二区13号楼501室","ci_DesignerCard":"03710123","sg_TrueTime":"2017-05-10","sg_StateName":"施工"},{"ci_RwdId":"12-194625","ci_ClientName":"信达证券办公装饰工程","ci_DecorationAddress":"北京市海淀区中关村善缘街立方庭旁","ci_DesignerCard":"03710123","sg_TrueTime":"2017-06-01","sg_StateName":"施工"}]
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

    public static class BodyBean implements Serializable{
        /**
         * ci_RwdId : 12-186672
         * ci_ClientName : 北京杰控科技有限公司
         * ci_DecorationAddress : 永定路口长银大厦10层b07
         * ci_DesignerCard : 03710123
         * sg_TrueTime : 2016-06-30
         * sg_StateName : 施工
         */

        private String ci_RwdId;
        private String ci_ClientName;
        private String ci_DecorationAddress;
        private String ci_DesignerCard;
        private String sg_TrueTime;
        private String sg_StateName;

        public String getCi_RwdId() {
            return ci_RwdId;
        }

        public void setCi_RwdId(String ci_RwdId) {
            this.ci_RwdId = ci_RwdId;
        }

        public String getCi_ClientName() {
            return ci_ClientName;
        }

        public void setCi_ClientName(String ci_ClientName) {
            this.ci_ClientName = ci_ClientName;
        }

        public String getCi_DecorationAddress() {
            return ci_DecorationAddress;
        }

        public void setCi_DecorationAddress(String ci_DecorationAddress) {
            this.ci_DecorationAddress = ci_DecorationAddress;
        }

        public String getCi_DesignerCard() {
            return ci_DesignerCard;
        }

        public void setCi_DesignerCard(String ci_DesignerCard) {
            this.ci_DesignerCard = ci_DesignerCard;
        }

        public String getSg_TrueTime() {
            return sg_TrueTime;
        }

        public void setSg_TrueTime(String sg_TrueTime) {
            this.sg_TrueTime = sg_TrueTime;
        }

        public String getSg_StateName() {
            return sg_StateName;
        }

        public void setSg_StateName(String sg_StateName) {
            this.sg_StateName = sg_StateName;
        }
    }
}
