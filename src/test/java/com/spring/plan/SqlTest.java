package com.spring.plan;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.spring.plan.model.vo.Board;
import com.spring.plan.model.vo.BoardComment;
import com.spring.plan.model.vo.CheckHabit;
import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Habit;
import com.spring.plan.model.vo.Member;
import com.spring.plan.model.vo.Schedule;

public class SqlTest {
	@Test
	public void boardInsert() throws Exception{
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		/*Member member = new Member();
		member.setPassword("���");
		Daily daily = new Daily();
		daily.setEmotion("�Ф�");
		daily.setDay("20181128");
		daily.setMonth("11");
		daily.setMemberNo(4);
		Schedule schedule = new Schedule();
		schedule.setScheduleNo(0);
		schedule.setScheduleStartDate("20181111");
		schedule.setScheduleEndDate("20181130");
		schedule.setScheduleContent("����");
		schedule.setScheduleTag("�");
		schedule.setScheduleTitle("�");
		System.out.println("11");
		System.out.println("@2");
		Board board = new Board();
		board.setBoardTitle("�����������");
		board.setBoardContent("gfjnkjdsngkjdfan");
		board.setMemberNo(4);
		BoardComment bc = new BoardComment();
		bc.setBoardComment("zzzzzzzz222222");
		bc.setBoardCommentMemberNo(4);
		bc.setBoardNo(2);
		bc.setBoardReplyComment(0);*/
//		Board b = sqlSession.selectOne("board-mapper.getBoardByNo",2);
/*		System.out.println(b);
		List<BoardComment> list = b.getBoardCommentList();
		BoardComment c = list.get(0);*/
//		System.out.println(":::::::::"+sqlSession.delete("board-mapper.deleteBoardComment",c));
		
		Habit habit = new Habit();
		habit.setMemberNo(4);
		habit.setHabit("���� �Ͼ��");
		habit.setHabitStartDate("20181202");
		
		/*sqlSession.insert("habit-mapper.addHabit",habit);
		sqlSession.commit();
		*/
		/*sqlSession.insert("habit-mapper.addHabitCheck",habit);
		sqlSession.commit();*/
		CheckHabit ch = new CheckHabit();
		ch.setHabit(habit);
		ch.setMonth("201812");
		
		String checkHabit = sqlSession.selectOne("habit-mapper.getCheckHabit",ch);
		System.out.println(checkHabit);
		
		char[] arr = checkHabit.toCharArray();
		arr[1]='1';
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]);
		}
		ch.setCheckHabit(new String(arr));
		System.out.println(sqlSession.update("habit-mapper.checkHabit",ch));
		sqlSession.commit();
		
	}
}
