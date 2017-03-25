package masxdeveloper.infobmkg.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import masxdeveloper.infobmkg.MyInterfaces.InfoGempaItemClickListener;
import masxdeveloper.infobmkg.R;
import masxdeveloper.infobmkg.ResponeInfoGempa.DataItem;

/**
 * Created by Masx Developer on 3/22/17.
 * https://masx-dev.blogspot.com
 */

public class AdapterInfoGempaTerkini extends RecyclerView.Adapter<AdapterInfoGempaTerkini.InfoHolder> {

    private List<DataItem> Data;
    private InfoGempaItemClickListener Listener;

    public AdapterInfoGempaTerkini(List<DataItem> data) {
        Data = data;
    }

    public AdapterInfoGempaTerkini(List<DataItem> data , InfoGempaItemClickListener click) {
        Data = data;
        Listener = click;
    }

    @Override
    public InfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_info_gempa_terkini ,parent ,false);
        return new InfoHolder(v);
    }

    @Override
    public void onBindViewHolder(InfoHolder holder, int position) {
        DataItem item = Data.get(position);

        String Wilayah = item.getWilayah().toUpperCase();
        String Kedalaman = item.getKedalaman();
        String Waktu = item.getWaktu();
        String Magnitudo = item.getMagnitudo();
        String LintangBujur = item.getLintangBujur();
        String[] LSBT = LintangBujur.split(" - ");
        Magnitudo = Magnitudo.replace(" SR","");

        holder.tvWilayah.setText(Wilayah);
        holder.tvKedalaman.setText("Kedalaman : " + Kedalaman);
        holder.tvWaktu.setText(Waktu);
        holder.tvMagnitudo.setText(Magnitudo);
        holder.tvLS.setText(LSBT[0] + " LS");
        holder.tvBT.setText(LSBT[1] + " BT");

        holder.setinfoPreviewDialog(Listener ,item.getImg());
    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class InfoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rowWilayah)
        TextView tvWilayah;
        @BindView(R.id.rowKedalaman)
        TextView tvKedalaman;
        @BindView(R.id.rowWaktu)
        TextView tvWaktu;
        @BindView(R.id.rowMagnitudo)
        TextView tvMagnitudo;
        @BindView(R.id.rowLS)
        TextView tvLS;
        @BindView(R.id.rowBT)
        TextView tvBT;

        InfoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setinfoPreviewDialog(final InfoGempaItemClickListener listener, final String URL){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.setPreviewImage(URL);
                }
            });
        }
    }

    public void filterList(List<DataItem> filter) {
        Data = new ArrayList<>();
        Data.addAll(filter);
        notifyDataSetChanged();
    }
}
