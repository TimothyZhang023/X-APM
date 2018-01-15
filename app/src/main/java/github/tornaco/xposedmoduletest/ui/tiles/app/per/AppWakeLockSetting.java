package github.tornaco.xposedmoduletest.ui.tiles.app.per;

import android.content.Context;
import android.support.annotation.NonNull;

import github.tornaco.xposedmoduletest.R;
import github.tornaco.xposedmoduletest.compat.os.AppOpsManagerCompat;
import github.tornaco.xposedmoduletest.xposed.app.XAshmanManager;
import github.tornaco.xposedmoduletest.xposed.bean.AppSettings;

/**
 * Created by guohao4 on 2018/1/15.
 * Email: Tornaco@163.com
 */

public class AppWakeLockSetting extends AppSettingsSwitchTile {

    public AppWakeLockSetting(@NonNull Context context, AppSettings appSettings) {
        super(context, appSettings);
        this.titleRes = R.string.app_ops_wakelock;
        this.iconRes = R.drawable.ic_memory_black_24dp;
    }

    @Override
    boolean getSwitchState() {
        int mode = XAshmanManager.get().getPermissionControlBlockModeForPkg(
                AppOpsManagerCompat.OP_WAKE_LOCK, getAppSettings().getPkgName()
        );
        return mode != AppOpsManagerCompat.MODE_IGNORED;
    }

    @Override
    void applySwitchState(boolean checked) {
        super.applySwitchState(checked);
        XAshmanManager.get().setPermissionControlBlockModeForPkg(AppOpsManagerCompat.OP_WAKE_LOCK,
                getAppSettings().getPkgName(),
                checked ? AppOpsManagerCompat.MODE_ALLOWED : AppOpsManagerCompat.MODE_IGNORED);
    }
}
