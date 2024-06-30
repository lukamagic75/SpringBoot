package com.ruoyi.project.system.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.aspectj.lang.annotation.Excel.ColumnType;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 课程表 sys_course
 *
 * @author ruoyi
 */
public class SysCourse extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 课程ID */
    @Excel(name = "课程ID", cellType = ColumnType.NUMERIC)
    private Long courseId;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 课程简介 */
    @Excel(name = "课程简介")
    private String courseDescription;

    /** 课程封面 */
    @Excel(name = "课程封面")
    private String courseCover;

    /** 课程视频 */
    @Excel(name = "课程视频")
    private String courseVideo;

    /** 课程作者 */
    @Excel(name = "课程作者")
    private String courseAuthor;

    /** 课程排序 */
    @Excel(name = "课程排序", cellType = ColumnType.NUMERIC)
    private Integer courseSort;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @NotBlank(message = "课程名称不能为空")
    @Size(min = 0, max = 100, message = "课程名称长度不能超过100个字符")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @NotBlank(message = "课程简介不能为空")
    @Size(min = 0, max = 500, message = "课程简介长度不能超过500个字符")
    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    @NotBlank(message = "课程封面不能为空")
    @Size(min = 0, max = 255, message = "课程封面长度不能超过255个字符")
    public String getCourseCover() {
        return courseCover;
    }

    public void setCourseCover(String courseCover) {
        this.courseCover = courseCover;
    }

    @NotBlank(message = "课程视频不能为空")
    @Size(min = 0, max = 255, message = "课程视频长度不能超过255个字符")
    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }

    @NotBlank(message = "课程作者不能为空")
    @Size(min = 0, max = 100, message = "课程作者长度不能超过100个字符")
    public String getCourseAuthor() {
        return courseAuthor;
    }

    public void setCourseAuthor(String courseAuthor) {
        this.courseAuthor = courseAuthor;
    }

    @NotNull(message = "课程排序不能为空")
    public Integer getCourseSort() {
        return courseSort;
    }

    public void setCourseSort(Integer courseSort) {
        this.courseSort = courseSort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("courseId", getCourseId())
                .append("courseName", getCourseName())
                .append("courseDescription", getCourseDescription())
                .append("courseCover", getCourseCover())
                .append("courseVideo", getCourseVideo())
                .append("courseAuthor", getCourseAuthor())
                .append("courseSort", getCourseSort())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
