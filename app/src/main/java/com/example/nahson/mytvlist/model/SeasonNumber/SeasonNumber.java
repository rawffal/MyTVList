
package com.example.nahson.mytvlist.model.SeasonNumber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class SeasonNumber {

    @SerializedName("air_date")
    @Expose
    private String airDate;
    @SerializedName("episodes")
    @Expose
    private List<Episode> episodes = new ArrayList<Episode>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("season_number")
    @Expose
    private int seasonNumber;

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
     * @return The episodes
     */
    public List<Episode> getEpisodes() {
        return episodes;
    }

    /**
     * @param episodes The episodes
     */
    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
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

}
