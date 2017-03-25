package masxdeveloper.infobmkg.ResponeInfoCuaca;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Suhu{

	@SerializedName("min")
	@Expose
	private String min;

	@SerializedName("max")
	@Expose
	private String max;

	public void setMin(String min){
		this.min = min;
	}

	public String getMin(){
		return min;
	}

	public void setMax(String max){
		this.max = max;
	}

	public String getMax(){
		return max;
	}

	@Override
 	public String toString(){
		return 
			"Suhu{" + 
			"min = '" + min + '\'' + 
			",max = '" + max + '\'' + 
			"}";
		}
}