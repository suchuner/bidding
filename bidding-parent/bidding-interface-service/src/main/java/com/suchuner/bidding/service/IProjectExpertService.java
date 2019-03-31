package com.suchuner.bidding.service;

import com.suchuner.bidding.pojo.Project;
import com.suchuner.bidding.pojo.ProjectExpert;

import java.util.Set;

/**
 * @author suchuner
 */
public interface IProjectExpertService {
     void addProjectExpert(ProjectExpert projectExpert) throws Exception;

     ProjectExpert getProjectExpertByProject(Project project) throws Exception;

     void updateProjectExpertByProjectExpert(ProjectExpert projectExpert) throws Exception;

     Set<ProjectExpert> getProjectExpertsByEid(Long eid) throws Exception;

}
