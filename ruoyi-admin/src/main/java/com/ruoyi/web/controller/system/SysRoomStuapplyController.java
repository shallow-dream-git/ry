package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysRoomStuapply;
import com.ruoyi.system.service.ISysRoomStuapplyService;
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
@RequestMapping("/system/stuapply")
public class SysRoomStuapplyController extends BaseController
{
    @Autowired
    private ISysRoomStuapplyService sysRoomStuapplyService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:stuapply:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRoomStuapply sysRoomStuapply)
    {
        startPage();
        List<SysRoomStuapply> list = sysRoomStuapplyService.selectSysRoomStuapplyList(sysRoomStuapply);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @PreAuthorize("@ss.hasPermi('system:stuapply:export')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRoomStuapply sysRoomStuapply)
    {
        List<SysRoomStuapply> list = sysRoomStuapplyService.selectSysRoomStuapplyList(sysRoomStuapply);
        ExcelUtil<SysRoomStuapply> util = new ExcelUtil<SysRoomStuapply>(SysRoomStuapply.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:stuapply:query')")
    @GetMapping(value = "/{applyId}")
    public AjaxResult getInfo(@PathVariable("applyId") Long applyId)
    {
        return AjaxResult.success(sysRoomStuapplyService.selectSysRoomStuapplyByApplyId(applyId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:stuapply:add')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRoomStuapply sysRoomStuapply)
    {
        return toAjax(sysRoomStuapplyService.insertSysRoomStuapply(sysRoomStuapply));
    }

    /**
     * 修改【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:stuapply:edit')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRoomStuapply sysRoomStuapply)
    {
        return toAjax(sysRoomStuapplyService.updateSysRoomStuapply(sysRoomStuapply));
    }

    /**
     * 删除【请填写功能名称】
     */
    @PreAuthorize("@ss.hasPermi('system:stuapply:remove')")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applyIds}")
    public AjaxResult remove(@PathVariable Long[] applyIds)
    {
        return toAjax(sysRoomStuapplyService.deleteSysRoomStuapplyByApplyIds(applyIds));
    }
}
