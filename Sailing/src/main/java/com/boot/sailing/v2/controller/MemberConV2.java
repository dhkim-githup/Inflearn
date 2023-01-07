package com.boot.sailing.v2.controller;

import com.boot.sailing.v2.service.MemberSvcV2;
import com.boot.sailing.v2.service.OrderSvcV2;
import com.boot.sailing.v2.vo.Cust_info;
import com.boot.sailing.v2.vo.Order_list;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/v2")
@Log4j2
public class MemberConV2 {

    @Autowired
    MemberSvcV2 memberSvcV2;

    @RequestMapping("/member")
    public String doMember(Model model){

        // Data 만들기 , List , Map
        List<Cust_info> list = memberSvcV2.doList();

        log.info("============================");
        log.info(list);
        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", " ========== MemberConV2 ======== ");


        return "/v2/member/member";
    }

    /* 조회하기 */
    @PostMapping("/member_search")
    public String doSearch( @RequestParam("start_date") String strStartDate,
                            @RequestParam("end_date") String strEndDate,
                            @RequestParam("name") String strName,
                            Model model

    ){

        log.info("strStartDate :"+strStartDate);

        List<Cust_info> list = memberSvcV2.doSerch(strStartDate,strEndDate, strName );

        model.addAttribute("list", list);

        return "/v2/member/member";
    }



}
