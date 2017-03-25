package masxdeveloper.infobmkg.MyInterfaces;

import java.util.List;

import masxdeveloper.infobmkg.MyFragment.InfoPrakiraanCuaca;
import masxdeveloper.infobmkg.ResponeInfoCuaca.PrakiraanItem;
import masxdeveloper.infobmkg.ResponeInfoGempa.DataItem;
import masxdeveloper.infobmkg.ResponeInfoProvinsi.DataItems;

/**
 * Created by Masx Developer on 3/22/17.
 * https://masx-dev.blogspot.com
 */

public class ResponseInfo {

    public interface InfoGempa {
        void BerhasilTerhubung(List<DataItem> data);

        void GagalTerhubung(String Error);
    }

    public interface InfoCuaca {
        void BerhasilTerhubung(List<PrakiraanItem> data);

        void GagalTerhubung(String Error);
    }

    public interface InfoProvinsi {
        void Berhasil(List<DataItems> data);

        void Gagal(String Error);
    }


}
