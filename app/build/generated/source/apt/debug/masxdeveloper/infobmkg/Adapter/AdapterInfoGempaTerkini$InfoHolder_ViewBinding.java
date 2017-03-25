// Generated code from Butter Knife. Do not modify!
package masxdeveloper.infobmkg.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import masxdeveloper.infobmkg.R;

public class AdapterInfoGempaTerkini$InfoHolder_ViewBinding implements Unbinder {
  private AdapterInfoGempaTerkini.InfoHolder target;

  @UiThread
  public AdapterInfoGempaTerkini$InfoHolder_ViewBinding(AdapterInfoGempaTerkini.InfoHolder target,
      View source) {
    this.target = target;

    target.tvWilayah = Utils.findRequiredViewAsType(source, R.id.rowWilayah, "field 'tvWilayah'", TextView.class);
    target.tvKedalaman = Utils.findRequiredViewAsType(source, R.id.rowKedalaman, "field 'tvKedalaman'", TextView.class);
    target.tvWaktu = Utils.findRequiredViewAsType(source, R.id.rowWaktu, "field 'tvWaktu'", TextView.class);
    target.tvMagnitudo = Utils.findRequiredViewAsType(source, R.id.rowMagnitudo, "field 'tvMagnitudo'", TextView.class);
    target.tvLS = Utils.findRequiredViewAsType(source, R.id.rowLS, "field 'tvLS'", TextView.class);
    target.tvBT = Utils.findRequiredViewAsType(source, R.id.rowBT, "field 'tvBT'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterInfoGempaTerkini.InfoHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvWilayah = null;
    target.tvKedalaman = null;
    target.tvWaktu = null;
    target.tvMagnitudo = null;
    target.tvLS = null;
    target.tvBT = null;
  }
}
