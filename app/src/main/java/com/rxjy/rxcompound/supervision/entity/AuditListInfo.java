package com.rxjy.rxcompound.supervision.entity;

import java.util.List;

/**
 * Created by AAA on 2017/12/14.
 */

public class AuditListInfo {

    /**
     * StatusCode : 1
     * StatusMsg : 成功
     * Body : {"loseitems":[{"item_id":2038,"item_name":"顶面漆调色费(深色)","item_type":1,"quantity_type":0,"price_type":0,"dispersion":27,"unit":"平方米","quantity":0,"cost_price":0,"cost_price_update":1.6,"quoted_price":0,"quoted_price_update":3,"operate_type":3,"check_state":2,"problem_describe":null,"yesorno_typical":0,"area_id":588,"order_id":47,"order_no":"11-168205","area_no":"146faa4f-91b3-4b85-9083-001a54851212","area_name":"卫生间","item_checked":0,"quantity_checked":0,"price_checked":0,"total_cost_price":30752.77,"total_quoted_price":35348.01,"area_rate":0,"createtime":"2016-07-07T09:35:53.337","ID":0},{"item_id":2039,"item_name":"五孔墙面插座","item_type":3,"quantity_type":3,"price_type":0,"dispersion":2,"unit":"套","quantity":0,"cost_price":0,"cost_price_update":12.6,"quoted_price":0,"quoted_price_update":25.48,"operate_type":4,"check_state":2,"problem_describe":null,"yesorno_typical":0,"area_id":597,"order_id":47,"order_no":"11-168205","area_no":"374824ec-a4a1-4bf1-9217-8993d46f8c7c","area_name":"电气工程.","item_checked":0,"quantity_checked":0,"price_checked":0,"total_cost_price":9245.55,"total_quoted_price":10627.07,"area_rate":0,"createtime":"2016-07-07T09:50:39.333","ID":0},{"item_id":2040,"item_name":"双联单控开关","item_type":3,"quantity_type":3,"price_type":0,"dispersion":2,"unit":"套","quantity":0,"cost_price":0,"cost_price_update":12.6,"quoted_price":0,"quoted_price_update":20.02,"operate_type":4,"check_state":2,"problem_describe":null,"yesorno_typical":0,"area_id":597,"order_id":47,"order_no":"11-168205","area_no":"374824ec-a4a1-4bf1-9217-8993d46f8c7c","area_name":"电气工程.","item_checked":0,"quantity_checked":0,"price_checked":0,"total_cost_price":9245.55,"total_quoted_price":10627.07,"area_rate":0,"createtime":"2016-07-07T09:50:39.357","ID":0},{"item_id":2041,"item_name":"墙面双面挂网","item_type":4,"quantity_type":4,"price_type":0,"dispersion":4,"unit":"平方米","quantity":0,"cost_price":0,"cost_price_update":36.04,"quoted_price":0,"quoted_price_update":63.7,"operate_type":4,"check_state":2,"problem_describe":null,"yesorno_typical":0,"area_id":601,"order_id":47,"order_no":"11-168205","area_no":"1018b821-6cb0-48c8-865c-d9e29b3b835a","area_name":"间隔工程.","item_checked":0,"quantity_checked":0,"price_checked":0,"total_cost_price":8499.25,"total_quoted_price":9769.25,"area_rate":0,"createtime":"2016-07-07T09:50:39.387","ID":0}],"RecordCount":4}
     */

    private int StatusCode;
    private String StatusMsg;
    private AuditList Body;

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

    public AuditList getBody() {
        return Body;
    }

    public void setBody(AuditList Body) {
        this.Body = Body;
    }

    public static class AuditList {
        /**
         * loseitems : [{"item_id":2038,"item_name":"顶面漆调色费(深色)","item_type":1,"quantity_type":0,"price_type":0,"dispersion":27,"unit":"平方米","quantity":0,"cost_price":0,"cost_price_update":1.6,"quoted_price":0,"quoted_price_update":3,"operate_type":3,"check_state":2,"problem_describe":null,"yesorno_typical":0,"area_id":588,"order_id":47,"order_no":"11-168205","area_no":"146faa4f-91b3-4b85-9083-001a54851212","area_name":"卫生间","item_checked":0,"quantity_checked":0,"price_checked":0,"total_cost_price":30752.77,"total_quoted_price":35348.01,"area_rate":0,"createtime":"2016-07-07T09:35:53.337","ID":0},{"item_id":2039,"item_name":"五孔墙面插座","item_type":3,"quantity_type":3,"price_type":0,"dispersion":2,"unit":"套","quantity":0,"cost_price":0,"cost_price_update":12.6,"quoted_price":0,"quoted_price_update":25.48,"operate_type":4,"check_state":2,"problem_describe":null,"yesorno_typical":0,"area_id":597,"order_id":47,"order_no":"11-168205","area_no":"374824ec-a4a1-4bf1-9217-8993d46f8c7c","area_name":"电气工程.","item_checked":0,"quantity_checked":0,"price_checked":0,"total_cost_price":9245.55,"total_quoted_price":10627.07,"area_rate":0,"createtime":"2016-07-07T09:50:39.333","ID":0},{"item_id":2040,"item_name":"双联单控开关","item_type":3,"quantity_type":3,"price_type":0,"dispersion":2,"unit":"套","quantity":0,"cost_price":0,"cost_price_update":12.6,"quoted_price":0,"quoted_price_update":20.02,"operate_type":4,"check_state":2,"problem_describe":null,"yesorno_typical":0,"area_id":597,"order_id":47,"order_no":"11-168205","area_no":"374824ec-a4a1-4bf1-9217-8993d46f8c7c","area_name":"电气工程.","item_checked":0,"quantity_checked":0,"price_checked":0,"total_cost_price":9245.55,"total_quoted_price":10627.07,"area_rate":0,"createtime":"2016-07-07T09:50:39.357","ID":0},{"item_id":2041,"item_name":"墙面双面挂网","item_type":4,"quantity_type":4,"price_type":0,"dispersion":4,"unit":"平方米","quantity":0,"cost_price":0,"cost_price_update":36.04,"quoted_price":0,"quoted_price_update":63.7,"operate_type":4,"check_state":2,"problem_describe":null,"yesorno_typical":0,"area_id":601,"order_id":47,"order_no":"11-168205","area_no":"1018b821-6cb0-48c8-865c-d9e29b3b835a","area_name":"间隔工程.","item_checked":0,"quantity_checked":0,"price_checked":0,"total_cost_price":8499.25,"total_quoted_price":9769.25,"area_rate":0,"createtime":"2016-07-07T09:50:39.387","ID":0}]
         * RecordCount : 4
         */

