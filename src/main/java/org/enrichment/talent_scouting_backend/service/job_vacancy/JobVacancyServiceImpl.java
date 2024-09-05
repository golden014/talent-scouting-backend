package org.enrichment.talent_scouting_backend.service.job_vacancy;

import org.enrichment.talent_scouting_backend.api.dao.job_vacancy.JobVacancyDAO;
import org.enrichment.talent_scouting_backend.api.dto.JobVacancyAllAttributes;
import org.enrichment.talent_scouting_backend.api.model.ExtrasInfo;
import org.enrichment.talent_scouting_backend.api.model.JobVacancy;
import org.enrichment.talent_scouting_backend.api.model.JobVacancyResponsibility;
import org.enrichment.talent_scouting_backend.api.model.JobVacancySkill;
import org.enrichment.talent_scouting_backend.api.dto.InsertJobVacancy;
import org.enrichment.talent_scouting_backend.api.dto.JobVacancyFilter;
import org.enrichment.talent_scouting_backend.service.extras_info.ExtrasInfoService;
import org.enrichment.talent_scouting_backend.service.job_vacancy_responsibility.JobVacancyResponsibilityService;
import org.enrichment.talent_scouting_backend.service.job_vacancy_skill.JobVacancySkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobVacancyServiceImpl implements JobVacancyService {

    @Autowired
    JobVacancyDAO jobVacancyDAO;

    @Autowired
    JobVacancyResponsibilityService jobVacancyResponsibilityService;

    @Autowired
    JobVacancySkillService jobVacancySkillService;

    @Autowired
    ExtrasInfoService extrasInfoService;

    @Transactional
    @Override
    public JobVacancy addJobVacancy(JobVacancy jobVacancy) {
        return jobVacancyDAO.addJobVacancy(jobVacancy);
    }

    @Transactional
    @Override
    public void deleteJobVacancy(JobVacancy jobVacancy) {
        jobVacancyDAO.deleteJobVacancy(jobVacancy);
    }

    @Transactional
    @Override
    public JobVacancy addJobVacancy(InsertJobVacancy data) {
        try {
            addJobVacancy(data.getJobVacancy());

            for (JobVacancySkill skill : data.getJobVacancySkills()) {
                jobVacancySkillService.addSkill(skill);
            }

            for (JobVacancyResponsibility responsibility : data.getJobVacancyResponsibilities()) {
                jobVacancyResponsibilityService.addJobVacancyResponsibility(responsibility);
            }

            for (ExtrasInfo extrasInfo: data.getExtrasInfos()) {
                extrasInfoService.addExtrasInfo(extrasInfo);
            }
        } catch (Exception e) {
            return null;
        }

        return data.getJobVacancy();
    }

    @Transactional
    @Override
    public List<JobVacancy> getJobVacanciesByFilters(JobVacancyFilter jobVacancyFilter) {
        return jobVacancyDAO.getJobVacanciesByFilters(jobVacancyFilter);
    }

    @Transactional
    @Override
    public List<JobVacancy> getJobVacancyByCompanyId(Long companyID) {
        return jobVacancyDAO.getJobVacancyByCompanyId(companyID);
    }

    @Override
    public JobVacancyAllAttributes getJobVacancyById(Long id) {
        return jobVacancyDAO.getJobVacancyByID(id);
    }
}
