package com.rxjy.rxcompound.supervision.entity;

import java.util.List;

/**
 * Created by AAA on 2017/12/25.
 */

public class AttachmentTypeInfo {

    /**
     * StatusCode : 1
     * StatusMsg : 成功
     * Body : [{"attr_model_id":46,"attr_name":"项目支款申请单 一期","attr_category":10,"attr_type":0,"templ_url":"/Files/partinfo/%e5%85%b6%e4%bb%96%e8%b5%84%e6%96%99/%e9%a1%b9%e7%9b%ae%e6%94%af%e6%ac%be%e7%94%b3%e8%af%b7%e5%8d%95%20%e4%b8%80%e6%9c%9f.doc","remark":null,"is_required":0,"ID":0},{"attr_model_id":47,"attr_name":"项目支款申请单 二期","attr_category":10,"attr_type":0,"templ_url":"/Files/partinfo/%e5%85%b6%e4%bb%96%e8%b5%84%e6%96%99/%e9%a1%b9%e7%9b%ae%e6%94%af%e6%ac%be%e7%94%b3%e8%af%b7%e5%8d%95%20%e4%ba%8c%e6%9c%9f.doc","remark":null,"is_required":0,"ID":0},{"attr_model_id":49,"attr_name":"工程整改通知单","attr_category":10,"attr_type":0,"templ_url":"/Files/partinfo/%e5%85%b6%e4%bb%96%e8%b5%84%e6%96%99/%e5%b7%a5%e7%a8%8b%e6%95%b4%e6%94%b9%e9%80%9a%e7%9f%a5%e5%8d%95.doc","remark":null,"is_required":0,"ID":0},{"attr_model_id":51,"attr_name":"安全隐患通知书","attr_category":10,"attr_type":0,"templ_url":"/Files/partinfo/%e5%85%b6%e4%bb%96%e8%b5%84%e6%96%99/%e5%ae%89%e5%85%a8%e9%9a%90%e6%82%a3%e9%80%9a%e7%9f%a5%e4%b9%a6.doc","remark":null,"is_required":0,"ID":0},{"attr_model_id":52,"attr_name":"工作联系单","attr_category":10,"attr_type":0,"templ_url":"/Files/partinfo/%e5%85%b6%e4%bb%96%e8%b5%84%e6%96%99/%e5%b7%a5%e4%bd%9c%e8%81%94%e7%b3%bb%e5%8d%95.docx","remark":null,"is_required":0,"ID":0},{"attr_model_id":53,"attr_name":"工程款支付申请表","attr_category":10,"attr_type":0,"templ_url":"/Files/partinfo/%e5%85%b6%e4%bb%96%e8%b5%84%e6%96%99/%e5%b7%a5%e7%a8%8b%e6%ac%be%e6%94%af%e4%bb%98%e7%94%b3%e8%af%b7%e8%a1%a8.docx","remark":null,"is_required":0,"ID":0},{"attr_model_id":55,"attr_name":"工程洽商记录","attr_category":10,"attr_type":0,"templ_url":"/Files/partinfo/%e5%85%b6%e4%bb%96%e8%b5%84%e6%96%99/%e5%b7%a5%e7%a8%8b%e6%b4%bd%e5%95%86%e8%ae%b0%e5%bd%95.docx","remark":null,"is_required":0,"ID":0},{"attr_model_id":91,"attr_name":"分公司项目审核表","attr_category":10,"attr_type":0,"templ_url":"/Files/partinfo/%e8%b5%84%e6%96%99%e6%a8%a1%e6%9d%bf/%e5%88%86%e5%85%ac%e5%8f%b8%e9%a1%b9%e7%9b%ae%e5%ae%a1%e6%a0%b8%e8%a1%a8.PDF","remark":null,"is_required":0,"ID":0},{"attr_model_id":93,"attr_name":"工程延期单","attr_category":10,"attr_type":0,"templ_url":null,"remark":null,"is_required":0,"ID":0},{"attr_model_id":95,"attr_name":"说明","attr_category":10,"attr_type":0,"templ_url":null,"remark":null,"is_required":0,"ID":0},{"attr_model_id":96,"attr_name":"其他资料","attr_category":10,"attr_type":0,"templ_url":null,"remark":null,"is_required":0,"ID":0},{"attr_model_id":97,"attr_name":"工人工资表","attr_category":10,"attr_type":0,"templ_url":null,"remark":null,"is_required":0,"ID":0},{"attr_model_id":102,"attr_name":"人身意外险","attr_category":10,"attr_type":2,"templ_url":null,"remark":null,"is_required":0,"ID":0}]
     */

    private int StatusCode;
    private String StatusMsg;
    private List<AttachmentInfo> Body;

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

    public List<AttachmentInfo> getBody() {
        return Body;
    }

    public void setBody(List<AttachmentInfo> Body) {
        this.Body = Body;
    }

    public static class AttachmentInfo {
        /**
         * attr_model_id : 46
         * attr_name : 项目支款申请单 一期
         * attr_category : 10
         * attr_type : 0
         * templ_url : /Files/partinfo/%e5%85%b6%e4%bb%96%e8%b5%84%e6%96%99/%e9%a1%b9%e7%9b%ae%e6%94%af%e6%ac%be%e7%94%b3%e8%af%b7%e5%8d%95%20%e4%b8%80%e6%9c%9f.doc
         * remark : null
         * is_required : 0
         * ID : 0
         */

        private int attr_model_id;
        private String attr_name;
        private int attr_category;
        private int attr_type;

        public int getAttr_model_id() {
            return attr_model_id;
        }

        public void setAttr_model_id(int attr_model_id) {
            this.attr_model_id = attr_model_id;
        }

        public String getAttr_name() {
            return attr_name;
        }

        public void setAttr_name(String attr_name) {
            this.attr_name = attr_name;
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
    }
}
