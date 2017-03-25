package masxdeveloper.infobmkg.ResponeInfoGempa;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoGempaRespone{

	@SerializedName("view")
	@Expose
	private String view;

	@SerializedName("data")
	@Expose
	private List<DataItem> data;

	@SerializedName("status")
	@Expose
	private String status;

	public void setView(String view){
		this.view = view;
	}

	public String getView(){
		return view;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

}