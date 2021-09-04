package com.dawn.lib_base.dialog;

import android.content.Context;

import androidx.annotation.NonNull;
import com.dawn.lib_base.R;
import com.dawn.lib_base.databinding.DialogLoading1Binding;


/**
 * @author: yufang
 * @date: 2020/10/2 17:29
 * desc:
 */
public class LoadingDialog extends BaseDialog<DialogLoading1Binding> {


    public LoadingDialog(@NonNull Context context) {
        super(context,R.style.trans_Dialog);
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_loading1;
    }

    @Override
    public void initData() {

    }
}
