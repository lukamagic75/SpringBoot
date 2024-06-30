package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.SysCourse;

/**
 * 课程信息 数据层
 *
 * @author ruoyi
 */
public interface SysCourseMapper
{
    /**
     * 查询课程数据集合
     *
     * @param course 课程信息
     * @return 课程数据集合
     */
    public List<SysCourse> selectCourseList(SysCourse course);

    /**
     * 查询所有课程
     *
     * @return 课程列表
     */
    public List<SysCourse> selectCourseAll();

    /**
     * 通过课程ID查询课程信息
     *
     * @param courseId 课程ID
     * @return 课程对象信息
     */
    public SysCourse selectCourseById(Long courseId);

    /**
     * 删除课程信息
     *
     * @param courseId 课程ID
     * @return 结果
     */
    public int deleteCourseById(Long courseId);

    /**
     * 批量删除课程信息
     *
     * @param courseIds 需要删除的课程ID
     * @return 结果
     */
    public int deleteCourseByIds(Long[] courseIds);

    /**
     * 修改课程信息
     *
     * @param course 课程信息
     * @return 结果
     */
    public int updateCourse(SysCourse course);

    /**
     * 新增课程信息
     *
     * @param course 课程信息
     * @return 结果
     */
    public int insertCourse(SysCourse course);

    /**
     * 校验课程名称
     *
     * @param courseName 课程名称
     * @return 结果
     */
    public SysCourse checkCourseNameUnique(String courseName);

}
