package cn.pku.meizi.domain;

import cn.pku.meizi.enumer.VideoCheckStatus;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunbo on 16/7/7.
 */
@Entity
@Table(name = "material")
public class Material {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private Integer owner_id;
    private String title;
    private String video_tag;
    private Integer hours;
    private Integer minutes;
    private Integer seconds;
    private Integer frames;
    private Date bDate;
    private String copyright;
    private Integer periods;
    private String mType;
    private String brief_info;
    private Integer size;
    private String dimension;
    private String format;
    private String original_name;
    private String uuid;
    private String file_uri;
    private Date upload_time;
    @Enumerated(EnumType.ORDINAL)
    private VideoCheckStatus status;
    private int media_type;
    private String price;
    private String lowdef_video_upload_path;
    private String highdef_video_upload_path;
    private String thumbnail;
    private Integer duration;
    private Integer pricing_type;

    @ElementCollection(targetClass = MaterialCheckInfoItem.class,fetch = FetchType.EAGER)
    @CollectionTable(name = "material_checkinfo_item",joinColumns = @JoinColumn(name = "id",nullable = false))
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<MaterialCheckInfoItem> checkInfo=new ArrayList<>();

    public Material(){}

    public Material(Integer owner_id, String title, String video_tag, Integer hours, Integer minutes, Integer seconds, Integer frames, Date bDate,
                    String copyright, Integer periods, String mType, String brief_info, Integer size, String dimension, String format, String original_name,
                    String uuid, String file_uri, Date upload_time, int media_type, String price, String thumbnail, Integer duration,
                    String lowdef_video_upload_path, String highdef_video_upload_path, VideoCheckStatus status, List<MaterialCheckInfoItem> checkInfo,Integer pricing_type) {
        this.owner_id = owner_id;
        this.title = title;
        this.video_tag = video_tag;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.frames = frames;
        this.bDate = bDate;
        this.copyright = copyright;
        this.periods = periods;
        this.mType = mType;
        this.brief_info = brief_info;
        this.size = size;
        this.dimension = dimension;
        this.format = format;
        this.original_name = original_name;
        this.uuid = uuid;
        this.file_uri = file_uri;
        this.upload_time = upload_time;
        this.media_type = media_type;
        this.price = price;
        this.thumbnail = thumbnail;
        this.duration = duration;
        this.lowdef_video_upload_path = lowdef_video_upload_path;
        this.highdef_video_upload_path = highdef_video_upload_path;
        this.status = status;
        this.checkInfo = checkInfo;
        this.pricing_type=pricing_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo_tag() {
        return video_tag;
    }

    public void setVideo_tag(String video_tag) {
        this.video_tag = video_tag;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    public Integer getFrames() {
        return frames;
    }

    public void setFrames(Integer frames) {
        this.frames = frames;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getBrief_info() {
        return brief_info;
    }

    public void setBrief_info(String brief_info) {
        this.brief_info = brief_info;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFile_uri() {
        return file_uri;
    }

    public void setFile_uri(String file_uri) {
        this.file_uri = file_uri;
    }

    public Date getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public int getMedia_type() {
        return media_type;
    }

    public void setMedia_type(int media_type) {
        this.media_type = media_type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLowdef_video_upload_path() {
        return lowdef_video_upload_path;
    }

    public void setLowdef_video_upload_path(String lowdef_video_upload_path) {
        this.lowdef_video_upload_path = lowdef_video_upload_path;
    }

    public String getHighdef_video_upload_path() {
        return highdef_video_upload_path;
    }

    public void setHighdef_video_upload_path(String highdef_video_upload_path) {
        this.highdef_video_upload_path = highdef_video_upload_path;
    }

    public VideoCheckStatus getStatus() {
        return status;
    }

    public void setStatus(VideoCheckStatus status) {
        this.status = status;
    }

    public List<MaterialCheckInfoItem> getCheckInfo() {
        return checkInfo;
    }

    public void setCheckInfo(List<MaterialCheckInfoItem> checkInfo) {
        this.checkInfo = checkInfo;
    }

    public Integer getPricing_type() {
        return pricing_type;
    }

    public void setPricing_type(Integer pricing_type) {
        this.pricing_type = pricing_type;
    }
}
