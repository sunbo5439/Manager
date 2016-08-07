package cn.pku.meizi.service;

import cn.pku.meizi.domain.Manager;
import cn.pku.meizi.domain.Material;
import cn.pku.meizi.domain.PageModel;
import cn.pku.meizi.enumer.VideoCheckStatus;

import java.util.List;

/**
 * Created by sunbo on 16/7/7.
 */
public interface MaterialService {
    List<Material> getUnChecked();
    void setStatus(Integer id, VideoCheckStatus videoCheckStatus, Manager manager,String remark);
    String getURLByID(Integer id);
    Material getByID(Integer id);
    List<Material> getLegalMedia();
    List<Material> getIllegalMedia();
    List<Material> getMediaByStatus(VideoCheckStatus videoCheckStatus);
    PageModel getPageModel(Integer currentPage, Integer rows,Integer status);
}
