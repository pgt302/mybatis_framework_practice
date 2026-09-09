package dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConfig {
	private static SqlSessionFactory sqlSessionFactory; // 싱글톤 패턴으로 정적 메서드인 getSqlSessionFactory()로 이미 생성된 인스턴스를 반환받음
	// 결론적으로 SqlSessionFactory 인스턴스는 하나만 존재함
	
	static {
		String resource = "mybatis-config.xml";
		
		try {
			
			Reader reader = Resources.getResourceAsReader(resource);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); // 여기서 인스턴스 생성
			reader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory; // 전역으로 생성된 인스턴스를 여기서 반환
	} 
}
