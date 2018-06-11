package com.rxjy.rxcompound.des.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by qindd on 2017/6/21.
 */
public class AllImagesInfo implements Serializable
{

    /**
     * StatusCode : 0
     * StatusMsg : Success
     * Body : [{"CreatorID":0,"WorksID":0,"CatalogID":53,"CatalogIDName":"量房手绘","CatalogCount":2,"childList":[{"DetailID":132990,"ImageUrl":"Image/2016/06/20/18110093371274.jpg"},{"DetailID":133032,"ImageUrl":"Image/2016/06/20/18112476377800.jpg"}]},{"CreatorID":0,"WorksID":0,"CatalogID":109,"CatalogIDName":"周边环境","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":123,"CatalogIDName":"大厦外立面","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":124,"CatalogIDName":"室内全景照片","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":125,"CatalogIDName":"墙面","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":126,"CatalogIDName":"顶面","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":127,"CatalogIDName":"地面","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":128,"CatalogIDName":"门面","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":129,"CatalogIDName":"空调","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":130,"CatalogIDName":"消防","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":131,"CatalogIDName":"强电箱","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":132,"CatalogIDName":"弱电箱","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":133,"CatalogIDName":"上下水","CatalogCount":0,"childList":[]},{"CreatorID":0,"WorksID":0,"CatalogID":134,"CatalogIDName":"特殊结构","CatalogCount":0,"childList":[]}]
     */

    private int StatusCode;
    private String StatusMsg;
    /**
     * CreatorID : 0
     * WorksID : 0
     * CatalogID : 53
     * CatalogIDName : 量房手绘
     * CatalogCount : 2
     * childList : [{"DetailID":132990,"ImageUrl":"Image/2016/06/20/18110093371274.jpg"},{"DetailID":133032,"ImageUrl":"Image/2016/06/20/18112476377800.jpg"}]
     */

    private List<Album> Body;

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

    public List<Album> getBody()
    {
        return Body;
    }

    public void setBody(List<Album> Body)
    {
        this.Body = Body;
    }

    public static class Album implements Serializable
    {
        private int CreatorID;
        private int WorksID;
        private int CatalogID;
        private String CatalogIDName;
        private int CatalogCount;
        private String CatalogShowType;
        private List<image> childList;

        public String getCatalogShowType()
        {
            return CatalogShowType;
        }

        public void setCatalogShowType(String catalogShowType)
        {
            CatalogShowType = catalogShowType;
        }

        public int getCreatorID()
        {
            return CreatorID;
        }

        public void setCreatorID(int CreatorID)
        {
            this.CreatorID = CreatorID;
        }

        public int getWorksID()
        {
            return WorksID;
        }

        public void setWorksID(int WorksID)
        {
            this.WorksID = WorksID;
        }

        public int getCatalogID()
        {
            return CatalogID;
        }

        public void setCatalogID(int CatalogID)
        {
            this.CatalogID = CatalogID;
        }

        public String getCatalogIDName()
        {
            return CatalogIDName;
        }

        public void setCatalogIDName(String CatalogIDName)
        {
            this.CatalogIDName = CatalogIDName;
        }

        public int getCatalogCount()
        {
            return CatalogCount;
        }

        public void setCatalogCount(int CatalogCount)
        {
            this.CatalogCount = CatalogCount;
        }

        public List<image> getChildList()
        {
            return childList;
        }

        public void setChildList(List<image> childList)
        {
            this.childList = childList;
        }

        public static class image implements Serializable
        {
            private int DetailID;
            private String ImageUrl;

            public image()
            {
            }

            public image(int detailID, String imageUrl)
            {
                DetailID = detailID;
                ImageUrl = imageUrl;
            }

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
}
