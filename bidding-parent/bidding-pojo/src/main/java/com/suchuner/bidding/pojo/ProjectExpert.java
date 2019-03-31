package com.suchuner.bidding.pojo;

import java.util.Objects;

public class ProjectExpert {
    private Long id;

    private Long pjtId;

    private Long judge1Id;

    private Long judge2Id;

    private Long judge3Id;

    private Long judge4Id;

    private Long judge5Id;

    private Long judge6Id;

    private Long judge7Id;

    private Long judge8Id;

    private Long judge9Id;

    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPjtId() {
        return pjtId;
    }

    public void setPjtId(Long pjtId) {
        this.pjtId = pjtId;
    }

    public Long getJudge1Id() {
        return judge1Id;
    }

    public void setJudge1Id(Long judge1Id) {
        this.judge1Id = judge1Id;
    }

    public Long getJudge2Id() {
        return judge2Id;
    }

    public void setJudge2Id(Long judge2Id) {
        this.judge2Id = judge2Id;
    }

    public Long getJudge3Id() {
        return judge3Id;
    }

    public void setJudge3Id(Long judge3Id) {
        this.judge3Id = judge3Id;
    }

    public Long getJudge4Id() {
        return judge4Id;
    }

    public void setJudge4Id(Long judge4Id) {
        this.judge4Id = judge4Id;
    }

    public Long getJudge5Id() {
        return judge5Id;
    }

    public void setJudge5Id(Long judge5Id) {
        this.judge5Id = judge5Id;
    }

    public Long getJudge6Id() {
        return judge6Id;
    }

    public void setJudge6Id(Long judge6Id) {
        this.judge6Id = judge6Id;
    }

    public Long getJudge7Id() {
        return judge7Id;
    }

    public void setJudge7Id(Long judge7Id) {
        this.judge7Id = judge7Id;
    }

    public Long getJudge8Id() {
        return judge8Id;
    }

    public void setJudge8Id(Long judge8Id) {
        this.judge8Id = judge8Id;
    }

    public Long getJudge9Id() {
        return judge9Id;
    }

    public void setJudge9Id(Long judge9Id) {
        this.judge9Id = judge9Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectExpert that = (ProjectExpert) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPjtId(), that.getPjtId()) &&
                Objects.equals(getJudge1Id(), that.getJudge1Id()) &&
                Objects.equals(getJudge2Id(), that.getJudge2Id()) &&
                Objects.equals(getJudge3Id(), that.getJudge3Id()) &&
                Objects.equals(getJudge4Id(), that.getJudge4Id()) &&
                Objects.equals(getJudge5Id(), that.getJudge5Id()) &&
                Objects.equals(getJudge6Id(), that.getJudge6Id()) &&
                Objects.equals(getJudge7Id(), that.getJudge7Id()) &&
                Objects.equals(getJudge8Id(), that.getJudge8Id()) &&
                Objects.equals(getJudge9Id(), that.getJudge9Id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPjtId(), getJudge1Id(), getJudge2Id(), getJudge3Id(), getJudge4Id(), getJudge5Id(), getJudge6Id(), getJudge7Id(), getJudge8Id(), getJudge9Id());
    }
}