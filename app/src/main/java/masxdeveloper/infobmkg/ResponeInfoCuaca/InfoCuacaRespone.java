package masxdeveloper.infobmkg.ResponeInfoCuaca;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoCuacaRespone{

	@SerializedName("provinsi")
	@Expose
	private String provinsi;

	@SerializedName("view")
	@Expose
	private String view;

	@SerializedName("status")
	@Expose
	private String status;

	@SerializedName("prakiraan")
	@Expose
	private List<PrakiraanItem> prakiraan;

	public void setProvinsi(String provinsi){
		this.provinsi = provinsi;
	}

	public String getProvinsi(){
		return provinsi;
	}

	public void setView(String view){
		this.view = view;
	}

	public String getView(){
		return view;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setPrakiraan(List<PrakiraanItem> prakiraan){
		this.prakiraan = prakiraan;
	}

	public List<PrakiraanItem> getPrakiraan(){
		return prakiraan;
	}

	@Override
 	public String toString(){
		return 
			"InfoCuacaRespone{" + 
			"provinsi = '" + provinsi + '\'' + 
			",view = '" + view + '\'' + 
			",status = '" + status + '\'' + 
			",prakiraan = '" + prakiraan + '\'' + 
			"}";
		}
}