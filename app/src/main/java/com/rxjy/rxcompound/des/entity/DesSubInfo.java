package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/23.
 */
public class DesSubInfo implements Serializable
{

    private int StatusCode;
    private String StatusMsg;
    private BodyBean Body;

    public int getStatusCode()
    {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode)
    {
        this.StatusCode = StatusCode;
    }

    public String getStatusMsg()
    {
        return StatusMsg;
    }

    public void setStatusMsg(String StatusMsg)
    {
        this.StatusMsg = StatusMsg;
    }

    public BodyBean getBody()
    {
        return Body;
    }

    public void setBody(BodyBean Body)
    {
        this.Body = Body;
    }

    public static class BodyBean implements Serializable
    {
    }
}
