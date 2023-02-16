package com.example.sailing_jsp_dev.comm;


import com.example.sailing_jsp_dev.v2.dao.MenuDaoV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class Bootlog {

    @Autowired
    MenuDaoV2 menuDaoV2;

    public int doBootLog(String strClass){
        int int1= menuDaoV2.doBootLog(strClass);
        return int1;
    }
}
