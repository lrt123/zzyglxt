package com.zyyglxt.service.impl;

import com.zyyglxt.dao.DataDOMapper;
import com.zyyglxt.dataobject.DataDO;
import com.zyyglxt.dataobject.DataDOKey;
import com.zyyglxt.dto.DataDto;
import com.zyyglxt.error.BusinessException;
import com.zyyglxt.error.EmBusinessError;
import com.zyyglxt.service.IDataAnnouncementService;
import com.zyyglxt.service.IDataNewsService;
import com.zyyglxt.util.DateUtils;
import com.zyyglxt.util.UUIDUtils;
import com.zyyglxt.util.UsernameUtil;
import com.zyyglxt.validator.ValidatorImpl;
import com.zyyglxt.validator.ValidatorResult;
import org.apache.commons.lang3.ObjectUtils;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangtao
 * @Date 2020/10/29 10:18
 * @Version 1.0
 */

@Service
@SuppressWarnings("unchecked")
public class DataAnnouncementServiceImpl implements IDataAnnouncementService {
    @Resource
    DataDOMapper dataDOMapper;

    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private UsernameUtil usernameUtil;

    @Resource
    private CacheManager cacheManager;

    @Override
    public DataDO selectAnnouncement(DataDOKey key) {
        return dataDOMapper.selectByPrimaryKey(key,"通知公告");
    }

    @Override
    public List<DataDto> selectAnnouncementList(String dataStatus) {
        return dataDOMapper.selectByAllData("通知公告", dataStatus);
    }



    @Override
    public int insertAnnouncement(DataDO record) {
        ValidatorResult result = validator.validate(record);
        if(result.isHasErrors()){
            throw new BusinessException(result.getErrMsg(), EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        record.setItemcreateat(DateUtils.getDate());
        record.setCreater(usernameUtil.getOperateUser());
        record.setUpdater(usernameUtil.getOperateUser());
        record.setDataType("通知公告");
        if(record.getItemcode() == null){
            record.setItemcode(UUIDUtils.getUUID());
        }
        return dataDOMapper.insertSelective(record);
    }

    @Override
    public int deleteAnnouncement(DataDOKey key) {
        return dataDOMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateAnnouncement(DataDO record) {
        ValidatorResult result = validator.validate(record);
        if(result.isHasErrors()){
            throw new BusinessException(result.getErrMsg(), EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        record.setUpdater(usernameUtil.getOperateUser());
        record.setItemupdateat(DateUtils.getDate());
        return dataDOMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public int changeStatus(DataDOKey key, String dataDelayedRelease, String dataStatus) {
        return dataDOMapper.changeStatusByPrimaryKey(key, dataDelayedRelease, dataStatus);
    }

    @Override
    public List<String> selectForMainPage() {
        //获得缓存
        Cache<String, Object> mainPageTzgg = cacheManager.getCache("mainPageData", String.class, Object.class);
        Object tzggData = mainPageTzgg.get("TzggData");
        //缓存判空
        if(ObjectUtils.allNotNull(tzggData)){
            //如果不是空，则直接将缓存数据给前台
            return (List<String>) tzggData;
        }else {
            //如果是空，则查询数据库，将数据重新放入本地缓存中
            List<String> tzgg = dataDOMapper.selectAllForMainPage("通知公告");
            mainPageTzgg.put("TzggData",tzgg);
            return tzgg;
        }
    }

}
