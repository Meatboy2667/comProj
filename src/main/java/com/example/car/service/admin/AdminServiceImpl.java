package com.example.car.service.admin;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.car.model.admin.AdminDAO;
import com.example.car.model.member.dto.MemberDTO;

@Service //service bean으로 등록
public class AdminServiceImpl implements AdminService {
	
	@Inject //의존관계 주입(DI)
	AdminDAO adminDao;

	@Override
	public String loginCheck(MemberDTO dto) {
		return adminDao.loginCheck(dto);
	}

}
