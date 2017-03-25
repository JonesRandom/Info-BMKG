package masxdeveloper.infobmkg.RequestInfo;

import java.util.List;

import masxdeveloper.infobmkg.MyInterfaces.APIService;
import masxdeveloper.infobmkg.MyInterfaces.RequestInfo;
import masxdeveloper.infobmkg.MyInterfaces.ResponseInfo;
import masxdeveloper.infobmkg.ResponeInfoProvinsi.DataItems;
import masxdeveloper.infobmkg.ResponeInfoProvinsi.InfoProvinsiRespone;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Masx Developer on 3/22/17.
 * https://masx-dev.blogspot.com
 */

public class RequestInfoProvinsi implements RequestInfo.InfoProvinsi {

    private ResponseInfo.InfoProvinsi infoProvinsi;

    public RequestInfoProvinsi(ResponseInfo.InfoProvinsi infoProvinsi) {
        this.infoProvinsi = infoProvinsi;
    }

    @Override
    public void getInfoProvinsi(String View, String Key) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ibacor.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        final Call<InfoProvinsiRespone> responeCall = service.getInfoProvinsi(View, Key);
        responeCall.enqueue(new Callback<InfoProvinsiRespone>() {
            @Override
            public void onResponse(Call<InfoProvinsiRespone> call, Response<InfoProvinsiRespone> response) {

                if (response.isSuccessful()){

                    String Status = response.body().getStatus();

                    if (Status.equals("error")){
                        infoProvinsi.Gagal("Server Offline");
                    } else {
                        List<DataItems> data = response.body().getData();
                        infoProvinsi.Berhasil(data);
                    }

                } else {
                    infoProvinsi.Gagal("Terjadi Kelasahan Saat Memuat Data");
                }

            }

            @Override
            public void onFailure(Call<InfoProvinsiRespone> call, Throwable t) {
                infoProvinsi.Gagal("Terjadi Kesalahan Saat Menghubungi Server");
            }
        });

    }
}
