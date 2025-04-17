package com.onehome.socialsecurity.service.impl;

import com.onehome.socialsecurity.dto.PanDto;
import com.onehome.socialsecurity.entity.UserPan;
import com.onehome.socialsecurity.mapper.PanMapper;
import com.onehome.socialsecurity.repository.UserPanRepository;
import com.onehome.socialsecurity.service.IUserPanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserPanServiceImpl implements IUserPanService {
    private UserPanRepository userPanRepository;
    @Override
    public void createUserPan(PanDto pan) {
        UserPan userPan = PanMapper.getPan(pan);
        userPanRepository.save(userPan);
    }
}
