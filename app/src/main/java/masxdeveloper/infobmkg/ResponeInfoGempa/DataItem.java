package masxdeveloper.infobmkg.ResponeInfoGempa;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("magnitudo")
	@Expose
	private String magnitudo;

	@SerializedName("img")
	@Expose
	private String img;

	@SerializedName("dirasakan")
	@Expose
	private List<String> dirasakan;

	@SerializedName("lintang_bujur")
	@Expose
	private String lintangBujur;

	@SerializedName("waktu")
	@Expose
	private String waktu;

	@SerializedName("kedalaman")
	@Expose
	private String kedalaman;

	@SerializedName("wilayah")
	@Expose
	private String wilayah;

	public void setMagnitudo(String magnitudo){
		this.magnitudo = magnitudo;
	}

	public String getMagnitudo(){
		return magnitudo;
	}

	public void setImg(String img){
		this.img = img;
	}

	public String getImg(){
		return img;
	}

	public void setDirasakan(List<String> dirasakan){
		this.dirasakan = dirasakan;
	}

	public List<String> getDirasakan(){
		return dirasakan;
	}

	public void setLintangBujur(String lintangBujur){
		this.lintangBujur = lintangBujur;
	}

	public String getLintangBujur(){
		return lintangBujur;
	}

	public void setWaktu(String waktu){
		this.waktu = waktu;
	}

	public String getWaktu(){
		return waktu;
	}

	public void setKedalaman(String kedalaman){
		this.kedalaman = kedalaman;
	}

	public String getKedalaman(){
		return kedalaman;
	}

	public void setWilayah(String wilayah){
		this.wilayah = wilayah;
	}

	public String getWilayah(){
		return wilayah;
	}

}