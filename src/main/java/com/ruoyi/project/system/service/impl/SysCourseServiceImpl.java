package com.ruoyi.project.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.domain.SysCourse;
import com.ruoyi.project.system.mapper.SysCourseMapper;
import com.ruoyi.project.system.service.ISysCourseService;

/**
 * 课程信息 服务层处理
 */
@Service
public class SysCourseServiceImpl implements ISysCourseService {
    @Autowired
    private SysCourseMapper courseMapper;

    /**
     * 查询课程信息集合
     *
     * @param course 课程信息
     * @return 课程信息集合
     */
    @Override
    public List<SysCourse> selectCourseList(SysCourse course) {
        return courseMapper.selectCourseList(course);
    }

    /**
     * 查询所有课程
     *
     * @return 课程列表
     */
    @Override
    public List<SysCourse> selectCourseAll() {
        return courseMapper.selectCourseAll();
    }

    /**
     * 通过课程ID查询课程信息
     *
     * @param courseId 课程ID
     * @return 课程对象信息
     */
    @Override
    public SysCourse selectCourseById(Long courseId) {
        return courseMapper.selectCourseById(courseId);
    }

    /**
     * 校验课程名称是否唯一
     *
     * @param course 课程信息
     * @return 结果
     */
    @Override
    public boolean checkCourseNameUnique(SysCourse course) {
        Long courseId = StringUtils.isNull(course.getCourseId()) ? -1L : course.getCourseId();
        SysCourse info = courseMapper.checkCourseNameUnique(course.getCourseName());
        if (StringUtils.isNotNull(info) && info.getCourseId() != null && info.getCourseId().longValue() != courseId.longValue()) {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 删除课程信息
     *
     * @param courseId 课程ID
     * @return 结果
     */
    @Override
    public int deleteCourseById(Long courseId) {
        return courseMapper.deleteCourseById(courseId);
    }

    /**
     * 批量删除课程信息
     *
     * @param courseIds 需要删除的课程ID
     * @return 结果
     */
    @Override
    public int deleteCourseByIds(Long[] courseIds) {
        return courseMapper.deleteCourseByIds(courseIds);
    }

    /**
     * 新增保存课程信息
     *
     * @param course 课程信息
     * @return 结果
     */
    @Override
    public int insertCourse(SysCourse course) {
        return courseMapper.insertCourse(course);
    }

    /**
     * 修改保存课程信息
     *
     * @param course 课程信息
     * @return 结果
     */
    @Override
    public int updateCourse(SysCourse course) {
        return courseMapper.updateCourse(course);
    }
}
