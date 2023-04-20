package com.thachnn.samplegallery.utils.permission;



import android.Manifest;
import android.content.pm.PackageManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.ExplainReasonCallback;
import com.permissionx.guolindev.callback.ForwardToSettingsCallback;
import com.permissionx.guolindev.callback.RequestCallback;
import com.permissionx.guolindev.request.ExplainScope;
import com.permissionx.guolindev.request.ForwardScope;
import com.thachnn.samplegallery.R;
import com.thachnn.samplegallery.ui.media.MediaFragment;

import java.util.List;
import java.util.Objects;


public class PermissionUtils {

    public static void requestPermission(Fragment context, AppRequestCallback callback, String permission) {
        PermissionX.init(context)
                .permissions(permission)
                .onExplainRequestReason((scope, deniedList) -> scope.showRequestReasonDialog(deniedList, context.getString(R.string.require_permission_approved), context.getString(R.string.btn_ok), context.getString(R.string.btn_cancel)))
                .onForwardToSettings((scope, deniedList) -> scope.showForwardToSettingsDialog(deniedList, context.getString(R.string.require_setting), context.getString(R.string.btn_ok), context.getString(R.string.btn_cancel)))
                .request(callback::onResult);
    }

    public static boolean checkPermission(Fragment context, String permission) {
        try {
            return (ContextCompat.checkSelfPermission(context.requireContext(),
                    permission)
                    == PackageManager.PERMISSION_GRANTED);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public interface AppRequestCallback {
        void onResult(boolean allGranted, @NonNull List<String> grantedList, @NonNull List<String> deniedList);
    }
}
