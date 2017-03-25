package masxdeveloper.infobmkg.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import butterknife.BindView;
import butterknife.ButterKnife;
import masxdeveloper.infobmkg.R;
import masxdeveloper.infobmkg.ResponeInfoCuaca.Besok;
import masxdeveloper.infobmkg.ResponeInfoCuaca.Cuaca;
import masxdeveloper.infobmkg.ResponeInfoCuaca.PrakiraanItem;

/**
 * Created by Masx Developer on 3/22/17.
 * https://masx-dev.blogspot.com
 */

public class AdapterInfoCuaca extends RecyclerView.Adapter<AdapterInfoCuaca.CuacaHolder>{

    private List<PrakiraanItem> data;

    public AdapterInfoCuaca(List<PrakiraanItem> data) {
        this.data = data;
    }

    @Override
    public CuacaHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_info_cuaca , parent , false);
        return new CuacaHolder(v);
    }

    @Override
    public void onBindViewHolder(CuacaHolder holder, int position) {

        PrakiraanItem item = data.get(position);
        Besok besok = item.getBesok();

        Cuaca cuacaSkarang = item.getSekarang().getCuaca();
        Cuaca cuacaBesok = item.getBesok().getCuaca();

        String Daerah  = item.getKota();
        String Tanggal = item.getSekarang().getTanggal();
        String Kelembaban = item.getSekarang().getKelembaban().getMin() + " - " + item.getSekarang().getKelembaban().getMax();
        String Suhu = item.getSekarang().getSuhu().getMin() + " - " + item.getSekarang().getSuhu().getMax();
        String SuhuMax = item.getSekarang().getSuhu().getMax();

        String kelembabanBesok = besok.getSuhu().getMin() + " - " + besok.getSuhu().getMax();
        String SuhuBesok = besok.getSuhu().getMin() + " - " + besok.getSuhu().getMax();

        holder.tvWilayah.setText(Daerah);
        holder.tvTanggal.setText(Tanggal);
        holder.tvKelembaban.setText(Kelembaban);
        holder.tvSuhu.setText(Suhu);
        holder.tvSuhuMax.setText(SuhuMax);

        holder.tvSuhuBesok.setText(SuhuBesok);
        holder.tvKelembabanBesok.setText(kelembabanBesok);

        holder.ivSiangNow.setImageResource(holder.getDrawableNow(cuacaSkarang.getSiang()));
        holder.ivMalamNow.setImageResource(holder.getDrawableNow(cuacaSkarang.getMalam()));
        holder.ivDinihariNow.setImageResource(holder.getDrawableNow(cuacaSkarang.getDinihari()));

        holder.ivPagi.setImageResource(holder.getDrawable(cuacaBesok.getPagi()));
        holder.ivSiang.setImageResource(holder.getDrawable(cuacaBesok.getSiang()));
        holder.ivMalam.setImageResource(holder.getDrawable(cuacaBesok.getMalam()));
        holder.ivDinihari.setImageResource(holder.getDrawable(cuacaBesok.getDinihari()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class CuacaHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.rowDaerah)
        TextView tvWilayah;
        @BindView(R.id.rowKelembaban)
        TextView tvKelembaban;
        @BindView(R.id.rowSuhu)
        TextView tvSuhu;
        @BindView(R.id.rowSuhuMax)
        TextView tvSuhuMax;
        @BindView(R.id.rowTanggal)
        TextView tvTanggal;

        @BindView(R.id.rowKelembabanBesok)
        TextView tvKelembabanBesok;
        @BindView(R.id.rowSuhuBesok)
        TextView tvSuhuBesok;

        @BindView(R.id.rowSiangNow)
        ImageView ivSiangNow;
        @BindView(R.id.rowMalamNow)
        ImageView ivMalamNow;
        @BindView(R.id.rowDiniHariNow)
        ImageView ivDinihariNow;

        @BindView(R.id.rowPagi)
        ImageView ivPagi;
        @BindView(R.id.rowSiang)
        ImageView ivSiang;
        @BindView(R.id.rowMalam)
        ImageView ivMalam;
        @BindView(R.id.rowDinihari)
        ImageView ivDinihari;

        public CuacaHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this , itemView);
        }

        public int getDrawableNow(String Cuaca){
            try {
                switch (Cuaca){
                    case "Udara Kabur":
                        return R.drawable.row_kabur;
                    case "Kabut":
                        return R.drawable.row_kabut;
                    case "Cerah":
                        return R.drawable.row_cerah;
                    case "Cerah Berawan":
                        return R.drawable.row_cerah_berawan;
                    case "Berawan Tebal":
                        return R.drawable.row_berawan_tebal;
                    case "Berawan":
                        return R.drawable.row_berawan;
                    case "Hujan Lokal":
                        return R.drawable.row_hujan_local;
                    case "Hujan Ringan":
                        return R.drawable.row_hujan_ringan;
                    case "Hujan Sedang":
                        return R.drawable.row_hujan_sedang;
                    case "Hujan Petir":
                        return R.drawable.row_hujan_petir;
                    default:
                        return R.drawable.ic_more;
                }
            } catch (Exception e){
                return R.drawable.ic_more;
            }

        }

        public int getDrawable(String Cuaca){
            try {
                switch (Cuaca){
                    case "Udara Kabur":
                        return R.drawable.row_kabur_black;
                    case "Kabut":
                        return R.drawable.row_kabut_black;
                    case "Cerah":
                        return R.drawable.row_cerah_black;
                    case "Cerah Berawan":
                        return R.drawable.row_cerah_berawan_black;
                    case "Berawan Tebal":
                        return R.drawable.row_berawan_tebal_black;
                    case "Berawan":
                        return R.drawable.row_berawan_black;
                    case "Hujan Lokal":
                        return R.drawable.row_hujan_local_black;
                    case "Hujan Ringan":
                        return R.drawable.row_hujan_ringan_black;
                    case "Hujan Sedang":
                        return R.drawable.row_hujan_sedang_black;
                    case "Hujan Petir":
                        return R.drawable.row_hujan_petir_black;
                    default:
                        return R.drawable.ic_more_black;
                }
            } catch (Exception e){
                return R.drawable.ic_more_black;
            }

        }

    }

    public void filterList(List<PrakiraanItem> filter){
        data = new ArrayList<>();
        data.addAll(filter);
        notifyDataSetChanged();
    }
}
