- 2018-11-23
  ### 添加带动画的ExpandableListView
  参考app下ExpandableListViewActivity
    - 使用方式
      1. 布局
      ```
       <com.mml.utilslibrary.android.widget.AnimatedExpandableListView
              android:id="@+id/expandableListView"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:layoutDirection="rtl"
              >
          </com.mml.utilslibrary.android.widget.AnimatedExpandableListView>
      ```
      2. 创建父item文件和孩子item文件，参考app目录下item_expand_child.xml和item_expand_parent.xml
      3. 创建ExpandableListViewAdapter继承AnimatedExpandableListView.AnimatedExpandableListAdapter并实现接口方法
      4. 动画设置方式
          ```
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
          ```