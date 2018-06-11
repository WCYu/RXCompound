package com.rxjy.rxcompound.supervision.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
public class PrepareInfo {

    private int StatusCode;
    private String StatusMsg;

    private List<PrepareGroup> Body;

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

    public List<PrepareGroup> getBody() {
        return Body;
    }

    public void setBody(List<PrepareGroup> Body) {
        this.Body = Body;
    }

    public static class PrepareGroup {
        private int process_id;
        private String process_name;
        private int NoCount;
        private int Status;
        /**
         * process_id : 196
         * process_name : 人员安全
         * NoCount : 1
         * Status : 0
         */

        private List<PrepareChild> list;

        public int getProcess_id() {
            return process_id;
        }

        public void setProcess_id(int process_id) {
            this.process_id = process_id;
        }

        public String getProcess_name() {
            return process_name;
        }

        public void setProcess_name(String process_name) {
            this.process_name = process_name;
        }

        public int getNoCount() {
            return NoCount;
        }

        public void setNoCount(int NoCount) {
            this.NoCount = NoCount;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public List<PrepareChild> getList() {
            return list;
        }

        public void setList(List<PrepareChild> list) {
            this.list = list;
        }

        public static class PrepareChild {
            private int process_id;
            private String process_name;
            private int NoCount;
            private int Status;

            public int getProcess_id() {
                return process_id;
            }

            public void setProcess_id(int process_id) {
                this.process_id = process_id;
            }

            public String getProcess_name() {
                return process_name;
            }

            public void setProcess_name(String process_name) {
                this.process_name = process_name;
            }

            public int getNoCount() {
                return NoCount;
            }

            public void setNoCount(int NoCount) {
                this.NoCount = NoCount;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }
        }
    }
}
