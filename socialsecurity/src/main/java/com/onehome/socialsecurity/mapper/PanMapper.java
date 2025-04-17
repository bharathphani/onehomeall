package com.onehome.socialsecurity.mapper;

import com.onehome.socialsecurity.dto.PanDto;
import com.onehome.socialsecurity.entity.UserPan;

public class PanMapper {
    public static PanDto getPanDto(UserPan pan) {
        return new PanDto(pan.getId(), pan.getPan(), pan.getName(), pan.getMobileNo());
    }

    public static UserPan getPan(PanDto pan) {
        return new UserPan(pan.getId(), pan.getPan(), pan.getName(), pan.getMobileNo());
    }
}