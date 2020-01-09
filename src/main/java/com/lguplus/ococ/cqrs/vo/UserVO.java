package com.lguplus.ococ.cqrs.vo;

import com.lguplus.ococ.cqrs.domain.Org;
import com.lguplus.ococ.cqrs.domain.User;
import lombok.*;

import java.util.HashSet;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserVO {
    String userNm;
    String userId;
    String acv;
    List<String> orgs;

    public static User toDomain(UserVO userVO){
        User user = User.builder().build();
        user.setAcv(userVO.getAcv());
        user.setUserId(userVO.getUserId());
        user.setUserNm(userVO.getUserNm());
        user.setOrgSet(new HashSet<>());
        userVO.getOrgs().stream().forEach( organization -> {
            Org org = new Org();
            org.setOrgCd(organization);
        });
        return user;
    }
}
