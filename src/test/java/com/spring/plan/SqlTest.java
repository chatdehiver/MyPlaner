package com.spring.plan;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeLog;
import com.spring.plan.model.vo.Daily;

public class SqlTest {
	/*@Test
	public void boardInsert() throws Exception{
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		Member member = new Member();
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
		System.out.println(sqlSession.selectOne("daily-mapper.selectEmotionByYear","2018"));
		sqlSession.commit();
		System.out.println("@2");
	}*/
	
	
	/////////////////////////////////////////////////////
	/////////////////////////////////////////////////////
	
	
/*	@Test
	public void sendMessage() throws Exception { // �޼��� ������
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		Message message = new Message(0, 0, 1, null, "�޼��� ������ 1 ����Ʈ", "SEND MESSAGE TITLE 1!!");

		// int sendMessage(Message message) // �޼��� ������
		System.out.println(message.getSenderMemberNo()+"���� "+message.getDestinationMemberNo()+ "�Կ��� �޼��� �����ϴ�.");
		sqlSession.insert("message-mapper.sendMessage", message);
		sqlSession.commit();
		System.out.println(message.getMessageTitle()+"������ ����!");
	}*/
	
	/*@Test
	public void getMessage() throws Exception {// �޼��� ��ȣ�� ������ �޼��� ��������
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		//Message getMessage(int messageNo) / messageNo�� ���� �޼��� ����
		Message message = (Message)sqlSession.selectOne("message-mapper.getMessage", 13);
		
		System.out.println(message);
	}
	*/
/*	@Test
	public void deleteMessage() throws Exception {  // �޼��� ��ȣ�� ������ �޼��� �����ϱ�
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		System.out.println("�޼����� �����մϴ�.");
		sqlSession.delete("message-mapper.deleteMessage", 16);
		sqlSession.commit();
		System.out.println("�޼��� ������ �Ϸ�Ǿ����ϴ�");	
	}*/
	
	/*@Test
	public void getMessageList() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		List<Message> messageList = sqlSession.selectList("message-mapper.getMessageList", 1);
		
		for(Message message : messageList)
			System.out.println(message);
	}
	*/
	/*@Test
	public void getSendMessageList() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		List<Message> messageList = sqlSession.selectList("message-mapper.getSendMessageList", 0);
		
		for(Message message : messageList)
			System.out.println(message);
	}*/
	/*
	@Test
	public void readMessage() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		sqlSession.update("message-mapper.readMessage", 18);
		sqlSession.commit();
		
		Message message = (Message)sqlSession.selectOne("message-mapper.getMessage", 18);
		
		System.out.println(message);
		System.out.println(message.isCheck());
		System.out.println("�޼����� �����̽��ϴ�.");
	}*/
	
	
	
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	
/*	@Test
	public void addChallenge() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		Challenge challenge = new Challenge(0,"C - TEST C-1", "2018-11-29", "2018-12-12",1, "TEST C", true);
		sqlSession.insert("challenge-mapper.addChallenge", challenge);
		sqlSession.commit();
		System.out.println(challenge.getChallengeTitle() + " << ���� ��� ����!!");
	}*/
	
	/*@Test
	public void deleteChallenge() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
	
		sqlSession.delete("challenge-mapper.deleteChallenge", 23);
		sqlSession.commit();

		System.out.println("Challenge�� �����Ǿ����ϴ�.");
	}*/
	/*
	@Test
	public void addChallengeContent() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		List<ChallengeContent> challengeContentList = new ArrayList<ChallengeContent>();
		challengeContentList.add(new ChallengeContent(16, "Content 111"));
		challengeContentList.add(new ChallengeContent(16, "Content 222"));
		
		sqlSession.insert("challenge-mapper.addChallengeContent", challengeContentList);
		sqlSession.commit();
		
		for(int i = 0 ; i < challengeContentList.size(); i++)
			System.out.println(challengeContentList.get(i).getChallengeContent() + " << ���� �׸� ��� ����!!");
	}*/
	
/*	@Test
	public void deleteChallengeContent() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		String challengeContent = "Content CCC";
		sqlSession.delete("challenge-mapper.deleteChallengeContent", challengeContent);
		sqlSession.commit();
		
		System.out.println(challengeContent + " << �� �����Ǿ����ϴ�.");
	}*/
	
	
	/*@Test
	public void writeChallengeComment() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		ChallengeComment challengeComment = new ChallengeComment(0,0,14,1,"��u����������",null);
		//challengeCommentList.add(new ChallengeComment(0,0,6,"huizz","�ȵ� �� ��������...",null));
		
		sqlSession.insert("challenge-mapper.writeChallengeComment", challengeComment);
		sqlSession.commit();
		
		System.out.println("��� ��� ����!!");
	}*/
	
/*	@Test
	public void deleteChallengeComment() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		sqlSession.delete("challenge-mapper.deleteChallengeComment", 35);
		sqlSession.commit();
		
		System.out.println("��� ���� ����!!");
	}*/
	
	/*@Test
	public void checkChallenge() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		sqlSession.update("challenge-mapper.checkChallenge", new ChallengeContent(14, "��Ʈ ���ġ ���Ǻ� �Ƴ���"));
		sqlSession.commit();
		
		System.out.println("������ �̼� ���ø�~~");
	}*/
	
	/*@Test
	public void getAllChallengeList() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		List<Challenge> challengeList = sqlSession.selectList("challenge-mapper.getAllChallengeList");
		
		for(Challenge c : challengeList)
			System.out.println(c);
	}*/
	
	/*@Test
	public void updateChallengeLog() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		sqlSession.insert("challenge-mapper.updateChallengeLog", new ChallengeLog(20,"log test", 1));
		sqlSession.commit();
		
		System.out.println("������Ʈ ����!");
	}*/
	
	/*@Test
	public void getChallengeByNo() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();

		Challenge challenge = sqlSession.selectOne("challenge-mapper.getChallengeByNo", 14);
		System.out.println("11"+challenge.getChallengeLogList());
		System.out.println("22"+challenge.getChallengeContentList());
		System.out.println("33"+challenge.getChallengeCommentList());
	}*/
	
	/*@Test
	public void getChallengeByMonth() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		Daily challengeByMonth = new Daily(1, "11", "28");
		List<Challenge> list = sqlSession.selectList("challenge-mapper.getChallengeByMonth",challengeByMonth);
		
		System.out.println(list);
		for(Challenge c : list)
			System.out.println(c);
		
		System.out.println("��� �Ϸ�");
	}*/
	
	/*@Test
	public void getChallengeByMonth() throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession sqlSession = factory.openSession();
		
		Daily challengeByDay = new Daily(0, "11", "20181128");
		List<Challenge> list = sqlSession.selectList("challenge-mapper.getChallengeByDay",challengeByDay);
		
		System.out.println(list);
		for(Challenge c : list)
			System.out.println(c);
		
		System.out.println("��� �Ϸ�");
	}*/
	
}
