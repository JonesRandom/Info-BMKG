package masxdeveloper.infobmkg.ResponeInfoCuaca;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrakiraanItem{

	@SerializedName("kota")
	@Expose
	private String kota;

	@SerializedName("besok")
	@Expose
	private Besok besok;

	@SerializedName("sekarang")
	@Expose
	private Sekarang sekarang;

	public void setKota(String kota){
		this.kota = kota;
	}

	public String getKota(){
		return kota;
	}

	public void setBesok(Besok besok){
		this.besok = besok;
	}

	public Besok getBesok(){
		return besok;
	}

	public void setSekarang(Sekarang sekarang){
		this.sekarang = sekarang;
	}

	public Sekarang getSekarang(){
		return sekarang;
	}

	@Override
 	public String toString(){
		return 
			"PrakiraanItem{" + 
			"kota = '" + kota + '\'' + 
			",besok = '" + besok + '\'' + 
			",sekarang = '" + sekarang + '\'' + 
			"}";
		}
}