package com.wd.health.contract;

import com.wd.health.base.IBaseView;
import com.wd.health.model.bean.BannerBean;


public interface BannerContract {

    interface IView extends IBaseView{
        void onBannerSuccess(BannerBean bannerBean);
        void onBannerFailure(Throwable e);
    }

    interface IModel{
        void banner(IModelBack iModelBack);
        interface IModelBack{
            void onBannerSuccess(BannerBean bannerBean);
            void onBannerFailure(Throwable e);
        }
    }

    interface IPresenter{
        void banner();
    }
}
