package masxdeveloper.infobmkg.ResponeInfoProvinsi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataItems {

	@SerializedName("nama")
	@Expose
	private String nama;

	@SerializedName("id")
	@Expose
	private String id;

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

}