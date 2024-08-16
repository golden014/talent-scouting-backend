package org.enrichment.talent_scouting_backend.api.dao.job_vacancy;

import org.enrichment.talent_scouting_backend.api.model.JobVacancy;

public interface JobVacancyDAO {

    JobVacancy addJobVacancy(JobVacancy jobVacancy);

    void deleteJobVacancy(JobVacancy jobVacancy);
}
