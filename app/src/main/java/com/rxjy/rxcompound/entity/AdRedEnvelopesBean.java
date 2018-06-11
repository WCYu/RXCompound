package com.rxjy.rxcompound.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/5/9.
 */

public class AdRedEnvelopesBean {


    /**
     * StatusCode : 0
     * StatusMsg : 获取成功
     * Body : [{"user_name":"范彩金","two_level":"商务入职","create_time":"04.28","task_award":500,"content_total":"5月份商务人数达到22人（以入职为准）","count_down":"413","task_num":"5人","task_balance":"余5","now_number":0,"execute_time":"2018-05-31 23:59:59"},{"user_name":"范彩金","two_level":"主案入职","create_time":"04.28","task_award":300,"content_total":"设计总监18号前到岗（以入职为准），同时需要集团主案面试通过。","count_down":"101","task_num":"1人","task_balance":"余1","now_number":0,"execute_time":"2018-05-18 23:59:59"}]
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

    public static class BodyBean implements Serializable {
        /**
         * user_name : 范彩金
         * two_level : 商务入职
         * create_time : 04.28
         * task_award : 500.0
         * content_total : 5月份商务人数达到22人（以入职为准）
         * count_down : 413
         * task_num : 5人
         * task_balance : 余5
         * now_number : 0
         * execute_time : 2018-05-31 23:59:59
         */

        private String user_name;
        private String two_level;
        private String create_time;
        private double task_award;
        private String content_total;
        private String count_down;
        private String task_num;
        private String task_balance;
        private int now_number;
        private String execute_time;

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getTwo_level() {
            return two_level;
        }

        public void setTwo_level(String two_level) {
            this.two_level = two_level;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public double getTask_award() {
            return task_award;
        }

        public void setTask_award(double task_award) {
            this.task_award = task_award;
        }

        public String getContent_total() {
            return content_total;
        }

        public void setContent_total(String content_total) {
            this.content_total = content_total;
        }

        public String getCount_down() {
            return count_down;
        }

        public void setCount_down(String count_down) {
            this.count_down = count_down;
        }

        public String getTask_num() {
            return task_num;
        }

        public void setTask_num(String task_num) {
            this.task_num = task_num;
        }

        public String getTask_balance() {
            return task_balance;
        }

        public void setTask_balance(String task_balance) {
            this.task_balance = task_balance;
        }

        public int getNow_number() {
            return now_number;
        }

        public void setNow_number(int now_number) {
            this.now_number = now_number;
        }

        public String getExecute_time() {
            return execute_time;
        }

        public void setExecute_time(String execute_time) {
            this.execute_time = execute_time;
        }
    }
}
