package com.rxjy.rxcompound.entity;

/**
 * Created by hjh on 2018/3/12.
 */

public class MessageDetailsBean {

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public MessageDetailsBean() {
        super();
    }

    @Override
    public String toString() {
        return "MessageDetailsBean{" +
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

    public class BodyBean {
        private int id;
        private String cardno;
        private String title;
        private String txt;
        private String state;
        private String flag;
        private String create_date;
        private String update_date;
        private String type;
        private String reward_money;
        private String notice_count;
        private String initiator_name;

        public BodyBean() {
            super();
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "id=" + id +
                    ", cardno='" + cardno + '\'' +
                    ", title='" + title + '\'' +
                    ", txt='" + txt + '\'' +
                    ", state='" + state + '\'' +
                    ", flag='" + flag + '\'' +
                    ", create_date='" + create_date + '\'' +
                    ", update_date='" + update_date + '\'' +
                    ", type='" + type + '\'' +
                    ", reward_money='" + reward_money + '\'' +
                    ", notice_count='" + notice_count + '\'' +
                    ", initiator_name='" + initiator_name + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCardno() {
            return cardno;
        }

        public void setCardno(String cardno) {
            this.cardno = cardno;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTxt() {
            return txt;
        }

        public void setTxt(String txt) {
            this.txt = txt;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getCreate_date() {
            return create_date;
        }

        public void setCreate_date(String create_date) {
            this.create_date = create_date;
        }

        public String getUpdate_date() {
            return update_date;
        }

        public void setUpdate_date(String update_date) {
            this.update_date = update_date;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReward_money() {
            return reward_money;
        }

        public void setReward_money(String reward_money) {
            this.reward_money = reward_money;
        }

        public String getNotice_count() {
            return notice_count;
        }

        public void setNotice_count(String notice_count) {
            this.notice_count = notice_count;
        }

        public String getInitiator_name() {
            return initiator_name;
        }

        public void setInitiator_name(String initiator_name) {
            this.initiator_name = initiator_name;
        }
    }

}