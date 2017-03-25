package masxdeveloper.infobmkg.RequestInfo;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import masxdeveloper.infobmkg.MyInterfaces.APIService;
import masxdeveloper.infobmkg.MyInterfaces.RequestInfo;
import masxdeveloper.infobmkg.MyInterfaces.ResponseInfo;
import masxdeveloper.infobmkg.ResponeInfoGempa.DataItem;
import masxdeveloper.infobmkg.ResponeInfoGempa.InfoGempaRespone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Masx Developer on 3/21/17.
 * https://masx-dev.blogspot.com
 */

public class RequestInfoGempa implements RequestInfo.InfoGempa {

    private ResponseInfo.InfoGempa InfoGempa;

    public RequestInfoGempa(ResponseInfo.InfoGempa infoGempa) {
        InfoGempa = infoGempa;
    }

    @Override
    public void getInfoGempa(String View, String Key) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ibacor.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<InfoGempaRespone> dataItemCall = service.getInfoGempa(View, Key);
        dataItemCall.enqueue(new Callback<InfoGempaRespone>() {
            @Override
            public void onResponse(Call<InfoGempaRespone> call, Response<InfoGempaRespone> response) {
                if (response.isSuccessful()) {
                    String Status = response.body().getStatus();

                    if (Status.equals("error")) {
                        InfoGempa.GagalTerhubung("Server Offline");
                    } else {
                        final List<DataItem> data = response.body().getData();
                        InfoGempa.BerhasilTerhubung(data);
                    }
                } else {
                    InfoGempa.GagalTerhubung("Terjadi Kesalahan Saat Memuat Data");
                }

            }

            @Override
            public void onFailure(Call<InfoGempaRespone> call, Throwable t) {
                InfoGempa.GagalTerhubung("Terjadi Kesalahan Saat Menghubungi Server");
            }
        });
    }
}
