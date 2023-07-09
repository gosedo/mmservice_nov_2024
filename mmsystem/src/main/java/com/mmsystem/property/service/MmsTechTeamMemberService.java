package com.mmsystem.property.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmsystem.property.dto.MmsTechTeamDTO;
import com.mmsystem.property.dto.MmsTechTeamMemberDTO;
import com.mmsystem.property.mapper.MmsTechTeamMapper;
import com.mmsystem.property.mapper.MmsTechTeamMemberMapper;
import com.mmsystem.property.model.MmsTechTeam;
import com.mmsystem.property.model.MmsTechTeamMember;
import com.mmsystem.property.repo.MmsTechTeamJPARepository;
import com.mmsystem.property.repo.MmsTechTeamMemberJPARepository;



@Service  
@Transactional 
public class MmsTechTeamMemberService {

	
	@Autowired  
	private MmsTechTeamMemberJPARepository mmsTechTeamMemberJPARepository; 
	
	public MmsTechTeamMemberDTO save(MmsTechTeamMemberDTO mmsTechTeamMemberDto) {
		
		MmsTechTeamMember mmsTechTeamMember = MmsTechTeamMemberMapper.INSTANCE.mapToMmsTechTeamMember(mmsTechTeamMemberDto);
		mmsTechTeamMemberJPARepository.save(mmsTechTeamMember);
		
		return MmsTechTeamMemberMapper.INSTANCE.mapToMmsTechTeamMemberDto(mmsTechTeamMember);
	}

	public List<MmsTechTeamMemberDTO> findAll() {
		
		return mmsTechTeamMemberJPARepository.findAll()
				.stream()
				.map((mmsTechTeamMember) -> MmsTechTeamMemberMapper.INSTANCE.mapToMmsTechTeamMemberDto(mmsTechTeamMember))
		        .collect(Collectors.toList());
	}

	public boolean delete(MmsTechTeamMember pojo) {
		mmsTechTeamMemberJPARepository.delete(pojo);
		return true;
	}

	public MmsTechTeamMember findById(MmsTechTeamMember pojo) {
		
		return mmsTechTeamMemberJPARepository.findById((long) pojo.getTeamMemberId()).get();
	}
		
	public MmsTechTeamMember update(MmsTechTeamMember pojo) {
		
		return mmsTechTeamMemberJPARepository.save(pojo);
	}

}
