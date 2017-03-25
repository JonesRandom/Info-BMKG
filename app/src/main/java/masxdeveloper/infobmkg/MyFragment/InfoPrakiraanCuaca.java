package masxdeveloper.infobmkg.MyFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import masxdeveloper.infobmkg.Adapter.AdapterInfoCuaca;
import masxdeveloper.infobmkg.Adapter.AdapterInfoProvinsiSpinner;
import masxdeveloper.infobmkg.MainActivity;
import masxdeveloper.infobmkg.MyInterfaces.FilterPencarianListener;
import masxdeveloper.infobmkg.MyInterfaces.ResponseInfo;
import masxdeveloper.infobmkg.R;
import masxdeveloper.infobmkg.RequestInfo.RequestInfoCuaca;
import masxdeveloper.infobmkg.RequestInfo.RequestInfoProvinsi;
import masxdeveloper.infobmkg.ResponeInfoCuaca.PrakiraanItem;
import masxdeveloper.infobmkg.ResponeInfoProvinsi.DataItems;

public class InfoPrakiraanCuaca extends Fragment implements ResponseInfo.InfoProvinsi, ResponseInfo.InfoCuaca {

    @BindString(R.string.query_info_provinsi)
    String Views;
    @BindString(R.string.query_info_cuaca)
    String ViewsCuaca;
    @BindString(R.string.query_key)
    String Key;

    @BindView(R.id.loading)
    ProgressBar Loading;
    @BindView(R.id.LoadingData)
    ProgressBar LoadingData;
    @BindView(R.id.spinnerProvinsi)
    Spinner spinnerProvinsi;

    @BindView(R.id.searchHeader)
    LinearLayout searchHeader;
    @BindView(R.id.searchError)
    LinearLayout searchError;
    @BindView(R.id.tvError)
    TextView tvError;
    @BindView(R.id.textErrorPencarian)
    TextView textPencarianError;


    @BindView(R.id.listInfoCuaca)
    RecyclerView listInfoCuaca;

    @BindView(R.id.cardviewPencarian)
    CardView cardViewPencarian;

    @BindView(R.id.rootParent)
    View parent;

    RequestInfoProvinsi infoProvinsi;
    RequestInfoCuaca infoCuaca;
    AdapterInfoProvinsiSpinner adapterInfoProvinsiSpinner;
    AdapterInfoCuaca adapterInfoCuaca;
    List<DataItems> spinnerData;
    List<PrakiraanItem> dataCuaca = new ArrayList<>();

    boolean Status;

    public InfoPrakiraanCuaca() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        infoProvinsi = new RequestInfoProvinsi(this);
        infoCuaca = new RequestInfoCuaca(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(container.getContext()).inflate(R.layout.f_prakiraan_cuaca, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapterInfoCuaca = new AdapterInfoCuaca(dataCuaca);

        listInfoCuaca.setHasFixedSize(true);
        listInfoCuaca.setLayoutManager(new LinearLayoutManager(getActivity()));
        listInfoCuaca.setAdapter(adapterInfoCuaca);

        infoProvinsi.getInfoProvinsi(Views, Key);

        ((MainActivity) getActivity()).DataPencarian(new FilterPencarianListener() {
            @Override
            public void OnPencarianQuery(String Data) {

                if (Status) {
                    Data = Data.toLowerCase();
                    List<PrakiraanItem> prakiraanItemList = new ArrayList<>();

                    for (PrakiraanItem item : dataCuaca) {

                        String Wilayah = item.getKota().toLowerCase();
                        if (Wilayah.contains(Data)) {
                            prakiraanItemList.add(item);
                        }
                    }

                    if (prakiraanItemList.size() < 1) {
                        textPencarianError.setVisibility(View.VISIBLE);
                        textPencarianError.setText("Tidak Ada Info Cuaca Untuk Daerah \n\"" + Data + "\"");
                    } else {
                        textPencarianError.setVisibility(View.GONE);
                    }

                    adapterInfoCuaca.filterList(prakiraanItemList);
                }
            }

            @Override
            public void OnPencarianFokusListener(boolean StatusFokus) {
                if (StatusFokus) {
                    textPencarianError.setVisibility(View.GONE);
                    cardViewPencarian.setVisibility(View.GONE);
                } else {
                    cardViewPencarian.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    @Override
    public void Berhasil(List<DataItems> data) {
        spinnerData = data;
        adapterInfoProvinsiSpinner = new AdapterInfoProvinsiSpinner(getActivity(), R.layout.row_info_provinsi_spinner, data);
        spinnerProvinsi.setAdapter(adapterInfoProvinsiSpinner);
        Loading.setVisibility(View.GONE);
        searchHeader.setVisibility(View.VISIBLE);
    }

    @Override
    public void Gagal(String Error) {
        tvError.setText(Error);
        Loading.setVisibility(View.GONE);
        searchError.setVisibility(View.VISIBLE);
    }

    @Override
    public void BerhasilTerhubung(List<PrakiraanItem> data) {
        dataCuaca = data;
        adapterInfoCuaca = new AdapterInfoCuaca(dataCuaca);
        listInfoCuaca.setAdapter(adapterInfoCuaca);
        LoadingData.setVisibility(View.GONE);

        Status = true;
    }

    @Override
    public void GagalTerhubung(String Error) {
        Snackbar.make(parent, Error, Snackbar.LENGTH_SHORT).show();
        LoadingData.setVisibility(View.GONE);

        Status = false;
    }

    @OnClick({R.id.btnCari, R.id.btnResfresh})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCari:
                int Position = spinnerProvinsi.getSelectedItemPosition();
                String Id = spinnerData.get(Position).getId();
                infoCuaca.getInfoCuaca(ViewsCuaca, Id, Key);
                LoadingData.setVisibility(View.VISIBLE);
                break;
            case R.id.btnResfresh:
                infoProvinsi.getInfoProvinsi(Views, Key);
                Loading.setVisibility(View.VISIBLE);
                searchError.setVisibility(View.GONE);
                break;
        }
    }

}
