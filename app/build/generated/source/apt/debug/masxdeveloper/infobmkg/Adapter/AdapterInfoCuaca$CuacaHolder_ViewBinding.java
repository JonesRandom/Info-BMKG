// Generated code from Butter Knife. Do not modify!
package masxdeveloper.infobmkg.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;
import masxdeveloper.infobmkg.R;

public class AdapterInfoCuaca$CuacaHolder_ViewBinding implements Unbinder {
  private AdapterInfoCuaca.CuacaHolder target;

  @UiThread
  public AdapterInfoCuaca$CuacaHolder_ViewBinding(AdapterInfoCuaca.CuacaHolder target,
      View source) {
    this.target = target;

    target.tvWilayah = Utils.findRequiredViewAsType(source, R.id.rowDaerah, "field 'tvWilayah'", TextView.class);
    target.tvKelembaban = Utils.findRequiredViewAsType(source, R.id.rowKelembaban, "field 'tvKelembaban'", TextView.class);
    target.tvSuhu = Utils.findRequiredViewAsType(source, R.id.rowSuhu, "field 'tvSuhu'", TextView.class);
    target.tvSuhuMax = Utils.findRequiredViewAsType(source, R.id.rowSuhuMax, "field 'tvSuhuMax'", TextView.class);
    target.tvTanggal = Utils.findRequiredViewAsType(source, R.id.rowTanggal, "field 'tvTanggal'", TextView.class);
    target.tvKelembabanBesok = Utils.findRequiredViewAsType(source, R.id.rowKelembabanBesok, "field 'tvKelembabanBesok'", TextView.class);
    target.tvSuhuBesok = Utils.findRequiredViewAsType(source, R.id.rowSuhuBesok, "field 'tvSuhuBesok'", TextView.class);
    target.ivSiangNow = Utils.findRequiredViewAsType(source, R.id.rowSiangNow, "field 'ivSiangNow'", ImageView.class);
    target.ivMalamNow = Utils.findRequiredViewAsType(source, R.id.rowMalamNow, "field 'ivMalamNow'", ImageView.class);
    target.ivDinihariNow = Utils.findRequiredViewAsType(source, R.id.rowDiniHariNow, "field 'ivDinihariNow'", ImageView.class);
    target.ivPagi = Utils.findRequiredViewAsType(source, R.id.rowPagi, "field 'ivPagi'", ImageView.class);
    target.ivSiang = Utils.findRequiredViewAsType(source, R.id.rowSiang, "field 'ivSiang'", ImageView.class);
    target.ivMalam = Utils.findRequiredViewAsType(source, R.id.rowMalam, "field 'ivMalam'", ImageView.class);
    target.ivDinihari = Utils.findRequiredViewAsType(source, R.id.rowDinihari, "field 'ivDinihari'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterInfoCuaca.CuacaHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvWilayah = null;
    target.tvKelembaban = null;
    target.tvSuhu = null;
    target.tvSuhuMax = null;
    target.tvTanggal = null;
    target.tvKelembabanBesok = null;
    target.tvSuhuBesok = null;
    target.ivSiangNow = null;
    target.ivMalamNow = null;
    target.ivDinihariNow = null;
    target.ivPagi = null;
    target.ivSiang = null;
    target.ivMalam = null;
    target.ivDinihari = null;
  }
}
