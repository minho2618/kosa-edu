package spring.service.dao.impl;

import spring.service.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO {
	
	public MemberDAOImpl() {
		System.out.println("MemberDAOImpl 객체 생성");
	}

	@Override
	public void register(String id, String name) {
		System.out.println(name + "님 등록 성공");
	}

	@Override
	public void delete(String id) {
		System.out.println(id + "님 삭제 성공");
	}

}
