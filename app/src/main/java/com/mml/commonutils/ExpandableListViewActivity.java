package com.mml.commonutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.mml.commonutils.adapter.ExpandableListViewAdapter;
import com.mml.utilslibrary.android.widget.AnimatedExpandableListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpandableListViewActivity extends AppCompatActivity {

    @BindView(R.id.expandableListView)
    AnimatedExpandableListView mAnimatedExpandableListView;
    public String[] groupString = {"射手", "辅助", "坦克", "法师","刺客"};
    public String[][] childString = {
            {"孙尚香", "后羿", "马可波罗", "狄仁杰","伽罗"},
            {"孙膑", "蔡文姬", "鬼谷子", "杨玉环"},
            {"张飞", "廉颇", "牛魔", "项羽"},
            {"诸葛亮", "王昭君", "安琪拉", "干将"},
            {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);
        ButterKnife.bind(this);
        mAnimatedExpandableListView.setAdapter(new ExpandableListViewAdapter().setGroup(groupString).setChild(childString));
        //设置分组的监听
        mAnimatedExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                if (mAnimatedExpandableListView.isGroupExpanded(groupPosition)) {
                    mAnimatedExpandableListView.collapseGroupWithAnimation(groupPosition);
                } else {
                    mAnimatedExpandableListView.expandGroupWithAnimation(groupPosition);
                }
                Toast.makeText(getApplicationContext(), groupString[groupPosition], Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        //设置子项布局监听
        mAnimatedExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), childString[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                return true;

            }
        });

        //控制他只能打开一个组
        mAnimatedExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int count = new ExpandableListViewAdapter().setGroup(groupString).setChild(childString).getGroupCount();
                for(int i = 0;i < count;i++){
                    if (i!=groupPosition){
                        mAnimatedExpandableListView.collapseGroup(i);
                    }
                }
            }
        });


    }

}
