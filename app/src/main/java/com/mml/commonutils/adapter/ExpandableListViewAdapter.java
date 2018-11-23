package com.mml.commonutils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mml.commonutils.R;
import com.mml.utilslibrary.android.widget.AnimatedExpandableListView;


/**
 * 项目名称：Base
 * Created by Long on 2018/11/23.
 * 修改时间：2018/11/23 14:00
 */
public class ExpandableListViewAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {
    private String[] groupString ;//= {"射手", "辅助", "坦克", "法师"};
    private String[][] childString ;//= {
//            {"孙尚香", "后羿", "马可波罗", "狄仁杰"},
//            {"孙膑", "蔡文姬", "鬼谷子", "杨玉环"},
//            {"张飞", "廉颇", "牛魔", "项羽"},
//            {"诸葛亮", "王昭君", "安琪拉", "干将"}
//
//    };

    public ExpandableListViewAdapter setGroup(String[] group){
        groupString=group;
        return this;
    }

    public ExpandableListViewAdapter setChild(String[][] child){
        childString=child;
        return this;
    }


    // 获取分组的个数

    @Override
    public int getGroupCount() {
        return groupString.length;
    }

//    //获取指定分组中的子选项的个数
//
//    @Override
//    public int getChildrenCount(int groupPosition) {
//        return childString[groupPosition].length;
//    }

    //        获取指定的分组数据

    @Override
    public Object getGroup(int groupPosition) {
        return groupString[groupPosition];
    }

    //获取指定分组中的指定子选项数据

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childString[groupPosition][childPosition];
    }

    //获取指定分组的ID, 这个ID必须是唯一的

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //获取子选项的ID, 这个ID必须是唯一的

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们

    @Override
    public boolean hasStableIds() {
        return true;
    }
    /**
     *
     * 获取显示指定组的视图对象
     *
     * @param groupPosition 组位置
     * @param isExpanded 该组是展开状态还是伸缩状态
     * @param convertView 重用已有的视图对象
     * @param parent 返回的视图对象始终依附于的视图组
     */
// 获取显示指定分组的视图

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expand_parent,parent,false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.imageView=convertView.findViewById(R.id.item_parent_image);
            groupViewHolder.tvTitle = (TextView)convertView.findViewById(R.id.label_group_normal);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder)convertView.getTag();
        }
        groupViewHolder.tvTitle.setText(groupString[groupPosition]);
        groupViewHolder.imageView.setColorFilter(R.color.colorPrimaryDark);
        return convertView;
    }

    @Override
    public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder;
        if (convertView == null) {
            // when convertView is not given, we try using view from cache.
            // Note: check the view type to ensure it's really resuable.
                holder = new ChildViewHolder();
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expand_child, parent, false);
                holder.tvTitle = (TextView) convertView.findViewById(R.id.expand_child);
                convertView.setTag(holder);
            } else {
            holder = (ChildViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(childString[groupPosition][childPosition]);

        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {
        return childString[groupPosition].length;
    }

//    /**
//     *
//     * 获取一个视图对象，显示指定组中的指定子元素数据。
//     *
//     * @param groupPosition 组位置
//     * @param childPosition 子元素位置
//     * @param isLastChild 子元素是否处于组中的最后一个
//     * @param convertView 重用已有的视图(View)对象
//     * @param parent 返回的视图(View)对象始终依附于的视图组
//     * @return
//     * @see android.widget.ExpandableListAdapter#getChildView(int, int, boolean, android.view.View,
//     *      android.view.ViewGroup)
//     */

    //取得显示给定分组给定子位置的数据用的视图
//    @Override
//    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//        ChildViewHolder childViewHolder;
//        if (convertView==null){
//            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expand_child,parent,false);
//            childViewHolder = new ChildViewHolder();
//            childViewHolder.tvTitle = (TextView)convertView.findViewById(R.id.expand_child);
//            convertView.setTag(childViewHolder);
//
//        }else {
//            childViewHolder = (ChildViewHolder) convertView.getTag();
//        }
//        childViewHolder.tvTitle.setText(childString[groupPosition][childPosition]);
//        return convertView;
//    }

    //指定位置上的子元素是否可选中

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    static class GroupViewHolder {
        ImageView imageView;
        TextView tvTitle;
    }

    static class ChildViewHolder {
        TextView tvTitle;

    }
}
