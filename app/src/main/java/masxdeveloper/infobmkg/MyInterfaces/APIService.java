package masxdeveloper.infobmkg.MyInterfaces;

import masxdeveloper.infobmkg.ResponeInfoCuaca.InfoCuacaRespone;
import masxdeveloper.infobmkg.ResponeInfoCuaca.PrakiraanItem;
import masxdeveloper.infobmkg.ResponeInfoGempa.InfoGempaRespone;
import masxdeveloper.infobmkg.ResponeInfoProvinsi.InfoProvinsiRespone;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Masx Developer on 3/21/17.
 * https://masx-dev.blogspot.com
 */

public interface APIService {

    @GET("api/bmkg/")
    Call<InfoGempaRespone> getInfoGempa(@Query("view") String View, @Query("k") String Key);

    @GET("api/bmkg/")
    Call<InfoProvinsiRespone> getInfoProvinsi(@Query("view") String View, @Query("k") String Key);

    @GET("api/bmkg/")
    Call<InfoCuacaRespone> getInfoCuaca(@Query("view") String View, @Query("id") String Id, @Query("k") String Key);
}
