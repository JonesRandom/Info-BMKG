package masxdeveloper.infobmkg.ResponeInfoCuaca;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sekarang{

	@SerializedName("cuaca")
	@Expose
	private Cuaca cuaca;

	@SerializedName("suhu")
	@Expose
	private Suhu suhu;

	@SerializedName("tanggal")
	@Expose
	private String tanggal;

	@SerializedName("kelembaban")
	@Expose
	private Kelembaban kelembaban;

	public void setCuaca(Cuaca cuaca){
		this.cuaca = cuaca;
	}

	public Cuaca getCuaca(){
		return cuaca;
	}

	public void setSuhu(Suhu suhu){
		this.suhu = suhu;
	}

	public Suhu getSuhu(){
		return suhu;
	}

	public void setTanggal(String tanggal){
		this.tanggal = tanggal;
	}

	public String getTanggal(){
		return tanggal;
	}

	public void setKelembaban(Kelembaban kelembaban){
		this.kelembaban = kelembaban;
	}

	public Kelembaban getKelembaban(){
		return kelembaban;
	}

	@Override
 	public String toString(){
		return 
			"Sekarang{" + 
			"cuaca = '" + cuaca + '\'' + 
			",suhu = '" + suhu + '\'' + 
			",tanggal = '" + tanggal + '\'' + 
			",kelembaban = '" + kelembaban + '\'' + 
			"}";
		}
}