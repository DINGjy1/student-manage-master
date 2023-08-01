package com.dayrain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dayrain.Dao.DaoHolder;
import com.dayrain.Dao.ScoreDao;
import com.dayrain.entity.Course;
import com.dayrain.entity.Score;
import com.dayrain.entity.Teacher;
import com.dayrain.entity.dto.ScoreDto;
import com.dayrain.entity.dto.StudentScoreDto;

public class ScoreService {

	private final ScoreDao scoreDao = DaoHolder.scoreDao;

	private final CourseService courseService = ServiceHolder.courseService;

	/**
	 * 获取成绩列表
	 * @return
	 */
	public List<ScoreDto> getScoreList(String query) {
		return scoreDao.getScoreList(query);
	}
	
	/**
	 * 更新成绩
	 * @param score
	 */
	public void updateScore(Score score) {
		scoreDao.updateScore(score);
	}
	
	/**
	 * 删除成绩
	 * @param id
	 */
	public void deleteScore(int id) {
	    scoreDao.deleteScore(id);
	}
	
	/**
	 * 获取成绩
	 * @param studenNo 学号
	 * @param courseNo 课程号
	 * @return
	 */
	public Score getScoreByStudentNoAndCourseNo(String studenNo, String courseNo) {
		return scoreDao.getScoreByStudentNoAndCourseNo(studenNo, courseNo);
	}

	/**
	 * 添加成绩
	 * @param scoreObj
	 */
	public void addScore(Score scoreObj) {
	
		scoreObj.setCreateTime(new Date());
		scoreObj.setUpdateTime(new Date());
		ScoreDao scoreDao = new ScoreDao();
		Score scoreRes = scoreDao.getScoreByStudentNoAndCourseNo(scoreObj.getStudentNo(), scoreObj.getCourseNo());
		if(scoreRes == null) {
			scoreDao.addScore(scoreObj);
		}
		
		//选课人数+1
		courseService.plusStudentNum(scoreObj.getCourseNo());
		
	}

	/**
	 * 获取排名前top的学霸
	 * @param top
	 * @return
	 */
	public List<ScoreDto> getTopScoreList(int top) {
		return scoreDao.getTopScoreList(top);
	}

	/**
	 * 通过学号查成绩
	 * @param studentNo 学号
	 * @return
	 */
	public List<StudentScoreDto> getScoreListByStudentNo(String studentNo) {
		List<ScoreDto> scoreDtos = scoreDao.getScoreListByStudentNo(studentNo);
		List<StudentScoreDto> studentScores= new ArrayList<StudentScoreDto>();
		for(ScoreDto scoreDto : scoreDtos) {
			StudentScoreDto studentScoreDto= new StudentScoreDto();
			CourseService courseService = new CourseService();
			TeacherService teacherService = new TeacherService();
			Course course = courseService.getCourseByNo(scoreDto.getCourseNo());
			
			Teacher teacher= teacherService.getTeacherByCourseNo(course.getCourseNo());
			
			studentScoreDto.setCourseNo(scoreDto.getCourseNo());
			studentScoreDto.setCourseName(scoreDto.getCourseName());
			studentScoreDto.setId(scoreDto.getId());
			studentScoreDto.setScore(scoreDto.getScore());
			studentScoreDto.setStudentName(scoreDto.getStudentName());
			studentScoreDto.setStudentNo(studentNo);
			studentScoreDto.setTeacherName(teacher.getTeacherName());
			studentScoreDto.setRank(scoreDao.getBeforeScoreNum(scoreDto.getCourseNo(), scoreDto.getScore()) + 1);
			studentScoreDto.setStudentNum(course.getStudentNum());
			studentScoreDto.setCreateTime(scoreDto.getCreateTime());
			studentScoreDto.setUpdateTime(scoreDto.getUpdateTime());
			
			studentScores.add(studentScoreDto);
			
		}
		return studentScores;
	}
}
