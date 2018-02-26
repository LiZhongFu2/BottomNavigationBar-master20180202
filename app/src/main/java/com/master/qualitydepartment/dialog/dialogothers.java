package com.master.qualitydepartment.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.flyco.dialog.listener.OnOperItemClickL;
import com.flyco.dialog.widget.ActionSheetDialog;
import com.flyco.dialog.widget.NormalListDialog;
import com.master.qualitydepartment.R;

import me.curzbin.library.BottomDialog;
import me.curzbin.library.Item;
import me.curzbin.library.OnItemClickListener;

import static android.content.ContentValues.TAG;

/**
 * Created by hufan on 2018/2/12.
 * 四种dialog
 */

public class dialogothers extends Activity{
    private LinearLayout mElv;
    private String[] mStringItems = {"曲江店", "南稍门店", "大学城店", "软件园店", "钟楼店", "边家村店"};
    private TextView tvCustomDialog;//动态改变显示的位置城市
    private Button btnCustomDialogConfirm;
    private Button btnCustomDialogCancel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_test);

        Button btnDia1=findViewById(R.id.btn_dialog1);
        Button btnDia2=findViewById(R.id.btn_dialog2);
        Button btnDia3=findViewById(R.id.btn_dialog3);
        Button btnDia4=findViewById(R.id.btn_dialog4);
        mElv= findViewById(R.id.dia_root);

        btnDia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(dialogothers.this,
                  "一般dialog", Toast.LENGTH_SHORT).show();
                CustomDialog();
            }
        });
        btnDia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"第二个Dialog出现");
                BottomDialog();//分享发布
            }
        });
        btnDia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActionSheetDialogNoTitle();//拍照
            }
        });
        btnDia4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NormalListDialogStringArr();//万科博宇列表
            }
        });
    }
    //拍照
    private void ActionSheetDialogNoTitle() {
        final String[] stringItems = {"拍照", "从相机选择"};
        final ActionSheetDialog dialog = new ActionSheetDialog(dialogothers.this, stringItems, mElv);
        dialog.isTitleShow(false).show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
            }
        });
    }
    private void NormalListDialogStringArr() {
        final NormalListDialog dialog = new NormalListDialog(dialogothers.this, mStringItems);//上下文和字符串
        dialog.title("万科泊寓—分店列表")//
                .layoutAnimation(null)//无卡片效果
                .show(R.style.myDialogAnim);//设置进入退出效果
        dialog.setItemExtraPadding(10,10,10,10);
        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                dialog.dismiss();
            }
        });
    }
    private void BottomDialog(){

        new BottomDialog(dialogothers.this)
                //.title(R.string.share_title)//没有title
                .orientation(BottomDialog.HORIZONTAL)
                .inflateMenu(R.menu.menu_share, new OnItemClickListener() {
                    @Override
                    public void click(Item item) {
                        //Toast.makeText(DialogAcyivity.this, getString(R.string.share_title) + item.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
    private void CustomDialog(){
        final Dialog dialog=new Dialog(dialogothers.this);
        Window window=getWindow();
        //window.setBackgroundDrawableResource(R.drawable.shape_background_white);//设置圆角，未成功
        dialog.requestWindowFeature(window.FEATURE_NO_TITLE);//去掉Title
        dialog.setContentView(R.layout.custom_dialog);
        dialog.show();
        btnCustomDialogConfirm=dialog.findViewById(R.id.btn_custom_dialog_confirm);
        btnCustomDialogCancel=dialog.findViewById(R.id.btn_custom_dialog_cancel);
        btnCustomDialogConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(dialogothers.this,"你点击了确定按钮", Toast.LENGTH_SHORT).show();
            }
        });

        btnCustomDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(dialogothers.this,"你点击了取消按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
