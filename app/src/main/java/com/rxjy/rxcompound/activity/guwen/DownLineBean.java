package com.rxjy.rxcompound.activity.guwen;

import java.util.List;

/**
 * Created by Administrator on 2018/5/30.
 */

public class DownLineBean {


    /**
     * StatusCode : 0
     * StatusMsg : 请求成功
     * Body : {"table":[{"Phone":"13141556985","Name":"会员","image":null,"State":"未激活"}],"count":1}
     */

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

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

    public BodyBean getBody() {
        return Body;
    }

    public void setBody(BodyBean Body) {
        this.Body = Body;
    }

    public static class BodyBean {
        /**
         * table : [{"Phone":"13141556985","Name":"会员","image":null,"State":"未激活"}]
         * count : 1
         */

        private int count;
        private List<TableBean> table;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<TableBean> getTable() {
            return table;
        }

        public void setTable(List<TableBean> table) {
            this.table = table;
        }

        public static class TableBean {
            /**
             * Phone : 13141556985
             * Name : 会员
             * image : null
             * State : 未激活
             */

            private String Phone;
            private String Name;
            private String image;
            private String State;

            public String getPhone() {
                return Phone;
            }

            public void setPhone(String Phone) {
                this.Phone = Phone;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getState() {
                return State;
            }

            public void setState(String State) {
                this.State = State;
            }
        }
    }
}
