package com.mmsystem.property.mapper;



import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mmsystem.property.dto.MmsUserDTO;
import com.mmsystem.property.model.MmsUser;

@Mapper
public interface MmsUserMapper {
	
	MmsUserMapper INSTANCE = Mappers.getMapper(MmsUserMapper.class);
		
	 MmsUserDTO mapToUserDto(MmsUser mmsuser);

	 MmsUser mapToUser(MmsUserDTO mmsuserDto);
	 
}
