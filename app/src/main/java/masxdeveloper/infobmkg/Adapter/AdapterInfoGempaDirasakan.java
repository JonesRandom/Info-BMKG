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
 * Created by Masx Developer on 3/21/17.
 * https://masx-dev.blogspot.com
 */

public class AdapterInfoGempaDirasakan extends RecyclerView.Adapter<AdapterInfoGempaDirasakan.InfoHolder> {

    private List<DataItem> data;
    private InfoGempaItemClickListener Listener;

    public AdapterInfoGempaDirasakan(List<DataItem> data) {
        this.data = data;
    }

    public AdapterInfoGempaDirasakan(List<DataItem> data, InfoGempaItemClickListener listeners) {
        this.data = data;
        Listener = listeners;
    }

    @Override
    public InfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_info_gempa_dirasakan, parent, false);
        return new InfoHolder(v);
    }

    @Override
    public void onBindViewHolder(InfoHolder holder, int position) {
        DataItem item = data.get(position);

        String Wilayah = item.getWilayah().toUpperCase();
        String Waktu = item.getWaktu();
        String Kedalaman = "Kedalaman : " + item.getKedalaman();
        String LintangBujur = item.getLintangBujur();

        String Magnitudo = item.getMagnitudo();
        Magnitudo = Magnitudo.replace(" SR", "");

        holder.tvWilayah.setText(Wilayah);
        holder.tvWaktu.setText(Waktu);
        holder.tvKedalaman.setText(Kedalaman);
        holder.tvMagnitudo.setText(Magnitudo);
        holder.tvLintangBujur.setText(LintangBujur);

        StringBuilder Builder = new StringBuilder();

        for (String Jangkauan : item.getDirasakan()) {
            Builder.append(Jangkauan).append("\n");
        }

        String Daerahjangkauan = "Jangkauan : \n\n" + Builder.toString();
        holder.tvJangkauan.setText(Daerahjangkauan);

        holder.setInfoPreviewDialog(Listener, item.getImg());

        if (position == data.size() - 1) {
            holder.viewLine.setVisibility(View.GONE);
        } else {
            holder.viewLine.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class InfoHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rowWilayah)
        TextView tvWilayah;
        @BindView(R.id.rowWaktu)
        TextView tvWaktu;
        @BindView(R.id.rowKedalaman)
        TextView tvKedalaman;
        @BindView(R.id.rowMagnitudo)
        TextView tvMagnitudo;
        @BindView(R.id.rowTerasa)
        TextView tvJangkauan;
        @BindView(R.id.rowLintangBujur)
        TextView tvLintangBujur;

        @BindView(R.id.viewLine)
        View viewLine;

        InfoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setInfoPreviewDialog(final InfoGempaItemClickListener listener, final String URL) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.setPreviewImage(URL);
                }
            });
        }
    }

    public void filterList(List<DataItem> filter) {
        data = new ArrayList<>();
        data.addAll(filter);
        notifyDataSetChanged();
    }
}
