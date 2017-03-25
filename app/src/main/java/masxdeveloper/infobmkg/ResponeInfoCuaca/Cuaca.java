package masxdeveloper.infobmkg.ResponeInfoCuaca;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cuaca{

	@SerializedName("siang")
	@Expose
	private String siang;

	@SerializedName("dinihari")
	@Expose
	private String dinihari;

	@SerializedName("pagi")
	@Expose
	private String pagi;

	@SerializedName("malam")
	@Expose
	private String malam;

	public void setSiang(String siang){
		this.siang = siang;
	}

	public String getSiang(){
		return siang;
	}

	public void setDinihari(String dinihari){
		this.dinihari = dinihari;
	}

	public String getDinihari(){
		return dinihari;
	}

	public void setPagi(String pagi){
		this.pagi = pagi;
	}

	public String getPagi(){
		return pagi;
	}

	public void setMalam(String malam){
		this.malam = malam;
	}

	public String getMalam(){
		return malam;
	}

	@Override
 	public String toString(){
		return 
			"Cuaca{" + 
			"siang = '" + siang + '\'' + 
			",dinihari = '" + dinihari + '\'' + 
			",pagi = '" + pagi + '\'' + 
			",malam = '" + malam + '\'' + 
			"}";
		}
}