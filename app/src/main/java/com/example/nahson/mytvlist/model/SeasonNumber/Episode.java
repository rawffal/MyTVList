
package com.example.nahson.mytvlist.model.SeasonNumber;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Episode implements Parcelable {

    @SerializedName("air_date")
    @Expose
    private String airDate;
    @SerializedName("crew")
    @Expose
    private List<Crew> crew = new ArrayList<Crew>();
    @SerializedName("episode_number")
    @Expose
    private int episodeNumber;
    @SerializedName("guest_stars")
    @Expose
    private List<GuestStar> guestStars = new ArrayList<GuestStar>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("production_code")
    @Expose
    private Object productionCode;
    @SerializedName("season_number")
    @Expose
    private int seasonNumber;
    @SerializedName("still_path")
    @Expose
    private String stillPath;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private int voteCount;

    protected Episode(Parcel in) {
        airDate = in.readString();
        episodeNumber = in.readInt();
        name = in.readString();
        overview = in.readString();
        stillPath = in.readString();
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
     * @return The crew
     */
    public List<Crew> getCrew() {
        return crew;
    }

    /**
     * @param crew The crew
     */
    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

    /**
     * @return The episodeNumber
     */
    public int getEpisodeNumber() {
        return episodeNumber;
    }

    /**
     * @param episodeNumber The episode_number
     */
    public void setEpisodeNumber(int episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    /**
     * @return The guestStars
     */
    public List<GuestStar> getGuestStars() {
        return guestStars;
    }

    /**
     * @param guestStars The guest_stars
     */
    public void setGuestStars(List<GuestStar> guestStars) {
        this.guestStars = guestStars;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @param overview The overview
     */
    public void setOverview(String overview) {
        this.overview = overview;
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
     * @return The productionCode
     */
    public Object getProductionCode() {
        return productionCode;
    }

    /**
     * @param productionCode The production_code
     */
    public void setProductionCode(Object productionCode) {
        this.productionCode = productionCode;
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

    /**
     * @return The stillPath
     */
    public String getStillPath() {
        Log.d("stillpath", stillPath);
        return "http://image.tmdb.org/t/p/w500" + stillPath;
    }

    /**
     * @param stillPath The still_path
     */
    public void setStillPath(String stillPath) {
        this.stillPath = stillPath;
    }

    /**
     * @return The voteAverage
     */
    public Double getVoteAverage() {
        return voteAverage;
    }

    /**
     * @param voteAverage The vote_average
     */
    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    /**
     * @return The voteCount
     */
    public int getVoteCount() {
        return voteCount;
    }

    /**
     * @param voteCount The vote_count
     */
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(airDate);
        dest.writeInt(episodeNumber);
        dest.writeString(name);
        dest.writeString(overview);
        dest.writeString(stillPath);

    }

    public static final Creator<Episode> CREATOR = new Creator<Episode>() {
        @Override
        public Episode createFromParcel(Parcel source) {
            return new Episode(source);
        }

        @Override
        public Episode[] newArray(int size) {
            return new Episode[size];
        }
    };
}
