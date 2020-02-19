package com.wd.health.presenter;

import com.wd.health.app.Constant;
import com.wd.health.base.BasePresenter;
import com.wd.health.contract.BingContract;
import com.wd.health.model.BingModel;
import com.wd.health.model.bean.DepartmentsBean;
import com.wd.health.model.bean.SearchSickCircleBean;
import com.wd.health.model.bean.SickCircleInfoBean;
import com.wd.health.model.bean.SickCircleListBean;

import java.util.Map;


public class BingPresenter extends BasePresenter<BingContract.IView> implements BingContract.Presenter {

    private BingModel bingModel;

    @Override
    protected void initModel() {
        bingModel = new BingModel();
    }

    @Override
    public void Depar() {
           bingModel.Depar(new BingContract.IModel.IModelCall() {
               @Override
               public void DeparSuccess(DepartmentsBean departmentsBean) {
                   if (isViewAttached()) {
                       if (departmentsBean != null && Constant.SUCCESS_CODE.equals(departmentsBean.getStatus())) {
                           getView().DeparSuccess(departmentsBean);
                       } else {
                           getView().DeparFailure(new Exception("服务器异常"));
                       }
                   }
               }

               @Override
               public void DeparFailure(Throwable e) {
                     if (isViewAttached()){
                         getView().DeparFailure(e);
                     }
               }
           });
    }

    @Override
    public void Sick(Map<String, String> map) {
        bingModel.Sick(map, new BingContract.IModel.SModelCall() {
            @Override
            public void SickSuccess(SickCircleListBean sickCircleListBean) {
                if (isViewAttached()){
                    if (sickCircleListBean != null && Constant.SUCCESS_CODE.equals(sickCircleListBean.getStatus())){
                        getView().SickSuccess(sickCircleListBean);
                    }else {
                        getView().SickFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void SickFailure(Throwable e) {
                     if (isViewAttached()){
                         getView().SickFailure(e);
                     }
            }
        });
    }

    @Override
    public void Circle(String keyWord) {
        bingModel.Circle(keyWord, new BingContract.IModel.CModelCall() {
            @Override
            public void CircleSuccess(SearchSickCircleBean searchSickCircleBean) {
                if (isViewAttached()){
                    if (searchSickCircleBean != null && Constant.SUCCESS_CODE.equals(searchSickCircleBean.getStatus())){
                        getView().CircleSuccess(searchSickCircleBean);
                    }else {
                        getView().CircleFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void CircleFailure(Throwable e) {
                if (isViewAttached()){
                    getView().CircleFailure(e);
                }
            }
        });
    }

    @Override
    public void SickInfo(Integer sickCircleId) {
        bingModel.SickInfo(sickCircleId, new BingContract.IModel.FModelCall() {
            @Override
            public void SickInfoSuccess(SickCircleInfoBean sickCircleInfoBean) {
                if (isViewAttached()){
                    if (sickCircleInfoBean != null && Constant.SUCCESS_CODE.equals(sickCircleInfoBean.getStatus())){
                        getView().SickInfoSuccess(sickCircleInfoBean);
                    }else {
                        getView().CircleFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void SickInfoFailure(Throwable e) {
                if (isViewAttached()){
                    getView().SickInfoFailure(e);
                }
            }
        });
    }
}
