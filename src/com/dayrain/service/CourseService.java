package com.dayrain.service;

import java.util.List;

import com.dayrain.Dao.CourseDao;
import com.dayrain.Dao.DaoHolder;
import com.dayrain.entity.Course;


public class CourseService {

	private final CourseDao courseDao = DaoHolder.courseDao;

	/**
	 * 获取课程列表
	 * @return 所有的课程信息
	 */
	public List<Course> getCourseList(String query) {
		List<Course> courses = courseDao.getCourseList(query);
		return courses;
	}
	
	/**
	 * 通过学号获取课程
	 * @param courseNo 课程
	 * @return
	 */
	public Course getCourseByNo(String courseNo) {
		Course course = courseDao.getCourseByNo(courseNo);
		return course;
	}
	
	/**
	 * 添加課程
	 * @param course
	 * @return
	 */
	public Course addCourse(Course course) {
		courseDao.addCourse(course);
		return courseDao.getCourseByNo(course.getCourseNo());
	}
	
	/**
	 * 删除课程
	 */
	public void deleteCourse(String CourseNo) {
		courseDao.deleteCourse(CourseNo);
	}
	
	/**
	 * 更新课程
	 * @param course
	 */
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);
	}
	
	/**
	 * 统计课程数
	 * @return
	 */
	public int count() {
		return courseDao.count();
	}

	/**
	 * 选课人数+1
	 * @param courseNo
	 */
	public void plusStudentNum(String courseNo) {
		courseDao.plusStudentNum(courseNo);
	}
	
	
}
