package com.wd.health.view.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.health.R;
import com.wd.health.base.BaseActivity;
import com.wd.health.contract.BingContract;
import com.wd.health.model.bean.DepartmentsBean;
import com.wd.health.model.bean.SearchSickCircleBean;
import com.wd.health.model.bean.SickCircleInfoBean;
import com.wd.health.model.bean.SickCircleListBean;
import com.wd.health.presenter.BingPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SickCircleInfoActivity extends BaseActivity<BingPresenter> implements BingContract.IView {
    @BindView(R.id.text_title)
    TextView textTitle;
    @BindView(R.id.relr)
    RelativeLayout relr;
    @BindView(R.id.text_xm)
    TextView textXm;
    @BindView(R.id.text_bingzhneg)
    TextView textBingzhneg;
    @BindView(R.id.text_neike)
    TextView textNeike;
    @BindView(R.id.text_xiangqing)
    TextView textXiangqing;
    @BindView(R.id.text_tiantan)
    TextView textTiantan;
    @BindView(R.id.text_riqi)
    TextView textRiqi;
    @BindView(R.id.text_jingli)
    TextView textJingli;
    @BindView(R.id.info_img)
    ImageView infoImg;
    @BindView(R.id.img_shoucang)
    CheckBox imgShoucang;
    @BindView(R.id.item_shoucang)
    TextView itemShoucang;
    @BindView(R.id.jianyi)
    ImageView jianyi;
    @BindView(R.id.item_jianyi)
    TextView itemJianyi;
    @BindView(R.id.img_HeadPic)
    SimpleDraweeView imgHeadPic;
    @BindView(R.id.name_NickName)
    TextView nameNickName;
    @BindView(R.id.time_adoptTime)
    TextView timeAdoptTime;
    @BindView(R.id.text_adoptComment)
    TextView textAdoptComment;
    @BindView(R.id.adoptFlag)
    LinearLayout adoptFlag;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.patient_activity_iv_cancel)
    ImageView patientActivityIvCancel;
    @BindView(R.id.patient_activity_et_content)
    EditText patientActivityEtContent;
    @BindView(R.id.patient_activity_iv_send_content)
    ImageView patientActivityIvSendContent;
    @BindView(R.id.patient_activity_relative_content)
    RelativeLayout patientActivityRelativeContent;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.wupinglun)
    RelativeLayout wupinglun;
    @BindView(R.id.patient_activity_iv_intent_release_sickCircle)
    ImageView patientActivityIvIntentReleaseSickCircle;
    @BindView(R.id.patient_activity_relative_release_sickCircle)
    RelativeLayout patientActivityRelativeReleaseSickCircle;

    @Override
    protected BingPresenter providePresenter() {
        return new BingPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_sickinfo;
    }

    @Override
    public void DeparSuccess(DepartmentsBean departmentsBean) {

    }

    @Override
    public void DeparFailure(Throwable e) {

    }

    @Override
    public void SickSuccess(SickCircleListBean sickCircleListBean) {

    }

    @Override
    public void SickFailure(Throwable e) {

    }

    @Override
    public void CircleSuccess(SearchSickCircleBean searchSickCircleBean) {

    }

    @Override
    public void CircleFailure(Throwable e) {

    }

    @Override
    public void SickInfoSuccess(SickCircleInfoBean sickCircleInfoBean) {

    }

    @Override
    public void SickInfoFailure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
