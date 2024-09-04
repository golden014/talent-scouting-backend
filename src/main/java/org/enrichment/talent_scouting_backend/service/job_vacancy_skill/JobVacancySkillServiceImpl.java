package org.enrichment.talent_scouting_backend.service.job_vacancy_skill;

import org.enrichment.talent_scouting_backend.api.dao.job_vacancy.JobVacancyDAO;
import org.enrichment.talent_scouting_backend.api.dao.job_vacancy_skill.JobVacancySkillDAO;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.model.JobVacancySkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobVacancySkillServiceImpl implements JobVacancySkillService {

    @Autowired
    JobVacancySkillDAO jobVacancySkillDAO;

    @Autowired
    JobVacancyDAO jobVacancyDAO;

    @Transactional
    @Override
    public JobVacancySkill addSkill(JobVacancySkill skill) {
        return jobVacancySkillDAO.addSkill(skill);
    }

    @Transactional
    @Override
    public JobVacancySkill getJobVacancySkill(long jobVacancyId, long skillId) {
        return jobVacancySkillDAO.getJobVacancySkill(jobVacancyId, skillId);
    }

    @Transactional
    @Override
    public void deleteSkill(long jobVacancyId, long skillId) {
        jobVacancySkillDAO.deleteSkill(jobVacancyId, skillId);
    }

    @Transactional
    @Override
    public List<JobVacancySkill> addSkills(List<JobVacancySkill> skills) {

        for (JobVacancySkill skill : skills) {

            JobVacancy jobVacancy = jobVacancyDAO.getJobVacancyByID(skill.getJobVacancy().getId());

            JobVacancySkill newSkill = new JobVacancySkill();
            newSkill.setJobVacancy(jobVacancy);
            newSkill.setSkill(skill.getSkill());
            newSkill.setSkillDetail(skill.getSkillDetail());

            addSkill(newSkill);
//            addSkill(skill);
        }
        return skills;
    }
}
