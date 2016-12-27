package com.szhr.anothermvp.core.data.remote;

import com.szhr.anothermvp.core.data.model.Movie;
import com.szhr.anothermvp.core.data.model.MovieDetail;
import com.szhr.anothermvp.core.data.model.RawResponse;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface VmovierApi {

  @FormUrlEncoded
  @POST("/apiv3/post/getPostByTab")
  Observable<RawResponse<List<Movie>>> getMoviesByTab(
      @Field("p") int pageIndex,
      @Field("size") int size,
      @Field("tab") String tab
  );

  @FormUrlEncoded
  @POST("/apiv3/post/view")
  Observable<RawResponse<MovieDetail>> getMovieDetail(
      @Field("postid") String postId
  );

}
