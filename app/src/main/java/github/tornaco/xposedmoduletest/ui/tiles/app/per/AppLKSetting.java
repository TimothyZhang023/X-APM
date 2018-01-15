package github.tornaco.xposedmoduletest.ui.tiles.app.per;

import android.content.Context;
import android.support.annotation.NonNull;

import github.tornaco.xposedmoduletest.R;
import github.tornaco.xposedmoduletest.xposed.app.XAshmanManager;
import github.tornaco.xposedmoduletest.xposed.bean.AppSettings;

/**
 * Created by guohao4 on 2018/1/15.
 * Email: Tornaco@163.com
 */

public class AppLKSetting extends AppSettingsSwitchTile {

    public AppLKSetting(@NonNull Context context, AppSettings appSettings) {
        super(context, appSettings);
        this.titleRes = R.string.title_app_lock_kill;
        this.iconRes = R.drawable.ic_screen_lock_portrait_black_24dp;
    }

    @Override
    boolean getSwitchState() {
        return getAppSettings().isLk();
    }

    @Override
    void applySwitchState(boolean checked) {
        super.applySwitchState(checked);
        XAshmanManager.get()
                .addOrRemoveLKApps(new String[]{getAppSettings().getPkgName()},
                        checked ? XAshmanManager.Op.ADD : XAshmanManager.Op.REMOVE);
    }
}
