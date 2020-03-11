# 一款去掉默认上下留白的TextView控件
## 效果如下图
![image](https://github.com/wangpingtaohn/ExcludePaddingTextView/blob/master/img-storage/demo.png)

## 使用步骤
1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}  
  ```
 2.Add the dependency
 ```
 dependencies {
	        implementation 'com.github.wangpingtaohn:ExcludePaddingTextView:1.0.0'
	}
  ```
  ## 实例
  ```
  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <com.wpt.exclude.ExcludePaddingTextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@color/colorPrimary"
        android:textSize="36dp"
        app:exText="留白TextView(自定义)" /> //也可在代码里setExText("xxx");

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp"
        android:includeFontPadding="false"
        android:textSize="36dp"
        android:background="@color/colorPrimary"
        android:text="留白TextView(默认)" />

</LinearLayout>
  ```
