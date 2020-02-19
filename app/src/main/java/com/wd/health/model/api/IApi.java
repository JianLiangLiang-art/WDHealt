package com.wd.health.model.api;


import com.wd.health.model.bean.BannerBean;

import com.wd.health.model.bean.ChaXunShiPin_ResutBean;
import com.wd.health.model.bean.LoginBean;
import com.wd.health.model.bean.Video_TablayoutResultBean;

import com.wd.health.model.bean.DepartmentsBean;
import com.wd.health.model.bean.LoginBean;
import com.wd.health.model.bean.SearchSickCircleBean;
import com.wd.health.model.bean.SickCircleInfoBean;
import com.wd.health.model.bean.SickCircleListBean;
import io.reactivex.Observable;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


import retrofit2.http.Query;

import retrofit2.http.QueryMap;

/**
 * @Description: 类作用描述
 * @Author: 高晨凯
 * @CreateDate: 2020/1/7 14:05
 */
public interface IApi {

    @FormUrlEncoded
    @POST("user/v1/login")
    Observable<LoginBean> login(@FieldMap Map<String, Object> map);

    //banner轮播
    @GET("share/v1/bannersShow")
    Observable<BannerBean> banner();


    @GET("user/video/v1/findVideoCategoryList")
    Observable<Video_TablayoutResultBean> tablyList();

    @GET("user/video/v1/findVideoVoList")
    @Headers({"userId:68447","sessionId:1578713430968447"})
    Observable<ChaXunShiPin_ResutBean> chaXun_Vidio(@QueryMap Map<String,Object> map);

    //科室列表
    @GET("share/knowledgeBase/v1/findDepartment")
    Observable<DepartmentsBean> depar();

    //病友圈列表
    @GET("user/sickCircle/v1/findSickCircleList")
    Observable<SickCircleListBean> sick(@QueryMap Map<String,String> map);

    //关键词查询病友圈
    @GET("user/sickCircle/v1/searchSickCircle")
    Observable<SearchSickCircleBean> circle(@Query("keyWord") String keyWord);

    //查询病友圈详情
    //http://172.17.8.100/health/user/sickCircle/v1/findSickCircleInfo?sickCircleId=4
    @GET("health/user/sickCircle/v1/findSickCircleInfo")
    Observable<SickCircleInfoBean> getSickCircleInfo(@Query("sickCircleId") Integer sickCircleId);

}
