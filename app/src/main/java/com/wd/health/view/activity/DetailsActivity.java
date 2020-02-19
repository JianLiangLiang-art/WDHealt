package com.wd.health.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.health.R;
import com.wd.health.adapter.SeachAdapter;
import com.wd.health.base.BaseActivity;
import com.wd.health.contract.BingContract;
import com.wd.health.model.bean.DepartmentsBean;
import com.wd.health.model.bean.SearchSickCircleBean;
import com.wd.health.model.bean.SickCircleInfoBean;
import com.wd.health.model.bean.SickCircleListBean;
import com.wd.health.presenter.BingPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailsActivity extends BaseActivity<BingPresenter> implements BingContract.IView {
    @BindView(R.id.fanhui_text)
    ImageView fanhuiText;
    @BindView(R.id.ed_mohucha)
    EditText edMohucha;
    @BindView(R.id.but_bingquanshou)
    Button butBingquanshou;
    @BindView(R.id.aaa)
    LinearLayout aaa;
    @BindView(R.id.recy_modainying)
    RecyclerView recyModainying;
//    @BindView(R.id.include_img)
//    SimpleDraweeView includeImg;
    @BindView(R.id.include_text)
    TextView includeText;
    @BindView(R.id.include_relate)
    RelativeLayout includeRelate;
    private String trim;
    private SeachAdapter seachAdapter;
    private SimpleDraweeView includeImg;

    @Override
    protected void initView() {
        super.initView();
        ButterKnife.bind(this);
        includeImg = findViewById(R.id.include_img);
    }

    @Override
    protected BingPresenter providePresenter() {
        return new BingPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_details;
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
        if (searchSickCircleBean.getStatus().equals("0000")){
            List<SearchSickCircleBean.ResultBean> result = searchSickCircleBean.getResult();
            if (result!=null){
                if (result.isEmpty()){
                    recyModainying.setVisibility(View.GONE);
                    includeRelate.setVisibility(View.VISIBLE);
                    includeText.setText("抱歉! 没有找到“"+trim+"”相关病友圈");
                }else{
                    recyModainying.setVisibility(View.VISIBLE);
                    includeRelate.setVisibility(View.GONE);
                    seachAdapter = new SeachAdapter(DetailsActivity.this, result);
                    recyModainying.setAdapter(seachAdapter);
                    seachAdapter.setItemOnClick(new SeachAdapter.ItemOnClick() {
                        @Override
                        public void onitem(int p) {
                            Intent intent = new Intent(DetailsActivity.this, SickCircleInfoActivity.class);
                            intent.putExtra("sickCircleId", p);
                            startActivity(intent);
                        }
                    });
                }
            }
        }else{
            Toast.makeText(this, searchSickCircleBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
    protected void initData() {
        super.initData();
        mPresenter.Circle("生");
        fanhuiText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        butBingquanshou.setOnClickListener(new View.OnClickListener() {

            private String trim;

            @Override
            public void onClick(View v) {
                //获取输入框内容
                trim = edMohucha.getText().toString().trim();
                if (trim != null) {
                    mPresenter.Circle(trim);
                }else{
                    recyModainying.setVisibility(View.GONE);
                    includeRelate.setVisibility(View.VISIBLE);
                }
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyModainying.setLayoutManager(linearLayoutManager);
    }
}
