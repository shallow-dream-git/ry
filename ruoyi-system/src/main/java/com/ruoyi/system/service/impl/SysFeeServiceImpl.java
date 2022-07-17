package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysFeeMapper;
import com.ruoyi.system.domain.SysFee;
import com.ruoyi.system.service.ISysFeeService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-16
 */
@Service
public class SysFeeServiceImpl implements ISysFeeService 
{
    @Autowired
    private SysFeeMapper sysFeeMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param roomId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public SysFee selectSysFeeByRoomId(Long roomId)
    {
        return sysFeeMapper.selectSysFeeByRoomId(roomId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sysFee 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<SysFee> selectSysFeeList(SysFee sysFee)
    {
        return sysFeeMapper.selectSysFeeList(sysFee);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param sysFee 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysFee(SysFee sysFee)
    {
        return sysFeeMapper.insertSysFee(sysFee);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param sysFee 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysFee(SysFee sysFee)
    {
        return sysFeeMapper.updateSysFee(sysFee);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param roomIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysFeeByRoomIds(Long[] roomIds)
    {
        return sysFeeMapper.deleteSysFeeByRoomIds(roomIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param roomId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSysFeeByRoomId(Long roomId)
    {
        return sysFeeMapper.deleteSysFeeByRoomId(roomId);
    }
}
