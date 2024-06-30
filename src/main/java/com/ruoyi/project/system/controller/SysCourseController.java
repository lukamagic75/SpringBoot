package com.ruoyi.project.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.system.domain.SysCourse;
import com.ruoyi.project.system.service.ISysCourseService;

/**
 * 课程信息操作处理
 */
@RestController
@RequestMapping("/system/course")
public class SysCourseController extends BaseController {
    @Autowired
    private ISysCourseService courseService;

    /**
     * 获取课程列表
     */
    @PreAuthorize("@ss.hasPermi('system:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysCourse course) {
        startPage();
        List<SysCourse> list = courseService.selectCourseList(course);
        return getDataTable(list);
    }

    @Log(title = "课程管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:course:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysCourse course) {
        List<SysCourse> list = courseService.selectCourseList(course);
        ExcelUtil<SysCourse> util = new ExcelUtil<SysCourse>(SysCourse.class);
        util.exportExcel(response, list, "课程数据");
    }

    /**
     * 根据课程编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable Long courseId) {
        return success(courseService.selectCourseById(courseId));
    }

    /**
     * 新增课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:add')")
    @Log(title = "课程管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysCourse course) {
        if (!courseService.checkCourseNameUnique(course)) {
            return error("新增课程'" + course.getCourseName() + "'失败，课程名称已存在");
        }
        if (StringUtils.isEmpty(course.getCourseAuthor())) {
            return error("作者不能为空");
        }
        course.setCreateBy(getUsername());
        return toAjax(courseService.insertCourse(course));
    }

    /**
     * 修改课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:edit')")
    @Log(title = "课程管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysCourse course) {
        if (!courseService.checkCourseNameUnique(course)) {
            return error("修改课程'" + course.getCourseName() + "'失败，课程名称已存在");
        }
        course.setUpdateBy(getUsername());
        return toAjax(courseService.updateCourse(course));
    }

    /**
     * 删除课程
     */
    @PreAuthorize("@ss.hasPermi('system:course:remove')")
    @Log(title = "课程管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds) {
        return toAjax(courseService.deleteCourseByIds(courseIds));
    }

    /**
     * 获取课程选择框列表
     */
    @GetMapping("/optionselect")
    public AjaxResult optionselect() {
        List<SysCourse> courses = courseService.selectCourseAll();
        return success(courses);
    }
}
