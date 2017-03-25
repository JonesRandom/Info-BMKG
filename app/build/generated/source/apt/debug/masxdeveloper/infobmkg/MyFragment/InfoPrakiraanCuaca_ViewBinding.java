// Generated code from Butter Knife. Do not modify!
package masxdeveloper.infobmkg.MyFragment;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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

public class InfoPrakiraanCuaca_ViewBinding implements Unbinder {
  private InfoPrakiraanCuaca target;

  private View view2131558548;

  private View view2131558551;

  @UiThread
  public InfoPrakiraanCuaca_ViewBinding(final InfoPrakiraanCuaca target, View source) {
    this.target = target;

    View view;
    target.Loading = Utils.findRequiredViewAsType(source, R.id.loading, "field 'Loading'", ProgressBar.class);
    target.LoadingData = Utils.findRequiredViewAsType(source, R.id.LoadingData, "field 'LoadingData'", ProgressBar.class);
    target.spinnerProvinsi = Utils.findRequiredViewAsType(source, R.id.spinnerProvinsi, "field 'spinnerProvinsi'", Spinner.class);
    target.searchHeader = Utils.findRequiredViewAsType(source, R.id.searchHeader, "field 'searchHeader'", LinearLayout.class);
    target.searchError = Utils.findRequiredViewAsType(source, R.id.searchError, "field 'searchError'", LinearLayout.class);
    target.tvError = Utils.findRequiredViewAsType(source, R.id.tvError, "field 'tvError'", TextView.class);
    target.textPencarianError = Utils.findRequiredViewAsType(source, R.id.textErrorPencarian, "field 'textPencarianError'", TextView.class);
    target.listInfoCuaca = Utils.findRequiredViewAsType(source, R.id.listInfoCuaca, "field 'listInfoCuaca'", RecyclerView.class);
    target.cardViewPencarian = Utils.findRequiredViewAsType(source, R.id.cardviewPencarian, "field 'cardViewPencarian'", CardView.class);
    target.parent = Utils.findRequiredView(source, R.id.rootParent, "field 'parent'");
    view = Utils.findRequiredView(source, R.id.btnCari, "method 'onClick'");
    view2131558548 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btnResfresh, "method 'onClick'");
    view2131558551 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });

    Context context = source.getContext();
    Resources res = context.getResources();
    target.Views = res.getString(R.string.query_info_provinsi);
    target.ViewsCuaca = res.getString(R.string.query_info_cuaca);
    target.Key = res.getString(R.string.query_key);
  }

  @Override
  @CallSuper
  public void unbind() {
    InfoPrakiraanCuaca target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.Loading = null;
    target.LoadingData = null;
    target.spinnerProvinsi = null;
    target.searchHeader = null;
    target.searchError = null;
    target.tvError = null;
    target.textPencarianError = null;
    target.listInfoCuaca = null;
    target.cardViewPencarian = null;
    target.parent = null;

    view2131558548.setOnClickListener(null);
    view2131558548 = null;
    view2131558551.setOnClickListener(null);
    view2131558551 = null;
  }
}
