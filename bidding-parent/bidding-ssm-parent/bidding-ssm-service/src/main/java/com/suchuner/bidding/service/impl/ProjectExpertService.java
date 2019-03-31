package com.suchuner.bidding.service.impl;

import com.suchuner.bidding.mapper.ProjectExpertMapper;
import com.suchuner.bidding.pojo.Project;
import com.suchuner.bidding.pojo.ProjectExpert;
import com.suchuner.bidding.pojo.ProjectExpertExample;
import com.suchuner.bidding.service.IProjectExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author suchuner
 */
@Service
public class ProjectExpertService implements IProjectExpertService {

    @Autowired
    private ProjectExpertMapper projectExpertMapper;

    public void addProjectExpert(ProjectExpert projectExpert) throws Exception {
        projectExpertMapper.insertSelective(projectExpert);
    }

    public ProjectExpert getProjectExpertByProject(Project project) throws Exception {
        ProjectExpertExample projectExpertExample = new ProjectExpertExample();
        ProjectExpertExample.Criteria criteria = projectExpertExample.createCriteria();
        criteria.andPjtIdEqualTo(project.getId());
        List<ProjectExpert> projectExperts = projectExpertMapper.selectByExample(projectExpertExample);
        return projectExperts.size()>0?projectExperts.get(0):null;
    }

    public void updateProjectExpertByProjectExpert(ProjectExpert projectExpert) throws Exception {
        projectExpertMapper.updateByPrimaryKey(projectExpert);
    }

    public Set<ProjectExpert> getProjectExpertsByEid(Long eid) throws Exception {
        Set<ProjectExpert> sets = new HashSet<ProjectExpert>();
        List<ProjectExpert> projectExperts ;
        for (int i=1;i<=9;i++){
            ProjectExpertExample projectExpertExample = new ProjectExpertExample();
            ProjectExpertExample.Criteria criteria = projectExpertExample.createCriteria();
            switch (i){
                case 1: criteria.andJudge1IdEqualTo(eid);break;
                case 2: criteria.andJudge2IdEqualTo(eid);break;
                case 3: criteria.andJudge3IdEqualTo(eid);break;
                case 4: criteria.andJudge4IdEqualTo(eid);break;
                case 5: criteria.andJudge5IdEqualTo(eid);break;
                case 6: criteria.andJudge6IdEqualTo(eid);break;
                case 7: criteria.andJudge7IdEqualTo(eid);break;
                case 8: criteria.andJudge8IdEqualTo(eid);break;
                case 9: criteria.andJudge9IdEqualTo(eid);break;
            }
            projectExperts = projectExpertMapper.selectByExample(projectExpertExample);
            if(!projectExperts.isEmpty()){
                sets.addAll(projectExperts);
            }
        }
        return sets;
    }
}
