package masxdeveloper.infobmkg.MyFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import masxdeveloper.infobmkg.Adapter.AdapterInfoGempaTerkini;
import masxdeveloper.infobmkg.Common.DialogInfo;
import masxdeveloper.infobmkg.MainActivity;
import masxdeveloper.infobmkg.MyInterfaces.FilterPencarianListener;
import masxdeveloper.infobmkg.MyInterfaces.InfoGempaItemClickListener;
import masxdeveloper.infobmkg.MyInterfaces.ResponseInfo;
import masxdeveloper.infobmkg.R;
import masxdeveloper.infobmkg.RequestInfo.RequestInfoGempa;
import masxdeveloper.infobmkg.ResponeInfoGempa.DataItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoGempaTerkini extends Fragment implements ResponseInfo.InfoGempa {

    @BindView(R.id.listInfoGempa)
    RecyclerView listInfoGempa;
    @BindView(R.id.loading)
    ProgressBar Loading;
    @BindView(R.id.textErrorPencarian)
    TextView textPencarianError;

    @BindString(R.string.query_key)
    String Key;
    @BindString(R.string.query_info_terkini)
    String Views;

    RequestInfoGempa infoGempa;
    List<DataItem> dataGempa = new ArrayList<>();
    AdapterInfoGempaTerkini adapterInfoGempaTerkini;

    boolean Status = false;

    public InfoGempaTerkini() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        infoGempa = new RequestInfoGempa(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_info_gempa_terkini, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapterInfoGempaTerkini = new AdapterInfoGempaTerkini(dataGempa);

        listInfoGempa.setHasFixedSize(true);
        listInfoGempa.setLayoutManager(new LinearLayoutManager(getActivity()));
        listInfoGempa.setAdapter(adapterInfoGempaTerkini);

        ((MainActivity) getActivity()).DataPencarian(new FilterPencarianListener() {
            @Override
            public void OnPencarianQuery(String Data) {

                if (Status){

                    Data = Data.toLowerCase();
                    List<DataItem> filter = new ArrayList<>();

                    for (DataItem item: dataGempa){
                        String Wilayah = item.getWilayah().toLowerCase();

                        if (Wilayah.contains(Data)){
                            filter.add(item);
                        }
                    }

                    if (filter.size() < 1){
                        textPencarianError.setVisibility(View.VISIBLE);
                        textPencarianError.setText("Tidak Dapat Menampilkan Infomasi Gempa Pada Wilayah\n\"" + Data + "\"");
                    } else {
                        textPencarianError.setVisibility(View.GONE);
                    }

                    adapterInfoGempaTerkini.filterList(filter);

                }
            }

            @Override
            public void OnPencarianFokusListener(boolean Status) {
                textPencarianError.setVisibility(View.GONE);
            }
        });

        infoGempa.getInfoGempa(Views, Key);
    }

    @Override
    public void BerhasilTerhubung(List<DataItem> data) {
        dataGempa = data;
        adapterInfoGempaTerkini = new AdapterInfoGempaTerkini(dataGempa, new InfoGempaItemClickListener() {
            @Override
            public void setPreviewImage(String URL) {
                DialogInfo.DialogPreview(getActivity() , URL).show();
            }
        });
        listInfoGempa.setAdapter(adapterInfoGempaTerkini);
        Loading.setVisibility(View.INVISIBLE);

        Status = true;
    }

    @Override
    public void GagalTerhubung(String Error) {
        Loading.setVisibility(View.INVISIBLE);
        Toast.makeText(getActivity(), Error, Toast.LENGTH_SHORT).show();

        Status = false;
    }

}
