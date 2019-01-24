package creapption.com.whatmovie.data.remote.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Class that contain detail response object for movies service.
 * */
public class MovieDetailResponseModel implements Serializable {
    @Expose
    @SerializedName("vote_count")
    private Long voteCount;
    @Expose
    @SerializedName("id")
    private Long id;
    @Expose
    @SerializedName("video")
    private Boolean video;
    @Expose
    @SerializedName("vote_average")
    private Double voteAverage;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("popularity")
    private Double popularity;
    @Expose
    @SerializedName("poster_path")
    private String posterPath;
    @Expose
    @SerializedName("original_language")
    private String originalLanguage;
    @Expose
    @SerializedName("original_title")
    private String original_title;
    @Expose
    @SerializedName("genre_ids")
    private List<Integer> genreIds;
    @Expose
    @SerializedName("backdrop_path")
    private String backdropPath;
    @Expose
    @SerializedName("adult")
    private Boolean adult;
    @Expose
    @SerializedName("overview")
    private String overview;
    @Expose
    @SerializedName("release_date")
    private String releaseDate;

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
