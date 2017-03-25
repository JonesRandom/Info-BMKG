package masxdeveloper.infobmkg.ResponeInfoProvinsi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoProvinsiRespone {

	@SerializedName("view")
	@Expose
	private String view;

	@SerializedName("data")
	@Expose
	private List<DataItems> data;

	@SerializedName("status")
	@Expose
	private String status;

	public void setView(String view){
		this.view = view;
	}

	public String getView(){
		return view;
	}

	public void setData(List<DataItems> data){
		this.data = data;
	}

	public List<DataItems> getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

}