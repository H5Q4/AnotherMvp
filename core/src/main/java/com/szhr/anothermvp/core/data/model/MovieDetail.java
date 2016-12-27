package com.szhr.anothermvp.core.data.model;

import java.util.List;

public class MovieDetail {

  private String postid;
  private String title;
  private String app_fu_title;
  private String intro;
  private String count_comment;
  private String is_album;
  private String is_collect;
  private Content content;
  private String image;
  private String rating;
  private String publish_time;
  private String count_like;
  private String count_share;

  private ShareLink share_link;
  private String tags;
  private List<String> cate;

  //region Getters and Setters
  public String getPostid() {
    return postid;
  }

  public void setPostid(String postid) {
    this.postid = postid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getApp_fu_title() {
    return app_fu_title;
  }

  public void setApp_fu_title(String app_fu_title) {
    this.app_fu_title = app_fu_title;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public String getCount_comment() {
    return count_comment;
  }

  public void setCount_comment(String count_comment) {
    this.count_comment = count_comment;
  }

  public String getIs_album() {
    return is_album;
  }

  public void setIs_album(String is_album) {
    this.is_album = is_album;
  }

  public String getIs_collect() {
    return is_collect;
  }

  public void setIs_collect(String is_collect) {
    this.is_collect = is_collect;
  }

  public Content getContent() {
    return content;
  }

  public void setContent(Content content) {
    this.content = content;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  public String getPublish_time() {
    return publish_time;
  }

  public void setPublish_time(String publish_time) {
    this.publish_time = publish_time;
  }

  public String getCount_like() {
    return count_like;
  }

  public void setCount_like(String count_like) {
    this.count_like = count_like;
  }

  public String getCount_share() {
    return count_share;
  }

  public void setCount_share(String count_share) {
    this.count_share = count_share;
  }

  public ShareLink getShare_link() {
    return share_link;
  }

  public void setShare_link(ShareLink share_link) {
    this.share_link = share_link;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public List<String> getCate() {
    return cate;
  }

  public void setCate(List<String> cate) {
    this.cate = cate;
  }
  //endregion

  public static class Content {

    private List<Video> video;

    public List<Video> getVideo() {
      return video;
    }

    public void setVideo(List<Video> video) {
      this.video = video;
    }

    public static class Video {
      private String image;
      private String title;
      private String duration;
      private String filesize;
      private String source_link;
      private String qiniu_url;

      //region Getters and Setters
      public String getImage() {
        return image;
      }

      public void setImage(String image) {
        this.image = image;
      }

      public String getTitle() {
        return title;
      }

      public void setTitle(String title) {
        this.title = title;
      }

      public String getDuration() {
        return duration;
      }

      public void setDuration(String duration) {
        this.duration = duration;
      }

      public String getFilesize() {
        return filesize;
      }

      public void setFilesize(String filesize) {
        this.filesize = filesize;
      }

      public String getSource_link() {
        return source_link;
      }

      public void setSource_link(String source_link) {
        this.source_link = source_link;
      }

      public String getQiniu_url() {
        return qiniu_url;
      }

      public void setQiniu_url(String qiniu_url) {
        this.qiniu_url = qiniu_url;
      }
      //endregion
    }
  }

  private static class ShareLink {
    private String sweibo;
    private String weixin;
    private String qzone;
    private String qq;

    //region Getters and Setters
    public String getSweibo() {
      return sweibo;
    }

    public void setSweibo(String sweibo) {
      this.sweibo = sweibo;
    }

    public String getWeixin() {
      return weixin;
    }

    public void setWeixin(String weixin) {
      this.weixin = weixin;
    }

    public String getQzone() {
      return qzone;
    }

    public void setQzone(String qzone) {
      this.qzone = qzone;
    }

    public String getQq() {
      return qq;
    }

    public void setQq(String qq) {
      this.qq = qq;
    }
    //endregion
  }
}
