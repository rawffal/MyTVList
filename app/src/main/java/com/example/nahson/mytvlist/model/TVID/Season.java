
package com.example.nahson.mytvlist.model.TVID;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Season implements Parcelable {

    @SerializedName("air_date")
    @Expose
    private String airDate;
    @SerializedName("episode_count")
    @Expose
    private int episodeCount;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("season_number")
    @Expose
    private int seasonNumber;

    protected Season(Parcel in) {
        airDate = in.readString();
        episodeCount = in.readInt();
        id = in.readInt();
        posterPath = in.readString();
        seasonNumber = in.readInt();
    }

    /**
     * @return The airDate
     */
    public String getAirDate() {
        return airDate;
    }

    /**
     * @param airDate The air_date
     */
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    /**
     * @return The episodeCount
     */
    public int getEpisodeCount() {
        return episodeCount;
    }

    /**
     * @param episodeCount The episode_count
     */
    public void setEpisodeCount(int episodeCount) {
        this.episodeCount = episodeCount;
    }

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The posterPath
     */
    public String getPosterPath() {
        return "http://image.tmdb.org/t/p/w500" + posterPath;
    }

    /**
     * @param posterPath The poster_path
     */
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    /**
     * @return The seasonNumber
     */
    public int getSeasonNumber() {
        return seasonNumber;
    }

    /**
     * @param seasonNumber The season_number
     */
    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(airDate);
        dest.writeInt(episodeCount);
        dest.writeInt(id);
        dest.writeString(posterPath);
        dest.writeInt(seasonNumber);
    }

    public static final Creator<Season> CREATOR = new Creator<Season>() {
        @Override
        public Season createFromParcel(Parcel source) {
            return new Season(source);
        }

        @Override
        public Season[] newArray(int size) {
            return new Season[size];
        }
    };
}
