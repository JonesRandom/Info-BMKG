// Generated code from Butter Knife. Do not modify!
package masxdeveloper.infobmkg;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.MyToolbar = Utils.findRequiredViewAsType(source, R.id.Toolbar, "field 'MyToolbar'", Toolbar.class);
    target.drawerLayout = Utils.findRequiredViewAsType(source, R.id.drawerItem, "field 'drawerLayout'", DrawerLayout.class);
    target.navigationView = Utils.findRequiredViewAsType(source, R.id.navItem, "field 'navigationView'", NavigationView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.MyToolbar = null;
    target.drawerLayout = null;
    target.navigationView = null;
  }
}
