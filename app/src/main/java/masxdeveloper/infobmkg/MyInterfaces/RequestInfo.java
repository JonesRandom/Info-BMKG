package masxdeveloper.infobmkg.MyInterfaces;

/**
 * Created by Masx Developer on 3/22/17.
 * https://masx-dev.blogspot.com
 */

public class RequestInfo {

    public interface InfoGempa {
        void getInfoGempa(String View, String Key);
    }

    public interface InfoCuaca {
        void getInfoCuaca(String View, String IDKota, String Key);
    }

    public interface InfoProvinsi{
        void getInfoProvinsi(String View,String Key);
    }
}
