package com.suchuner.bidding.controller;

import com.suchuner.bidding.common.utils.CommonUtils;
import com.suchuner.bidding.common.utils.CookieUtils;
import com.suchuner.bidding.pojo.Expert;
import com.suchuner.bidding.pojo.ProjectExpert;
import com.suchuner.bidding.service.IExpertService;
import com.suchuner.bidding.service.IProjectExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @author suchuner
 */
@Controller
public class ProjectExpertController {
    @Autowired
    private IProjectExpertService projectExpertService;

    @Autowired
    private IExpertService expertService;

    @RequestMapping("/projectExpert/toMyBiddingPage")
    public String toMyBiddingPage(){
        return "/projectExpert/myBiddingProject";
    }

    @RequestMapping("/projectExpert/getProjectExperts")
    public void getProjectExpertsByEid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String token = CookieUtils.getCookieValue(request, "BIDDING_SYSTEM_EXPERT", true);
        Expert expert = expertService.getLoginExpertByLoginToken(token);
        if(expert==null){
            CommonUtils.returnMessages(response,false,"你还未登录!");
           return ;
        }
        Set<ProjectExpert> projectExperts = projectExpertService.getProjectExpertsByEid(expert.getId());
        CommonUtils.returnMessages(response,projectExperts.size(),projectExperts);
    }
}
