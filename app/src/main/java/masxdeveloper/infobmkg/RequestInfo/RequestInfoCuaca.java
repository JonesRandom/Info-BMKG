package masxdeveloper.infobmkg.RequestInfo;

import java.util.List;

import masxdeveloper.infobmkg.MyInterfaces.APIService;
import masxdeveloper.infobmkg.MyInterfaces.RequestInfo;
import masxdeveloper.infobmkg.MyInterfaces.ResponseInfo;
import masxdeveloper.infobmkg.ResponeInfoCuaca.InfoCuacaRespone;
import masxdeveloper.infobmkg.ResponeInfoCuaca.PrakiraanItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Masx Developer on 3/22/17.
 * https://masx-dev.blogspot.com
 */

public class RequestInfoCuaca implements RequestInfo.InfoCuaca {

    private ResponseInfo.InfoCuaca infoCuaca;

    public RequestInfoCuaca(ResponseInfo.InfoCuaca infoCuaca) {
        this.infoCuaca = infoCuaca;
    }

    @Override
    public void getInfoCuaca(String View, String IDKota, String Key) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ibacor.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<InfoCuacaRespone> itemCall = service.getInfoCuaca(View , IDKota , Key);
        itemCall.enqueue(new Callback<InfoCuacaRespone>() {
            @Override
            public void onResponse(Call<InfoCuacaRespone> call, Response<InfoCuacaRespone> response) {

                if (response.isSuccessful()){

                    String Status = response.body().getStatus();

                    if (Status.equals("error")){
                        infoCuaca.GagalTerhubung("Server Offline");
                    } else {
                        List<PrakiraanItem> data = response.body().getPrakiraan();
                        infoCuaca.BerhasilTerhubung(data);
                    }

                } else {
                    infoCuaca.GagalTerhubung("Terjadi Kesalahan Saat Memuat Data");
                }
            }

            @Override
            public void onFailure(Call<InfoCuacaRespone> call, Throwable t) {
                infoCuaca.GagalTerhubung("Terjadi Kesalahan Saat Mengambil Informasi Data");
            }
        });
    }
}
