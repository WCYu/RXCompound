package com.rxjy.rxcompound.supervision.mvp.contract;
import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.AuditListInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2017/12/13.
 */

public interface AuditContract {

    interface View extends BaseView {

        void responseAuditListData(List<AuditListInfo.AuditList.AuditInfo> dataList);

        void responseAuditListDataError(String msg);

        void responseAuditListLoadMoreData(List<AuditListInfo.AuditList.AuditInfo> dataList);

        void responseAuditListLoadMoreDataError(String msg);

    }

    interface Model extends BaseModel {

        Observable<String> getAuditList(
                String orderNo,
                int pageIndex,
                int pageSize
        );

        Observable<String> getAuditListLoadMore(
                String orderNo,
                int pageIndex,
                int pageSize
        );

    }

    abstract class Presenter extends BasePresenter<View, Model> {

        public abstract void getAuditList(
                String orderNo,
                int pageIndex,
                int pageSize
        );

        public abstract void getAuditListLoadMore(
                String orderNo,
                int pageIndex,
                int pageSize
        );

    }


}
