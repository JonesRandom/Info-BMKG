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

public class AdapterInfoGempaDirasakan$InfoHolder_ViewBinding implements Unbinder {
  private AdapterInfoGempaDirasakan.InfoHolder target;

  @UiThread
  public AdapterInfoGempaDirasakan$InfoHolder_ViewBinding(AdapterInfoGempaDirasakan.InfoHolder target,
      View source) {
    this.target = target;

    target.tvWilayah = Utils.findRequiredViewAsType(source, R.id.rowWilayah, "field 'tvWilayah'", TextView.class);
    target.tvWaktu = Utils.findRequiredViewAsType(source, R.id.rowWaktu, "field 'tvWaktu'", TextView.class);
    target.tvKedalaman = Utils.findRequiredViewAsType(source, R.id.rowKedalaman, "field 'tvKedalaman'", TextView.class);
    target.tvMagnitudo = Utils.findRequiredViewAsType(source, R.id.rowMagnitudo, "field 'tvMagnitudo'", TextView.class);
    target.tvJangkauan = Utils.findRequiredViewAsType(source, R.id.rowTerasa, "field 'tvJangkauan'", TextView.class);
    target.tvLintangBujur = Utils.findRequiredViewAsType(source, R.id.rowLintangBujur, "field 'tvLintangBujur'", TextView.class);
    target.viewLine = Utils.findRequiredView(source, R.id.viewLine, "field 'viewLine'");
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterInfoGempaDirasakan.InfoHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvWilayah = null;
    target.tvWaktu = null;
    target.tvKedalaman = null;
    target.tvMagnitudo = null;
    target.tvJangkauan = null;
    target.tvLintangBujur = null;
    target.viewLine = null;
  }
}
