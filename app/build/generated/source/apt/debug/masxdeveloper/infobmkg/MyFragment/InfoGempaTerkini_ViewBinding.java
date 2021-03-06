// Generated code from Butter Knife. Do not modify!
package masxdeveloper.infobmkg.MyFragment;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import masxdeveloper.infobmkg.R;

public class InfoGempaTerkini_ViewBinding implements Unbinder {
  private InfoGempaTerkini target;

  @UiThread
  public InfoGempaTerkini_ViewBinding(InfoGempaTerkini target, View source) {
    this.target = target;

    target.listInfoGempa = Utils.findRequiredViewAsType(source, R.id.listInfoGempa, "field 'listInfoGempa'", RecyclerView.class);
    target.Loading = Utils.findRequiredViewAsType(source, R.id.loading, "field 'Loading'", ProgressBar.class);
    target.textPencarianError = Utils.findRequiredViewAsType(source, R.id.textErrorPencarian, "field 'textPencarianError'", TextView.class);

    Context context = source.getContext();
    Resources res = context.getResources();
    target.Key = res.getString(R.string.query_key);
    target.Views = res.getString(R.string.query_info_terkini);
  }

  @Override
  @CallSuper
  public void unbind() {
    InfoGempaTerkini target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listInfoGempa = null;
    target.Loading = null;
    target.textPencarianError = null;
  }
}
