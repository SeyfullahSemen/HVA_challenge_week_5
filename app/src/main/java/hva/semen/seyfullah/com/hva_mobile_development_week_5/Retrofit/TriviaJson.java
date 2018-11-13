package hva.semen.seyfullah.com.hva_mobile_development_week_5.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
 * Created by Seyfullah Semen on 12-11-2018.
 */
public class TriviaJson {

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("number")
    @Expose
    private Integer number;

    /**
     * No args constructor for use in serialization
     */
    public TriviaJson() {
    }

    /**
     * @param text
     * @param number
     */
    public TriviaJson(String text, Integer number) {
        super();
        this.text = text;
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