        private int RecordCount;
        private List<AuditInfo> loseitems;

        public int getRecordCount() {
            return RecordCount;
        }

        public void setRecordCount(int RecordCount) {
            this.RecordCount = RecordCount;
        }

        public List<AuditInfo> getLoseitems() {
            return loseitems;
        }

        public void setLoseitems(List<AuditInfo> loseitems) {
            this.loseitems = loseitems;
        }

        public static class AuditInfo {
            /**
             * item_id : 2038
             * item_name : 顶面漆调色费(深色)
             * item_type : 1
             * quantity_type : 0
             * price_type : 0
             * dispersion : 27
             * unit : 平方米
             * quantity : 0
             * cost_price : 0
             * cost_price_update : 1.6
             * quoted_price : 0
             * quoted_price_update : 3
             * operate_type : 3
             * check_state : 2
             * problem_describe : null
             * yesorno_typical : 0
             * area_id : 588
             * order_id : 47
             * order_no : 11-168205
             * area_no : 146faa4f-91b3-4b85-9083-001a54851212
             * area_name : 卫生间
             * item_checked : 0
             * quantity_checked : 0
             * price_checked : 0
             * total_cost_price : 30752.77
             * total_quoted_price : 35348.01
             * area_rate : 0
             * createtime : 2016-07-07T09:35:53.337
             * ID : 0
             */

            private int item_id;
            private String item_name;
            private int item_type;
            private int quantity_type;
            private int price_type;
            private int dispersion;
            private String unit;
            private int quantity;
            private int cost_price;
            private double cost_price_update;
            private double quoted_price;
            private double quoted_price_update;
            private int operate_type;
            private int check_state;
            private int area_id;
            private int order_id;
            private String order_no;
            private String area_name;

            public int getItem_id() {
                return item_id;
            }

            public void setItem_id(int item_id) {
                this.item_id = item_id;
            }

            public String getItem_name() {
                return item_name;
            }

            public void setItem_name(String item_name) {
                this.item_name = item_name;
            }

            public int getItem_type() {
                return item_type;
            }

            public void setItem_type(int item_type) {
                this.item_type = item_type;
            }

            public int getQuantity_type() {
                return quantity_type;
            }

            public void setQuantity_type(int quantity_type) {
                this.quantity_type = quantity_type;
            }

            public int getPrice_type() {
                return price_type;
            }

            public void setPrice_type(int price_type) {
                this.price_type = price_type;
            }

            public int getDispersion() {
                return dispersion;
            }

            public void setDispersion(int dispersion) {
                this.dispersion = dispersion;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getCost_price() {
                return cost_price;
            }

            public void setCost_price(int cost_price) {
                this.cost_price = cost_price;
            }

            public double getCost_price_update() {
                return cost_price_update;
            }

            public void setCost_price_update(double cost_price_update) {
                this.cost_price_update = cost_price_update;
            }

            public double getQuoted_price() {
                return quoted_price;
            }

            public void setQuoted_price(double quoted_price) {
                this.quoted_price = quoted_price;
            }

            public double getQuoted_price_update() {
                return quoted_price_update;
            }

            public void setQuoted_price_update(int quoted_price_update) {
                this.quoted_price_update = quoted_price_update;
            }

            public int getOperate_type() {
                return operate_type;
            }

            public void setOperate_type(int operate_type) {
                this.operate_type = operate_type;
            }

            public int getCheck_state() {
                return check_state;
            }

            public void setCheck_state(int check_state) {
                this.check_state = check_state;
            }

            public int getArea_id() {
                return area_id;
            }

            public void setArea_id(int area_id) {
                this.area_id = area_id;
            }

            public int getOrder_id() {
                return order_id;
            }

            public void setOrder_id(int order_id) {
                this.order_id = order_id;
            }

            public String getOrder_no() {
                return order_no;
            }

            public void setOrder_no(String order_no) {
                this.order_no = order_no;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }
        }
    }
}
