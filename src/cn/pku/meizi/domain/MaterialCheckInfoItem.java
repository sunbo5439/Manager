package cn.pku.meizi.domain;


import cn.pku.meizi.enumer.VideoCheckStatus;
import org.hibernate.annotations.Parent;

import javax.persistence.Embeddable;
import java.util.Date;

/**
 * Created by sunbo on 16/7/14.
 */
@Embeddable
public class MaterialCheckInfoItem {

    private Integer managerId;
    private Date checkDate;
    private VideoCheckStatus checkResult;
    private String remark;
    @Parent
    private Material parent;

    public MaterialCheckInfoItem(){}

    public MaterialCheckInfoItem(Integer managerId, Date checkDate, VideoCheckStatus checkResult, String remark) {
        this.managerId = managerId;
        this.checkDate = checkDate;
        this.checkResult = checkResult;
        this.remark = remark;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public VideoCheckStatus getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(VideoCheckStatus checkResult) {
        this.checkResult = checkResult;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Material getParent() {
        return parent;
    }

    public void setParent(Material parent) {
        this.parent = parent;
    }
}
