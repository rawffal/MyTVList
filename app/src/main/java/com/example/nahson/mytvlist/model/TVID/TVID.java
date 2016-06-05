
package com.example.nahson.mytvlist.model.TVID;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TVID implements Parcelable{

    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("created_by")
    @Expose
    private List<CreatedBy> createdBy = new ArrayList<CreatedBy>();
    @SerializedName("episode_run_time")
    @Expose
    private List<Integer> episodeRunTime = new ArrayList<Integer>();
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres = new ArrayList<Genre>();
    @SerializedName("homepage")
    @Expose
    private String homepage;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("in_production")
    @Expose
    private boolean inProduction;
    @SerializedName("languages")
    @Expose
    private List<String> languages = new ArrayList<String>();
    @SerializedName("last_air_date")
    @Expose
    private String lastAirDate;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("networks")
    @Expose
    private List<Network> networks = new ArrayList<Network>();
    @SerializedName("number_of_episodes")
    @Expose
    private int numberOfEpisodes;
    @SerializedName("number_of_seasons")
    @Expose
    private int numberOfSeasons;
    @SerializedName("origin_country")
    @Expose
    private List<String> originCountry = new ArrayList<String>();
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("popularity")
    @Expose
    private double popularity;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("production_companies")
    @Expose
    private List<ProductionCompany> productionCompanies = new ArrayList<ProductionCompany>();
    @SerializedName("seasons")
    @Expose
    private List<Season> seasons = new ArrayList<Season>();
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("vote_average")
    @Expose
    private double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private int voteCount;

    /**
     * @return The backdropPath
     */
    public String getBackdropPath() {
        return "http://image.tmdb.org/t/p/w500" + backdropPath;
    }

    /**
     * @param backdropPath The backdrop_path
     */
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    /**
     * @return The createdBy
     */
    public List<CreatedBy> getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy The created_by
     */
    public void setCreatedBy(List<CreatedBy> createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return The episodeRunTime
     */
    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    /**
     * @param episodeRunTime The episode_run_time
     */
    public void setEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    /**
     * @return The firstAirDate
     */
    public String getFirstAirDate() {
        return firstAirDate;
    }

    /**
     * @param firstAirDate The first_air_date
     */
    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    /**
     * @return The genres
     */
    public List<Genre> getGenres() {
        return genres;
    }

    /**
     * @param genres The genres
     */
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    /**
     * @return The homepage
     */
    public String getHomepage() {
        return homepage;
    }

    /**
     * @param homepage The homepage
     */
    public void setHomepage(String homepage) {
        this.homepage = homepage;
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
     * @return The inProduction
     */
    public boolean isInProduction() {
        return inProduction;
    }

    /**
     * @param inProduction The in_production
     */
    public void setInProduction(boolean inProduction) {
        this.inProduction = inProduction;
    }

    /**
     * @return The languages
     */
    public List<String> getLanguages() {
        return languages;
    }

    /**
     * @param languages The languages
     */
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    /**
     * @return The lastAirDate
     */
    public String getLastAirDate() {
        return lastAirDate;
    }

    /**
     * @param lastAirDate The last_air_date
     */
    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
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
     * @return The networks
     */
    public List<Network> getNetworks() {
        return networks;
    }

    /**
     * @param networks The networks
     */
    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    /**
     * @return The numberOfEpisodes
     */
    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    /**
     * @param numberOfEpisodes The number_of_episodes
     */
    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    /**
     * @return The numberOfSeasons
     */
    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    /**
     * @param numberOfSeasons The number_of_seasons
     */
    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    /**
     * @return The originCountry
     */
    public List<String> getOriginCountry() {
        return originCountry;
    }

    /**
     * @param originCountry The origin_country
     */
    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    /**
     * @return The originalLanguage
     */
    public String getOriginalLanguage() {
        return originalLanguage;
    }

    /**
     * @param originalLanguage The original_language
     */
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /**
     * @return The originalName
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * @param originalName The original_name
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
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
     * @return The popularity
     */
    public double getPopularity() {
        return popularity;
    }

    /**
     * @param popularity The popularity
     */
    public void setPopularity(double popularity) {
        this.popularity = popularity;
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
     * @return The productionCompanies
     */
    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    /**
     * @param productionCompanies The production_companies
     */
    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    /**
     * @return The seasons
     */
    public List<Season> getSeasons() {
        return seasons;
    }

    /**
     * @param seasons The seasons
     */
    public void setSeasons(List<Season> seasons) {
        this.seasons = seasons;
    }

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The voteAverage
     */
    public double getVoteAverage() {
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

    public TVID(Parcel in) {
        backdropPath = in.readString();
        firstAirDate = in.readString();
        id = in.readInt();
        name = in.readString();
        originalName = in.readString();
        overview = in.readString();
        posterPath = in.readString();
        seasons = new ArrayList<Season>();
        in.readList(seasons, Season.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(backdropPath);
        dest.writeString(firstAirDate);
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(originalName);
        dest.writeString(overview);
        dest.writeString(posterPath);
        dest.writeList(seasons);
    }
    public static final Creator<TVID> CREATOR = new Creator<TVID>() {
        @Override
        public TVID createFromParcel(Parcel source) {
            return new TVID(source);
        }

        @Override
        public TVID[] newArray(int size) {
            return new TVID[size];
        }
    };
}
