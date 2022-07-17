package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysRepairApply;
import com.ruoyi.system.service.ISysRepairApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-07-15
 */
@RestController
@RequestMapping("/system/apply")
public class SysRepairApplyController extends BaseController
{
    @Autowired
    private ISysRepairApplyService sysRepairApplyService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:apply:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRepairApply sysRepairApply)
    {
        startPage();
        List<SysRepairApply> list = sysRepairApplyService.selectSysRepairApplyList(sysRepairApply);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:apply:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRepairApply sysRepairApply)
    {
        List<SysRepairApply> list = sysRepairApplyService.selectSysRepairApplyList(sysRepairApply);
        ExcelUtil<SysRepairApply> util = new ExcelUtil<SysRepairApply>(SysRepairApply.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:apply:query')")
    @GetMapping(value = "/{rid}")
    public AjaxResult getInfo(@PathVariable("rid") Long rid)
    {
        return AjaxResult.success(sysRepairApplyService.selectSysRepairApplyByRid(rid));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:apply:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRepairApply sysRepairApply)
    {
        return toAjax(sysRepairApplyService.insertSysRepairApply(sysRepairApply));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:apply:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRepairApply sysRepairApply)
    {
        return toAjax(sysRepairApplyService.updateSysRepairApply(sysRepairApply));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:apply:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{rids}")
    public AjaxResult remove(@PathVariable Long[] rids)
    {
        return toAjax(sysRepairApplyService.deleteSysRepairApplyByRids(rids));
    }
}
