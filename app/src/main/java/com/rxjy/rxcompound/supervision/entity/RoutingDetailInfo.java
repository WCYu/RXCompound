package com.rxjy.rxcompound.supervision.entity;

import java.util.List;

/**
 * Created by AAA on 2018/1/17.
 */

public class RoutingDetailInfo {

    /**
     * StatusCode : 1
     * StatusMsg : Success
     * Body : [{"xj_id":7317,"xj_orderno":"50-17300","xj_remark":"地方撒旦撒发","xj_photoUrl":["http://img9.rxjy.com:80/image/0AA6wKgBtFpfG8GAXkjgAAASWn6OmF4260.png","http://img9.rxjy.com:80/image/0AA6wKgBtFpfG8GAIhdKAAJJIY60fi4814.png"],"xj_TypeName":"工程质量"},{"xj_id":7317,"xj_orderno":"50-17300","xj_remark":"","xj_photoUrl":[],"xj_TypeName":"施工进度"},{"xj_id":7317,"xj_orderno":"50-17300","xj_remark":"","xj_photoUrl":[],"xj_TypeName":"安全形象"},{"xj_id":7317,"xj_orderno":"50-17300","xj_remark":"是的范德萨","xj_photoUrl":["http://img9.rxjy.com:80/image/0AA6wKgBtFpfG8GAC3ZuAAOS2c4Ts5U587.png","http://img9.rxjy.com:80/image/0AA6wKgBtFpfG8GAGDgbAAMPceXyumo091.png"],"xj_TypeName":"环境卫生"},{"xj_id":7317,"xj_orderno":"50-17300","xj_remark":"","xj_photoUrl":[],"xj_TypeName":"材料质量"},{"xj_id":7317,"xj_orderno":"50-17300","xj_remark":"的的撒","xj_photoUrl":["http://img9.rxjy.com:80/image/0AA6wKgBtFpfG8GAUr0HAAMPceXyumo523.png"],"xj_TypeName":"项目管理"}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<RoutingMarkInfo> Body;

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

    public List<RoutingMarkInfo> getBody() {
        return Body;
    }

    public void setBody(List<RoutingMarkInfo> Body) {
        this.Body = Body;
    }

    public static class RoutingMarkInfo {
        /**
         * xj_id : 7317
         * xj_orderno : 50-17300
         * xj_remark : 地方撒旦撒发
         * xj_photoUrl : ["http://img9.rxjy.com:80/image/0AA6wKgBtFpfG8GAXkjgAAASWn6OmF4260.png","http://img9.rxjy.com:80/image/0AA6wKgBtFpfG8GAIhdKAAJJIY60fi4814.png"]
         * xj_TypeName : 工程质量
         */

        private int xj_id;
        private String xj_orderno;
        private String xj_remark;
        private String xj_TypeName;
        private List<String> xj_photoUrl;

        public int getXj_id() {
            return xj_id;
        }

        public void setXj_id(int xj_id) {
            this.xj_id = xj_id;
        }

        public String getXj_orderno() {
            return xj_orderno;
        }

        public void setXj_orderno(String xj_orderno) {
            this.xj_orderno = xj_orderno;
        }

        public String getXj_remark() {
            return xj_remark;
        }

        public void setXj_remark(String xj_remark) {
            this.xj_remark = xj_remark;
        }

        public String getXj_TypeName() {
            return xj_TypeName;
        }

        public void setXj_TypeName(String xj_TypeName) {
            this.xj_TypeName = xj_TypeName;
        }

        public List<String> getXj_photoUrl() {
            return xj_photoUrl;
        }

        public void setXj_photoUrl(List<String> xj_photoUrl) {
            this.xj_photoUrl = xj_photoUrl;
        }
    }
}
