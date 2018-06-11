package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/22.
 */
public class AlbumImgInfo implements Serializable
{

    private int StatusCode;
    private String StatusMsg;

    private List<ImgInfo> Body;

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

    public List<ImgInfo> getBody()
    {
        return Body;
    }

    public void setBody(List<ImgInfo> Body)
    {
        this.Body = Body;
    }

    public static class ImgInfo implements Serializable
    {
        private int DetailID;
        private String ImageUrl;

        public int getDetailID()
        {
            return DetailID;
        }

        public void setDetailID(int DetailID)
        {
            this.DetailID = DetailID;
        }

        public String getImageUrl()
        {
            return ImageUrl;
        }

        public void setImageUrl(String ImageUrl)
        {
            this.ImageUrl = ImageUrl;
        }
    }
}
