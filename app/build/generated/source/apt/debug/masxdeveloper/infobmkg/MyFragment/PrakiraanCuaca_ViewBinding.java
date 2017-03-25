// Generated code from Butter Knife. Do not modify!
package masxdeveloper.infobmkg.MyFragment;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import masxdeveloper.infobmkg.R;

public class PrakiraanCuaca_ViewBinding implements Unbinder {
  private InfoPrakiraanCuaca target;

  private View view2131558543;

  private View view2131558546;

  @UiThread
  public PrakiraanCuaca_ViewBinding(final InfoPrakiraanCuaca target, View source) {
    this.target = target;

    View view;
    target.Loading = Utils.findRequiredViewAsType(source, R.id.loading, "field 'Loading'", ProgressBar.class);
    target.spinnerProvinsi = Utils.findRequiredViewAsType(source, R.id.spinnerProvinsi, "field 'spinnerProvinsi'", Spinner.class);
    target.searchHeader = Utils.findRequiredViewAsType(source, R.id.searchHeader, "field 'searchHeader'", LinearLayout.class);
    target.searchError = Utils.findRequiredViewAsType(source, R.id.searchError, "field 'searchError'", LinearLayout.class);
    target.tvError = Utils.findRequiredViewAsType(source, R.id.tvError, "field 'tvError'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnCari, "method 'onClick'");
    view2131558543 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnResfresh, "method 'onClick'");
    view2131558546 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });

    Context context = source.getContext();
    Resources res = context.getResources();
    target.Views = res.getString(R.string.query_info_provinsi);
    target.Key = res.getString(R.string.query_key);
  }

  @Override
  @CallSuper
  public void unbind() {
    InfoPrakiraanCuaca target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.Loading = null;
    target.spinnerProvinsi = null;
    target.searchHeader = null;
    target.searchError = null;
    target.tvError = null;

    view2131558543.setOnClickListener(null);
    view2131558543 = null;
    view2131558546.setOnClickListener(null);
    view2131558546 = null;
  }
}
