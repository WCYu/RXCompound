package com.rxjy.rxcompound.supervision.mvp.contract;

import com.rxjy.rxcompound.commons.base.BaseModel;
import com.rxjy.rxcompound.commons.base.BasePresenter;
import com.rxjy.rxcompound.commons.base.BaseView;
import com.rxjy.rxcompound.supervision.entity.ProblemInfo;

import java.util.List;

import rx.Observable;

/**
 * Created by AAA on 2018/1/17.
 */

public interface NewRoutingSubContract {

    interface View extends BaseView {

        //提交巡检成功
        void responseRoutingSubData();

        //提交巡检失败
        void responseRoutingSubDataError(String msg);

        //返回问题列表
        void responseProblemListData(List<ProblemInfo.Problem> dataList);

        //返回问题列表错误信息
        void responseProblemListDataError(String msg);

        void showDialog();

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<String> getProblemList(

        );

        Observable<String> subXJProblem(
                int xjID,
                String orderNo,
                String content,
                String count,
                double xjX,
                double xjY,
                String address,
                int type,
                List<ProblemInfo.Problem> proList
        );
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getProblemList(

        );

        public abstract void subXJProblem(
                int xjID,
                String orderNo,
                String content,
                String count,
                double xjX,
                double xjY,
                String address,
                int type,
                List<ProblemInfo.Problem> proList
        );
    }

}
