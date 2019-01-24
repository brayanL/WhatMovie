package creapption.com.whatmovie.data.remote.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Class that contain main response object for movies service.
 * */
public class MovieResponseModel implements Serializable {
    @Expose
    @SerializedName("page")
    private Long page;
    @Expose
    @SerializedName("total_results")
    private Long totalResults;
    @Expose
    @SerializedName("total_pages")
    private Long totalPages;
    @Expose
    @SerializedName("results")
    private List<MovieDetailResponseModel> results;

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Long totalResults) {
        this.totalResults = totalResults;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public List<MovieDetailResponseModel> getResults() {
        return results;
    }

    public void setResults(List<MovieDetailResponseModel> results) {
        this.results = results;
    }
}
